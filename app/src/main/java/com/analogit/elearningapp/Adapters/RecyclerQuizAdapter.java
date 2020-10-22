package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.AllQuestionsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerQuizAdapter extends ListAdapter<AllQuestionsModel,RecyclerQuizAdapter.MyViewholder> {
        Fragment fragment;
    public RecyclerQuizAdapter(Fragment fragment) {
        super(AllQuestionsModel.allQuestionsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder( LayoutInflater.from(parent.getContext()).inflate(R.layout.total_questions_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        holder.textView.setText(String.valueOf(position+1));
    }

    @Override
    public void submitList(@Nullable List<AllQuestionsModel> list) {
        super.submitList(list==null?null:new ArrayList<AllQuestionsModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{
            TextView textView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_total_questions_number);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
