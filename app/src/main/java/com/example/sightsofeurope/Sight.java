package com.example.sightsofeurope;
import java.io.Serializable;

public class Sight {
    private int id;
    private String name;
    private String cover;
    private String listImage;
    private double latt;
    private double longt;
    private double bottomBoundary;
    private double leftBoundary;
    private double topBoundary;
    private double rightBoundary;
    private String content;
    private int country_id;

    public Sight(int id, String name, String cover, String listImage, double latt, double longt, double bottomBoundary, double leftBoundary, double topBoundary, double rightBoundary, String content, int country_id){
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.listImage = listImage;
        this.latt = latt;
        this.longt = longt;
        this.bottomBoundary = bottomBoundary;
        this.leftBoundary = leftBoundary;
        this.topBoundary = topBoundary;
        this.rightBoundary = rightBoundary;
        this.content = content;
        this.country_id = country_id;
    }

    public Sight(){

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public double getLatt() { return latt; }

    public void setLatt(double latt) { this.latt = latt; }

    public double getLongt() { return longt; }

    public void setLongt(double longt) { this.longt = longt; }

    public double getBottomBoundary() {
        return bottomBoundary;
    }

    public void setBottomBoundary(double bottomBoundary) {
        this.bottomBoundary = bottomBoundary;
    }

    public double getLeftBoundary() {
        return leftBoundary;
    }

    public void setLeftBoundary(double leftBoundary) {
        this.leftBoundary = leftBoundary;
    }

    public double getTopBoundary() { return topBoundary; }

    public void setTopBoundary(double topBoundary) {
        this.topBoundary = topBoundary;
    }

    public double getRightBoundary() {
        return rightBoundary;
    }

    public void setRightBoundary(double rightBoundary) {
        this.rightBoundary = rightBoundary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
