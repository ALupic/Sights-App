package com.example.sightsofeurope;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets the font
        TextView firstTextView = findViewById(R.id.firstTextView);
        Typeface tfFirstTextView = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        firstTextView.setTypeface(tfFirstTextView);

        Button startButton = findViewById(R.id.startButton);
        Typeface tfStartButton = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        startButton.setTypeface(tfStartButton);

        Button loginButton = findViewById(R.id.loginButton);
        Typeface tfLoginButton = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        loginButton.setTypeface(tfLoginButton);

        // Listener for the Explore button
        startButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), CountryListActivity.class);
                startActivity(startIntent);
            }
        });

        // Listener for the Login button
        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
