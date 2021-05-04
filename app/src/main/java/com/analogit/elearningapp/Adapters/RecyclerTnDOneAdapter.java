package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.GeneralIndructionFragmment;

import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.databinding.StartResumeTestDisRowOneBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTnDOneAdapter extends ListAdapter<TnDOneModel,RecyclerTnDOneAdapter.MyViewholder> {

    Fragment fragment;
    public RecyclerTnDOneAdapter(Fragment fragment) {
        super(TnDOneModel.tnDOneModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.start_resume_test_dis_row_one,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        TnDOneModel tnDOneModel=getCurrentList().get(position);

        holder.binding.tvMcq.setText(tnDOneModel.getNumberOfQuestions());

        holder.binding.subject.setText(tnDOneModel.getSubject());

        holder.binding.dateOfExam.setText(tnDOneModel.getStartDate());

        holder.binding.title.setText(tnDOneModel.getTitle());



    }


    @Override
    public void submitList(@Nullable List<TnDOneModel> list) {
        super.submitList(list == null ? null : new ArrayList<TnDOneModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        StartResumeTestDisRowOneBinding binding;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            binding=StartResumeTestDisRowOneBinding.bind(itemView);


            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity appCompatActivity=(AppCompatActivity) view.getContext();
                    Fragment fragment=new GeneralIndructionFragmment();

                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }
}
