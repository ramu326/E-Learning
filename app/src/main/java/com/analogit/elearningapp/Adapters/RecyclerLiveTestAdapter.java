package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.LiveTestFragment;
import com.analogit.elearningapp.Model.LiveClassModel;
import com.analogit.elearningapp.Model.LiveTestModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerLiveTestAdapter extends ListAdapter<LiveTestModel, RecyclerLiveTestAdapter.MyViewholder> {
    Fragment fragment;

    public RecyclerLiveTestAdapter(Fragment fragment) {
        super(LiveTestModel.livetestmodelItemCallback);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.live_test_row_new, parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        //   holder.calender.setImageDrawable(liveTestFragment.getContext().getResources().getDrawable(R.drawable.date_cal));
        if (getItemCount() > 4) {

        }

    }

    @Override
    public void submitList(@Nullable List<LiveTestModel> list) {
        super.submitList(list == null ? null : new ArrayList<LiveTestModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder {
        ImageView T_image, calender;
        TextView title, mins, quest, attemt, like, share, play_bt, ltext;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            itemView.findViewById(R.id.live_test_card_view).getLayoutParams().width = itemView.getContext().getResources().getDisplayMetrics().widthPixels - 200;
//            T_image=itemView.findViewById(R.id.iv_ltr_image);
//            calender=itemView.findViewById(R.id.iv_ltr_calender);
//            title=itemView.findViewById(R.id.tv_ltr_topic_name);
//            mins=itemView.findViewById(R.id.tv_ltr_mins);
//            quest=itemView.findViewById(R.id.tv_ltr_questions);
//            attemt=itemView.findViewById(R.id.tv_ltr_attempt);
//            like=itemView.findViewById(R.id.tv_ltr_like);
//            share=itemView.findViewById(R.id.tv_ltr_share);
            play_bt = itemView.findViewById(R.id.tv_ltr_play);
            // ltext=itemView.findViewById(R.id.tv_ltr_longtext);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
