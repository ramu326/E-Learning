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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.ImagesBankFragment;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class RecyclerSubjectaAdapter extends RecyclerView.Adapter<RecyclerSubjectaAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllSubjectModel>allSubjectModel;

    int idname;
    int pos=-1;

    public RecyclerSubjectaAdapter(Context context, ArrayList<AllSubjectModel> allSubjectModel) {
        this.context = context;
        this.allSubjectModel = allSubjectModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.imagebank_all_subjects_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.tv_subject.setText(allSubjectModel.get(position).getName());

        holder.tv_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagesBankFragment imagesBankFragment=new ImagesBankFragment();
                Log.d("haiii",String.valueOf(allSubjectModel.get(position).getId()));
                Bundle args=new Bundle();
                args.putInt("subid",allSubjectModel.get(position).getId());
                imagesBankFragment.setArguments(args);
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,imagesBankFragment).commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return allSubjectModel.size();
    }

  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject;

     public MyViewHolder(@NonNull final View itemView) {
         super(itemView);

         tv_subject=itemView.findViewById(R.id.tv_img_subjects);




     }
 }
}
