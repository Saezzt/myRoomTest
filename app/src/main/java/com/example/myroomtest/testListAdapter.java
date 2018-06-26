package com.example.myroomtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Marco on 22/06/2018.
 */

public class testListAdapter extends RecyclerView.Adapter<testListAdapter.testViewHolder> {

    class testViewHolder extends RecyclerView.ViewHolder {
        private final TextView testItemView;

        private testViewHolder(View itemView) {
            super(itemView);
            testItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Events> testList; // Cached copy of words

    testListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public testViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new testViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(testViewHolder holder, int position) {
        if (testList != null) {
            Events current = testList.get(position);
            //Calendars current = testList.get(position);
            holder.testItemView.setText("cal: "+current.get_calendar()+", id: "+current.get_id());
//            holder.testItemView.setText(current.getAccount_name());
        } else {
            // Covers the case of data not being ready yet.
            holder.testItemView.setText("No Calendars");
        }
    }

    void setCalendars(List<Calendars> calendars){
//        testList = calendars;
        notifyDataSetChanged();
    }

    void setUsers(List<Users> users){
//        testList = users;
        notifyDataSetChanged();
    }
    void setEvents(List<Events> events){
        testList = events;
        notifyDataSetChanged();
    }
    void setWords(List<Word> words){
//        testList = words;
        notifyDataSetChanged();
    }
    // getItemCount() is called many times, and when it is first called,
    // testList has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (testList != null)
            return testList.size();
        else return 0;
    }
}
