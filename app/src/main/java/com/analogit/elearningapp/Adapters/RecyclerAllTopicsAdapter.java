package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.SubjectQbankFragment;
import com.analogit.elearningapp.Model.NewIcardsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAllTopicsAdapter extends ListAdapter<NewIcardsModel,RecyclerAllTopicsAdapter.MyViewholder> {
    Fragment fragment;

    public RecyclerAllTopicsAdapter(Fragment fragment) {
        super(NewIcardsModel.newIcardsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_topic_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public void submitList(@Nullable List<NewIcardsModel> list) {
        super.submitList(list==null?null:new ArrayList<NewIcardsModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{


        LinearLayout linearLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.ll_subject_topic_modules);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new IcardsZoomImagesFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, myFragment).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
