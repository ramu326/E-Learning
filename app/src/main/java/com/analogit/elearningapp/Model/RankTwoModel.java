package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class RankTwoModel {
    int Id,Rank,Candidtaes;
    String TitleName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public int getCandidtaes() {
        return Candidtaes;
    }

    public void setCandidtaes(int candidtaes) {
        Candidtaes = candidtaes;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public RankTwoModel(int id, int rank, int candidtaes, String titleName) {
        Id = id;
        Rank = rank;
        Candidtaes = candidtaes;
        TitleName = titleName;
    }
    public  static DiffUtil.ItemCallback<RankTwoModel>rankTwoModelItemCallback=new DiffUtil.ItemCallback<RankTwoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull RankTwoModel oldItem, @NonNull RankTwoModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull RankTwoModel oldItem, @NonNull RankTwoModel newItem) {
            return oldItem.TitleName.equals(newItem.getTitleName());
        }
    };
}
