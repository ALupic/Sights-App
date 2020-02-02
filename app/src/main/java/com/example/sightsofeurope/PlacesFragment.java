package com.example.sightsofeurope;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    DatabaseHelper db;
    ListView sightsListView;
    private ArrayList<Sight> allSights = new ArrayList<Sight>();
    int countryId;

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_places, container, false);

        db = new DatabaseHelper(v.getContext());
        allSights = db.getSights();

        countryId = getActivity().getIntent().getIntExtra("id", 1);

        System.out.println("////// COUNTRY_ID: " + countryId);

        Resources res = getResources();
        sightsListView = (ListView) v.findViewById(R.id.sightsListView);



        List<String> listSights = new ArrayList<String>();
        List<String> listImages = new ArrayList<String>();
        int counter = 0;


   /*     for(int i = 0; i < allSights.size(); i++){
            sights[i] = allSights.get(i).getName();
            images[i] = allSights.get(i).getCover();
        }
        */

        for(int i = 0; i < allSights.size(); i++){
            if(allSights.get(i).getCountry_id() == countryId){
                System.out.println("////// I: " + i);
                System.out.println("////// NAME: " + allSights.get(i).getName());
                System.out.println("////// COVER: " + allSights.get(i).getCover());
                listSights.add(allSights.get(i).getName());
                listImages.add(allSights.get(i).getCover());
                counter = counter+1;
            }
        }

        String[] sights = new String[counter];
        String[] images = new String[counter];
        sights = listSights.toArray(sights);
        images = listImages.toArray(images);



     /*  for(int i = 0; i < allSights.size(); i++){
            if(allSights.get(i).getCountry_id() == countryId){
                sights[i] = allSights.get(i).getName();
                System.out.println("//////SIGHT_NAME: " + sights[i]);
                images[i] = allSights.get(i).getCover();
                System.out.println("//////IMAGE_NAME: " + images[i]);
            }
        }*/

        SightAdapter sightAdapter = new SightAdapter(v.getContext(), sights, images);
        sightsListView.setAdapter(sightAdapter);
        System.out.println("/////// FINISHED PLACES FRAGMENT");


     /*   countriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent showCountryActivity = new Intent(view.getContext(), CountryActivity.class);
                int selectedCountryId = adapterView.getId();
                //  showArticleActivity.putExtra("com.example.news24.ITEM_INDEX", position);
                int countryId = allSights.get(i).getId();
                Country country = db.findCountryById(countryId);
                System.out.println("/////// THE BOUNDARY IS: " + country.getContent());
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
        });*/
        return v;
    }

}
