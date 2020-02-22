package com.example.sightsofeurope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {

    TextView topicNameTW;
    ListView commentsListView;

    private ArrayList<Comment> allComments = new ArrayList<Comment>();

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        db = new DatabaseHelper(this);

        Intent in = getIntent();
        String transTopicName = (String) in.getSerializableExtra("topic_name");

        topicNameTW = findViewById(R.id.topicNameTW);
        topicNameTW.setText(transTopicName);

        // fonts
        Typeface typefaceFont = Typeface.createFromAsset(getAssets(), "fonts/Orienta-Regular.ttf");
        topicNameTW.setTypeface(typefaceFont);

        allComments = db.getComments();

        Resources res = getResources();
        commentsListView = (ListView) findViewById(R.id.commentsListView);

        String[] comments = new String[allComments.size()];
        String[] users = new String[allComments.size()];
        String[] timestamps = new String[allComments.size()];

        for(int i = 0; i < allComments.size(); i++){
            comments[i] = allComments.get(i).getContent();
            users[i] = allComments.get(i).getUser_username();
            timestamps[i] = allComments.get(i).getTime();
        }
        CommentAdapter commentAdapter = new CommentAdapter(this, comments, users, timestamps);
        commentsListView.setAdapter(commentAdapter);

    }
}
