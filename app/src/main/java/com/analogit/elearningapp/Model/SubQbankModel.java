package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class SubQbankModel {
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

    public SubQbankModel(int id, String subname) {
        Id = id;
        Subname = subname;
    }
    public static DiffUtil.ItemCallback<SubQbankModel>subQbankModelItemCallback=new DiffUtil.ItemCallback<SubQbankModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull SubQbankModel oldItem, @NonNull SubQbankModel newItem) {
            return newItem.Id==oldItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull SubQbankModel oldItem, @NonNull SubQbankModel newItem) {
            return false;
        }
    };
}
