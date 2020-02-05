package com.example.sightsofeurope;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SightInfoFragment extends Fragment {

    TextView sightContentTW;

    DatabaseHelper db;

    public SightInfoFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sight_info, container, false);

        db = new DatabaseHelper(v.getContext());

        sightContentTW = v.findViewById(R.id.sightContentTW);
        String stringContent = getActivity().getIntent().getStringExtra("content");
        sightContentTW.setText(stringContent);

        // font
        Typeface typefaceFont = Typeface.createFromAsset(v.getContext().getAssets(), "fonts/Orienta-Regular.ttf");
        sightContentTW.setTypeface(typefaceFont);

        return v;
    }
}
