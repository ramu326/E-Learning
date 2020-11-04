package com.analogit.elearningapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.GrandTestModel;

public class RecyclerGrandTestAdapter extends ListAdapter<GrandTestModel,RecyclerGrandTestAdapter.MyViewholder> {

    protected RecyclerGrandTestAdapter(@NonNull DiffUtil.ItemCallback<GrandTestModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
