package com.analogit.elearningapp.ApiModel;

public class QuestionOfDayModel {
    int question_id;
    String question,optoin1,optoin2,optoin3,optoin4,answer_image,ans_description,answer_of_question;

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

    public String getOptoin1() {
        return optoin1;
    }

    public void setOptoin1(String optoin1) {
        this.optoin1 = optoin1;
    }

    public String getOptoin2() {
        return optoin2;
    }

    public void setOptoin2(String optoin2) {
        this.optoin2 = optoin2;
    }

    public String getOptoin3() {
        return optoin3;
    }

    public void setOptoin3(String optoin3) {
        this.optoin3 = optoin3;
    }

    public String getOptoin4() {
        return optoin4;
    }

    public void setOptoin4(String optoin4) {
        this.optoin4 = optoin4;
    }

    public String getAnswer_image() {
        return answer_image;
    }

    public void setAnswer_image(String answer_image) {
        this.answer_image = answer_image;
    }

    public String getAns_description() {
        return ans_description;
    }

    public void setAns_description(String ans_description) {
        this.ans_description = ans_description;
    }

    public String getAnswer_of_question() {
        return answer_of_question;
    }

    public void setAnswer_of_question(String answer_of_question) {
        this.answer_of_question = answer_of_question;
    }

    public QuestionOfDayModel(int question_id, String question, String optoin1, String optoin2, String optoin3, String optoin4, String answer_image, String ans_description, String answer_of_question) {
        this.question_id = question_id;
        this.question = question;
        this.optoin1 = optoin1;
        this.optoin2 = optoin2;
        this.optoin3 = optoin3;
        this.optoin4 = optoin4;
        this.answer_image = answer_image;
        this.ans_description = ans_description;
        this.answer_of_question = answer_of_question;
    }
}
