package com.example.user.roomandroid.model;

/**
 * Created by User on 28.08.2018.
 */
public class WallItem {
    private String URLPhoto;
    private String name;
    private String surname;
    private String URLContext;
    private String text;
    private int countLikes;
    private int countReposts;
    private int countComments;
    private int countViews;

    public WallItem(){

    }

    public String getURLPhoto() {
        return URLPhoto;
    }

    public void setURLPhoto(String URLPhoto) {
        this.URLPhoto = URLPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getURLContext() {
        return URLContext;
    }

    public void setURLContext(String URLContext) {
        this.URLContext = URLContext;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public int getCountReposts() {
        return countReposts;
    }

    public void setCountReposts(int countReposts) {
        this.countReposts = countReposts;
    }

    public int getCountComments() {
        return countComments;
    }

    public void setCountComments(int countComments) {
        this.countComments = countComments;
    }

    public int getCountViews() {
        return countViews;
    }

    public void setCountViews(int countViews) {
        this.countViews = countViews;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
