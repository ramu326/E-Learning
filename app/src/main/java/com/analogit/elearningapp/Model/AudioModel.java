package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class AudioModel {
    int Id;
    String AudioName;

    public AudioModel(int id, String audioName) {
        Id = id;
        AudioName = audioName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAudioName() {
        return AudioName;
    }

    public void setAudioName(String audioName) {
        AudioName = audioName;
    }
    public  static DiffUtil.ItemCallback<AudioModel>audioModelItemCallback=new DiffUtil.ItemCallback<AudioModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull AudioModel oldItem, @NonNull AudioModel newItem) {
            return oldItem.Id==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull AudioModel oldItem, @NonNull AudioModel newItem) {
            return oldItem.AudioName.equals(newItem.getAudioName());
        }
    };
}
