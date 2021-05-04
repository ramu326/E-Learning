package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.WallPosterModel;
import com.analogit.elearningapp.R;

public class RecyclerLearnSubjectsSubTopicAdapter extends ListAdapter<WallPosterModel,RecyclerLearnSubjectsSubTopicAdapter.MyViewholder> {

    Fragment fragment;
    public RecyclerLearnSubjectsSubTopicAdapter( Fragment fragment) {
        super(WallPosterModel.wallPosterModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_subjects_subtopic_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {



    }

    class MyViewholder extends RecyclerView.ViewHolder{
            ImageView imageView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
