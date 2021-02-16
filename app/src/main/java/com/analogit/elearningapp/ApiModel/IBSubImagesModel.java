package com.analogit.elearningapp.ApiModel;

public class IBSubImagesModel {
    int image_no;
    String subject_name,image,description;

    public IBSubImagesModel( int image_no, String subject_name, String image, String description) {

        this.image_no = image_no;
        this.subject_name = subject_name;
        this.image = image;
        this.description = description;
    }



    public int getImage_no() {
        return image_no;
    }

    public void setImage_no(int image_no) {
        this.image_no = image_no;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
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
