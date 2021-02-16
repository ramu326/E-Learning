package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsFragment;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAudioAdapter extends ListAdapter<AudioModel,RecyclerAudioAdapter.MyViewholder> {

    Fragment fragment;
    public RecyclerAudioAdapter(Fragment fragment) {
        super(AudioModel.audioModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_audios_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public void submitList(@Nullable List<AudioModel> list) {
        super.submitList(list==null?null:new ArrayList<AudioModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.cons_icards_audio);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new IcardsFragment()).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
