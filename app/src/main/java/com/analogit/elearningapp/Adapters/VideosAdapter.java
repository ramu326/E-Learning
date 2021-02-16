package com.analogit.elearningapp.Adapters;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.VideosModel;
import com.analogit.elearningapp.R;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewholder> {

    private List<VideosModel>videosModel;

    public VideosAdapter(List<VideosModel> videosModel) {
        this.videosModel = videosModel;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slots_layout_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        holder.setVideos(videosModel.get(position));

    }

    @Override
    public int getItemCount() {
        return videosModel.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView textView;
        ImageView iv_share;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.slv_videos);
            textView=itemView.findViewById(R.id.tv_slv_title);
            iv_share=itemView.findViewById(R.id.slots_share);
            iv_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent=new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"nothing");
                    sendIntent.setType("text/plain");
                    Intent shereintent=Intent.createChooser(sendIntent,null);
                    v.getContext().startActivity(shereintent);
                }
            });
            textView.setSelected(true);

        }
        void setVideos(VideosModel videosModel){
            videoView.setVideoPath(videosModel.videoUrl);


            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();

                    float videoratio=mediaPlayer.getVideoWidth()/(float)mediaPlayer.getVideoHeight();
                    float screenRatio=videoView.getWidth()/(float)videoView.getHeight();

                    float scale=videoratio/screenRatio;

                    if(scale>1f){
                        videoView.setScaleX(scale);

                    }else {
                        videoView.setScaleY(1f/scale);
                    }

                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
