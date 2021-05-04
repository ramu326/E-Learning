package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerImageBankSubjectAdapter;
import com.analogit.elearningapp.Adapters.RecyclerQbankSubTopicsAdapter;
import com.analogit.elearningapp.Adapters.RecylerImageBankAdapter;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.IBAllImagesModel;
import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerSubjectaAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImagesBankFragment extends Fragment {

    public View view;
    public RecyclerView recIbSubImage, recSubName, recAllImages;
    public RecylerImageBankAdapter recylerImageBankAdapter;
    public RecyclerImageBankSubjectAdapter recyclerImageBankSubjectAdapter;
    public RecyclerQbankSubTopicsAdapter recyclerImageGridViewAdapter;
    SwitchCompat aSwitch;
    API REST_CLIENT;

    public LinearLayout linearLayout;

    public ArrayList<AllSubjectModel> arrayListData = new ArrayList<>();
    public ArrayList<IBAllImagesModel> arrayListAllImages = new ArrayList<>();
    public String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;

    public ArrayList<IBSubImagesModel> arrayListIBSubImages = new ArrayList<>();

    public ImagesBankFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_images_bank, container, false);






        getIds();
        AllSubjects();


        return  view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void getIds() {
        recIbSubImage = view.findViewById(R.id.image_bank_rec);
        recSubName = view.findViewById(R.id.imagebank_sub_rec);
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        REST_CLIENT = RestClient.get();
        recAllImages = view.findViewById(R.id.image_bank_all_images);



        recAllImages.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recIbSubImage.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recSubName.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
    }

    private void AllSubjects() {

        Call<List<AllSubjectModel>> call = REST_CLIENT.getSubjects(pref.getString("token", "-1"), content);

        call.enqueue(new Callback<List<AllSubjectModel>>() {
            @Override
            public void onResponse(Call<List<AllSubjectModel>> call, Response<List<AllSubjectModel>> response) {
                List<AllSubjectModel> allSubjectList;
                AllSubjectModel AllSujectData;

                allSubjectList = response.body();
                if (response.isSuccessful()) {
                    for (int i = 0; i < allSubjectList.size(); i++) {
                        AllSujectData = allSubjectList.get(i);
                        arrayListData.add(new AllSubjectModel(AllSujectData.getId(), AllSujectData.getCategory(), AllSujectData.getName(), AllSujectData.getCode(), AllSujectData.getStatusCreated(), AllSujectData.getUpdated()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
                RecyclerSubjectaAdapter recyclerSubjectaAdapter = new RecyclerSubjectaAdapter(getContext(), arrayListData, ImagesBankFragment.this);
                recSubName.setAdapter(recyclerSubjectaAdapter);
                recyclerSubjectaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AllSubjectModel>> call, Throwable t) {


                Toast.makeText(getContext(), "Please check internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
