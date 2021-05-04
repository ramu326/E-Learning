package com.analogit.elearningapp.ApiModel;

public class IBSubImagesModel {
    int subject_id;
    String subject_name,image_no,image,description;

    public IBSubImagesModel(int subject_id, String subject_name, String image_no, String image, String description) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.image_no = image_no;
        this.image = image;
        this.description = description;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getImage_no() {
        return image_no;
    }

    public void setImage_no(String image_no) {
        this.image_no = image_no;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
