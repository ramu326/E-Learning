package com.analogit.elearningapp.NewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerLearnSubjectsSubTopicAdapter;
import com.analogit.elearningapp.Model.WallPosterModel;
import com.analogit.elearningapp.R;

public class RecyclerMegaQNDAdapter extends ListAdapter<WallPosterModel, RecyclerMegaQNDAdapter.MyViewholder> {

    Fragment fragment;
    public RecyclerMegaQNDAdapter( Fragment fragment) {
        super(WallPosterModel.wallPosterModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mega_qnd_row,parent,false));
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
