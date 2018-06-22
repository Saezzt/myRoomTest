package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 22/06/2018.
 */

public class AgendaViewModel extends AndroidViewModel {

    private UsersRepository usersRepository;
    private CalendarsRepository calendarsRepository;
    private EventsRepository eventsRepository;

    private LiveData<ArrayList<Users>> AllUsers;
    private LiveData<ArrayList<Calendars>> AllCalendars;
    private LiveData<ArrayList<Events>> AllEvents;

    public AgendaViewModel (Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        calendarsRepository = new CalendarsRepository(application);
        eventsRepository = new EventsRepository(application);
        AllUsers = usersRepository.getAllUsers();
        AllCalendars = calendarsRepository.getAllCalendars();
        AllEvents = eventsRepository.getAllEvents();
    }

    LiveData<ArrayList<Users>> getAllUsers() { return AllUsers; }
    LiveData<ArrayList<Calendars>> getAllCalendars() { return AllCalendars; }
    LiveData<ArrayList<Events>> getAllEvents() { return AllEvents; }

    //public void insert(Word word) { mRepository.insert(word); }

    //public void deleteAll() { mRepository.deleteAll(); }
}
