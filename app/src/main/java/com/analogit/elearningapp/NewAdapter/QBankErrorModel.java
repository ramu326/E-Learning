package com.analogit.elearningapp.NewAdapter;

public class QBankErrorModel {
    int id,error;
    String name,image;

    public QBankErrorModel(int id, int error, String name, String image) {
        this.id = id;
        this.error = error;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
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
