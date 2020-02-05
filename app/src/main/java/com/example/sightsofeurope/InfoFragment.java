package com.example.sightsofeurope;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
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

    TextView countryTW1;
    TextView countryTW2;
    TextView countryTW3;
    TextView countryTW4;

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

        //font
        countryTW1 = v.findViewById(R.id.countryTW1);
        countryTW2 = v.findViewById(R.id.countryTW2);
        countryTW3 = v.findViewById(R.id.countryTW3);
        countryTW4 = v.findViewById(R.id.countryTW4);
        Typeface typefaceFont = Typeface.createFromAsset(v.getContext().getAssets(), "fonts/Orienta-Regular.ttf");
        countryCityTW.setTypeface(typefaceFont);
        countryAreaTW.setTypeface(typefaceFont);
        countryPopulationTW.setTypeface(typefaceFont);
        countryLanguageTW.setTypeface(typefaceFont);
        countryTW1.setTypeface(typefaceFont);
        countryTW2.setTypeface(typefaceFont);
        countryTW3.setTypeface(typefaceFont);
        countryTW4.setTypeface(typefaceFont);


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
