package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BottomSheetModel {
    int id;
    String OptOne;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptOne() {
        return OptOne;
    }

    public void setOptOne(String optOne) {
        OptOne = optOne;
    }

    public BottomSheetModel(int id, String optOne) {
        this.id = id;
        OptOne = optOne;
    }
    public  static DiffUtil.ItemCallback<BottomSheetModel>bottomSheetModelItemCallback=new DiffUtil.ItemCallback<BottomSheetModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull BottomSheetModel oldItem, @NonNull BottomSheetModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull BottomSheetModel oldItem, @NonNull BottomSheetModel newItem) {
            return oldItem.OptOne.equals(newItem.getOptOne());
        }
    };
}
