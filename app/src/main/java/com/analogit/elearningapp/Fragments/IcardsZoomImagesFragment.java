package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.ImageAdapter;
import com.analogit.elearningapp.Adapters.VideosAdapter;
import com.analogit.elearningapp.Model.ImageModel;
import com.analogit.elearningapp.Model.VideosModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;


public class IcardsZoomImagesFragment extends Fragment {

    ViewPager2 viewPager;
    View view;
    public ImageAdapter imageAdapter;
    List<ImageModel> imageModels = new ArrayList<>();

    public IcardsZoomImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_icards_zoom_images, container, false);
        viewPager = view.findViewById(R.id.image_slider_viewpager);


        ImageModel first = new ImageModel();
        first.imageView = getActivity().getResources().getDrawable(R.drawable.image_zoom);
        imageModels.add(first);

        ImageModel sec = new ImageModel();
        sec.imageView = getActivity().getResources().getDrawable(R.drawable.image_zoom_one);
        imageModels.add(sec);

        ImageModel t = new ImageModel();
        t.imageView = getActivity().getResources().getDrawable(R.drawable.image_zoom_two);
        imageModels.add(t);

        ImageModel f = new ImageModel();
        f.imageView = getActivity().getResources().getDrawable(R.drawable.image_zoom_three);
        imageModels.add(f);

        viewPager.setAdapter(new ImageAdapter(imageModels));

        return view;
    }
}