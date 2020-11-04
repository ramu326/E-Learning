package com.analogit.elearningapp.Adapters;

import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.ImageModel;
import com.analogit.elearningapp.Model.VideosModel;
import com.analogit.elearningapp.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewholder> {


    private List<ImageModel> imageModel;

    public ImageAdapter(List<ImageModel> imageModel) {
        this.imageModel = imageModel;
    }
    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_zoom_image_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.image.setImageDrawable(imageModel.get(position).imageView);

    }

    @Override
    public int getItemCount() {
        return imageModel.size();
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ImageView image;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_zoom_view);
        }

    }



}
