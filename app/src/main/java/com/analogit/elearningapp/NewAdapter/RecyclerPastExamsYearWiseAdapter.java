package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsModel;
import com.analogit.elearningapp.Fragments.IcardsPastExamsPagesFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerPastExamsYearWiseAdapter extends RecyclerView.Adapter<RecyclerPastExamsYearWiseAdapter.PastExamsAdapter> {

    Context context;
    ArrayList<IcardsPastExamsTopicsModel>arrayList;

    public RecyclerPastExamsYearWiseAdapter(Context context, ArrayList<IcardsPastExamsTopicsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PastExamsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastExamsAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.past_exams_year_wise_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastExamsAdapter holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvSub.setText(arrayList.get(position).getSubject());
        holder.tvPastExam.setText(String.valueOf(arrayList.get(position).getPast_exam())+" Topics");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class PastExamsAdapter extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvSub,tvPastExam;
        public PastExamsAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.constaraint_year_topic);
            imageView=itemView.findViewById(R.id.iv_sub_image_topic);
            tvSub=itemView.findViewById(R.id.tv_qbank_sub_name_topic);
            tvPastExam=itemView.findViewById(R.id.qbank_tv_sub_work_status_topic);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IcardsPastExamsPagesFragment icardsPastExamsPagesFragment=new IcardsPastExamsPagesFragment();
                    Bundle args=new Bundle();
                    args.putInt("topicid",arrayList.get(getAdapterPosition()).getId());
                    icardsPastExamsPagesFragment.setArguments(args);
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, icardsPastExamsPagesFragment).commit();

                }
            });
        }
    }
}
