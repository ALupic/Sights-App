package com.example.sightsofeurope;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ForumFragment extends Fragment {

    Button addTopicButton;
    ListView topicsListView;
    private ArrayList<Topic> allTopics = new ArrayList<Topic>();
    int sightId;

    DatabaseHelper db;

    public ForumFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forum, container, false);
        db = new DatabaseHelper(v.getContext());

        allTopics = db.getTopics();

        sightId = getActivity().getIntent().getIntExtra("sight_id", 1);

        System.out.println("////// FORUM - SIGHT_ID: " + sightId);

        Resources res = getResources();
        topicsListView = (ListView) v.findViewById(R.id.topicsListView);

        List<String> listTopics = new ArrayList<String>();
        int counter = 0;

        for(int i = 0; i < allTopics.size(); i++){
            if(allTopics.get(i).getSight_id() == sightId){
                System.out.println("////// FORUM - I: " + i);
                System.out.println("////// FORUM - NAME: " + allTopics.get(i).getName());
                listTopics.add(allTopics.get(i).getName());
                counter = counter+1;
            }
        }

        String[] topics = new String[counter];
        topics = listTopics.toArray(topics);

        TopicAdapter topicAdapter = new TopicAdapter(v.getContext(), topics);
        topicsListView.setAdapter(topicAdapter);

        topicsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //int p = allSights.get(i).getId();
                Intent showCommentActivity = new Intent(view.getContext(), CommentActivity.class);
                int selectedTopicId = adapterView.getId();
                //  showArticleActivity.putExtra("com.example.news24.ITEM_INDEX", position);
                int topicId = allTopics.get(i).getId();
                Topic topic = db.findTopicById(topicId);
                String selectedFromList = (String)topicsListView.getItemAtPosition(i);                      // Takes the name of the topic and compares it to the database to get the ID
                for(int pos=0; pos< allTopics.size(); pos++){
                    if((allTopics.get(pos).getName().equals(selectedFromList))){
                        showCommentActivity.putExtra("topic_id", allTopics.get(pos).getId());
                        showCommentActivity.putExtra("topic_name", allTopics.get(pos).getName());
                        System.out.println("////// INSIDE CHECK !!!!!!!!!!!!!!! " + allTopics.get(i).getName());
                        startActivity(showCommentActivity);
                    }
                }
            }
        });

        // ADD TOPIC BUTTON
        addTopicButton = v.findViewById(R.id.addTopicButton);

        addTopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopicDialog topicDialog = new TopicDialog();
                topicDialog.show(getFragmentManager(), "missiles");
            }
        });

        return v;
    }

}
