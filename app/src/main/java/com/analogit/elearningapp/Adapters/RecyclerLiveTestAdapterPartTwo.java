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

import com.analogit.elearningapp.Model.LiveTestModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerLiveTestAdapterPartTwo extends ListAdapter<LiveTestModel, RecyclerLiveTestAdapterPartTwo.MyViewholder> {
    Fragment fragment;

    public RecyclerLiveTestAdapterPartTwo(Fragment fragment) {
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
//           itemView.findViewById(R.id.live_test_card_view).getLayoutParams().width = itemView.getContext().getResources().getDisplayMetrics().widthPixels - 200;
//
//            play_bt = itemView.findViewById(R.id.tv_ltr_play);
            // ltext=itemView.findViewById(R.id.tv_ltr_longtext);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
