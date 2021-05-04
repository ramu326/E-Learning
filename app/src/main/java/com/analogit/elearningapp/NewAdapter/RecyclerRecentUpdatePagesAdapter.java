package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.RecentUpdatePagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerRecentUpdatePagesAdapter extends RecyclerView.Adapter<RecyclerRecentUpdatePagesAdapter.RecentUpdate> {
    Context context;
    ArrayList<RecentUpdatePagesModel> arrayList;

    public RecyclerRecentUpdatePagesAdapter(Context context, ArrayList<RecentUpdatePagesModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecentUpdate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentUpdate(LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_pages_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentUpdate holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecentUpdate extends RecyclerView.ViewHolder {
        ImageView imageView;

        public RecentUpdate(@NonNull View itemView) {

            super(itemView);

            imageView = itemView.findViewById(R.id.iv_recent_image);
        }
    }
}
