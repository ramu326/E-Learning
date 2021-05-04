package com.analogit.elearningapp.Adapters;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.QbankSubjectModel;
import com.analogit.elearningapp.Fragments.QBankSubTopicsFragment;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;


public class RecyclerSubjectsAdapter extends RecyclerView.Adapter<RecyclerSubjectsAdapter.QbankAdapter> {

    Context context;
    ArrayList<QbankSubjectModel> arrayList;

    public RecyclerSubjectsAdapter(Context context, ArrayList<QbankSubjectModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public QbankAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QbankAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_qbank_row_practice, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull QbankAdapter holder, int position) {
        holder.tvSub.setText(arrayList.get(position).getName());

        holder.task.setText(arrayList.get(position).getOut_of() + "  Out of  " + arrayList.get(position).getTotal_topics());

        Glide.with(context).load(Image_Url + arrayList.get(position).getImage()).into(holder.imageView);

        holder.progressBar.setMax(arrayList.get(position).getTotal_topics());

        holder.progressBar.setProgress(arrayList.get(position).getOut_of());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class QbankAdapter extends RecyclerView.ViewHolder {

        TextView tvSub, task;
        ProgressBar progressBar;
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public QbankAdapter(@NonNull View itemView) {
            super(itemView);
            tvSub = itemView.findViewById(R.id.tv_qbank_sub_name);
            task = itemView.findViewById(R.id.qbank_tv_sub_work_status);
            constraintLayout = itemView.findViewById(R.id.constaraint_qbank);
            imageView = itemView.findViewById(R.id.iv_sub_image);

            progressBar=itemView.findViewById(R.id.qbank_pbar);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QBankSubTopicsFragment qbankExamModuleFragment = new QBankSubTopicsFragment();
                    Bundle args = new Bundle();
                    int id = arrayList.get(getAdapterPosition()).getId();
                    Log.d("subjectidddddd", String.valueOf(id));
                    args.putInt("sid", arrayList.get(getAdapterPosition()).getId());
                    args.putString("name", arrayList.get(getAdapterPosition()).getName());
                    qbankExamModuleFragment.setArguments(args);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, qbankExamModuleFragment).addToBackStack(null).commit();
                }
            });

        }
    }
}


