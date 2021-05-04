package com.analogit.elearningapp.Adapters;

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

import com.analogit.elearningapp.ApiModel.IcardsPastExamsModel;
import com.analogit.elearningapp.Fragments.PastExamsYearWiseFragment;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerIcardsPastExamAdapter extends RecyclerView.Adapter<RecyclerIcardsPastExamAdapter.PastExamsData> {

    Context context;
    ArrayList<IcardsPastExamsModel>audioModels;

    public RecyclerIcardsPastExamAdapter(Context context, ArrayList<IcardsPastExamsModel> audioModels) {
        this.context = context;
        this.audioModels = audioModels;
    }

    @NonNull
    @Override
    public PastExamsData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastExamsData(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_pastexams_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastExamsData holder, int position) {

        Glide.with(context).load(audioModels.get(position).getImage()).into(holder.imageView);

        holder.tvSub.setText(audioModels.get(position).getSubject());

        holder.tvPastexam.setText(String.valueOf(audioModels.get(position).getPast_exam())+" Past Exams");
    }

    @Override
    public int getItemCount() {
        return audioModels.size();
    }

    public class PastExamsData extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvSub,tvPastexam;
        public PastExamsData(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.cons_icards_past_exams);
            imageView=itemView.findViewById(R.id.iv_icards_image);
            tvSub=itemView.findViewById(R.id.tv_text_anatomy);
            tvPastexam=itemView.findViewById(R.id.tv_past_topics);
            constraintLayout.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     PastExamsYearWiseFragment pastExamsYearWiseFragment=new  PastExamsYearWiseFragment();
                    Bundle args=new Bundle();
                    args.putInt("id",audioModels.get(getAdapterPosition()).getId());
                    args.putString("subject",audioModels.get(getAdapterPosition()).getSubject());
                    pastExamsYearWiseFragment.setArguments(args);
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content,pastExamsYearWiseFragment).commit();
                }
            }
            );
        }
    }
}
