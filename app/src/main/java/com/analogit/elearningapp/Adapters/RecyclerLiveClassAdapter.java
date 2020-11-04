package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.LiveClassFragment;
import com.analogit.elearningapp.Model.LiveClassModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class RecyclerLiveClassAdapter extends ListAdapter <LiveClassModel, RecyclerLiveClassAdapter.MyViewholder>{
    Fragment fragment;
    public RecyclerLiveClassAdapter(Fragment fragment) {
        super(LiveClassModel.liveClassModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.live_class_row_now,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
       // holder.T_image.setImageURI(Uri.parse(getCurrentList().get(position).getImage()));

       // holder.calender.setImageDrawable(liveclassFragment.getContext().getResources().getDrawable(R.drawable.ic_calendar));
//        holder.title.setText(getCurrentList().get(position).getTopicName());
//        holder.time.setText(getCurrentList().get(position).getTime());
//        holder.subject.setText(getCurrentList().get(position).getSubject());
//        holder.view.setText(getCurrentList().get(position).getViews());
//        holder.like.setText(getCurrentList().get(position).getLikes());
//        holder.share.setText(getCurrentList().get(position).getShares());
//        holder.play_bt.setText(getCurrentList().get(position).getPlay());
//        holder.ltext.setText(getCurrentList().get(position).getLongText());
    }
    @Override
    public void submitList(@Nullable List<LiveClassModel> list) {
        super.submitList(list == null ? null : new ArrayList<LiveClassModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        ImageView T_image,calender;
        TextView title,time,subject,view,like,share,play_bt,ltext;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
//            T_image=itemView.findViewById(R.id.iv_lcr_image);
//            calender=itemView.findViewById(R.id.iv_lcr_calender);
//            title=itemView.findViewById(R.id.tv_lcr_topic_name);
//            time=itemView.findViewById(R.id.tv_lcr_time);
//            subject=itemView.findViewById(R.id.tv_lcr_subject);
//            view=itemView.findViewById(R.id.tv_lcr_views);
//            like=itemView.findViewById(R.id.tv_lcr_like);
//            share=itemView.findViewById(R.id.tv_lcr_share);
//            play_bt=itemView.findViewById(R.id.tv_lcr_play);
           // ltext=itemView.findViewById(R.id.tv_lcr_longtext);

        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
