package com.example.myroomtest;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class UsersStaticRepository {
    private UsersDao myUsersDao;
    private static ArrayList<Users> mySAllUsers;
    private static UsersStaticRepository INSTANCE;
    UsersStaticRepository(Application application) {
        AgendaRoomDatabase db = AgendaRoomDatabase.getDatabase(application);
        INSTANCE = this;
        myUsersDao = db.usersDao();
        new getAllAsyncTask(myUsersDao).execute();

    }



    private void assignAll(List<Users> users){
        mySAllUsers = new ArrayList<>(users);
    }
    ArrayList<Users> getSAllUsers() {
        return mySAllUsers;
    }
    private static class getAllAsyncTask extends AsyncTask<Users, Void, List<Users>> {

        private UsersDao mAsyncTaskDao;

        getAllAsyncTask(UsersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected List<Users> doInBackground(final Users... params) {

            INSTANCE.assignAll(mAsyncTaskDao.sLoadAllUsers());
            return mAsyncTaskDao.sLoadAllUsers();
        }

        @Override
        protected void onPostExecute(List<Users> users) {
            super.onPostExecute(users);
            //INSTANCE.assignAll(users);

        }
    }

    public void insert (Users user) {
        new UsersStaticRepository.insertAsyncTask(myUsersDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<Users, Void, Void> {

        private UsersDao mAsyncTaskDao;

        insertAsyncTask(UsersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Users... params) {
            mAsyncTaskDao.insertUser(params);
            return null;
        }
    }

    public void delete (Users user) {
        new UsersStaticRepository.deleteAsyncTask(myUsersDao).execute(user);
    }

    private static class deleteAsyncTask extends AsyncTask<Users, Void, Void> {

        private UsersDao mAsyncTaskDao;

        deleteAsyncTask(UsersDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Users... params) {
            mAsyncTaskDao.deleteUser(params);
            return null;
        }
    }
    /*private static class InsertAsyncTask extends AsyncTask<Void, Void, Integer> {

        //Prevent leak
        private WeakReference<Activity> weakActivity;
        private Users user;

        public InsertAsyncTask(AgendaViewModel activity, Users user) {
            weakActivity = new WeakReference(activity);
            this.user = user;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            usersRepository.insert(user);
            return 0;
        }

        @Override
        protected void onPostExecute(Integer agentsCount) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return;
            }*/
/*
            if (agentsCount > 0) {
                //2: If it already exists then prompt user
                Toast.makeText(activity, "Agent already exists!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(activity, "Agent does not exist! Hurray :)", Toast.LENGTH_LONG).show();
                activity.onBackPressed();
            }*//*

        }
    }
*/
}
