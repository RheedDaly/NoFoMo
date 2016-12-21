package com.thetechaupair.nofomo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> items;
    ArrayList<File> mySongs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);

        items = new ArrayList<String>();
        lv = (ListView)findViewById(R.id.list);

        mySongs = findSongs(Environment.getExternalStorageDirectory());

        for (int i = 0; i <mySongs.size(); i++){
            items.add(mySongs.get(i).getName().toString().replace(".mp3",""));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting listitem index
                int songIndex = position;

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), Player.class);
                // Sending songIndex to PlayerActivity
                in.putExtra("songIndex", songIndex);
                setResult(100, in);
                // Closing PlayListView
                finish();
            }
        });
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
}
