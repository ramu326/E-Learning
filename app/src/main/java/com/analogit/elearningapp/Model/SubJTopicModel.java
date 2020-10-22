package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class SubJTopicModel {
    int Id;
   Boolean Topic;

    public SubJTopicModel(int id, Boolean topic) {
        Id = id;
        Topic = topic;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Boolean getTopic() {
        return Topic;
    }

    public void setTopic(Boolean topic) {
        Topic = topic;
    }

    public static DiffUtil.ItemCallback<SubJTopicModel> getSubJTopicModelItemCallback() {
        return subJTopicModelItemCallback;
    }

    public static void setSubJTopicModelItemCallback(DiffUtil.ItemCallback<SubJTopicModel> subJTopicModelItemCallback) {
        SubJTopicModel.subJTopicModelItemCallback = subJTopicModelItemCallback;
    }

    public static  DiffUtil.ItemCallback<SubJTopicModel>subJTopicModelItemCallback=new DiffUtil.ItemCallback<SubJTopicModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull SubJTopicModel oldItem, @NonNull SubJTopicModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull SubJTopicModel oldItem, @NonNull SubJTopicModel newItem) {
            return oldItem.Topic.equals(newItem.getTopic());
        }
    };
}
