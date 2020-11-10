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
