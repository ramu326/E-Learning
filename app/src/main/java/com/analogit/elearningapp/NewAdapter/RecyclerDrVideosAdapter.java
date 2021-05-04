package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.DrLearnVideoPlayFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerDrVideosAdapter extends RecyclerView.Adapter<RecyclerDrVideosAdapter.AdapterVideos> {
    Context context;
    ArrayList<DoctorModel> arrayList;

    public RecyclerDrVideosAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterVideos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterVideos(LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_child_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideos holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AdapterVideos extends RecyclerView.ViewHolder {

        ConstraintLayout constraintLayout;

        public AdapterVideos(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.ll_new_sub_go_qutions_module);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    DrLearnVideoPlayFragment drLearnVideoPlayFragment = new DrLearnVideoPlayFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, drLearnVideoPlayFragment).addToBackStack(null).commit();
                }
            });
        }
    }
}
