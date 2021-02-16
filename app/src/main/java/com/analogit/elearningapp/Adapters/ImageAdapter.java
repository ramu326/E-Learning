package com.analogit.elearningapp.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Model.ImageModel;
import com.analogit.elearningapp.Model.VideosModel;
import com.analogit.elearningapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewholder> {


    private List<ImageModel> imageModel;
    Context context;
    MediaPlayer player = new MediaPlayer();


    public ImageAdapter(List<ImageModel> imageModel) {
        this.imageModel = imageModel;


    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_zoom_image_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.image.setImageDrawable(imageModel.get(position).imageView);


    }

    @Override
    public int getItemCount() {
        return imageModel.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder {

        ImageView image, music_play;

        BottomSheetBehavior<View> bottomSheetBehavior;


        public MyViewholder(@NonNull final View itemView) {
            super(itemView);
            bottomSheetBehavior = BottomSheetBehavior.from(itemView.findViewById(R.id.linear));

            image = itemView.findViewById(R.id.image_zoom_view);
            music_play = itemView.findViewById(R.id.pod_cast_play_audio);
            image.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {


                    switch (bottomSheetBehavior.getState()) {
                        case BottomSheetBehavior.STATE_COLLAPSED:
                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                            music_play.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (!player.isPlaying()) {
                                        player = MediaPlayer.create(itemView.getContext(), R.raw.one);
                                        music_play.setImageResource(R.drawable.ic_music_pause);
                                        player.start();
                                    } else {
                                        player.stop();
                                        music_play.setImageResource(R.drawable.ic_play);

                                    }
                                }
                            });
                            break;
                        case BottomSheetBehavior.STATE_EXPANDED:
                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                            break;
                    }


                }

            });


        }


    }


}
