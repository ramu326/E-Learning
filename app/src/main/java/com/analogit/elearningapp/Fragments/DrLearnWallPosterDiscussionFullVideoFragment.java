package com.analogit.elearningapp.Fragments;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.analogit.elearningapp.R;
import com.github.rtoshiro.view.video.FullscreenVideoLayout;

import java.io.IOException;


public class DrLearnWallPosterDiscussionFullVideoFragment extends Fragment {

  View view;
 FullscreenVideoLayout videoView;

    public DrLearnWallPosterDiscussionFullVideoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_dr_learn_wall_poster_discussion_full_video, container, false);
        videoView=view.findViewById(R.id.videoViewRelative);

        if(getArguments()!=null){
            String url=getArguments().getString("videourl");
            Log.d("fullviewvideo",url);
            Uri videouri=Uri.parse(url);
            try {
                videoView.setVideoURI(videouri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        View decorView = getActivity().getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//
//
//       String VideoPath="android.resource://"+getActivity().getPackageName()+"/"+R.raw.rrr;
//       Uri uri=Uri.parse(VideoPath);
//       videoView.setVideoURI(uri);
//
//       // getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//       MediaController mediaController=new MediaController(getContext());
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);
        return view;
    }
}