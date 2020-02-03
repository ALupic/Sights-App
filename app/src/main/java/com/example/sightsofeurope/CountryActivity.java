package com.example.sightsofeurope;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity {

    ImageView imageView2;
    TextView countryNameTW;
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
        String transName = (String) in.getSerializableExtra("name");
        String transCover = (String) in.getSerializableExtra("cover");                          // REVIEW

        //Data transfer to InfoFragment
        Bundle infoBundle = new Bundle();
        infoBundle.putString("capital", "From Activity");
        infoBundle.putString("area", "From Activity");
        infoBundle.putString("population", "From Activity");
        infoBundle.putString("language", "From Activity");
        infoBundle.putString("flag", "From Activity");
        InfoFragment fragObj = new InfoFragment();
        fragObj.setArguments(infoBundle);

        //Data transfer to PlacesFragment
        Bundle sightBundle = new Bundle();
        sightBundle.putInt("id", 1);

        //Data transfer to MapFragment
        Bundle mapBundle = new Bundle();
        mapBundle.putDouble("bottomBoundary", 1);
        mapBundle.putDouble("leftBoundary", 1);
        mapBundle.putDouble("topBoundary", 1);
        mapBundle.putDouble("rightBoundary", 1);
        mapBundle.putString("name", "From Activity");
        MapFragment mapObj = new MapFragment();
        mapObj.setArguments(mapBundle);

        imageView2 = findViewById(R.id.imageView2);
        countryNameTW = findViewById(R.id.countryNameTW);
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