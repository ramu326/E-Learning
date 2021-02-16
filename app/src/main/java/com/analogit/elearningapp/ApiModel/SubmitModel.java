package com.analogit.elearningapp.ApiModel;

public class SubmitModel {

    int total_attempts,correct,wrong,skip,accuracy,average,rank,daily_question;
    String strength;

    public int getTotal_attempts() {
        return total_attempts;
    }

    public void setTotal_attempts(int total_attempts) {
        this.total_attempts = total_attempts;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDaily_question() {
        return daily_question;
    }

    public void setDaily_question(int daily_question) {
        this.daily_question = daily_question;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public SubmitModel(int total_attempts, int correct, int wrong, int skip, int accuracy, int average, int rank, int daily_question, String strength) {
        this.total_attempts = total_attempts;
        this.correct = correct;
        this.wrong = wrong;
        this.skip = skip;
        this.accuracy = accuracy;
        this.average = average;
        this.rank = rank;
        this.daily_question = daily_question;
        this.strength = strength;
    }
}