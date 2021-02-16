package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IBAllImagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerIBAliImagesAdapter extends RecyclerView.Adapter<RecyclerIBAliImagesAdapter.MyViewHolder>{

    Context context;
    ArrayList<IBAllImagesModel>ibAllImagesModel;

    public RecyclerIBAliImagesAdapter(Context context, ArrayList<IBAllImagesModel> ibAllImagesModel) {
        this.context = context;
        this.ibAllImagesModel = ibAllImagesModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ib_allimages_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_no.setText("Image No: "+String.valueOf(ibAllImagesModel.get(position).getImage_no()));
        holder.tv_dec.setText(ibAllImagesModel.get(position).getDescription());
        holder.tv_topic.setText(ibAllImagesModel.get(position).getSubject_name());
        Glide.with(context).load(Image_Url+ibAllImagesModel.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return ibAllImagesModel.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_no,tv_dec,tv_topic,tv_Notes;
        ImageView imageView;
        ConstraintLayout constraintLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_no=itemView.findViewById(R.id.ib_all_images_no);
            imageView=itemView.findViewById(R.id.ib_all_image);
            tv_dec=itemView.findViewById(R.id.tv_ib_all_images_dec);
            tv_topic=itemView.findViewById(R.id.tv_ib_all_images_topic);
            tv_Notes=itemView.findViewById(R.id.tv_all_images_notes);
               constraintLayout=itemView.findViewById(R.id.constraintlayout_all_images);
               constraintLayout.setVisibility(View.GONE);
               tv_Notes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (constraintLayout.getVisibility()==View.GONE){
                        constraintLayout.setVisibility(View.VISIBLE);
                    }
                    else{
                        constraintLayout.setVisibility(View.GONE);

                    }

                }
            });
        }
    }
}
