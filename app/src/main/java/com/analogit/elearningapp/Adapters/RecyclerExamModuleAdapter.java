package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.ExamModuleFragment;
import com.analogit.elearningapp.Model.ExamModulesModels;
import com.analogit.elearningapp.R;

import java.util.zip.Inflater;

public class RecyclerExamModuleAdapter extends ListAdapter<ExamModulesModels,RecyclerExamModuleAdapter.MyViewholder> {
        ExamModuleFragment examModuleFragment;
    public RecyclerExamModuleAdapter(ExamModuleFragment examModuleFragment) {
        super(ExamModulesModels.examsModelsItemCallback);
        this.examModuleFragment=examModuleFragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_modules_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.stock.setImageDrawable(examModuleFragment.getContext().getResources().getDrawable(R.drawable.stock));

    }

    class MyViewholder extends RecyclerView.ViewHolder{
            TextView grand,recall,mini,title;
            ImageView stock;
            LinearLayout llCompleted,llPause,llPending;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            grand=itemView.findViewById(R.id.tv_ltrow_grand);
            mini=itemView.findViewById(R.id.tv_ltrow_mini);
            recall=itemView.findViewById(R.id.tv_ltrow_recall);
            title=itemView.findViewById(R.id.tv_ltrow_title);
            stock=itemView.findViewById(R.id.iv_ltrow_stack);
            llCompleted=itemView.findViewById(R.id.ll_ltrow_complted);
            llPause=itemView.findViewById(R.id.ll_ltrow_pause);
            llPending=itemView.findViewById(R.id.ll_ltrow_pending);


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
