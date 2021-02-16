package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class GroupDiscussionSubModel {
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

    public GroupDiscussionSubModel(int id, String image) {
        this.id = id;
        Image = image;
    }
    public static DiffUtil.ItemCallback<GroupDiscussionSubModel>homeImageTwoModelItemCallback=new DiffUtil.ItemCallback<GroupDiscussionSubModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull GroupDiscussionSubModel oldItem, @NonNull GroupDiscussionSubModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull GroupDiscussionSubModel oldItem, @NonNull GroupDiscussionSubModel newItem) {
            return oldItem.Image.equals(newItem.getImage());
        }
    };
}
