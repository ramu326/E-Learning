package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class HomeImageOneModel {

    int Id;
    String Image;

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

    public HomeImageOneModel(int id, String image) {
        Id = id;
        Image = image;
    }
    public  static DiffUtil.ItemCallback<HomeImageOneModel>homeImageModelItemCallback=new DiffUtil.ItemCallback<HomeImageOneModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull HomeImageOneModel oldItem, @NonNull HomeImageOneModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull HomeImageOneModel oldItem, @NonNull HomeImageOneModel newItem) {
            return oldItem.Image.equals(newItem.getImage());
        }
    };
}
