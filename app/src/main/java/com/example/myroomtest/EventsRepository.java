package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */

public class EventsRepository {


    private EventsDao myEventsDao;
    private LiveData<List<Events>> myAllEvents;

    EventsRepository(Application application) {
        AgendaRoomDatabase db = AgendaRoomDatabase.getDatabase(application);
        myEventsDao = db.eventsDao();
        myAllEvents = myEventsDao.loadAllEvents();
    }

    LiveData<List<Events>> getAllEvents() {
        return myAllEvents;
    }


    public void insert (Events Event) {
        new EventsRepository.insertAsyncTask(myEventsDao).execute(Event);
    }

    private static class insertAsyncTask extends AsyncTask<Events, Void, Void> {

        private EventsDao mAsyncTaskDao;

        insertAsyncTask(EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Events... params) {
            mAsyncTaskDao.insertEvent(params);
            return null;
        }
    }

    public void insertAll (Events... Event) {
        new EventsRepository.insertAllAsyncTask(myEventsDao).execute(Event);
    }

    private static class insertAllAsyncTask extends AsyncTask<Events, Void, Void> {

        private EventsDao mAsyncTaskDao;

        insertAllAsyncTask(EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Events... params) {
            mAsyncTaskDao.insertEvent(params);
            return null;
        }
    }

    public void delete (Events Event) {
        new EventsRepository.deleteAsyncTask(myEventsDao).execute(Event);
    }

    private static class deleteAsyncTask extends AsyncTask<Events, Void, Void> {

        private EventsDao mAsyncTaskDao;

        deleteAsyncTask(EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Events... params) {
            mAsyncTaskDao.deleteEvent(params);
            return null;
        }
    }
}
