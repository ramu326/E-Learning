package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.RecentUpdateModel;
import com.analogit.elearningapp.Fragments.IcardsTopicsFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.RecentUpadetPagesFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecentUpdatesRecyclerAdapter extends RecyclerView.Adapter<RecentUpdatesRecyclerAdapter.RecentAdapter> {

    Context context;
    ArrayList<RecentUpdateModel> arrayList;

    public RecentUpdatesRecyclerAdapter(Context context, ArrayList<RecentUpdateModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecentAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecentAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_updates_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentAdapter holder, int position) {

        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvsub.setText(arrayList.get(position).getName());
        holder.tvupdate.setText(String.valueOf(arrayList.get(position).getId())+"  new Updates");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecentAdapter extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvsub,tvupdate;

        public RecentAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constaraint_recent_topic);
            imageView=itemView.findViewById(R.id.iv_sub_image_topic);
            tvsub=itemView.findViewById(R.id.tv_qbank_sub_name_topic);
            tvupdate=itemView.findViewById(R.id.qbank_tv_sub_work_status_topic);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecentUpadetPagesFragment recentUpadetPagesFragment=new RecentUpadetPagesFragment();

                    Bundle args=new Bundle();
                    args.putInt("id",arrayList.get(getAdapterPosition()).getId());
                    recentUpadetPagesFragment.setArguments(args);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, recentUpadetPagesFragment).commit();
                }
            });
        }
    }
}
