package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class AppwallModel {
    int Id;
    String Image,Calander,Testname,Questions,Mints,Attempt,Likes,Share,BtText;

    public AppwallModel(int id, String image, String calander, String testname, String questions, String mints, String attempt, String likes, String share, String btText) {
        Id = id;
        Image = image;
        Calander = calander;
        Testname = testname;
        Questions = questions;
        Mints = mints;
        Attempt = attempt;
        Likes = likes;
        Share = share;
        BtText = btText;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getCalander() {
        return Calander;
    }

    public void setCalander(String calander) {
        Calander = calander;
    }

    public String getTestname() {
        return Testname;
    }

    public void setTestname(String testname) {
        Testname = testname;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getMints() {
        return Mints;
    }

    public void setMints(String mints) {
        Mints = mints;
    }

    public String getAttempt() {
        return Attempt;
    }

    public void setAttempt(String attempt) {
        Attempt = attempt;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }

    public String getShare() {
        return Share;
    }

    public void setShare(String share) {
        Share = share;
    }

    public String getBtText() {
        return BtText;
    }

    public void setBtText(String btText) {
        BtText = btText;
    }


    public  static DiffUtil.ItemCallback<AppwallModel>appwallModelItemCallback=new DiffUtil.ItemCallback<AppwallModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull AppwallModel oldItem, @NonNull AppwallModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull AppwallModel oldItem, @NonNull AppwallModel newItem) {
            return oldItem.Likes.equals(newItem.getLikes());
        }
    };
}
