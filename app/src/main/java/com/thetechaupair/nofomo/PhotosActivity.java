package com.thetechaupair.nofomo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class PhotosActivity extends Fragment {

    private ArrayList<Photo> photos;
    private PhotoGalleryAdapter photoGalleryAdapter;
    private RecyclerView photosRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_photos, container, false);

        photosRecyclerView = (RecyclerView)rootView.findViewById(R.id.photosRecyclerView);

        photos = new ArrayList<Photo>();

        Photo p = new Photo(R.drawable.rheed, "Rheed");
        photos.add(p);

        p = new Photo(R.drawable.rheed, "Rheed");
        photos.add(p);

        photoGalleryAdapter = new PhotoGalleryAdapter(getContext(), photos);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        photosRecyclerView.setLayoutManager(mLayoutManager);
        photosRecyclerView.setItemAnimator(new DefaultItemAnimator());
        photosRecyclerView.setAdapter(photoGalleryAdapter);

        photosRecyclerView.addOnItemTouchListener(new PhotoGalleryAdapter.RecyclerTouchListener(getContext(), photosRecyclerView, new PhotoGalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent("com.thetechaupair.nofomo.VIEWPHOTOSACTIVITY");
                Bundle bundle = new Bundle();
                bundle.putSerializable("photos", photos);
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext(),"No",Toast.LENGTH_SHORT).show();
            }
        }));

        return rootView;
    }

    @Override
    public String toString() {
        String title = "Photos";
        return title;
    }
}