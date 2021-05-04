package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.DiagnosticPagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerDiffrentailDiagnosisPagesAdapter extends RecyclerView.Adapter<RecyclerDiffrentailDiagnosisPagesAdapter.DiagnosisAdapter> {
   Context context;
    ArrayList<DiagnosticPagesModel>arrayList;

    public RecyclerDiffrentailDiagnosisPagesAdapter(Context context, ArrayList<DiagnosticPagesModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DiagnosisAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiagnosisAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.diagnosispage_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DiagnosisAdapter holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class DiagnosisAdapter extends RecyclerView.ViewHolder{

        ImageView imageView;
        public DiagnosisAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_diagnosis);
        }
    }
}
