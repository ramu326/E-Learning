package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.MorningRoundPracticalsDecFragment;
import com.analogit.elearningapp.Model.ExamModulesModels;
import com.analogit.elearningapp.R;

public class RecyclerMorningRoundPracticalAdapter extends ListAdapter<ExamModulesModels, RecyclerMorningRoundPracticalAdapter.MyViewholder> {
        Fragment examModuleFragment;
    public RecyclerMorningRoundPracticalAdapter(Fragment examModuleFragment) {
        super(ExamModulesModels.examsModelsItemCallback);
        this.examModuleFragment=examModuleFragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.morning_round_practicles_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {


    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        constraintLayout=itemView.findViewById(R.id.constraint_morning_round_dec_practical);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new MorningRoundPracticalsDecFragment()).addToBackStack(null).commit();
            }
        });


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
