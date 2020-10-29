package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class MorningConModel {
    int id;
    String Image,Topic,Subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public MorningConModel(int id, String image, String topic, String subject) {
        this.id = id;
        Image = image;
        Topic = topic;
        Subject = subject;
    }

    public  static DiffUtil.ItemCallback<MorningConModel>morningConModelItemCallback=new DiffUtil.ItemCallback<MorningConModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull MorningConModel oldItem, @NonNull MorningConModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull MorningConModel oldItem, @NonNull MorningConModel newItem) {
            return oldItem.Image.equals(newItem.getImage());
        }
    };
}
