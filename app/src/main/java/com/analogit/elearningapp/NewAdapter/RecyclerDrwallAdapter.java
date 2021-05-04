package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.SuggestedModel;
import com.analogit.elearningapp.Model.AppwallModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerDrwallAdapter extends RecyclerView.Adapter<RecyclerDrwallAdapter.DrwallAdapter> {

    Context context;
    ArrayList<SuggestedModel>arrayList;

    public RecyclerDrwallAdapter(Context context, ArrayList<SuggestedModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DrwallAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DrwallAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_wall_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DrwallAdapter holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvTopic.setText(arrayList.get(position).getRounds());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class DrwallAdapter extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView tvName,tvTopic;
        public DrwallAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_dr_wall);
            tvName=itemView.findViewById(R.id.topic);
            tvTopic=itemView.findViewById(R.id.topic_dec);
        }
    }
}
