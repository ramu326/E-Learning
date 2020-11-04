package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TndThreeModel {
    int Id;
    String Title;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public TndThreeModel(int id, String title) {
        Id = id;
        Title = title;
    }
    public  static DiffUtil.ItemCallback<TndThreeModel>tndThreeModelItemCallback=new DiffUtil.ItemCallback<TndThreeModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TndThreeModel oldItem, @NonNull TndThreeModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TndThreeModel oldItem, @NonNull TndThreeModel newItem) {
            return oldItem.Title.equals(newItem.getTitle());
        }
    };
}
