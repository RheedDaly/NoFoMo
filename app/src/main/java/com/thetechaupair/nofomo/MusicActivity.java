package com.thetechaupair.nofomo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MusicActivity extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv;
    ArrayList<String> items;
    ArrayList<File> mySongs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_music, container, false);

        items = new ArrayList<String>();
        lv = (ListView)rootView.findViewById(R.id.myListView);

        mySongs = findSongs(Environment.getExternalStorageDirectory());
        MediaPlayer mediaPlayer = new MediaPlayer();
        Utilities utilities = new Utilities();

        for (int i = 0; i < mySongs.size(); i++){
            items.add(mySongs.get(i).getName().toString().replace(".mp3","") + " " + utilities.milliSecondsToTimer(mediaPlayer.getDuration()));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        startActivity(new Intent(getContext(), Player.class).putExtra("pos", position).putExtra("songslist", mySongs));

    }

    public void toast(String text){
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<File> findSongs(File root) {
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();

        for (File singleFile : files) {
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findSongs(singleFile));
            } else {
                if(singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".MP3")){
                    al.add(singleFile);
                }
            }
        }
        return al;
    }

    @Override
    public String toString() {
        String title = "Music";
        return title;
    }
}
