package com.example.sightsofeurope;
import java.io.Serializable;

public class Comment {
    private int id;
    private String content;
    private String user_username;
    private String time;
    private int topic_id;

    public Comment(int id, String content, String user_username, String time, int topic_id){
        this.id = id;
        this.content = content;
        this.user_username = user_username;
        this.time = time;
        this.topic_id = topic_id;
    }

    public Comment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
