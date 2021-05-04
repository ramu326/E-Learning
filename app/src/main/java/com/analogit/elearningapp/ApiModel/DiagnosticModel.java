package com.analogit.elearningapp.ApiModel;

public class DiagnosticModel {
    int id;
    String topic,image,subject;

    public DiagnosticModel(int id, String topic, String image, String subject) {
        this.id = id;
        this.topic = topic;
        this.image = image;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
