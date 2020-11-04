package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class LecturerModel {
    int Id;
    String Image,Designation;

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

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public LecturerModel(int id, String image, String designation) {
        Id = id;
        Image = image;
        Designation = designation;
    }
    public  static DiffUtil.ItemCallback<LecturerModel>lecturerModelItemCallback=new DiffUtil.ItemCallback<LecturerModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull LecturerModel oldItem, @NonNull LecturerModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull LecturerModel oldItem, @NonNull LecturerModel newItem) {
            return oldItem.Image.equals(newItem.getImage());
        }
    };
}
