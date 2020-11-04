package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class HomeSubjectsModels {

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

    public HomeSubjectsModels(int id, String subname) {
        Id = id;
        Subname = subname;
    }
    public static DiffUtil.ItemCallback<HomeSubjectsModels>homeSubjectsModelsItemCallback=new DiffUtil.ItemCallback<HomeSubjectsModels>() {
        @Override
        public boolean areItemsTheSame(@NonNull HomeSubjectsModels oldItem, @NonNull HomeSubjectsModels newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull HomeSubjectsModels oldItem, @NonNull HomeSubjectsModels newItem) {
            return oldItem.Subname.equals(newItem.getSubname());
        }
    };
}
