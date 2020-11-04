package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class AllSubjectsModel {
    int Id;
    String Subname;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSubname() {
        return Subname;
    }

    public void setSubname(String subname) {
        Subname = subname;
    }

    public AllSubjectsModel(int id, String subname) {
        Id = id;
        Subname = subname;
    }
    public static DiffUtil.ItemCallback<AllSubjectsModel>allSubjectsModelItemCallback=new DiffUtil.ItemCallback<AllSubjectsModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull AllSubjectsModel oldItem, @NonNull AllSubjectsModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull AllSubjectsModel oldItem, @NonNull AllSubjectsModel newItem) {
            return oldItem.Subname.equals(newItem.getSubname());
        }
    };
}
