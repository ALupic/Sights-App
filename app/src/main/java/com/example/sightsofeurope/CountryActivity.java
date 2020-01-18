package com.example.sightsofeurope;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CountryActivity extends AppCompatActivity {

    ImageView imageView2;
    TabLayout tabLayout;
    TabItem tabInfo;
    TabItem tabPlaces;
    TabItem tabMap;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        db = new DatabaseHelper(getParent());

        Intent in = getIntent();
        Country country = (Country) in.getSerializableExtra("country");
        String transCover = (String) in.getSerializableExtra("cover");                          // REVIEW

        imageView2 = findViewById(R.id.imageView2);
        tabLayout = findViewById(R.id.tablayout);
        tabInfo = findViewById(R.id.tabInfo);
        tabPlaces = findViewById(R.id.tabPlaces);
        tabMap = findViewById(R.id.tabMap);
        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        // image setup
//        String imgName = country.getCover();
        Context c = CountryActivity.this;
        Resources res = getResources();
        //int resourceId = res.getIdentifier(imgName, "drawable", c.getPackageName());
        int resourceId = res.getIdentifier(transCover, "drawable", c.getPackageName());         // REVIEW
        imageView2.setImageResource(resourceId);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}


// https://stackoverflow.com/questions/27425026/add-textview-over-imageview-android