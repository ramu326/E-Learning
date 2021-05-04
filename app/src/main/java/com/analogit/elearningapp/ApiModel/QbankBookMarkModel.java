package com.analogit.elearningapp.ApiModel;

public class QbankBookMarkModel {
    int id,bookmark;
    String name,image;

    public QbankBookMarkModel(int id, int bookmark, String name, String image) {
        this.id = id;
        this.bookmark = bookmark;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
