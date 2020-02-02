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

public class SightAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] sights;
    String[] images;
    Typeface font;

    DatabaseHelper db;
    Resources resources;
    int[] imageIds;

    public SightAdapter(Context cx, String[] c, String[] i){
        sights = c;
        images = i;
        font = Typeface.createFromAsset(cx.getAssets(), "fonts/Orienta-Regular.ttf");
        mInflater = (LayoutInflater) cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //    db = new DatabaseHelper(cx);
        resources = cx.getResources();
        imageIds = new int[i.length];

        for(int pos=0; pos<i.length; pos++){
            System.out.println("/////// LENGTH: " + i.length);
            System.out.println("/////// VALUE: " + i[pos]);
        }



        for(int pos=0; pos<i.length; pos++){

            int resourceId = resources.getIdentifier(i[pos], "drawable", cx.getPackageName());
            imageIds[pos] = resourceId;
        }
    }

    @Override
    public int getCount() {
        return sights.length;
    }

    @Override
    public Object getItem(int position) {
        return sights[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_layout, null);
        TextView countryNameTextView = v.findViewById(R.id.countryNameTextView);
        countryNameTextView.setTypeface(font);
        ImageView countryImageView = v.findViewById(R.id.countryImageView);

        String name = sights[position];
        String image = images[position];

        countryNameTextView.setText(name);

        countryImageView.setImageResource(imageIds[position]);
        return v;
    }
}
