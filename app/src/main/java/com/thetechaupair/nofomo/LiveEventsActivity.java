package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LiveEventsActivity extends Fragment implements AdapterView.OnItemClickListener {

    PostsAdapter postsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_list, container, false);

//        ListView lv = (ListView) rootView.findViewById(R.id.tabListView);
//
//        postsAdapter = new PostsAdapter(getActivity(), getPosts());
//        lv.setOnItemClickListener(this);
//        lv.setAdapter(postsAdapter);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s = String.valueOf(postsAdapter.getItem(i).getUsername());
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        Intent a = new Intent("com.thetechaupair.nofomo.VIEWLIVEEVENTSACTIVITY");
        startActivity(a);
    }

    private ArrayList<Post> getPosts() {

        ArrayList<Post> posts = new ArrayList<>();

        Post p = new Post("Rheed", R.drawable.rheed);

        posts.add(p);

        p = new Post("Rheed", R.drawable.rheed);

        posts.add(p);

        p = new Post("Rheed", R.drawable.rheed);

        posts.add(p);

        p = new Post("Rheed", R.drawable.rheed);

        posts.add(p);

        return posts;
    }

    @Override
    public String toString() {
        String title = "Live Events";
        return title;
    }
}
