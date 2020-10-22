package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class MedicalPgModel {
    int Id;
    String subject;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MedicalPgModel(int id, String subject) {
        Id = id;
        this.subject = subject;
    }
    public static DiffUtil.ItemCallback<MedicalPgModel>medicalPgModelItemCallback=new DiffUtil.ItemCallback<MedicalPgModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull MedicalPgModel oldItem, @NonNull MedicalPgModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull MedicalPgModel oldItem, @NonNull MedicalPgModel newItem) {
            return oldItem.subject.equals(newItem.getSubject());
        }
    };
}
