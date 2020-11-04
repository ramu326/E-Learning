package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerLiveClassAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLiveClassLatestAdapter;
import com.analogit.elearningapp.R;

public class LiveClassFragment extends Fragment {
    private RecyclerView onGoing_rview,upComing_rView,previous_rView;
    private RecyclerLiveClassLatestAdapter allthreeAdapter;


    View v;

    public LiveClassFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      v= inflater.inflate(R.layout.live_class_latest_layout, container, false);
      onGoing_rview=v.findViewById(R.id.live_class_latest_rec);
      upComing_rView=v.findViewById(R.id.live_class_upcoming_rec);
      previous_rView=v.findViewById(R.id.live_class_previous_rec);

       // ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        onGoing_rview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        allthreeAdapter=new RecyclerLiveClassLatestAdapter(this);
        onGoing_rview.setAdapter(allthreeAdapter);

        upComing_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        upComing_rView.setAdapter(allthreeAdapter);

        previous_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        previous_rView.setAdapter(allthreeAdapter);

        return v;
    }

}
