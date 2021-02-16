package com.analogit.elearningapp.ApiModel;

public class QuestionOfDayDecModel {
    String description,answer,image;
    Boolean status;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public QuestionOfDayDecModel(String description, String answer, String image, Boolean status) {
        this.description = description;
        this.answer = answer;
        this.image = image;
        this.status = status;
    }
}
