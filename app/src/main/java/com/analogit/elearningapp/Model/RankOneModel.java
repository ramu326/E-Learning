package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class RankOneModel {
    int id,Rank,Cash;
    String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public int getCash() {
        return Cash;
    }

    public void setCash(int cash) {
        Cash = cash;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public RankOneModel(int id, int rank, int cash, String name) {
        this.id = id;
        Rank = rank;
        Cash = cash;
        Name = name;
    }
    public static DiffUtil.ItemCallback<RankOneModel>rankOneModelItemCallback=new DiffUtil.ItemCallback<RankOneModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull RankOneModel oldItem, @NonNull RankOneModel newItem) {
            return oldItem.id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull RankOneModel oldItem, @NonNull RankOneModel newItem) {
            return oldItem.Name.equals(newItem.getName());
        }
    };
}
