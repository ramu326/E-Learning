package com.analogit.elearningapp.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsTabsDecFragment;
import com.analogit.elearningapp.Fragments.NewIcardExtenFragment;
import com.analogit.elearningapp.Model.NewIcardsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerNewIcardsAdapter extends ListAdapter<NewIcardsModel, RecyclerNewIcardsAdapter.MyViewholder> {
    Fragment fragment;

    public RecyclerNewIcardsAdapter(Fragment fragment) {
        super(NewIcardsModel.newIcardsModelItemCallback);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_icards_first_tab_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    @Override
    public void submitList(@Nullable List<NewIcardsModel> list) {
        super.submitList(list == null ? null : new ArrayList<NewIcardsModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder {


        ConstraintLayout constraintLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.cons_icards_view);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, new IcardsTabsDecFragment()).commit();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
