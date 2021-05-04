package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.DiagnosticModel;
import com.analogit.elearningapp.Fragments.DiffrentailDiagnosisPagesFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.RecentUpadetPagesFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerDifferentialDiagnosisAdapter extends RecyclerView.Adapter<RecyclerDifferentialDiagnosisAdapter.MyViewHolder> {

    Context context;
    ArrayList<DiagnosticModel> arrayList;

    public RecyclerDifferentialDiagnosisAdapter(Context context, ArrayList<DiagnosticModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.differentail_diagnosis_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textTopic.setText(arrayList.get(position).getTopic());
        holder.textsub.setText("# "+arrayList.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        TextView textTopic,textsub;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.cons_diffrential);
            textTopic=itemView.findViewById(R.id.tv_different);
            textsub=itemView.findViewById(R.id.dia_sub_name);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    DiffrentailDiagnosisPagesFragment diffrentailDiagnosisPagesFragment=new DiffrentailDiagnosisPagesFragment();

                    Bundle args=new Bundle();
                    args.putInt("id",arrayList.get(getAdapterPosition()).getId());
                    diffrentailDiagnosisPagesFragment.setArguments(args);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, diffrentailDiagnosisPagesFragment).commit();

//                    DiffrentailDiagnosisPagesFragment diffrentailDiagnosisPagesFragment=new DiffrentailDiagnosisPagesFragment();
//                    Bundle args=new Bundle();
//                    args.putInt("tid",arrayList.get(getAdapterPosition()).getId());
//                    diffrentailDiagnosisPagesFragment.setArguments(args);
//                    Log.d("idssssssssssss",String.valueOf(arrayList.get(getAdapterPosition()).getId()));
//                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content,  diffrentailDiagnosisPagesFragment).commit();
                }
            });
        }
    }
}
