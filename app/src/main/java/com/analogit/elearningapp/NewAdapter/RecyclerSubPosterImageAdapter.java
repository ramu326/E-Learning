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

import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.Fragments.WallPosterZoomFragment;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerSubPosterImageAdapter extends RecyclerView.Adapter<RecyclerSubPosterImageAdapter.MyViewHolder> {

    Context context;
    ArrayList<PosterSubImagesModel>posterSubImageList;

    public RecyclerSubPosterImageAdapter(Context context, ArrayList<PosterSubImagesModel> posterSubImageList) {
        this.context = context;
        this.posterSubImageList = posterSubImageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.poser_sub_iamges_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Glide.with(context).load(Image_Url+posterSubImageList.get(position).getImage()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallPosterZoomFragment wallPosterZoomFragment=new WallPosterZoomFragment();
                int id=posterSubImageList.get(position).getId();
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
        return posterSubImageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_poster_sub);

        }
    }
}
