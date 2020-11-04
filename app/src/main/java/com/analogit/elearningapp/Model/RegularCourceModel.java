package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class RegularCourceModel {
    int Id;
    String Subject,Image,Tasks,Progress,Rating,Qtext,Ptest,Stest;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTasks() {
        return Tasks;
    }

    public void setTasks(String tasks) {
        Tasks = tasks;
    }

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getQtext() {
        return Qtext;
    }

    public void setQtext(String qtext) {
        Qtext = qtext;
    }

    public String getPtest() {
        return Ptest;
    }

    public void setPtest(String ptest) {
        Ptest = ptest;
    }

    public String getStest() {
        return Stest;
    }

    public void setStest(String stest) {
        Stest = stest;
    }

    public RegularCourceModel(int id, String subject, String image, String tasks, String progress, String rating, String qtext, String ptest, String stest) {
        Id = id;
        Subject = subject;
        Image = image;
        Tasks = tasks;
        Progress = progress;
        Rating = rating;
        Qtext = qtext;
        Ptest = ptest;
        Stest = stest;
    }
    public static DiffUtil.ItemCallback<RegularCourceModel>regularCourceModelItemCallback=new DiffUtil.ItemCallback<RegularCourceModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull RegularCourceModel oldItem, @NonNull RegularCourceModel newItem) {
            return newItem.Id==oldItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull RegularCourceModel oldItem, @NonNull RegularCourceModel newItem) {
            return newItem.Image.equals(oldItem.getImage());
        }
    };
}

