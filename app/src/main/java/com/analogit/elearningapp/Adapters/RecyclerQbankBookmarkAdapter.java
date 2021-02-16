package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.GrandTestModel;
import com.analogit.elearningapp.Model.SubjectsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerQbankBookmarkAdapter extends ListAdapter<GrandTestModel, RecyclerQbankBookmarkAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerQbankBookmarkAdapter(Fragment fragment) {
        super(GrandTestModel.grandTestModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.qbnak_bookmark_row,parent,false));

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void submitList(@Nullable List<GrandTestModel> list) {
        super.submitList(list == null ? null : new ArrayList<GrandTestModel>(list));
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
