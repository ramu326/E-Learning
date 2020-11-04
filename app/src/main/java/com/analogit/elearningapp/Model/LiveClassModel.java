package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class LiveClassModel {
    int Id;
    String Image;
    String Calendar;
    String TopicName;
    String Time;
    String Subject;
    String Play;
    String Views;

    public LiveClassModel(int id, String image, String calendar, String topicName, String time, String subject, String play, String views, String likes, String shares, String longText) {
        Id = id;
        Image = image;
        Calendar = calendar;
        TopicName = topicName;
        Time = time;
        Subject = subject;
        Play = play;
        Views = views;
        Likes = likes;
        Shares = shares;
        LongText = longText;
    }

    String Likes;
    String Shares;
    String LongText;
    public String getLongText() {
        return LongText;
    }

    public void setLongText(String longText) {
        LongText = longText;
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

    public String getCalendar() {
        return Calendar;
    }

    public void setCalendar(String calendar) {
        Calendar = calendar;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getPlay() {
        return Play;
    }

    public void setPlay(String play) {
        Play = play;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }

    public String getShares() {
        return Shares;
    }

    public void setShares(String shares) {
        Shares = shares;
    }

    public static DiffUtil.ItemCallback<LiveClassModel>liveClassModelItemCallback=new DiffUtil.ItemCallback<LiveClassModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull LiveClassModel oldItem, @NonNull LiveClassModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull LiveClassModel oldItem, @NonNull LiveClassModel newItem) {
            return oldItem.getImage().equals(newItem.getImage());
        }
    };
}
