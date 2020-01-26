package com.example.sightsofeurope;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.location.Geocoder;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    MapView mapView;

    Double doubleBB;
    Double doubleLB;
    Double doubleTB;
    Double doubleRB;

    DatabaseHelper db;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        String stringName = getActivity().getIntent().getStringExtra("name");

        db = new DatabaseHelper(v.getContext());

        doubleBB = getActivity().getIntent().getDoubleExtra("bottomBoundary", 1);
        doubleLB = getActivity().getIntent().getDoubleExtra("leftBoundary", 1);
        doubleTB = getActivity().getIntent().getDoubleExtra("topBoundary", 1);
        doubleRB = getActivity().getIntent().getDoubleExtra("rightBoundary", 1);


    /*    countryBB = getActivity().getIntent().getDoubleExtra("bottomBoundary", 1);
        countryLB = getActivity().getIntent().getDoubleExtra("leftBoundary", 1);
        countryTB = getActivity().getIntent().getDoubleExtra("topBoundary", 1);
        countryRB = getActivity().getIntent().getDoubleExtra("rightBoundary", 1);

        System.out.println("///////////Coordinates: " + countryBB + ", " + countryLB + ", " + countryTB + "," + countryRB + " //////"); */

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = view.findViewById(R.id.mapView);

        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        MapsInitializer.initialize(getContext());
        map = googleMap;



        //LatLngBounds bounds = new LatLngBounds(new LatLng(Double.parseDouble(stringBB), Double.parseDouble(stringLB)),
        //                                       new LatLng(Double.parseDouble(stringTB), Double.parseDouble(stringRB)));

        LatLngBounds bounds = new LatLngBounds(new LatLng(doubleBB, doubleLB), new LatLng(doubleTB, doubleRB));
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 1));
    }
}
