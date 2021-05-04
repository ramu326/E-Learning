package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.DrNotesFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerDrNotesWithTopicWiseAdapter extends RecyclerView.Adapter<RecyclerDrNotesWithTopicWiseAdapter.TopicAdapter> {

  Context context;
  ArrayList<DoctorModel>arrayList;

    public RecyclerDrNotesWithTopicWiseAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TopicAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TopicAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_child_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class TopicAdapter extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout;
        public TopicAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.ll_new_sub_go_qutions_module);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    constraintLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppCompatActivity app3=(AppCompatActivity)v.getContext();
                            app3.getSupportFragmentManager().beginTransaction().replace(R.id.content,new DrNotesFragment()).addToBackStack(null).commit();
                        }
                    });
                }
            });
        }
    }
}
