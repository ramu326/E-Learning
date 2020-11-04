package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerNewIcardsAdapter;
import com.analogit.elearningapp.R;

public class NewIcardExtenFragment  extends Fragment {
public RecyclerView fYear_rView,sYear_rView,tYear_rView,foYear_rView,fiYear_rView,fYear_rViewTopic;
private  View v;
private int position;
public NewIcardExtenFragment(int position){
    this.position=position;
}
private RecyclerNewIcardsAdapter recyclerNewIcardsAdapter;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v=  inflater.inflate(R.layout.new_icards_main_layout,container,false);
        fYear_rView=v.findViewById(R.id.rec_pre_clinicals);
        sYear_rView=v.findViewById(R.id.rec_para_clinicals);
        tYear_rView=v.findViewById(R.id.rec_proof_three_clinicals);
        foYear_rView=v.findViewById(R.id.rec_proof_four_clinicals);
        fiYear_rView=v.findViewById(R.id.rec_proof_minor_sub);

        fYear_rViewTopic=v.findViewById(R.id.rec_pre_clinicals_sub_topic);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        fYear_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerNewIcardsAdapter=new RecyclerNewIcardsAdapter(this);
        fYear_rView.setAdapter(recyclerNewIcardsAdapter);

        sYear_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        sYear_rView.setAdapter(recyclerNewIcardsAdapter);

        tYear_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        tYear_rView.setAdapter(recyclerNewIcardsAdapter);

        foYear_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        foYear_rView.setAdapter(recyclerNewIcardsAdapter);

        fiYear_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        fiYear_rView.setAdapter(recyclerNewIcardsAdapter);
        return v;

    }
}
