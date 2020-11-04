package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class SubjectsModel {
    int Id;
    String Subject,Image,Progress,bPractice,bError,Rating,Tasks;

    public SubjectsModel(int id, String subject, String image, String progress, String bPractice, String bError, String rating, String tasks) {
        Id = id;
        Subject = subject;
        Image = image;
        Progress = progress;
        this.bPractice = bPractice;
        this.bError = bError;
        Rating = rating;
        Tasks = tasks;
    }

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

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getbPractice() {
        return bPractice;
    }

    public void setbPractice(String bPractice) {
        this.bPractice = bPractice;
    }

    public String getbError() {
        return bError;
    }

    public void setbError(String bError) {
        this.bError = bError;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getTasks() {
        return Tasks;
    }

    public void setTasks(String tasks) {
        Tasks = tasks;
    }

   public static DiffUtil.ItemCallback<SubjectsModel>subjectsModelItemCallback=new DiffUtil.ItemCallback<SubjectsModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull SubjectsModel oldItem, @NonNull SubjectsModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull SubjectsModel oldItem, @NonNull SubjectsModel newItem) {
            return oldItem.getImage().equals(newItem.getImage())  && oldItem.getProgress().equals(newItem.getProgress()) &&
                    oldItem.getRating().equals(newItem.getRating())&&newItem.getSubject().equals(oldItem.getSubject());
        }
    };
}
