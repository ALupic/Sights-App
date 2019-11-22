package com.example.sightsofeurope;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryListActivity extends AppCompatActivity {

    ListView countriesListView;
    String[] countries;
    String[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        Resources res = getResources();
        countriesListView = (ListView) findViewById(R.id.countriesListView);
        countries = res.getStringArray(R.array.countries);
        images = res.getStringArray(R.array.images);

        ItemAdapter itemAdapter = new ItemAdapter(this, countries, images);
        countriesListView.setAdapter(itemAdapter);
    }
}
