package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class HomeImageTwoModel {
    int id;
    String Image;

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

    public HomeImageTwoModel(int id, String image) {
        this.id = id;
        Image = image;
    }
    public static DiffUtil.ItemCallback<HomeImageTwoModel>homeImageTwoModelItemCallback=new DiffUtil.ItemCallback<HomeImageTwoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull HomeImageTwoModel oldItem, @NonNull HomeImageTwoModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull HomeImageTwoModel oldItem, @NonNull HomeImageTwoModel newItem) {
            return oldItem.Image.equals(newItem.getImage());
        }
    };
}
