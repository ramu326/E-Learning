package com.analogit.elearningapp.ApiModel;

public class RecentUpdateModel {
    int id,update;
    String name,image;

    public RecentUpdateModel(int id, int update, String name, String image) {
        this.id = id;
        this.update = update;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
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
