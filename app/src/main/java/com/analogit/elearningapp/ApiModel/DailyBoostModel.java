package com.analogit.elearningapp.ApiModel;

public class DailyBoostModel {
    int question_id;



    int duration;
    String question,question_image,option1,option2,option3,option4,answer_description,answer_image,answer,created;

    public DailyBoostModel(int question_id,int duration, String question, String question_image, String option1, String option2, String option3, String option4, String answer_description, String answer_image, String answer, String created, Boolean question_status) {
        this.question_id = question_id;
        this.question = question;
        this.question_image = question_image;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.duration = duration;
        this.answer_description = answer_description;
        this.answer_image = answer_image;
        this.answer = answer;
        this.created = created;
        this.question_status = question_status;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(String question_image) {
        this.question_image = question_image;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer_description() {
        return answer_description;
    }

    public void setAnswer_description(String answer_description) {
        this.answer_description = answer_description;
    }

    public String getAnswer_image() {
        return answer_image;
    }

    public void setAnswer_image(String answer_image) {
        this.answer_image = answer_image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Boolean getQuestion_status() {
        return question_status;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public void setQuestion_status(Boolean question_status) {
        this.question_status = question_status;
    }

    Boolean question_status;
}
