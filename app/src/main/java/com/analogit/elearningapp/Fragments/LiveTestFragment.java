package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerLiveTestAdapterPartTwo;
import com.analogit.elearningapp.R;

public  class LiveTestFragment extends Fragment{
    private View v;
    private RecyclerView onGoing_rview,upComing_rView,previous_rView;
    private RecyclerLiveTestAdapterPartTwo RltAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.live_test_latest_layout, container, false);
        onGoing_rview=v.findViewById(R.id.live_test_latest_rec);
        upComing_rView=v.findViewById(R.id.live_test_upcoming_rec);
        previous_rView=v.findViewById(R.id.live_test_previous_rec);

        onGoing_rview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
       RltAdapter=new RecyclerLiveTestAdapterPartTwo(this);
        onGoing_rview.setAdapter(RltAdapter);

        upComing_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        upComing_rView.setAdapter(RltAdapter);

        previous_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        previous_rView.setAdapter(RltAdapter);

        return v;
    }
}
