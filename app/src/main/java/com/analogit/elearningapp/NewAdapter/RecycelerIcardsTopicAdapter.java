package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsSubjectTopics;
import com.analogit.elearningapp.Fragments.IcardsPagesFragment;
import com.analogit.elearningapp.Fragments.IcardsTabsDecFragment;
import com.analogit.elearningapp.Fragments.IcardsTopicsFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecycelerIcardsTopicAdapter extends RecyclerView.Adapter<RecycelerIcardsTopicAdapter.IcardsTopicAdapter> {

    Context context;
    ArrayList<IcardsSubjectTopics>arrayList;

    public RecycelerIcardsTopicAdapter(Context context, ArrayList<IcardsSubjectTopics> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public IcardsTopicAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IcardsTopicAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_topics_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IcardsTopicAdapter holder, int position) {
        holder.textView.setText(arrayList.get(position).getSubject());
        holder.tvIcards.setText(String.valueOf(arrayList.get(position).getIcard()+" Cards"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class IcardsTopicAdapter extends RecyclerView.ViewHolder{
            ConstraintLayout constraintLayout;
            TextView textView,tvIcards;

        public IcardsTopicAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.constaraint_icard_topic);
            tvIcards=itemView.findViewById(R.id.qbank_tv_sub_work_status_topic);
            textView=itemView.findViewById(R.id.tv_qbank_sub_name_topic);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IcardsPagesFragment icardsPagesFragment=new IcardsPagesFragment();
                    Bundle args=new Bundle();
                    args.putInt("topicid",arrayList.get(getAdapterPosition()).getId());
                    icardsPagesFragment.setArguments(args);
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, icardsPagesFragment).commit();
                }
            });
        }
    }
}
