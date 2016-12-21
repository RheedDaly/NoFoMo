package com.thetechaupair.nofomo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;

public class MusicCustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Post> posts;
    private LayoutInflater inflater;

    public MusicCustomAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return posts.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        holder = new ViewHolder();

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.activity_custom_music_list_view, null);

            holder.userImageView = (ImageView) convertView.findViewById(R.id.user_image_view);
            holder.username = (TextView) convertView.findViewById(R.id.username_text_view);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Post currentPost = posts.get(position);

        Picasso.with(context).load(currentPost.getImageResourceId()).into(holder.userImageView);
        holder.username.setText(currentPost.getUsername());

        return convertView;
    }

    private class ViewHolder {
        ImageView userImageView;
        TextView username;
    }
}

