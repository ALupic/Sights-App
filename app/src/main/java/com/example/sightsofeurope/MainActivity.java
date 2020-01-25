package com.example.sightsofeurope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedPreferences;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        // Preferences setup for session purposes
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

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

        TextView logoutTextView = findViewById(R.id.logoutTextView);
        Typeface tfLogoutTextView = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        logoutTextView.setTypeface(tfLogoutTextView);

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

        // Listener for the Logout text
        logoutTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Intent registerIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(registerIntent);
            }
        });

        // SHARED PREFERENCES - LOGIN TEST
        if(sharedPreferences.getString("username","").equals("")){ //IF THERE IS NO SESSION
            loginButton.setVisibility(View.VISIBLE);
            logoutTextView.setVisibility(View.INVISIBLE);
            startButton.setVisibility(View.INVISIBLE);
        }
        else{
            loginButton.setVisibility(View.INVISIBLE);
            logoutTextView.setVisibility(View.VISIBLE);
            startButton.setVisibility(View.VISIBLE);
        }
    }
}
