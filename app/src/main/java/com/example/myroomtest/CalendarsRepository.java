package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */

public class CalendarsRepository {


    private CalendarsDao myCalendarsDao;
    private LiveData<List<Calendars>> myAllCalendars;

    CalendarsRepository(Application application) {
        AgendaRoomDatabase db = AgendaRoomDatabase.getDatabase(application);
        myCalendarsDao = db.calendarsDao();
        myAllCalendars = myCalendarsDao.loadAllCalendars();
    }

    LiveData<List<Calendars>> getAllCalendars() {
        return myAllCalendars;
    }


    public void insert (Calendars Calendar) {
        new CalendarsRepository.insertAsyncTask(myCalendarsDao).execute(Calendar);
    }

    private static class insertAsyncTask extends AsyncTask<Calendars, Void, Void> {

        private CalendarsDao mAsyncTaskDao;

        insertAsyncTask(CalendarsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Calendars... params) {
            mAsyncTaskDao.insertCalendar(params);
            return null;
        }
    }

    public void delete (Calendars Calendar) {
        new CalendarsRepository.deleteAsyncTask(myCalendarsDao).execute(Calendar);
    }

    private static class deleteAsyncTask extends AsyncTask<Calendars, Void, Void> {

        private CalendarsDao mAsyncTaskDao;

        deleteAsyncTask(CalendarsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Calendars... params) {
            mAsyncTaskDao.deleteCalendar(params);
            return null;
        }
    }
}
