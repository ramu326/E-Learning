package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.DrLearnWallPosterDiscussionFullVideoFragment;
import com.analogit.elearningapp.Model.HomeImageOneModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDrLearnWallposterAdapter extends ListAdapter<HomeImageOneModel, RecyclerDrLearnWallposterAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerDrLearnWallposterAdapter(Fragment fragment) {
        super(HomeImageOneModel.homeImageModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_poster_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
      //  holder.Image.
    }

    @Override
    public void submitList(@Nullable List<HomeImageOneModel> list) {
        super.submitList(list==null?null:new ArrayList<HomeImageOneModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        CardView image;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.wall_poster_grid_card_view);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity appCompatActivity=(AppCompatActivity)v.getContext();
                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new DrLearnWallPosterDiscussionFullVideoFragment() ).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 26;
    }
}
