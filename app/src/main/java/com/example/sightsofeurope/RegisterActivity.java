package com.example.sightsofeurope;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText usernameRegEditText;
    EditText passwordRegEditText;
    EditText password2RegEditText;
    Button registerButton;
    TextView loginLinkTextView;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        usernameRegEditText = findViewById(R.id.usernameRegEditText);
        passwordRegEditText = findViewById(R.id.passwordRegEditText);
        password2RegEditText = findViewById(R.id.password2RegEditText);
        registerButton = findViewById(R.id.registerButton);
        loginLinkTextView = findViewById(R.id.loginLinkTextView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameRegEditText.getText().toString().trim();
                String pwd = passwordRegEditText.getText().toString().trim();
                String cnf_pwd = password2RegEditText.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user, pwd);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginLinkTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
