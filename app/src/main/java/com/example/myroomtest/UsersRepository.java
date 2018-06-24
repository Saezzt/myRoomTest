package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;
import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */

public class UsersRepository {

    private UsersDao myUsersDao;
    private LiveData<List<Users>> myAllUsers;
    private List<Users> mySAllUsers;

    UsersRepository(Application application) {
        AgendaRoomDatabase db = AgendaRoomDatabase.getDatabase(application);
        myUsersDao = db.usersDao();
        myAllUsers = myUsersDao.loadAllUsers();
        mySAllUsers = myUsersDao.sLoadAllUsers();
    }

    LiveData<List<Users>> getAllUsers() {
        return myAllUsers;
    }
    List<Users> getSAllUsers() {
        return mySAllUsers;
    }

    public void insert (Users user) {
        new insertAsyncTask(myUsersDao).execute(user);
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
        new deleteAsyncTask(myUsersDao).execute(user);
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
}
