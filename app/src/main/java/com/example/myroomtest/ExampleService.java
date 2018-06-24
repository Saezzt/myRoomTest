package com.example.myroomtest;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Marco on 24/06/2018.
 */

public class ExampleService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void example_create(){
        AgendaServiceView myAgendaServiceView = new AgendaServiceView(getApplication());
    }

    public void example_use(AgendaServiceView myAgendaServiceView){
        myAgendaServiceView.getAllEvents();
        myAgendaServiceView.getAllEvents().contains(new Events(0000, 0000, false, false, "location",0,0, 0));
        myAgendaServiceView.getAllEvents().add(new Events(0000, 0000, false, false,"location",0, 0, 0));//aggiunge solo nella lista non nel DB!
        myAgendaServiceView.getAllEvents().get(0);
        myAgendaServiceView.getAllCalendarsWithAcN("account_name");

        //NB per le modifiche alle tuple usiamo l'inserimento, room non farà altro che sostituire la tupla, quindi vanno settati tutti i parametri e non solo quello che cambia

        myAgendaServiceView.insertU(null);
        myAgendaServiceView.deleteU(null);

        myAgendaServiceView.insertAllC(null);
        myAgendaServiceView.insertC(null);
        myAgendaServiceView.deleteAllC(null);
        myAgendaServiceView.deleteC(null);

        myAgendaServiceView.insertAllE(null);
        myAgendaServiceView.insertE(null);
        myAgendaServiceView.deleteE(null);
    }

}
