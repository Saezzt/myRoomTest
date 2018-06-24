package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Marco on 22/06/2018.
 */

public class AgendaViewModel extends AndroidViewModel {

    private UsersRepository usersRepository;
    private CalendarsRepository calendarsRepository;
    private EventsRepository eventsRepository;

    private LiveData<List<Users>> AllUsers;
    private LiveData<List<Calendars>> AllCalendars;
    private LiveData<List<Events>> AllEvents;

    public AgendaViewModel (Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        calendarsRepository = new CalendarsRepository(application);
        eventsRepository = new EventsRepository(application);
        AllUsers = usersRepository.getAllUsers();
        AllCalendars = calendarsRepository.getAllCalendars();
        AllEvents = eventsRepository.getAllEvents();
    }

    LiveData<List<Users>> getAllUsers() { return AllUsers; }
    LiveData<List<Calendars>> getAllCalendars() { return AllCalendars; }
    LiveData<List<Events>> getAllEvents() { return AllEvents; }

    public void insertAllC(List<Calendars> calendars) {
        Calendars[] params = new Calendars[calendars.size()];
        params = calendars.toArray(params);
        calendarsRepository.insertAll(params);
    }

    public void insertAllE(List<Events> events) {
        Events[] params = new Events[events.size()];
        params = events.toArray(params);
        eventsRepository.insertAll(params); }

    public void insertU(Users user) { usersRepository.insert(user); }
    public void deleteU(Users user) { usersRepository.delete(user); };
    public void insertC(Calendars calendar) { calendarsRepository.insert(calendar); }
    public void deleteAllC(Calendars... calendars) { calendarsRepository.deleteAll(calendars); }
    public void deleteC(Calendars calendar) { calendarsRepository.delete(calendar); }
    public void insertE(Events event) { eventsRepository.insert(event);};
    public void deleteE(Events event) { eventsRepository.delete(event);}
}
