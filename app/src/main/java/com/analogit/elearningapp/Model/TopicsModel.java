package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TopicsModel {
    int Id;
    String TopicName;

    public TopicsModel(int id) {
        Id = id;
    }

    public TopicsModel(String topicName) {
        TopicName = topicName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }

    public static DiffUtil.ItemCallback<TopicsModel> topicsModelItemCallback = new DiffUtil.ItemCallback<TopicsModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TopicsModel oldItem, @NonNull TopicsModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TopicsModel oldItem, @NonNull TopicsModel newItem) {
            return oldItem.TopicName.equals(newItem.getTopicName());
        }
    };
}