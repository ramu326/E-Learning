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
import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.RecyclerWallPosterGridAdapter;
import com.analogit.elearningapp.R;


public class WallPosterGridfFragment extends Fragment {

   View view;
RecyclerView rViewsub,rViewImages;
    public WallPosterGridfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_wall_poster_gridf, container, false);

       rViewsub=view.findViewById(R.id.fr_wall_poster_grid_subject);
       rViewImages=view.findViewById(R.id.fr_wall_poster_grid_image);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

       rViewsub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        RecyclerAllSubjectsAdapter recyclerAllSubjectsAdapter=new RecyclerAllSubjectsAdapter(this);
        rViewsub.setAdapter(recyclerAllSubjectsAdapter);

        RecyclerWallPosterGridAdapter recyclerWallPosterAdapter=new RecyclerWallPosterGridAdapter(this);
        rViewImages.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
        rViewImages.setAdapter(recyclerWallPosterAdapter);
       return  view;
    }
}