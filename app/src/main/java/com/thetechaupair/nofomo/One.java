package com.thetechaupair.nofomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class One extends Fragment {

    ArrayList<User> users;
    UserAdapter userAdapter;
    ListView tabListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_list, container, false);

        users = new ArrayList<User>();

        users.add(new User("Rheed", R.drawable.one));
        users.add(new User("Rheed", R.drawable.two));
        users.add(new User("Rheed", R.drawable.three));
        users.add(new User("Rheed", R.drawable.four));

        userAdapter = new UserAdapter(getContext(), users);
        tabListView = (ListView)rootView.findViewById(R.id.tabListView);
        tabListView.setAdapter(userAdapter);

        tabListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent("com.thetechaupair.nofomo.PROFILEACTIVITY");
                startActivity(myIntent);
            }
        });

        return rootView;
    }

    @Override
    public String toString() {
        String title = "Events";
        return title;
    }
}
