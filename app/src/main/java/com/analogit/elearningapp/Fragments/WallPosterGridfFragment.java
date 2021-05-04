package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerPosterSubjectsAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerSubPosterImageAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WallPosterGridfFragment extends Fragment {

    public View v;
    public RecyclerView rViewSubName, rviewsubposter;
    public API REST_CLIENT;
    public ArrayList<AllSubjectModel> arrayListData = new ArrayList<>();
    public ArrayList<AllPosterImagesModel> arrayListposterData = new ArrayList<>();
    public ArrayList<PosterSubImagesModel> arrayListsubposterData = new ArrayList<>();
    public  String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;


    public WallPosterGridfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_wall_poster_gridf, container, false);

        rViewSubName = v.findViewById(R.id.rec_all_poster_subject_name);

        rviewsubposter = v.findViewById(R.id.rec_subject_posters);
        pref =getActivity(). getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();


        REST_CLIENT = RestClient.get();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        rViewSubName.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rviewsubposter.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));


        PostersSubjects();


        return v;
    }



    private void PostersSubjects() {
        Call<List<AllSubjectModel>> call = REST_CLIENT.getSubjects(pref.getString("token", "-1"),content);
        Log.d("hellohaidfef",pref.getString("token", "-1")+content);

        call.enqueue(new Callback<List<AllSubjectModel>>() {
            @Override
            public void onResponse(Call<List<AllSubjectModel>> call, Response<List<AllSubjectModel>> response) {
                List<AllSubjectModel> allSubjectList;
                AllSubjectModel AllSujectData;
                allSubjectList = response.body();
                if (response.isSuccessful()) {
                    for (int i = 0; i < allSubjectList.size(); i++) {
                        AllSujectData = allSubjectList.get(i);
                        Log.d("AllSubjects", AllSujectData.getName());
                        arrayListData.add(new AllSubjectModel(AllSujectData.getId(), AllSujectData.getCategory(), AllSujectData.getName(), AllSujectData.getCode(), AllSujectData.getStatusCreated(), AllSujectData.getUpdated()));
                    }
                }
                RecyclerPosterSubjectsAdapter recyclerPosterSubjectsAdapter = new RecyclerPosterSubjectsAdapter(getContext(), arrayListData, WallPosterGridfFragment.this);
                rViewSubName.setAdapter(recyclerPosterSubjectsAdapter);
                recyclerPosterSubjectsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AllSubjectModel>> call, Throwable t) {

               if(getActivity()!=null)
                Toast.makeText(getContext(), "Please check internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}