package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.AllSubjectsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerImageBankSubjectAdapter  extends ListAdapter<AllSubjectsModel,RecyclerImageBankSubjectAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerImageBankSubjectAdapter(Fragment fragment) {
        super(AllSubjectsModel.allSubjectsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public RecyclerImageBankSubjectAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.imagebank_all_subjects_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerImageBankSubjectAdapter.MyViewholder holder, int position) {
        switch (position){
            case 0:holder.SubName.setText("All");
                break;
            case 1:holder.SubName.setText("Anatomy");
                break;
            case 2:holder.SubName.setText("Physiology");
                break;
            case 3:holder.SubName.setText("Biochemistry");
                break;
            case 4:holder.SubName.setText("Pathology");
                break;
            case 5:holder.SubName.setText("Pharmacology");
                break;
            case 6:holder.SubName.setText("Microbiology");
                break;
            case 7:holder.SubName.setText("Forensic Medicine");
                break;
            case 8:holder.SubName.setText("Community Medicine");
                break;
            case 9:holder.SubName.setText("ENT");
                break;
            case 10:holder.SubName.setText("Opthalmology");
                break;
            case 11:holder.SubName.setText("Gynaecology & obstetrics");
                break;
            case 12:holder.SubName.setText("Paediatrics");
                break;
            case 13:holder.SubName.setText("Surgery");
                break;
            case 14:holder.SubName.setText("Medicine");
                break;
            case 15:holder.SubName.setText("Radiology");
                break;
            case 16:holder.SubName.setText("Anaesthesia");
                break;
            case 17:holder.SubName.setText("Orthopaedics");
                break;
            case 18:holder.SubName.setText("Psychiatry");
                break;
            case 19:holder.SubName.setText("Dermatology");
                break;
            case 20:holder.SubName.setText("Emergency Medicine");
                break;
            case 21:holder.SubName.setText("Integrated lectures");
                break;
            default:
                break;

        }

    }

    @Override
    public void submitList(@Nullable List<AllSubjectsModel> list) {
        super.submitList(list==null?null:new ArrayList<AllSubjectsModel>());
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView SubName;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            //  linearLayout=itemView.findViewById(R.id.asr_ll_one);
            SubName=itemView.findViewById(R.id.tv_img_subjects);
        }
    }

    @Override
    public int getItemCount() {
        return 22;
    }
}

