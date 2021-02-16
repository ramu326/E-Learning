package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.PosterImageVideoModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;


public class WallPosterZoomFragment extends Fragment {

    View v;
    PhotoView pvZoomView;
    TextView tvVideos;
    API REST_CLIENT;
    Bundle bundle;
    String videourl;
    ProgressBar progressBar;

    public WallPosterZoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_wall_poster_zoom, container, false);
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        pvZoomView = v.findViewById(R.id.wallposter_zoom_imaze);
        tvVideos = v.findViewById(R.id.wall_poster_zoom_video);
        progressBar=v.findViewById(R.id.progress);
        REST_CLIENT = RestClient.get();
        bundle = new Bundle();
        if (getArguments() != null) {
            Log.d("videosid", String.valueOf(getArguments().getInt("subidd")));

            Call<PosterImageVideoModel> call = REST_CLIENT.getPosterVideo(getArguments().getInt("subidd"));
            call.enqueue(new Callback<PosterImageVideoModel>() {
                PosterImageVideoModel posterImageVideoData;

                @Override
                public void onResponse(Call<PosterImageVideoModel> call, Response<PosterImageVideoModel> response) {
                    posterImageVideoData = response.body();
                    if (response.isSuccessful()) {
                        progressBar.setVisibility(View.GONE);
                        Glide.with(getContext()).load(Image_Url + posterImageVideoData.getImage()).into(pvZoomView);


                    } else {
                        progressBar.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                }


                @Override
                public void onFailure(Call<PosterImageVideoModel> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            });

        }

        tvVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (getArguments() != null) {

                    Log.d("videosid", String.valueOf(getArguments().getInt("subidd")));
                    Call<PosterImageVideoModel> call = REST_CLIENT.getPosterVideo(getArguments().getInt("subidd"));
                    call.enqueue(new Callback<PosterImageVideoModel>() {
                        PosterImageVideoModel posterImageVideoData;

                        @Override
                        public void onResponse(Call<PosterImageVideoModel> call, Response<PosterImageVideoModel> response) {
                            posterImageVideoData = response.body();
                            if (response.isSuccessful()) {

                                String videourl = Image_Url + posterImageVideoData.getVideo();
                                DrLearnWallPosterDiscussionFullVideoFragment drLearnWallPosterDiscussionFullVideoFragment = new DrLearnWallPosterDiscussionFullVideoFragment();
                                bundle.putString("videourl", videourl);
                                drLearnWallPosterDiscussionFullVideoFragment.setArguments(bundle);
                                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.content, drLearnWallPosterDiscussionFullVideoFragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            } else {
                                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onFailure(Call<PosterImageVideoModel> call, Throwable t) {
                            Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                        }
                    });

                }


            }
        });

        return v;
    }
}