package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TnDOneModel {
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

    public TnDOneModel(int id, String title) {
        Id = id;
        Title = title;
    }
    public  static DiffUtil.ItemCallback<TnDOneModel>tnDOneModelItemCallback=new DiffUtil.ItemCallback<TnDOneModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TnDOneModel oldItem, @NonNull TnDOneModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TnDOneModel oldItem, @NonNull TnDOneModel newItem) {
            return oldItem.Title.equals(newItem.getTitle());
        }
    };
}
