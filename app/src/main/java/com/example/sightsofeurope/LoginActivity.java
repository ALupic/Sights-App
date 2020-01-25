package com.example.sightsofeurope;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button submitButton;
    TextView registerTextView;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //set content view AFTER ABOVE sequence (to avoid crash)
        //this.setContentView(R.layout.activity_login);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_login);

        //LinearLayout ll = findViewById(R.id.loginactivityid);
        //ll.setBackgroundColor(Color.rgb(74, 42, 10));

        db = new DatabaseHelper(this);

        usernameEditText = findViewById(R.id.usernameEditText);
        Typeface typefaceFont = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        usernameEditText.setTypeface(typefaceFont);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordEditText.setTypeface(typefaceFont);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setTypeface(typefaceFont);
        registerTextView = findViewById(R.id.registerLinkTextView);
        registerTextView.setTypeface(typefaceFont);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = usernameEditText.getText().toString().trim();
                String pwd = passwordEditText.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true){
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);

                    //User Session setup
                    SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("username", user);
                    editor.commit();

                    db.close();

                    startActivity(mainIntent);
                }
                else{
                    db.close();
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);

            }
        });
    }
}
