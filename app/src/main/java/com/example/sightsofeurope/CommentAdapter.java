package com.example.sightsofeurope;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommentAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] comments;
    String[] users;
    String[] timestamps;
    Typeface font;

    DatabaseHelper db;
    Resources resources;

    public CommentAdapter(Context cx, String[] c, String[] u, String[] t){
        comments = c;
        users = u;
        timestamps = t;
        font = Typeface.createFromAsset(cx.getAssets(), "fonts/Orienta-Regular.ttf");
        mInflater = (LayoutInflater) cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //    db = new DatabaseHelper(cx);
        resources = cx.getResources();
    }

    @Override
    public int getCount() {
        return comments.length;
    }

    @Override
    public Object getItem(int position) {
        return comments[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_comments_layout, null);

        TextView commentTextView = v.findViewById(R.id.commentTextView);
        commentTextView.setTypeface(font);
        TextView authorTextView = v.findViewById(R.id.authorTextView);
        authorTextView.setTypeface(font);
        TextView timestampTextView = v.findViewById(R.id.timestampTextView);
        timestampTextView.setTypeface(font);

        String comment = comments[position];
        String user = users[position];
        String timestamp = timestamps[position];

        commentTextView.setText(comment);
        authorTextView.setText(user);
        timestampTextView.setText(timestamp);

        return v;
    }
}
