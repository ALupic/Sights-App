package com.example.sightsofeurope;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TopicAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] topics;
    Typeface font;

    DatabaseHelper db;
    Resources resources;

    public TopicAdapter(Context cx, String[] t){
        topics = t;
        font = Typeface.createFromAsset(cx.getAssets(), "fonts/Orienta-Regular.ttf");
        mInflater = (LayoutInflater) cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //    db = new DatabaseHelper(cx);
        resources = cx.getResources();
    }

    @Override
    public int getCount() {
        return topics.length;
    }

    @Override
    public Object getItem(int position) {
        return topics[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_topics_layout, null);
        TextView topicNameTextView = v.findViewById(R.id.topicNameTextView);
        topicNameTextView.setTypeface(font);

        String name = topics[position];

        topicNameTextView.setText(name);
        return v;
    }
}
