package com.analogit.elearningapp.ApiModel;

public class QbankPastExamsWithSubJectsModel {
    int id;
    String subject,image;

    public QbankPastExamsWithSubJectsModel(int id, String subject, String image) {
        this.id = id;
        this.subject = subject;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
