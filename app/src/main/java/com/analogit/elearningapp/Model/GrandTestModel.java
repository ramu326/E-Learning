package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class GrandTestModel {
    int Id;
    String TestName,Start,Reseme,Review,Mcq,Mins,AllTopics;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getReseme() {
        return Reseme;
    }

    public void setReseme(String reseme) {
        Reseme = reseme;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getMcq() {
        return Mcq;
    }

    public void setMcq(String mcq) {
        Mcq = mcq;
    }

    public String getMins() {
        return Mins;
    }

    public void setMins(String mins) {
        Mins = mins;
    }

    public String getAllTopics() {
        return AllTopics;
    }

    public void setAllTopics(String allTopics) {
        AllTopics = allTopics;
    }

    public GrandTestModel(int id, String testName, String start, String reseme, String review, String mcq, String mins, String allTopics) {
        Id = id;
        TestName = testName;
        Start = start;
        Reseme = reseme;
        Review = review;
        Mcq = mcq;
        Mins = mins;
        AllTopics = allTopics;
    }
    public  static DiffUtil.ItemCallback<GrandTestModel>grandTestModelItemCallback=new DiffUtil.ItemCallback<GrandTestModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull GrandTestModel oldItem, @NonNull GrandTestModel newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull GrandTestModel oldItem, @NonNull GrandTestModel newItem) {
            return oldItem.getTestName().equals(newItem.getTestName());
        }
    };
}
