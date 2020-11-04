package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.QAViewpagerFragment;
import com.analogit.elearningapp.Fragments.QnAFragment;
import com.analogit.elearningapp.Model.AllQuestionsModel;
import com.analogit.elearningapp.Model.RegularCourceModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAllQuestionsRow extends ListAdapter<AllQuestionsModel,RecyclerAllQuestionsRow.MyViewholder> {

   Fragment fragment;
    public RecyclerAllQuestionsRow(Fragment fragment) {
        super(AllQuestionsModel.allQuestionsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.total_questions_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
//        holder.SerNo.setBackground(qaViewpagerFragment.getResources().getDrawable(R.drawable.cirle_shape));
//        holder.itemView.setVisibility(View.VISIBLE);
        holder.SerNo.setText(String.valueOf(position+1));
//
//        if((position+1)>7){
//           // holder.itemView.setVisibility(View.GONE);
//
//            holder.SerNo.setText(". . .");
//            holder.SerNo.setBackground(null);
//
//         //   if(position+1>=29){
//
//              //  holder.itemView.setVisibility(View.VISIBLE);
//
//               // holder.SerNo.setBackground(null);
//                if(position+1==30){
//                    holder.SerNo.setBackground(qaViewpagerFragment.getResources().getDrawable(R.drawable.cirle_shape));
//
//                    holder.SerNo.setText(String.valueOf(position+1));
//
//                }
//
//          //  }
//
//      }



    }
    @Override
    public void submitList(@Nullable List<AllQuestionsModel> list) {
        super.submitList(list == null ? null : new ArrayList<AllQuestionsModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{
            TextView SerNo;
            LinearLayout linearLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            SerNo=itemView.findViewById(R.id.tv_total_questions_number);
            linearLayout=itemView.findViewById(R.id.ll_tq_one);
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
