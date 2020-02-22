package com.example.sightsofeurope;
import java.io.Serializable;

public class Topic {
    private int id;
    private String name;
    private String user_username;
    private int sight_id;

    public Topic(int id, String name, String user_username, int sight_id){
        this.id = id;
        this.name = name;
        this.user_username = user_username;
        this.sight_id = sight_id;
    }

    public Topic(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getSight_id() {
        return sight_id;
    }

    public void setSight_id(int sight_id) {
        this.sight_id = sight_id;
    }
}
