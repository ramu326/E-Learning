package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.HomeLiveClassPartTwoFragment;
import com.analogit.elearningapp.Fragments.LiveClassFragment;
import com.analogit.elearningapp.Model.LiveClassModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class RecyclerLiveClassAdapter extends ListAdapter <LiveClassModel, RecyclerLiveClassAdapter.MyViewholder>{
    Fragment fragment;
    public RecyclerLiveClassAdapter(Fragment fragment) {
        super(LiveClassModel.liveClassModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_live_class_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }
    @Override
    public void submitList(@Nullable List<LiveClassModel> list) {
        super.submitList(list == null ? null : new ArrayList<LiveClassModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        constraintLayout=itemView.findViewById(R.id.const_live_class);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new HomeLiveClassPartTwoFragment()).addToBackStack(null).commit();
            }
        });

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
