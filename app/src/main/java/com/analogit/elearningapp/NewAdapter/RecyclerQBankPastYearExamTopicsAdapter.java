package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.QbankPastExamsEntraceModel;
import com.analogit.elearningapp.Fragments.QbankExamModuleFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerQBankPastYearExamTopicsAdapter extends RecyclerView.Adapter<RecyclerQBankPastYearExamTopicsAdapter.PastExamAdapter> {
   Context context;
   ArrayList<QbankPastExamsEntraceModel>arrayList;

    public RecyclerQBankPastYearExamTopicsAdapter(Context context, ArrayList<QbankPastExamsEntraceModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PastExamAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastExamAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.qbank_past_year_exam_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastExamAdapter holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvsub.setText(arrayList.get(position).getName());
        holder.question.setText(String.valueOf(arrayList.get(position).getNo_of_question()+" Questions"));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PastExamAdapter extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvsub,question;
        public PastExamAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.constaraint_all_exams_topic);
            imageView=itemView.findViewById(R.id.iv_past_sub_image_topic);
            tvsub=itemView.findViewById(R.id.tv_past_qbank_sub_name_topic);
            question=itemView.findViewById(R.id.past_qbank_tv_sub_work_status_topic);
//            constraintLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new QbankExamModuleFragment()).addToBackStack(null).commit();
//                }
//            });
        }
    }
}
