package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsAudioTopicModel;
import com.analogit.elearningapp.Fragments.IcardsFragment;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerIcardsAudioTopicsAdapter extends RecyclerView.Adapter<RecyclerIcardsAudioTopicsAdapter.AudioTopic> {
   Context context;
   ArrayList<IcardsAudioTopicModel>arrayList;

    public RecyclerIcardsAudioTopicsAdapter(Context context, ArrayList<IcardsAudioTopicModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AudioTopic onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AudioTopic(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_audio_topic_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AudioTopic holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.audio.setText(String.valueOf(arrayList.get(position).getIcard()+" AudioCards"));
        holder.topic.setText(arrayList.get(position).getAudio_topic());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AudioTopic extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView topic,audio;
        ConstraintLayout constraintLayout;
        public AudioTopic(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_icards_audio_image);
            topic=itemView.findViewById(R.id.tv_text_audio_anatomy);
            audio=itemView.findViewById(R.id.icards_audio);
            constraintLayout=itemView.findViewById(R.id.cons_icards_bookmarks_audio);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new IcardsFragment()).addToBackStack(null).commit();


                }
            });
        }
    }
}
