package com.analogit.elearningapp.ApiModel;

public class IBAllImagesModel {
    int image_no;
    String image,description,subject_name;

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public IBAllImagesModel(int image_no, String image, String description, String subject_name) {
        this.image_no = image_no;
        this.image = image;
        this.description = description;
        this.subject_name=subject_name;
    }



    public int getImage_no() {
        return image_no;
    }

    public void setImage_no(int image_no) {
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
