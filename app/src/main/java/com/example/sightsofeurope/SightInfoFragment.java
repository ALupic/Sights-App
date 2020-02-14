package com.example.sightsofeurope;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class SightInfoFragment extends Fragment {

    TextView sightContentTW;
    ToggleButton beenHereIW;
    ToggleButton wannaGoIW;

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

        beenHereIW = (ToggleButton) v.findViewById(R.id.beenHereIW);
        wannaGoIW = (ToggleButton) v.findViewById(R.id.wannaGoIW);
        beenHereIW.setChecked(false);
        beenHereIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.been_here));
        wannaGoIW.setChecked(false);
        wannaGoIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.wanna_go));

        beenHereIW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    beenHereIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.been_here_c));
                }else{
                    beenHereIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.been_here));
                }
            }
        });

        wannaGoIW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wannaGoIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.wanna_go_c));
                }else{
                    wannaGoIW.setBackgroundDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.wanna_go));
                }
            }
        });

        return v;
    }
}
