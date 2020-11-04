package com.analogit.elearningapp.Adapters;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.HomeActivity;

import com.analogit.elearningapp.Fragments.SpecificSubFragment;
import com.analogit.elearningapp.Fragments.SubjectQbankFragment;
import com.analogit.elearningapp.Model.SubjectsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerSubjectsAdapter extends ListAdapter<SubjectsModel,RecyclerSubjectsAdapter.MyViewholder> {
        Fragment fragment;
   public RecyclerSubjectsAdapter(Fragment fragment) {
        super(SubjectsModel.subjectsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_qbank_row_practice,parent,false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
//        holder.Qbank.setImageDrawable(fragment.getResources().getDrawable(R.drawable.allqbank));
//        holder.Stack.setImageDrawable(fragment.getResources().getDrawable(R.drawable.stock));
//
//        switch (position){
//            case 0:
//                holder.Subject.setText("Intigrated");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.anatomy));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.antmycolor)));
//                break;
//            case 1:
//                holder.Subject.setText("Anatomy");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.anatomy));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.antmycolor)));
//                break;
//            case 2:
//                holder.Subject.setText("Physiology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.physiology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.phylogycolor)));
//                break;
//            case 3:
//                holder.Subject.setText("Biochemistry");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.biochemistry));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.biochecolor)));
//                break;
//            case 4:
//                holder.Subject.setText("Pathology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.pathology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.pathcolor)));
//                break;
////            case 4:
////                holder.Subject.setText("Anatomy");
////                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.anatomy));
////                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.antmycolor)));
////                break;
//            case 5:
//                holder.Subject.setText("Pharmacology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.pharmacology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.pharmcolor)));
//                break;
//            case 6:
//                holder.Subject.setText("Microbiologgy");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.microbiology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.microcolor)));
//                break;
//            case 7:
//                holder.Subject.setText("Forensic Medicine");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.foresic));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.forcolor)));
//                break;
//            case 8:
//                holder.Subject.setText("Community Medicine");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.communitymedicin));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.comcolor)));
//                break;
//            case 9:
//                holder.Subject.setText("ENT");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.ent));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.entcolor)));
//                break;
//            case 10:
//                holder.Subject.setText("Opthalmology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.opthalmology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.opthocolor)));
//                break;
//            case 11:
//                holder.Subject.setText("Gynaecology & Obstetrics");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.obestric));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.obcolor)));
//                break;
//            case 12:
//                holder.Subject.setText("Paediatrics");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.pediatrics));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.pedcolor)));
//                break;
//            case 13:
//                holder.Subject.setText("Surgery");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.generalsurgery));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.gencolor)));
//                break;
//            case 14:
//                holder.Subject.setText("Medicine");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.generalmedicine));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.genmcolor)));
//                break;
//            case 15:
//                holder.Subject.setText("Radiology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.radiology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.radiocolor)));
//                break;
//            case 16:
//                holder.Subject.setText("Anaesthesia");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.anesthesia));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.anescolor)));
//                break;
//            case 17:
//                holder.Subject.setText("Orthopaedics");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.orthopedics));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.orthocolor)));
//                break;
//            case 18:
//                holder.Subject.setText("Psychiatry");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.physiology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.phylogycolor)));
//                break;
//            case 19:
//                holder.Subject.setText("Dermatology");
//                holder.Simage.setImageDrawable(fragment.getResources().getDrawable(R.drawable.dermatology));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(fragment.getResources().getColor(R.color.dermocolor)));
//                break;
//
//        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void submitList(@Nullable List<SubjectsModel> list) {
        super.submitList(list == null ? null : new ArrayList<SubjectsModel>(list));
    }
    class MyViewholder extends RecyclerView.ViewHolder{
      ImageView Simage;
//       ProgressBar progressBar;
//       TextView Bpractise,bError,Rating,Subject;
//       LinearLayout linearLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
          Simage=itemView.findViewById(R.id.iv_sub_image);

            Simage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new SubjectQbankFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, myFragment).addToBackStack(null).commit();

                }
            });
        }

    }


}
