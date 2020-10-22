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

import com.analogit.elearningapp.Model.SubJTopicModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerSubJTopicAdapter extends ListAdapter<SubJTopicModel,RecyclerSubJTopicAdapter.MyViewholder> {

                Fragment fragment;
    public RecyclerSubJTopicAdapter(Fragment fragment) {
        super(SubJTopicModel.subJTopicModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view;
        if(viewType==0){
            view=layoutInflater.inflate(R.layout.subject_topic_wise_one_row,parent,false);

        }else{
            view=layoutInflater.inflate(R.layout.subject_topic_wise_two_row,parent,false);

        }

        return new MyViewholder(view);
    }

    @Override
    public int getItemViewType(int position) {
            if(getCurrentList().get(position).getTopic()==true){
                return 0;
            }
            else return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

//        switch (holder.getItemViewType()){
//            case 0:
//
//
//        }

    }

    @Override
    public void submitList(@Nullable List<SubJTopicModel> list) {
        super.submitList(list==null?null:new ArrayList<SubJTopicModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {

            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }
}
