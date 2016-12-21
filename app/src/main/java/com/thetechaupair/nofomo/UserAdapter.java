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

public class UserAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users;
    private LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        holder = new ViewHolder();

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.activity_user_list_view, null);

            holder.userImageView = (ImageView) convertView.findViewById(R.id.user_image_view);
            holder.username = (TextView) convertView.findViewById(R.id.username_text_view);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        User currentUser = users.get(position);

        Picasso.with(context).load(currentUser.getImageResourceId()).into(holder.userImageView);
        holder.username.setText(currentUser.getUsername());

        return convertView;
    }

    private class ViewHolder {
        ImageView userImageView;
        TextView username;
    }
}