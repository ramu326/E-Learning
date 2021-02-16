package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerIBSubImagesAdapter extends RecyclerView.Adapter<RecyclerIBSubImagesAdapter.MyViewHolder> {

    Context context;
    ArrayList<IBSubImagesModel>ibSubImagesList;

    public RecyclerIBSubImagesAdapter(Context context, ArrayList<IBSubImagesModel> ibSubImagesList) {

        Log.d("lohhhh",String.valueOf(ibSubImagesList.size()));
        this.context = context;
        this.ibSubImagesList = ibSubImagesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ib_sub_images_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_No.setText("Image No: "+String.valueOf(ibSubImagesList.get(position).getImage_no()));
        holder.tv_Topic.setText(ibSubImagesList.get(position).getSubject_name());
        holder.tv_Dec.setText(ibSubImagesList.get(position).getDescription());
        Glide.with(context).load(Image_Url+ibSubImagesList.get(position).getImage()).into(holder.iv_Image);
    }

    @Override
    public int getItemCount() {
        return ibSubImagesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_No,tv_Topic,tv_Dec;
        ImageView iv_Image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_No=itemView.findViewById(R.id.ib_sub_images_no);
            tv_Topic=itemView.findViewById(R.id.tv_ib_sub_images_topic);
            tv_Dec=itemView.findViewById(R.id.tv_ib_sub_image_dec);
            iv_Image=itemView.findViewById(R.id.ib_sub_image);
        }
    }
}
