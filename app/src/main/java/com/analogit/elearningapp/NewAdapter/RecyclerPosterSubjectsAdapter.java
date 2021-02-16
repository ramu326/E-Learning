package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.Fragments.ImagesBankFragment;
import com.analogit.elearningapp.Fragments.WallPosterGridfFragment;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerPosterSubjectsAdapter extends RecyclerView.Adapter<RecyclerPosterSubjectsAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllSubjectModel>allSubjectDataList;

    public RecyclerPosterSubjectsAdapter(Context context, ArrayList<AllSubjectModel> allSubjectDataList) {
        this.context = context;
        this.allSubjectDataList = allSubjectDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_poster_sub_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.textView.setText(allSubjectDataList.get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallPosterGridfFragment wallPosterGridfFragment=new WallPosterGridfFragment();
                Log.d("haiii",String.valueOf(allSubjectDataList.get(position).getId()));
                Bundle args=new Bundle();
                args.putInt("posterid",allSubjectDataList.get(position).getId());
                wallPosterGridfFragment.setArguments(args);
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,wallPosterGridfFragment).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return allSubjectDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_poster_subjects);

        }
    }
}
