package com.analogit.elearningapp.Adapters;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.RegularCourceFragment;
import com.analogit.elearningapp.Model.RegularCourceModel;
import com.analogit.elearningapp.Model.SubjectsModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class RecyclerRegularNTrAdapter extends ListAdapter<RegularCourceModel,RecyclerRegularNTrAdapter.MyViewholder> {

    RegularCourceFragment regularCourceFragment;
    public RecyclerRegularNTrAdapter(RegularCourceFragment regularCourceFragment) {
        super(RegularCourceModel.regularCourceModelItemCallback);
        this.regularCourceFragment=regularCourceFragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.regular_course_row,parent,false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
      holder.Tv.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.newtv));
        Glide.with(regularCourceFragment).load(R.drawable.ic_arrow_down).into(holder.Darrow);
      holder.Qimage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.allqbank));
      holder.Pimage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.newprevious));
      holder.Swtimage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.newswt));

      switch (position){
          case 0:
              holder.Subject.setText("Anatomy");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.anatomy));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.antmycolor)));
              break;
          case 1:
              holder.Subject.setText("Physiology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.physiology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.phylogycolor)));
              break;
          case 2:
              holder.Subject.setText("Biochemistry");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.biochemistry));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.biochecolor)));
              break;
          case 3:
              holder.Subject.setText("Pathology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.pathology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.pathcolor)));
              break;
//            case 4:
//                holder.Subject.setText("Anatomy");
//                holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.anatomy));
//                holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.antmycolor)));
//                break;
          case 4:
              holder.Subject.setText("Pharmacology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.pharmacology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.pharmcolor)));
              break;
          case 5:
              holder.Subject.setText("Microbiologgy");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.microbiology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.microcolor)));
              break;
          case 6:
              holder.Subject.setText("Forensic Medicine");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.foresic));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.forcolor)));
              break;
          case 7:
              holder.Subject.setText("Community Medicine");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.communitymedicin));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.comcolor)));
              break;
          case 8:
              holder.Subject.setText("ENT");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.ent));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.entcolor)));
              break;
          case 9:
              holder.Subject.setText("Opthalmology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.opthalmology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.opthocolor)));
              break;
          case 10:
              holder.Subject.setText("Gynaecology & Obstetrics");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.obestric));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.obcolor)));
              break;
          case 11:
              holder.Subject.setText("Paediatrics");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.pediatrics));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.pedcolor)));
              break;
          case 12:
              holder.Subject.setText("Surgery");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.generalsurgery));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.gencolor)));
              break;
          case 13:
              holder.Subject.setText("Medicine");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.generalmedicine));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.genmcolor)));
              break;
          case 14:
              holder.Subject.setText("Radiology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.radiology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.radiocolor)));
              break;
          case 15:
              holder.Subject.setText("Anaesthesia");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.anesthesia));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.anescolor)));
              break;
          case 16:
              holder.Subject.setText("Orthopaedics");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.orthopedics));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.orthocolor)));
              break;
          case 17:
              holder.Subject.setText("Psychiatry");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.physiology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.phylogycolor)));
              break;
          case 18:
              holder.Subject.setText("Dermatology");
              holder.Simage.setImageDrawable(regularCourceFragment.getResources().getDrawable(R.drawable.dermatology));
              holder.progressBar.setProgressTintList(ColorStateList.valueOf(regularCourceFragment.getResources().getColor(R.color.dermocolor)));
              break;
      }
    }
    @Override
    public void submitList(@Nullable List<RegularCourceModel> list) {
        super.submitList(list == null ? null : new ArrayList<RegularCourceModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{
        TextView Subject,Rating,tasks,Qtask,Ptask,Stask;
        ImageView Simage,Darrow,Qimage,Pimage,Swtimage,Tv;
        ProgressBar progressBar;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            Subject=itemView.findViewById(R.id.tv_rcr_subject);
            Rating=itemView.findViewById(R.id.tv_rcr_rating);
            tasks=itemView.findViewById(R.id.tv_rcr_tasks);
            Qtask=itemView.findViewById(R.id.tv_rcr_q_task);
            Ptask=itemView.findViewById(R.id.tv_rcr_p_task);
            Stask=itemView.findViewById(R.id.tv_rcr_s_task);

            Simage=itemView.findViewById(R.id.iv_rcr_image);
            Darrow=itemView.findViewById(R.id.iv_rcr_down_arrow);
            Qimage=itemView.findViewById(R.id.iv_rcr_qbank);
            Pimage=itemView.findViewById(R.id.iv_rcr_prev);
            Swtimage=itemView.findViewById(R.id.iv_rcr_s_task);

            Tv=itemView.findViewById(R.id.iv_rcr_tv);
            progressBar=itemView.findViewById(R.id.pb_rcr_progress);
        }
    }

    @Override
    public int getItemCount() {
        return 19;
    }
}
