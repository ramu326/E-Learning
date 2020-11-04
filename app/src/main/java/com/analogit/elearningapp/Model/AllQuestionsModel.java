package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class AllQuestionsModel {
    int Id;
    int No;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public AllQuestionsModel(int id, int no) {
        Id = id;
        No = no;
    }

   public static DiffUtil.ItemCallback<AllQuestionsModel> allQuestionsModelItemCallback=new DiffUtil.ItemCallback<AllQuestionsModel>() {
       @Override
       public boolean areItemsTheSame(@NonNull AllQuestionsModel oldItem, @NonNull AllQuestionsModel newItem) {
           return newItem.getId()==oldItem.getId();
       }

       @Override
       public boolean areContentsTheSame(@NonNull AllQuestionsModel oldItem, @NonNull AllQuestionsModel newItem) {
           return newItem.getNo()==newItem.getNo();
       }
   };
}
