package com.analogit.elearningapp.ApiModel;

public class QbankPastExamsEntraceModel {
    int id,no_of_question;
    String image,examination_name,name;

    public QbankPastExamsEntraceModel(int id, int no_of_question, String image, String examination_name, String name) {
        this.id = id;
        this.no_of_question = no_of_question;
        this.image = image;
        this.examination_name = examination_name;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_of_question() {
        return no_of_question;
    }

    public void setNo_of_question(int no_of_question) {
        this.no_of_question = no_of_question;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExamination_name() {
        return examination_name;
    }

    public void setExamination_name(String examination_name) {
        this.examination_name = examination_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
