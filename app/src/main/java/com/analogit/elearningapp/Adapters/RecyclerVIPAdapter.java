package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.AppwallModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVIPAdapter extends ListAdapter<AppwallModel, RecyclerVIPAdapter.MyViewholder> {
            Fragment fragment1;
    public RecyclerVIPAdapter(Fragment fragment1) {
        super(AppwallModel.appwallModelItemCallback);
        this.fragment1=fragment1;
    }



    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_app_wall_row,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }
    @Override
    public void submitList(@Nullable List<AppwallModel> list) {
        super.submitList(list == null ? null : new ArrayList<AppwallModel>(list));
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
