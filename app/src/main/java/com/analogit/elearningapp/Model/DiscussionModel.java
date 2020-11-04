package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class DiscussionModel {

    int Id;
    String Videos;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVideos() {
        return Videos;
    }

    public void setVideos(String videos) {
        Videos = videos;
    }

    public DiscussionModel(int id, String videos) {
        Id = id;
        Videos = videos;
    }
    public static DiffUtil.ItemCallback<DiscussionModel>discussionModelItemCallback=new DiffUtil.ItemCallback<DiscussionModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull DiscussionModel oldItem, @NonNull DiscussionModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull DiscussionModel oldItem, @NonNull DiscussionModel newItem) {
            return oldItem.Videos.equals(newItem.Videos);
        }
    };
}
