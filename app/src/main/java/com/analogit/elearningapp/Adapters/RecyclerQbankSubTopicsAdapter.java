package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.analogit.elearningapp.ApiModel.QbankSubTopicsModel;
import com.analogit.elearningapp.Fragments.QBankSubTopicsFragment;
import com.analogit.elearningapp.Fragments.QbankExamModuleFragment;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerQbankSubTopicsAdapter extends RecyclerView.Adapter<RecyclerQbankSubTopicsAdapter.QbankTopicsAdapter>{

    Context context;
    ArrayList<QbankSubTopicsModel>arrayList;
    QBankSubTopicsFragment qBankSubTopicsFragment;
    String name;
    public RecyclerQbankSubTopicsAdapter(Context context, ArrayList<QbankSubTopicsModel> arrayList, QBankSubTopicsFragment qBankSubTopicsFragment) {
        this.context = context;
        this.arrayList = arrayList;
        this.qBankSubTopicsFragment=qBankSubTopicsFragment;
    }

    @NonNull
    @Override
    public QbankTopicsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QbankTopicsAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_imazes_gridview_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull QbankTopicsAdapter holder, int position) {

        holder.tvTopic.setText(arrayList.get(position).getTopic_name());
        holder.tvQuestions.setText("Total Questions: "+String.valueOf(arrayList.get(position).getTotal_question()));
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        qBankSubTopicsFragment.textView.getText();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class QbankTopicsAdapter extends RecyclerView.ViewHolder{

        TextView tvTopic,tvQuestions;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        public QbankTopicsAdapter(@NonNull View itemView) {
            super(itemView);
            tvTopic=itemView.findViewById(R.id.tv_qbank_sub_name_topic);
            tvQuestions=itemView.findViewById(R.id.qbank_tv_sub_work_status_topic);
            imageView=itemView.findViewById(R.id.iv_sub_image_topic);
            constraintLayout=itemView.findViewById(R.id.constaraint_qbank_topic);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    QbankExamModuleFragment qbankExamModuleFragment=new QbankExamModuleFragment();
                    Bundle args=new Bundle();
                   qBankSubTopicsFragment.textView.getText();

                    args.putInt("tid",arrayList.get(getAdapterPosition()).getTopic_id());
                    args.putString("topicname",arrayList.get(getAdapterPosition()).getTopic_name());
                    args.putInt("total",arrayList.get(getAdapterPosition()).getTotal_question());
                    args.putString("subjectname",qBankSubTopicsFragment.textView.getText().toString());

                    qbankExamModuleFragment.setArguments(args);
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,qbankExamModuleFragment).addToBackStack(null).commit();
                }
            });

        }
    }
}
