package com.example.myroomtest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Marco on 24/06/2018.
 *
 * App esempio per integrazione AgendaRoomDatabase e AgendaViewModel
 */

public class ExampleActivity extends AppCompatActivity{

    /*private AgendaViewModel myViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myViewModel = ViewModelProviders.of(this).get(AgendaViewModel.class);

        myViewModel.getAllUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(@Nullable List<Users> users) {
                // TODO azioni da eseguire quando cambiano users
            }
        });
        myViewModel.getAllCalendars().observe(this, new Observer<List<Calendars>>() {
            @Override
            public void onChanged(@Nullable final List<Calendars> calendars) {
                // TODO azioni da eseguire quando cambiano calendars
            }
        });
        myViewModel.getAllEvents().observe(this, new Observer<List<Events>>() {
            @Override
            public void onChanged(@Nullable final List<Events> events) {
                // TODO azioni da eseguire quando cambiano events
        }
        });
    }

    public void example_extractLiveData (){
        myViewModel.getAllEvents().getValue();
        myViewModel.getAllEvents().getValue().contains(new Events(new Long(111), new Long(1),false, false,"location",0, 0.0, 0.0));
        myViewModel.getAllEvents().getValue().add(new Events(new Long(111), new Long(1),false, false,"location",0, 0.0, 0.0));//aggiunge solo nella lista non nel DB!
        myViewModel.getAllEvents().getValue().get(0);
    }
    public void example_modDB (){

        //NB per le modifiche alle tuple usiamo l'inserimento, room non farà altro che sostituire la tupla, quindi vanno settati tutti i parametri e no solo quello che cambia

        myViewModel.insertU(null);
        myViewModel.deleteU(null);

        myViewModel.insertAllC(null);
        myViewModel.insertC(null);
        myViewModel.deleteAllC(null);
        myViewModel.deleteC(null);

        myViewModel.insertAllE(null);
        myViewModel.insertE(null);
        myViewModel.deleteE(null);
    }*/
}
