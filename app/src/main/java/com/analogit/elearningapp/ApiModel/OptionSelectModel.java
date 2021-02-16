package com.analogit.elearningapp.ApiModel;

public class OptionSelectModel {
    int id;
    String question,correct,wrong,time,created,user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public OptionSelectModel(int id, String question, String correct, String wrong, String time, String created, String user) {
        this.id = id;
        this.question = question;
        this.correct = correct;
        this.wrong = wrong;
        this.time = time;
        this.created = created;
        this.user = user;
    }
}
