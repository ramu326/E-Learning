package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.BottomSheetModel;
import com.analogit.elearningapp.R;

public class RecyclerBottomSheetAdapter extends ListAdapter<BottomSheetModel,RecyclerBottomSheetAdapter.MyViewholder> {

    Fragment fragment;

    public RecyclerBottomSheetAdapter(Fragment fragment) {
        super(BottomSheetModel.bottomSheetModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_layout_num_row,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.tvTotalquest.setText(String.valueOf(position+1));

    }

    class  MyViewholder extends RecyclerView.ViewHolder{

        TextView tvTotalquest;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tvTotalquest=itemView.findViewById(R.id.tv_opt_one_bottom);
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
