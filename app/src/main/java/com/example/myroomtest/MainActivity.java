package com.example.myroomtest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AgendaViewModel myViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                //startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);

                ArrayList<Calendars> tmp = new ArrayList<>();
                if(!myViewModel.getAllCalendars().getValue().contains(new Calendars(2, "saezzt3@live.it")))tmp.add(new Calendars(2,"saezzt3@live.it"));
                if(!myViewModel.getAllCalendars().getValue().contains(new Calendars(3, "saezzt2@live.it")))tmp.add(new Calendars(3,"saezzt2@live.it"));
                if(!myViewModel.getAllCalendars().getValue().contains(new Calendars(4, "saezzt@live.it")))tmp.add(new Calendars(4,"saezzt@live.it"));
                if(!tmp.isEmpty())myViewModel.insertAllC(tmp);
                ArrayList<Events> tmp2 = new ArrayList<>();
                if(!myViewModel.getAllEvents().getValue().contains(new Events(111,1,false, false,"location",0, 0, 0)))tmp2.add(new Events(111,1,false, false,"location",0, 0, 0));
                if(!myViewModel.getAllEvents().getValue().contains(new Events(222,2,false, false, "location",0, 0, 0)))tmp2.add(new Events(222,2,false, false,"location",0, 0, 0));
                if(!myViewModel.getAllEvents().getValue().contains(new Events(333,3,false, false,"location", 0, 0, 0)))tmp2.add(new Events(333,3,false, false,"location",0, 0, 0));
                if(!tmp2.isEmpty())myViewModel.insertAllE(tmp2);

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Calendars[] tmp = new Calendars[1];
                //tmp[0] = new Calendars(1, "saezzt@live.it");
                //tmp[1] = new Calendars(4, "saezzt@live.it");
                //myViewModel.deleteAllC(tmp);
                ArrayList<Events> tmp2 = new ArrayList<>();
                if(!myViewModel.getAllEvents().getValue().contains(new Events(111,1,false, false,"location",0, 0, 0)))tmp2.add(new Events(111,1,false, false,"location",0, 0, 0));
                if(!myViewModel.getAllEvents().getValue().contains(new Events(222,2,false, false, "location",0, 0, 0)))tmp2.add(new Events(222,2,false, false,"location",0, 0, 0));
                if(!myViewModel.getAllEvents().getValue().contains(new Events(333,3,false, false,"location", 0, 0, 0)))tmp2.add(new Events(333,3,false, false,"location",0, 0, 0));
                if(!tmp2.isEmpty())myViewModel.insertAllE(tmp2);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final testListAdapter adapter = new testListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myViewModel = ViewModelProviders.of(this).get(AgendaViewModel.class);

        myViewModel.getAllUsers().observe(this, new Observer<List<Users>>() {
            @Override
            public void onChanged(@Nullable List<Users> users) {
                // Update the cached copy of the users in the adapter.
                adapter.setUsers(users);
            }
        });
        myViewModel.getAllCalendars().observe(this, new Observer<List<Calendars>>() {
            @Override
            public void onChanged(@Nullable final List<Calendars> calendars) {
                // Update the cached copy of the calendars in the adapter.
                adapter.setCalendars(calendars);
            }
        });
        myViewModel.getAllEvents().observe(this, new Observer<List<Events>>() {
            @Override
            public void onChanged(@Nullable final List<Events> events) {
                // Update the cached copy of the events in the adapter.
                adapter.setEvents(events);
            }
        });

        myViewModel.insertU(new Users("saezzt@live.it","it.live"));

        myViewModel.insertU(new Users("saezzt2@live.it","it.live"));
        myViewModel.insertU(new Users("saezzt3@live.it","it.live"));
        myViewModel.insertC(new Calendars(1,"saezzt@live.it"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
