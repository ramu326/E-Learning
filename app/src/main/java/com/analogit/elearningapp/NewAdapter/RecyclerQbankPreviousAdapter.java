package com.analogit.elearningapp.NewAdapter;

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

import com.analogit.elearningapp.ApiModel.QbankPastExamsWithSubJectsModel;
import com.analogit.elearningapp.Fragments.QBankPastYearExamTopicsFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerQbankPreviousAdapter extends RecyclerView.Adapter<RecyclerQbankPreviousAdapter.PastExamsAdapter> {

    Context context;
    ArrayList<QbankPastExamsWithSubJectsModel> arrayList;

    public RecyclerQbankPreviousAdapter(Context context, ArrayList<QbankPastExamsWithSubJectsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PastExamsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastExamsAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.qbank_previous_exams_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastExamsAdapter holder, int position) {

        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvSub.setText(arrayList.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PastExamsAdapter extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvSub;

        public PastExamsAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.cons_all_exams_view);
            imageView=itemView.findViewById(R.id.iv_com_sub_image);
            tvSub=itemView.findViewById(R.id.tv_com_text_anatomy);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     QBankPastYearExamTopicsFragment qBankPastYearExamTopicsFragment= new QBankPastYearExamTopicsFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("subject",arrayList.get(getAdapterPosition()).getSubject());
                    bundle.putInt("id",arrayList.get(getAdapterPosition()).getId());
                    qBankPastYearExamTopicsFragment.setArguments(bundle);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, qBankPastYearExamTopicsFragment).addToBackStack(null).commit();
                }
            });

        }
    }
}
