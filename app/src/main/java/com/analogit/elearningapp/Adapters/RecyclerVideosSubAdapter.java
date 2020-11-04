package com.analogit.elearningapp.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.HomeSubjectsModels;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVideosSubAdapter extends ListAdapter<HomeSubjectsModels,RecyclerVideosSubAdapter.MyViewholder> {
        Fragment fragment;
    public RecyclerVideosSubAdapter(Fragment fragment) {
        super(HomeSubjectsModels.homeSubjectsModelsItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_sub_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        Log.d("hello","Data");
        switch (position){
            case 0:holder.SubName.setText("Anatomy");
                break;
            case 1:holder.SubName.setText("Physiology");
                break;
            case 2:holder.SubName.setText("Biochemistry");
                break;
            case 3:holder.SubName.setText("Pathology");
                break;
            case 4:holder.SubName.setText("Pharmacology");
                break;
            case 5:holder.SubName.setText("Microbiology");
                break;
            case 6:holder.SubName.setText("Forensic Medicine");
                break;
            case 7:holder.SubName.setText("Community Medicine");
                break;
            case 8:holder.SubName.setText("ENT");
                break;
            case 9:holder.SubName.setText("Opthalmology");
                break;
            case 10:holder.SubName.setText("Gynaecology & obstetrics");
                break;
            case 11:holder.SubName.setText("Paediatrics");
                break;
            case 12:holder.SubName.setText("Surgery");
                break;
            case 13:holder.SubName.setText("Medicine");
                break;
            case 14:holder.SubName.setText("Radiology");
                break;
            case 15:holder.SubName.setText("Anaesthesia");
                break;
            case 16:holder.SubName.setText("Orthopaedics");
                break;
            case 17:holder.SubName.setText("Psychiatry");
                break;
            case 18:holder.SubName.setText("Dermatology");
                break;
            case 19:holder.SubName.setText("Emergency Medicine");
                break;
            case 20:holder.SubName.setText("Integrated lectures");
                break;
            default:
                break;

        }

    }

    @Override
    public void submitList(@Nullable List<HomeSubjectsModels> list) {
        super.submitList(list==null?null:new ArrayList<HomeSubjectsModels>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView SubName;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.vsr_ll_one);
            SubName=itemView.findViewById(R.id.tv_vsr_subjects);
        }
    }

    @Override
    public int getItemCount() {
        return 21;
    }
}
