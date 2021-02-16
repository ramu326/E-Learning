package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerDrLearnWallposterAdapter;
import com.analogit.elearningapp.Adapters.RecyclerImageBankSubjectAdapter;
import com.analogit.elearningapp.R;


public class DrLearnWallPosterDiscussion extends Fragment {


View v;
RecyclerView recyclerViewSub,recyclerViewImage;

    public DrLearnWallPosterDiscussion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dr_learn_wall_poster_discussion, container, false);
        recyclerViewSub=v.findViewById(R.id.fr_dr_learn_wall_poster_grid_subject);
        recyclerViewImage=v.findViewById(R.id.fr_dr_learn_wall_poster_grid_image);

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        recyclerViewSub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        RecyclerImageBankSubjectAdapter recyclerAllSubjectsAdapter=new RecyclerImageBankSubjectAdapter(this);
        recyclerViewSub.setAdapter(recyclerAllSubjectsAdapter);

        RecyclerDrLearnWallposterAdapter recyclerWallPosterAdapter=new RecyclerDrLearnWallposterAdapter(this);
        recyclerViewImage.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
        recyclerViewImage.setAdapter(recyclerWallPosterAdapter);
        return v;
    }
}