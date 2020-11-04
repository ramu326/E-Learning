package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ExamModulesModels {
    int Id;
    String Grand,Recall,Mini,Title,Completed,pause,pending,stock;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGrand() {
        return Grand;
    }

    public void setGrand(String grand) {
        Grand = grand;
    }

    public String getRecall() {
        return Recall;
    }

    public void setRecall(String recall) {
        Recall = recall;
    }

    public String getMini() {
        return Mini;
    }

    public void setMini(String mini) {
        Mini = mini;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCompleted() {
        return Completed;
    }

    public void setCompleted(String completed) {
        Completed = completed;
    }

    public String getPause() {
        return pause;
    }

    public void setPause(String pause) {
        this.pause = pause;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public ExamModulesModels(int id, String grand, String recall, String mini, String title, String completed, String pause, String pending, String stock) {
        Id = id;
        Grand = grand;
        Recall = recall;
        Mini = mini;
        Title = title;
        Completed = completed;
        this.pause = pause;
        this.pending = pending;
        this.stock = stock;
    }
    public static DiffUtil.ItemCallback<ExamModulesModels>examsModelsItemCallback=new DiffUtil.ItemCallback<ExamModulesModels>() {
        @Override
        public boolean areItemsTheSame(@NonNull ExamModulesModels oldItem, @NonNull ExamModulesModels newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ExamModulesModels oldItem, @NonNull ExamModulesModels newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    };
}
