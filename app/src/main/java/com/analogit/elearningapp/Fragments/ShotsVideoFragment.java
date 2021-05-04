package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerShotsAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.databinding.FragmentShotsVideoBinding;

import java.util.ArrayList;


public class ShotsVideoFragment extends Fragment {


    View v;
    RecyclerView recyclerView;
    FragmentShotsVideoBinding binding;
    ArrayList<DoctorModel> arrayList = new ArrayList<>();

    ArrayAdapter<String> subjectSpinnerAdapter;

    ArrayAdapter<String> topicSpinnerAdapter;

    public ShotsVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_shots_video, container, false);

        binding = FragmentShotsVideoBinding.bind(v);

        recyclerView = v.findViewById(R.id.rec_shots);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        RecyclerShotsAdapter recyclerShotsAdapter = new RecyclerShotsAdapter(getContext(), arrayList);

        recyclerView.setAdapter(recyclerShotsAdapter);
        recyclerShotsAdapter.notifyDataSetChanged();


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        subjectSpinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, new String[]{"Anatomy", "Biology"});

        subjectSpinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_textview);
        binding.subjectSpinner.setAdapter(subjectSpinnerAdapter);


        topicSpinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, new String[]{"Topic1", "Topic2"});
        topicSpinnerAdapter.setDropDownViewResource(R.layout.spinner_dropdown_textview);

        binding.topicsSpinner.setAdapter(topicSpinnerAdapter);
    }
}