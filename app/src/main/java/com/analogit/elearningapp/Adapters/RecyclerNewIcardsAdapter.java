package com.analogit.elearningapp.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

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

        LinearLayout linearLayout;
        RecyclerView recyclerView;
        TextView textView;


        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.ll_subject_topic);


            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.d("topics","Anotomysub");
                    RecyclerAllTopicsAdapter recyclerAllTopicsAdapter=new RecyclerAllTopicsAdapter(fragment);

                    ((NewIcardExtenFragment) (fragment)).fYear_rViewTopic
                            .setLayoutManager(new LinearLayoutManager(fragment.getContext(), RecyclerView.HORIZONTAL, false));
                    ((NewIcardExtenFragment) (fragment)).fYear_rViewTopic.setAdapter(recyclerAllTopicsAdapter);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
