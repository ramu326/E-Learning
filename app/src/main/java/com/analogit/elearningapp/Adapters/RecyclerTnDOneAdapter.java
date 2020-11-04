package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.TdStartFragment;
import com.analogit.elearningapp.Model.SubjectsModel;
import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTnDOneAdapter extends ListAdapter<TnDOneModel,RecyclerTnDOneAdapter.MyViewholder> {

    Fragment fragment;
    public RecyclerTnDOneAdapter(Fragment fragment) {
        super(TnDOneModel.tnDOneModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.start_resume_test_dis_row_one,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }
    @Override
    public void submitList(@Nullable List<TnDOneModel> list) {
        super.submitList(list == null ? null : new ArrayList<TnDOneModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            linearLayout=itemView.findViewById(R.id.ll_srtdone);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity appCompatActivity=(AppCompatActivity) view.getContext();
                    Fragment fragment=new TdStartFragment();

                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return 10;
    }
}
