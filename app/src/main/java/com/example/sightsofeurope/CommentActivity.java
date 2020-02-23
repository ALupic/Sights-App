package com.example.sightsofeurope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    TextView topicNameTW;
    ListView commentsListView;
    Button addCommentButton;
    int topicId;

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
        topicId = getIntent().getIntExtra("topic_id", 1);


        Resources res = getResources();
        commentsListView = (ListView) findViewById(R.id.commentsListView);


 /*       for(int i = 0; i < allComments.size(); i++){
                comments[i] = allComments.get(i).getContent();
                users[i] = allComments.get(i).getUser_username();
                timestamps[i] = allComments.get(i).getTime();
        }
        */

        List<String> listComments = new ArrayList<String>();
        List<String> listUsers = new ArrayList<String>();
        List<String> listTimestamps = new ArrayList<String>();
        System.out.println("////// HERE I AAAAAAAAAAAAAAAAAAAAAAAAAM!");
        int counter = 0;
        for(int i = 0; i < allComments.size(); i++){
            System.out.println("////// TOPIC ID IN COMMENT ACTIVITY IS: " + topicId);
            if(allComments.get(i).getTopic_id() == topicId){
                System.out.println("////// TOPIC - I: " + i);
                System.out.println("////// TOPIC - CONTENT: " + allComments.get(i).getContent());
                listComments.add(allComments.get(i).getContent());
                listUsers.add(allComments.get(i).getUser_username());
                listTimestamps.add(allComments.get(i).getTime());
                counter = counter+1;
            }
        }

        String[] comments = new String[counter];
        String[] users = new String[counter];
        String[] timestamps = new String[counter];
        comments = listComments.toArray(comments);
        users = listUsers.toArray(users);
        timestamps = listTimestamps.toArray(timestamps);

        CommentAdapter commentAdapter = new CommentAdapter(this, comments, users, timestamps);
        commentsListView.setAdapter(commentAdapter);

        // ADD COMMENT BUTTON - Sending data from activity to dialog
        addCommentButton = findViewById(R.id.addCommentButton);

        addCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentDialog commentDialog = new CommentDialog();
                Bundle bundle = new Bundle();
                bundle.putInt("topic_id", topicId);
                commentDialog.setArguments(bundle);
                commentDialog.show(getSupportFragmentManager(), "missiles");
            }
        });

    }
}
