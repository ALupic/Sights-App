package com.example.sightsofeurope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SightActivity extends AppCompatActivity {

    ImageView imageView2;
    TextView countryNameTW;
    TabLayout tabLayout;
    TabItem tabInfo;
    TabItem tabMap;
    TabItem tabForum;
    ViewPager viewPager;
    PageAdapterSight pageAdapter;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight);

        db = new DatabaseHelper(getParent());

        Intent in = getIntent();
        String transName = (String) in.getSerializableExtra("name");
        String transCover = (String) in.getSerializableExtra("cover");                          // REVIEW

        imageView2 = findViewById(R.id.sightImageView2);
        countryNameTW = findViewById(R.id.sightCountryNameTW);
        tabLayout = findViewById(R.id.sightTablayout);
        tabInfo = findViewById(R.id.sightTabInfo);
        tabMap = findViewById(R.id.sightTabMap);
        tabForum = findViewById(R.id.sightTabForum);
        viewPager = findViewById(R.id.sightViewPager);
        pageAdapter = new PageAdapterSight(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        Context c = SightActivity.this;
        Resources res = getResources();
        int resourceId = res.getIdentifier(transCover, "drawable", c.getPackageName());         // REVIEW

        imageView2.setImageResource(resourceId);
        countryNameTW.setText(transName);

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
