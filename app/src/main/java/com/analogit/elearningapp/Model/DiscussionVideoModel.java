package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DiscussionVideoModel {
    int id,time;
    String subject,correct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public DiscussionVideoModel(int id, int time, String subject, String correct) {
        this.id = id;
        this.time = time;
        this.subject = subject;
        this.correct = correct;
    }
    public  static DiffUtil.ItemCallback<DiscussionVideoModel>discussionVideoModelItemCallback=new DiffUtil.ItemCallback<DiscussionVideoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull DiscussionVideoModel oldItem, @NonNull DiscussionVideoModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull DiscussionVideoModel oldItem, @NonNull DiscussionVideoModel newItem) {
            return oldItem.subject.equals(newItem.getSubject());
        }
    };
}
