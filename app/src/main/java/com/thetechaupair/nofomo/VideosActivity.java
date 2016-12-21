package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class VideosActivity extends Fragment implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private ProgressBar progressBar;

    private VideosAdapter videosAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_videos, container, false);

        gridView = (GridView) rootView.findViewById(R.id.videosGridView);
        progressBar = (ProgressBar) rootView.findViewById(R.id.videosProgressBar);

        videosAdapter = new VideosAdapter(getActivity(), getVideos());

        gridView.setOnItemClickListener(this);
        gridView.setAdapter(videosAdapter);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Get item at position
        Video item = (Video) adapterView.getItemAtPosition(position);

        Intent intent = new Intent("com.thetechaupair.nofomo.VIEWVIDEOSACTIVITY");
        ImageView imageView = (ImageView) view.findViewById(R.id.videosImageView);

        int[] screenLocation = new int[2];
        imageView.getLocationOnScreen(screenLocation);

        //Pass the image title and url to DetailsActivity
        intent.putExtra("left", screenLocation[0]).
                putExtra("top", screenLocation[1]).
                putExtra("width", imageView.getWidth()).
                putExtra("height", imageView.getHeight()).
                putExtra("title", item.getVideoTitle()).
                putExtra("image", item.getVideoResourceId());

        //Start details activity
        startActivity(intent);
    }

    private ArrayList<Video> getVideos() {

        ArrayList<Video> videos = new ArrayList<>();

        Video p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        p = new Video(R.drawable.rheed, "Rheed");
        videos.add(p);

        return videos;
    }

    @Override
    public String toString() {
        String title = "Videos";
        return title;
    }
}
