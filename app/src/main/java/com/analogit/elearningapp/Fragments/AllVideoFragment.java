package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

import com.analogit.elearningapp.Adapters.RecyclerVideosSubAdapter;
import com.analogit.elearningapp.Adapters.VideosAdapter;
import com.analogit.elearningapp.Model.VideosModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;


public class AllVideoFragment extends Fragment {

    private ViewPager2 viewPager2;
    private View v;
    private RecyclerView rSubView;
    private MediaController media_control;
    private RecyclerVideosSubAdapter recyclerVideosSubAdapter;

    List<VideosModel>videosModels=new ArrayList<>();



    public AllVideoFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       v= inflater.inflate(R.layout.fragment_video, container, false);

       viewPager2=v.findViewById(R.id.fv_viewpagers);
       rSubView=v.findViewById(R.id.rec_sub_slv);

       rSubView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
       recyclerVideosSubAdapter=new RecyclerVideosSubAdapter(this);
       rSubView.setAdapter(recyclerVideosSubAdapter);

       VideosModel first=new VideosModel();
       // first.videoUrl=getActivity().getResources().getDrawable(R.drawable.image_zoom);
       first.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.one;
       videosModels.add(first);


//       VideosModel second=new VideosModel();
//       second.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.two;;
//       videosModels.add(second);
//
//       VideosModel third=new VideosModel();
//       third.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.three;
//       videosModels.add(third);
//
//       VideosModel fourth=new VideosModel();
//       fourth.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.four;
//       videosModels.add(fourth);
//
//        VideosModel fifth=new VideosModel();
//        fifth.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.five;
//        videosModels.add(fifth);
//
//        VideosModel sixth=new VideosModel();
//        sixth.videoUrl="android.resource://" + getActivity().getPackageName() + "/" + R.raw.six;
//        videosModels.add(sixth);

       viewPager2.setAdapter(new VideosAdapter(videosModels));
       return v;
    }
}