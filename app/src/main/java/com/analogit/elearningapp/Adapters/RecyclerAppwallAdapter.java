package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.AppWallFragment;
import com.analogit.elearningapp.Model.AppwallModel;
import com.analogit.elearningapp.Model.LiveClassModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAppwallAdapter extends ListAdapter<AppwallModel,RecyclerAppwallAdapter.MyViewholder> {
            Fragment fragment1;
    public RecyclerAppwallAdapter(Fragment fragment1) {
        super(AppwallModel.appwallModelItemCallback);
        this.fragment1=fragment1;
    }



    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_app_wall_row,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
       // holder.calender.setImageDrawable(appWallFragment.getContext().getResources().getDrawable(R.drawable.ic_calendar));

    }
    @Override
    public void submitList(@Nullable List<AppwallModel> list) {
        super.submitList(list == null ? null : new ArrayList<AppwallModel>(list));
    }
    class MyViewholder extends RecyclerView.ViewHolder{
        ImageView T_image,calender;
        TextView title,time,subject,view,like,share,play_bt,ltext;
       public MyViewholder(@NonNull View itemView) {
           super(itemView);//appwall
//           T_image=itemView.findViewById(R.id.iv_appwall_image);
//           calender=itemView.findViewById(R.id.iv_appwall_calender);
//           title=itemView.findViewById(R.id.tv_appwall_topic_name);
//           time=itemView.findViewById(R.id.tv_appwall_time);
//           subject=itemView.findViewById(R.id.tv_appwall_subject);
//           view=itemView.findViewById(R.id.tv_appwall_views);
//           like=itemView.findViewById(R.id.tv_appwall_like);
//           share=itemView.findViewById(R.id.tv_appwall_share);
//           play_bt=itemView.findViewById(R.id.tv_appwall_play);
//           ltext=itemView.findViewById(R.id.tv_appwall_longtext);
       }
   }

    @Override
    public int getItemCount() {
        return 4;
    }
}
