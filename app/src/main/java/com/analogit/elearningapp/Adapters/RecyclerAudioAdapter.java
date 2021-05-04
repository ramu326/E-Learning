package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsAudioTopicFragment;
import com.analogit.elearningapp.Fragments.IcardsFragment;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerAudioAdapter extends RecyclerView.Adapter<RecyclerAudioAdapter.AudioAdapter>{
    Context context;
    ArrayList<AudioModel>arrayList;

    public RecyclerAudioAdapter(Context context, ArrayList<AudioModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AudioAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AudioAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_audios_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AudioAdapter holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvSub.setText(arrayList.get(position).getSubject());
        holder.tvaudo.setText(String.valueOf(arrayList.get(position).getIcard()+" Audio Cards"));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AudioAdapter extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView tvSub,tvaudo;
    ConstraintLayout constraintLayout;
        public AudioAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_icards_image);
            tvSub=itemView.findViewById(R.id.tv_text_anatomy);
            tvaudo=itemView.findViewById(R.id.no_audo);
            constraintLayout=itemView.findViewById(R.id.cons_icards_audio);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IcardsAudioTopicFragment icardsAudioTopicFragment=new IcardsAudioTopicFragment();
                    Bundle args=new Bundle();
                    args.putInt("sid",arrayList.get(getAdapterPosition()).getId());
                    args.putString("subject",arrayList.get(getAdapterPosition()).getSubject());
                    icardsAudioTopicFragment.setArguments(args);
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,icardsAudioTopicFragment).addToBackStack(null).commit();
                }
            });
        }
    }
}