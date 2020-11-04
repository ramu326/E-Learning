package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class LearnVideosModel {
    int Id;
    String Video;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public LearnVideosModel(int id, String video) {
        Id = id;
        Video = video;
    }
    public static DiffUtil.ItemCallback<LearnVideosModel>learnVideosModelItemCallback=new DiffUtil.ItemCallback<LearnVideosModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull LearnVideosModel oldItem, @NonNull LearnVideosModel newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull LearnVideosModel oldItem, @NonNull LearnVideosModel newItem) {
            return false;
        }
    };
}
