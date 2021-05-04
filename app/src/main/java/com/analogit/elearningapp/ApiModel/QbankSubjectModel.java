package com.analogit.elearningapp.ApiModel;

public class QbankSubjectModel {
    int id,total_topics,out_of;

    String name,image;

    public QbankSubjectModel(int id, int total_topics, int out_of, String name, String image) {
        this.id = id;
        this.total_topics = total_topics;
        this.out_of = out_of;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_topics() {
        return total_topics;
    }

    public void setTotal_topics(int total_topics) {
        this.total_topics = total_topics;
    }

    public int getOut_of() {
        return out_of;
    }

    public void setOut_of(int out_of) {
        this.out_of = out_of;
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
