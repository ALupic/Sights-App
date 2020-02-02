package com.example.sightsofeurope;

import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        countriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent showCountryActivity = new Intent(view.getContext(), CountryActivity.class);
                int selectedCountryId = adapterView.getId();
                //  showArticleActivity.putExtra("com.example.news24.ITEM_INDEX", position);
                int countryId = allCountries.get(i).getId();
                Country country = db.findCountryById(countryId);
                showCountryActivity.putExtra("id", country.getId());
                showCountryActivity.putExtra("name", country.getName());
                showCountryActivity.putExtra("cover", country.getCover());
                showCountryActivity.putExtra("capital", country.getCapital());
                showCountryActivity.putExtra("area", country.getArea());
                showCountryActivity.putExtra("population", country.getPopulation());
                showCountryActivity.putExtra("language", country.getLanguage());
                showCountryActivity.putExtra("flag", country.getFlag());
                showCountryActivity.putExtra("bottomBoundary", country.getBottomBoundary());
                showCountryActivity.putExtra("leftBoundary", country.getLeftBoundary());
                showCountryActivity.putExtra("topBoundary", country.getTopBoundary());
                showCountryActivity.putExtra("rightBoundary", country.getRightBoundary());
                startActivity(showCountryActivity);
            }
        });
    }
}
