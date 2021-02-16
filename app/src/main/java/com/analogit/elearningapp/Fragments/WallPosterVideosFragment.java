package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerWallPosterVideosAdapter;
import com.analogit.elearningapp.R;

public class WallPosterVideosFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     v=inflater.inflate(R.layout.videos_layout, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
     recyclerView=v.findViewById(R.id.wall_poster_videos);
     recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerWallPosterVideosAdapter recyclerWallPosterVideosAdapter=new RecyclerWallPosterVideosAdapter(this);
        recyclerView.setAdapter(recyclerWallPosterVideosAdapter);
     return v;
    }
}
