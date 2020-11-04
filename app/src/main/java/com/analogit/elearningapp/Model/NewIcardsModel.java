package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NewIcardsModel {
    int Id;
    String fYearSub,sYearSub,tYearSub,foYearSub,fiYearSub;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getfYearSub() {
        return fYearSub;
    }

    public void setfYearSub(String fYearSub) {
        this.fYearSub = fYearSub;
    }

    public String getsYearSub() {
        return sYearSub;
    }

    public void setsYearSub(String sYearSub) {
        this.sYearSub = sYearSub;
    }

    public String gettYearSub() {
        return tYearSub;
    }

    public void settYearSub(String tYearSub) {
        this.tYearSub = tYearSub;
    }

    public String getFoYearSub() {
        return foYearSub;
    }

    public void setFoYearSub(String foYearSub) {
        this.foYearSub = foYearSub;
    }

    public String getFiYearSub() {
        return fiYearSub;
    }

    public void setFiYearSub(String fiYearSub) {
        this.fiYearSub = fiYearSub;
    }

    public NewIcardsModel(int id, String fYearSub, String sYearSub, String tYearSub, String foYearSub, String fiYearSub) {
        Id = id;
        this.fYearSub = fYearSub;
        this.sYearSub = sYearSub;
        this.tYearSub = tYearSub;
        this.foYearSub = foYearSub;
        this.fiYearSub = fiYearSub;
    }
    public static DiffUtil.ItemCallback<NewIcardsModel>newIcardsModelItemCallback=new DiffUtil.ItemCallback<NewIcardsModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull NewIcardsModel oldItem, @NonNull NewIcardsModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewIcardsModel oldItem, @NonNull NewIcardsModel newItem) {
            return oldItem.fiYearSub.equals(newItem.fiYearSub);
        }
    };
}
