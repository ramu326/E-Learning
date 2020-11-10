package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;
import com.github.chrisbanes.photoview.PhotoView;


public class WallPosterZoomFragment extends Fragment {

  View v;
  PhotoView pvZoomView;

    public WallPosterZoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_wall_poster_zoom, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        pvZoomView=v.findViewById(R.id.wallposter_zoom_imaze);

        return  v;
    }
}