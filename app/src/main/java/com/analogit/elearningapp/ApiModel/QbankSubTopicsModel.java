package com.analogit.elearningapp.ApiModel;

public class QbankSubTopicsModel {
    int topic_id,total_question;
    String topic_name,image;

    public QbankSubTopicsModel(int topic_id, int total_question, String topic_name, String image) {
        this.topic_id = topic_id;
        this.total_question = total_question;
        this.topic_name = topic_name;
        this.image = image;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getTotal_question() {
        return total_question;
    }

    public void setTotal_question(int total_question) {
        this.total_question = total_question;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
