package com.example.sightsofeurope;
import java.io.Serializable;

public class Country {
    private int id;
    private String name;
    private String flag;
    private String cover;
    private String capital;
    private String area;
    private String population;
    private String language;
    private String religion;
    private String currency;
    private double bottomBoundary;
    private double leftBoundary;
    private double topBoundary;
    private double rightBoundary;
    private String content;

    public Country(int id, String name, String flag, String cover, String capital, String area, String population, String language, String religion,
                   String currency, double bottomBoundary, double leftBoundary, double topBoundary, double rightBoundary, String content){
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.cover = cover;
        this.capital = capital;
        this.area = area;
        this.population = population;
        this.language = language;
        this.religion = religion;
        this.currency = currency;
        this.bottomBoundary = bottomBoundary;
        this.leftBoundary = leftBoundary;
        this.topBoundary = topBoundary;
        this.rightBoundary = rightBoundary;
        this.content = content;
    }

    public Country(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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
}
