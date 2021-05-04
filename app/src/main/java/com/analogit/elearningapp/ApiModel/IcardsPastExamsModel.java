package com.analogit.elearningapp.ApiModel;

public class IcardsPastExamsModel {
    int id,past_exam;
    String image,subject;

    public IcardsPastExamsModel(int id, int past_exam, String image, String subject) {
        this.id = id;
        this.past_exam = past_exam;
        this.image = image;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPast_exam() {
        return past_exam;
    }

    public void setPast_exam(int past_exam) {
        this.past_exam = past_exam;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
