package com.analogit.elearningapp.ApiModel;

public class TeachersModel {
    int id,subject;
    String name,image,experience,s_name;



    public TeachersModel(int id, int subject, String name, String image, String experience, String s_name) {
        this.id = id;
        this.subject = subject;
        this.name = name;
        this.image = image;
        this.experience = experience;
        this.s_name=s_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
}
