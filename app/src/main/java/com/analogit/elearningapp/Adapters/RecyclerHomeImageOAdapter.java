package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.HomeFragment;
import com.analogit.elearningapp.Model.HomeImageOneModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerHomeImageOAdapter extends ListAdapter<HomeImageOneModel, RecyclerHomeImageOAdapter.MyViewholder> {
    HomeFragment homeFragment;
    public RecyclerHomeImageOAdapter(HomeFragment homeFragment) {
        super(HomeImageOneModel.homeImageModelItemCallback);
        this.homeFragment=homeFragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_image_one_row,parent,false));
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
        ImageView Image;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Image=itemView.findViewById(R.id.iv_hir_image);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
