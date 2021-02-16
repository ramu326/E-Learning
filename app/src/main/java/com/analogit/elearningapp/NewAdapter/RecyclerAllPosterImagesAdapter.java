package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.Fragments.WallPosterZoomFragment;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerAllPosterImagesAdapter extends RecyclerView.Adapter<RecyclerAllPosterImagesAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllPosterImagesModel>allPosterImages;

    public RecyclerAllPosterImagesAdapter(Context context, ArrayList<AllPosterImagesModel> allPosterImages) {
        this.context = context;
        this.allPosterImages = allPosterImages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_poster_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        Glide.with(context).load(Image_Url+allPosterImages.get(position).getImage()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallPosterZoomFragment wallPosterZoomFragment=new WallPosterZoomFragment();
                int id=allPosterImages.get(position).getId();
                Bundle bundle=new Bundle();
                bundle.putInt("subidd",id);
                wallPosterZoomFragment.setArguments(bundle);
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,wallPosterZoomFragment).commit();
                Log.d("imageid",String.valueOf(id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return allPosterImages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_wall_poster_image);
        }
    }
}
