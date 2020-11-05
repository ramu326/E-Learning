package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.RecylerImageBankAdapter;
import com.analogit.elearningapp.R;


public class ImagesBankFragment extends Fragment {

private  View view;
private RecyclerView recyclerViewImage,recyclerViewSubject;
    RecylerImageBankAdapter recylerImageBankAdapter;
    RecyclerAllSubjectsAdapter recyclerAllSubjectsAdapter;
    public ImagesBankFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_images_bank, container, false);

        recyclerViewImage=view.findViewById(R.id.image_bank_rec);
        recyclerViewSubject=view.findViewById(R.id.imagebank_sub_rec);

        recyclerViewImage.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       recylerImageBankAdapter=new RecylerImageBankAdapter(this);
        recyclerViewImage.setAdapter(recylerImageBankAdapter);

        recyclerViewSubject.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerAllSubjectsAdapter=new RecyclerAllSubjectsAdapter(this);
        recyclerViewSubject.setAdapter(recyclerAllSubjectsAdapter);

       return  view;
    }
}