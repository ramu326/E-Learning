package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ParentChildModel {
    int Id;
    String title,SubTopics;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTopics() {
        return SubTopics;
    }

    public void setSubTopics(String subTopics) {
        SubTopics = subTopics;
    }

    public ParentChildModel(int id, String title, String subTopics) {
        Id = id;
        this.title = title;
        SubTopics = subTopics;
    }
    public static  DiffUtil.ItemCallback<ParentChildModel>parentChildModelItemCallback=new DiffUtil.ItemCallback<ParentChildModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull ParentChildModel oldItem, @NonNull ParentChildModel newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ParentChildModel oldItem, @NonNull ParentChildModel newItem) {
            return false;
        }
    };
}
