package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TnDOneModel {
    int Id;
    String Title="";
    String examType="";

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    String startDate="";
    String endDate="";
    String duration="";
    String numberOfQuestions="";
    String subject="";


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public TnDOneModel(int id, String title) {
        Id = id;
        Title = title;
    }

    public TnDOneModel(int id, String title, String examType, String startDate, String endDate, String duration, String numberOfQuestions, String subject) {
        Id = id;
        Title = title;
        this.examType = examType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.numberOfQuestions = numberOfQuestions;
        this.subject = subject;
    }

    public static DiffUtil.ItemCallback<TnDOneModel> tnDOneModelItemCallback = new DiffUtil.ItemCallback<TnDOneModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TnDOneModel oldItem, @NonNull TnDOneModel newItem) {
            return oldItem.Id == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TnDOneModel oldItem, @NonNull TnDOneModel newItem) {
            return oldItem.Title.equals(newItem.getTitle());
        }
    };
}
