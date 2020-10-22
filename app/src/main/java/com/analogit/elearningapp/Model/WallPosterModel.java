package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class WallPosterModel {
    int id;
    String Topic,Image;

    public WallPosterModel(int id, String topic, String image) {
        this.id = id;
        Topic = topic;
        Image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    public  static DiffUtil.ItemCallback<WallPosterModel>wallPosterModelItemCallback=new DiffUtil.ItemCallback<WallPosterModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull WallPosterModel oldItem, @NonNull WallPosterModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull WallPosterModel oldItem, @NonNull WallPosterModel newItem) {
            return newItem.Image.equals(oldItem.getImage());
        }
    };
}
