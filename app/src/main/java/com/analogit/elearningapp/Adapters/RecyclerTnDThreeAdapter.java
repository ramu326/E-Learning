package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.Model.TndThreeModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTnDThreeAdapter extends ListAdapter<TndThreeModel,RecyclerTnDThreeAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerTnDThreeAdapter(Fragment fragment) {
        super(TndThreeModel.tndThreeModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.start_resume_test_dis_row_three,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }
    @Override
    public void submitList(@Nullable List<TndThreeModel> list) {
        super.submitList(list == null ? null : new ArrayList<TndThreeModel>(list));
    }

    class  MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
