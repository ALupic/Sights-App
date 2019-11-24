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

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] countries;
    String[] images;
    Typeface font;

    DatabaseHelper db;
    Resources resources;

    /*
    int[] imageIds = {
            R.drawable.cover_at,
            R.drawable.cover_be,
            R.drawable.cover_fr,
            R.drawable.cover_de,
            R.drawable.cover_gr,
            R.drawable.cover_hu,
            R.drawable.cover_it
    };
    */
    int[] imageIds;


    public ItemAdapter(Context cx, String[] c, String[] i){
        countries = c;
        images = i;
        font = Typeface.createFromAsset(cx.getAssets(), "fonts/Orienta-Regular.ttf");
        mInflater = (LayoutInflater) cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    //    db = new DatabaseHelper(cx);
        resources = cx.getResources();
        imageIds = new int[i.length];

        for(int pos=0; pos<i.length; pos++){
            int resourceId = resources.getIdentifier(i[pos], "drawable", cx.getPackageName());
            imageIds[pos] = resourceId;
        }
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
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

        String name = countries[position];
        String image = images[position];

        countryNameTextView.setText(name);
        /*
        if(position==0){
            countryImageView.setImageResource(imageIds[0]);
        }else if (position==1){
            countryImageView.setImageResource(imageIds[1]);
        }else if (position==2){
            countryImageView.setImageResource(imageIds[2]);
        }else if (position==3){
            countryImageView.setImageResource(imageIds[3]);
        }else if (position==4){
            countryImageView.setImageResource(imageIds[4]);
        }else if (position==5){
            countryImageView.setImageResource(imageIds[5]);
        }else{
            countryImageView.setImageResource(imageIds[6]);
        }
*/
        countryImageView.setImageResource(imageIds[position]);
        return v;
    }
}
