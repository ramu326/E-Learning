package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerLearnSavedAdapter extends RecyclerView.Adapter<RecyclerLearnSavedAdapter.SavedData> {

    Context context;
    ArrayList<DoctorModel>arrayList;

    public RecyclerLearnSavedAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SavedData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SavedData(LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_saved_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SavedData holder, int position) {
        switch (position){

            case 0:
                holder.textView.setText("Anatomy");
                break;
            case 1:
                holder.textView.setText("Physiology");
                break;
            case 2:
                holder.textView.setText("Biochemistry");
                break;
            case 3:
                holder.textView.setText("Microbiology");
                break;
            case 4:
                holder.textView.setText("Pharmacology");
                break;
            case 5:
                holder.textView.setText("Pathology");
                break;
            case 6:
                holder.textView.setText("Forensic Medicine");
                break;
            case 7:
                holder.textView.setText("ENT");
                break;
            case 8:
                holder.textView.setText("Ophthalmology");
                break;
            case 9:

                holder.textView.setText("Community medicine");
                break;
            case 10:
                holder.textView.setText("Obstetrics");
                break;
            case 11:
                holder.textView.setText("General Medicine");
                break;
            case 12:
                holder.textView.setText("General Surgery");
                break;
            case 13:
                holder.textView.setText("Pediatrics");
                break;
            case 14:
                holder.textView.setText("Dermatology");
                break;
            case 15:
                holder.textView.setText("Anesthesia");
                break;
            case 16:
                holder.textView.setText("Radiology");
                break;
            case 17:
                holder.textView.setText("Psychiatry");
                break;
            case 18:
                holder.textView.setText("Orthopaedics");
                break;
            case 19:
                holder.textView.setText("Emergency Medicine");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public  class SavedData extends RecyclerView.ViewHolder{
            TextView textView;
        public SavedData(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.iv_saved_name);

        }
    }
}
