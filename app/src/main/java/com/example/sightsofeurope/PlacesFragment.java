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
import android.widget.TextView;

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


        sightsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //int p = allSights.get(i).getId();
                Intent showSightActivity = new Intent(view.getContext(), SightActivity.class);
                int selectedSightId = adapterView.getId();
                //  showArticleActivity.putExtra("com.example.news24.ITEM_INDEX", position);
                int sightId = allSights.get(i).getId();
                Sight sight = db.findSightById(sightId);
                String selectedFromList = (String)sightsListView.getItemAtPosition(i);                      // Takes the name of the sight and compares it to the database to get the ID
                for(int pos=0; pos< allSights.size(); pos++){
                    if((allSights.get(pos).getName().equals(selectedFromList))){
                        showSightActivity.putExtra("name", allSights.get(pos).getName());
                        showSightActivity.putExtra("cover", allSights.get(pos).getCover());
                        showSightActivity.putExtra("content", allSights.get(pos).getContent());
                        showSightActivity.putExtra("latitude", allSights.get(pos).getLatt());
                        showSightActivity.putExtra("longitude", allSights.get(pos).getLongt());
                        showSightActivity.putExtra("bottomBoundary", allSights.get(pos).getBottomBoundary());
                        showSightActivity.putExtra("leftBoundary", allSights.get(pos).getLeftBoundary());
                        showSightActivity.putExtra("topBoundary", allSights.get(pos).getTopBoundary());
                        showSightActivity.putExtra("rightBoundary", allSights.get(pos).getRightBoundary());
                        startActivity(showSightActivity);
                    }
                }


      /*
                System.out.println("/////// THE VALUE OF ITEM IS: " + selectedFromList);
                System.out.println("/////// THE VALUE OF L IS: " + l);
                System.out.println("/////// THE VALUE OF I IS: " + i);
                System.out.println("/////// THE VALUE OF SIGHTID IS: " + sightId);
                System.out.println("/////// THE BOUNDARY IS: " + sight.getContent());
                showSightActivity.putExtra("name", sight.getName());
                showSightActivity.putExtra("cover", sight.getCover());
                startActivity(showSightActivity);
                */
            }
        });
        return v;
    }

}
