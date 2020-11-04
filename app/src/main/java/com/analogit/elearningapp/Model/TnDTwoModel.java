package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TnDTwoModel {
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

    public TnDTwoModel(int id, String title) {
        Id = id;
        Title = title;
    }
    public  static DiffUtil.ItemCallback<TnDTwoModel>tnDTwoModelItemCallback=new DiffUtil.ItemCallback<TnDTwoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TnDTwoModel oldItem, @NonNull TnDTwoModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TnDTwoModel oldItem, @NonNull TnDTwoModel newItem) {
            return oldItem.Title.equals(newItem.getTitle());
        }
    };
}
