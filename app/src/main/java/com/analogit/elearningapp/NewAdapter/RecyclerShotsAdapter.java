package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerShotsAdapter extends RecyclerView.Adapter<RecyclerShotsAdapter.Shotsadapter> {

    Context context;
    ArrayList<DoctorModel>arrayList;

    public RecyclerShotsAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Shotsadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Shotsadapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.shots_row_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Shotsadapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Shotsadapter extends RecyclerView.ViewHolder{

        public Shotsadapter(@NonNull View itemView) {
            super(itemView);
        }
    }
}
