package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerLearnAudioAdapter extends RecyclerView.Adapter<RecyclerLearnAudioAdapter.MyViewholder> {

    Context context;
    ArrayList<DoctorModel>arrayList;

    public RecyclerLearnAudioAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_learn_audio_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        switch (position){

            case 0:
                //  holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.d));
                holder.textView.setText("Anatomy");
                break;
            case 1:
                //  holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.e));
                holder.textView.setText("Physiology");
                break;
            case 2:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.f));
                holder.textView.setText("Biochemistry");
                break;
            case 3:
                //  holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.g));
                holder.textView.setText("Microbiology");
                break;
            case 4:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.h));
                holder.textView.setText("Pharmacology");
                break;
            case 5:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.i));
                holder.textView.setText("Pathology");
                break;
            case 6:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.j));
                holder.textView.setText("Forensic Medicine");
                break;
            case 7:
                //holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.k));
                holder.textView.setText("ENT");
                break;
            case 8:
                //holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.l));
                holder.textView.setText("Ophthalmology");
                break;
            case 9:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.m));
                holder.textView.setText("Community medicine");
                break;
            case 10:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.n));
                holder.textView.setText("Obstetrics");
                break;
            case 11:
                //   holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.o));
                holder.textView.setText("General Medicine");
                break;
            case 12:
                //  holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.p));
                holder.textView.setText("General Surgery");
                break;
            case 13:
                //  holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.q));
                holder.textView.setText("Pediatrics");
                break;
            case 14:
                // holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.d));
                holder.textView.setText("Dermatology");
                break;
            case 15:
                //   holder.imageview.setImageDrawable(fragment.getContext().getResources().getDrawable(R.drawable.f));
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

    public class MyViewholder extends RecyclerView.ViewHolder{
        ConstraintLayout cardView;
        TextView textView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.new_learn_video_card_view);
            textView=itemView.findViewById(R.id.tv_grid_text);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new IcardsFragment()).addToBackStack(null).commit();
                }
            });
        }
    }
}
