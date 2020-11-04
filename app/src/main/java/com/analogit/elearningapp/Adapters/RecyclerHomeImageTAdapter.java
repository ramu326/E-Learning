package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.HomeFragment;
import com.analogit.elearningapp.Model.HomeImageOneModel;
import com.analogit.elearningapp.Model.HomeImageTwoModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerHomeImageTAdapter extends ListAdapter<HomeImageTwoModel,RecyclerHomeImageTAdapter.MyViewholder> {
    HomeFragment homeFragment;
   public RecyclerHomeImageTAdapter( HomeFragment homeFragment) {
        super(HomeImageTwoModel.homeImageTwoModelItemCallback);
        this.homeFragment=homeFragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_image_two_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public void submitList(@Nullable List<HomeImageTwoModel> list) {
        super.submitList(list==null?null:new ArrayList<HomeImageTwoModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
