package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class WallPosterGridModel {
    int Id;
    String ImageUrl;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public WallPosterGridModel(int id, String imageUrl) {
        Id = id;
        ImageUrl = imageUrl;
    }
    public  static DiffUtil.ItemCallback<WallPosterGridModel>imageGridModelItemCallback=new DiffUtil.ItemCallback<WallPosterGridModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull WallPosterGridModel oldItem, @NonNull WallPosterGridModel newItem) {
            return newItem.Id==oldItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull WallPosterGridModel oldItem, @NonNull WallPosterGridModel newItem) {
            return newItem.ImageUrl.equals(oldItem.getImageUrl());
        }
    };
}
