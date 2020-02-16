package com.example.sightsofeurope;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class SightMapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    MapView mapView;

    double latt;
    double longt;
    double doubleBB;
    double doubleLB;
    double doubleTB;
    double doubleRB;

    DatabaseHelper db;

    public SightMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sight_map, container, false);

        String stringName = getActivity().getIntent().getStringExtra("name");

        db = new DatabaseHelper(v.getContext());

        doubleBB = getActivity().getIntent().getDoubleExtra("bottomBoundary", 1);
        doubleLB = getActivity().getIntent().getDoubleExtra("leftBoundary", 1);
        doubleTB = getActivity().getIntent().getDoubleExtra("topBoundary", 1);
        doubleRB = getActivity().getIntent().getDoubleExtra("rightBoundary", 1);

        latt = getActivity().getIntent().getDoubleExtra("latitude", 1);
        longt = getActivity().getIntent().getDoubleExtra("longitude", 1);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = view.findViewById(R.id.sightMapView);

        String languageToLoad = "en_GB";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getResources().updateConfiguration(config,
                getActivity().getResources().getDisplayMetrics());

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

        LatLng location = new LatLng(latt, longt);
        LatLngBounds bounds = new LatLngBounds(new LatLng(doubleBB, doubleLB), new LatLng(doubleTB, doubleRB));
        map.addMarker(new MarkerOptions().position(location).title("Sight Location"));
        map.moveCamera(CameraUpdateFactory.newLatLng(location));
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 1));
    }
}
