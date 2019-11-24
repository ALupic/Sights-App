package com.example.sightsofeurope;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CountryListActivity extends AppCompatActivity {

    ListView countriesListView;
    //String[] countries;
    //String[] images;

    DatabaseHelper db;
    private ArrayList<Country> allCountries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        // DATABASE - NEW
        db = new DatabaseHelper(this);
        //db.getCountryName();
        allCountries = db.getCountries();

        Resources res = getResources();
        countriesListView = (ListView) findViewById(R.id.countriesListView);
        //countries = res.getStringArray(R.array.countries);
        //images = res.getStringArray(R.array.images);



        String[] countries = new String[allCountries.size()];
        String[] images = new String[allCountries.size()];
        for(int i = 0; i < allCountries.size(); i++){
            countries[i] = allCountries.get(i).getName();
            images[i] = allCountries.get(i).getCover();
        }
        ItemAdapter itemAdapter = new ItemAdapter(this, countries, images);
        countriesListView.setAdapter(itemAdapter);
    }
}
