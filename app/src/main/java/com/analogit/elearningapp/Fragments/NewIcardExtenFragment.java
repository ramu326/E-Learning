package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerNewIcardsAdapter;
import com.analogit.elearningapp.Model.NewIcardsModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewIcardExtenFragment extends Fragment {

    View v;
    RecyclerView rSub;
    ProgressBar progressBar;
    ArrayList<NewIcardsModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
      String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    public NewIcardExtenFragment() {
        // this.position = position;
    }

    private RecyclerNewIcardsAdapter recyclerNewIcardsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.icards_layout_with_tab_info, container, false);
        rSub = v.findViewById(R.id.new_cards_rec);
        progressBar = v.findViewById(R.id.icard_pro);
        REST_CLIENT = RestClient.get();
        pref =getActivity(). getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        rSub.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        Call<List<NewIcardsModel>> call = REST_CLIENT.getIcardssub(pref.getString("token", "-1"),content);
        call.enqueue(new Callback<List<NewIcardsModel>>() {
            List<NewIcardsModel> newIcardsModelList;
            NewIcardsModel newIcardsModelMap;

            @Override
            public void onResponse(Call<List<NewIcardsModel>> call, Response<List<NewIcardsModel>> response) {
                newIcardsModelList = response.body();
                progressBar.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    arrayList.clear();
                    for (int i = 0; i < newIcardsModelList.size(); i++) {
                        newIcardsModelMap = newIcardsModelList.get(i);
                        arrayList.add(new NewIcardsModel(newIcardsModelMap.getId(), newIcardsModelMap.getIcard(), newIcardsModelMap.getSubject(), newIcardsModelMap.getImage()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
                RecyclerNewIcardsAdapter recyclerLearnVideoAdapter = new RecyclerNewIcardsAdapter(getContext(), arrayList);
                rSub.setAdapter(recyclerLearnVideoAdapter);
                recyclerLearnVideoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NewIcardsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });


        return v;

    }
}
