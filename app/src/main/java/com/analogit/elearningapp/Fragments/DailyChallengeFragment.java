package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerQuizAdapter;
import com.analogit.elearningapp.R;


public class DailyChallengeFragment extends Fragment {

private  View v;
private RecyclerView recyclerView;
private RecyclerQuizAdapter recyclerQuizAdapter;
private ImageView Imagecal;
private TextView tvSubmit;

    public DailyChallengeFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_daily_challenge, container, false);


        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView=v.findViewById(R.id.fdc_rec);
        tvSubmit=v.findViewById(R.id.tv_submit);
        Imagecal=v.findViewById(R.id.iv_fdc_cal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerQuizAdapter=new RecyclerQuizAdapter(this);
        recyclerView.setAdapter(recyclerQuizAdapter);

    Imagecal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.content,new DailyChallngeAtempetdFragment());
            fr.addToBackStack(null);
            fr.commit();
        }
    });
        tvSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
            fr.replace(R.id.content,new DailyChallngeAtempetdFragment());
            fr.addToBackStack(null);
            fr.commit();
        }
    });
        return v;
    }
}