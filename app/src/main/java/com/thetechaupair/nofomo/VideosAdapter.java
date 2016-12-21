package com.thetechaupair.nofomo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideosAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Video> videos;
    private LayoutInflater inflater;

    public VideosAdapter(Context context, ArrayList<Video> videos) {
        this.context = context;
        this.videos = videos;
    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Video getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return videos.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        holder = new ViewHolder();

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.activity_videos_grid_view, null);

            holder.videosImageView = (ImageView) convertView.findViewById(R.id.videosImageView);
            holder.videosTextView = (TextView) convertView.findViewById(R.id.videosTextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Video currentVideo = videos.get(position);

        Picasso.with(context).load(currentVideo.getVideoResourceId()).into(holder.videosImageView);
        holder.videosTextView.setText(currentVideo.getVideoTitle());

        return convertView;
    }

    private class ViewHolder {
        ImageView videosImageView;
        TextView videosTextView;
    }
}