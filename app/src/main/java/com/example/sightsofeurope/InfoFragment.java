package com.example.sightsofeurope;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    TextView countryCityTW;
    TextView countryAreaTW;
    TextView countryPopulationTW;
    TextView countryLanguageTW;
    ImageView countryFlagIW;

    DatabaseHelper db;

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_info, container, false);

        db = new DatabaseHelper(v.getContext());

        countryCityTW = v.findViewById(R.id.countryCityTW);
        countryAreaTW = v.findViewById(R.id.countryAreaTW);
        countryPopulationTW = v.findViewById(R.id.countryPopulationTW);
        countryLanguageTW = v.findViewById(R.id.countryLanguageTW);
        countryFlagIW = v.findViewById(R.id.countryFlagIW);
        String stringCapital = getActivity().getIntent().getStringExtra("capital");
        String stringArea = getActivity().getIntent().getStringExtra("area");
        String stringPopulation = getActivity().getIntent().getStringExtra("population");
        String stringLanguage = getActivity().getIntent().getStringExtra("language");
        String stringFlag = getActivity().getIntent().getStringExtra("flag");

        countryCityTW.setText(stringCapital);
        countryAreaTW.setText(stringArea);
        countryPopulationTW.setText(stringPopulation);
        countryLanguageTW.setText(stringLanguage);

        // image setup
//        String imgName = country.getCover();
        Context c = v.getContext();
        Resources res = getResources();
        //int resourceId = res.getIdentifier(imgName, "drawable", c.getPackageName());
        int resourceId = res.getIdentifier(stringFlag, "drawable", c.getPackageName());         // REVIEW

        countryFlagIW.setImageResource(resourceId);



        return v;

    }

}
