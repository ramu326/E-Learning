package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerAllPosterImagesAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerSubPosterImageAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WallPosterCheckFragment extends Fragment {

    View v;
    RecyclerView rviewsubposter,rviewAllposter;
    API REST_CLIENT;
    int name1=-1;
    ArrayList<AllPosterImagesModel> arrayListposterData = new ArrayList<>();
    ArrayList<PosterSubImagesModel> arrayListsubposterData = new ArrayList<>();
    public WallPosterCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_wall_poster_check, container, false);
        rviewsubposter = v.findViewById(R.id.rec_sub_poster);

        rviewAllposter = v.findViewById(R.id.rec_all_poster);
        REST_CLIENT = RestClient.get();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        rviewAllposter.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        rviewsubposter.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));

        if(getArguments().getInt("name")==name1){
            AllSubjectImages();
        }
        else{


            ParticularSubImages();
        }



        return v;
    }

    private void AllSubjectImages() {
        Call<List<AllPosterImagesModel>> call = REST_CLIENT.getAllPosterImages();
        call.enqueue(new Callback<List<AllPosterImagesModel>>() {
            List<AllPosterImagesModel> allPosterImagesModelList;
            AllPosterImagesModel posterImageData;

            @Override
            public void onResponse(Call<List<AllPosterImagesModel>> call, Response<List<AllPosterImagesModel>> response) {
                allPosterImagesModelList = response.body();
                if (response.isSuccessful()) {
                    arrayListposterData.clear();
                    arrayListsubposterData.clear();
                    rviewsubposter.setVisibility(View.GONE);
                    rviewAllposter.setVisibility(View.VISIBLE);
                    for (int i = 0; i < allPosterImagesModelList.size(); i++) {
                        posterImageData = allPosterImagesModelList.get(i);
                        arrayListposterData.add(new AllPosterImagesModel(posterImageData.getId(), posterImageData.getImage()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    rviewsubposter.setVisibility(View.GONE);
                    rviewAllposter.setVisibility(View.VISIBLE);
                }
                RecyclerAllPosterImagesAdapter recyclerAllPosterImagesAdapter = new RecyclerAllPosterImagesAdapter(getContext(), arrayListposterData);
                rviewAllposter.setAdapter(recyclerAllPosterImagesAdapter);
                recyclerAllPosterImagesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<AllPosterImagesModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void ParticularSubImages() {

        if(getArguments()!=null){

            Call<List<PosterSubImagesModel>>call=REST_CLIENT.getsubPosters(getArguments().getInt("nameid"));
            call.enqueue(new Callback<List<PosterSubImagesModel>>() {
                List<PosterSubImagesModel> posterSubImagesList;
                PosterSubImagesModel posterSubImagesData;
                @Override
                public void onResponse(Call<List<PosterSubImagesModel>> call, Response<List<PosterSubImagesModel>> response) {
                    posterSubImagesList=response.body();
                    if(response.isSuccessful()){
                        for(int i=0;i<posterSubImagesList.size();i++){

                            arrayListposterData.clear();
                            arrayListsubposterData.clear();
                            rviewsubposter.setVisibility(View.VISIBLE);
                            rviewAllposter.setVisibility(View.GONE);
                            posterSubImagesData=posterSubImagesList.get(i);
                            arrayListsubposterData.add(new PosterSubImagesModel(posterSubImagesData.getId(),posterSubImagesData.getSubject(),posterSubImagesData.getVideo(),posterSubImagesData.getImage(),posterSubImagesData.getName()));
                        }
                    }
                    else{
                        rviewsubposter.setVisibility(View.VISIBLE);
                        rviewAllposter.setVisibility(View.GONE);
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }

                    RecyclerSubPosterImageAdapter recyclerSubPosterImageAdapter=new RecyclerSubPosterImageAdapter(getContext(),arrayListsubposterData);
                    rviewsubposter.setAdapter(recyclerSubPosterImageAdapter);
                    recyclerSubPosterImageAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<List<PosterSubImagesModel>> call, Throwable t) {

                }
            });
        }


    }
}