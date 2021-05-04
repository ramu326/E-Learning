package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerTnDOneAdapter;
import com.analogit.elearningapp.Adapters.RecyclerTnDThreeAdapter;
import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;


public class DiffTestTypesFragment extends Fragment {

    private View v;
    private RecyclerView rView_one, rView_three;
    private RecyclerTnDOneAdapter recyclerTnDOneAdapter;
    int position;
    private RecyclerTnDThreeAdapter recyclerTnDThreeAdapter;

    public DiffTestTypesFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_diff_test_types, container, false);
        rView_one = v.findViewById(R.id.diff_test_rec);
        rView_three = v.findViewById(R.id.diff_test_type_rec);

        rView_one.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerTnDOneAdapter = new RecyclerTnDOneAdapter(this);
        rView_one.setAdapter(recyclerTnDOneAdapter);

        List<TnDOneModel> list=new ArrayList<>();

        TnDOneModel tnDOneModel=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");

        TnDOneModel tnDOneModel1=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");

        TnDOneModel tnDOneModel2=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");


        list.add(tnDOneModel);
        list.add(tnDOneModel1);
        list.add(tnDOneModel2);

        recyclerTnDOneAdapter.submitList(list);


        rView_three.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerTnDThreeAdapter = new RecyclerTnDThreeAdapter(this);
        rView_three.setAdapter(recyclerTnDThreeAdapter);


        List<TnDOneModel> list1=new ArrayList<>();

        TnDOneModel tnDOneModell=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");

        TnDOneModel tnDOneModell1=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");

        TnDOneModel tnDOneModell2=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");
        TnDOneModel tnDOneModell4=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");

        TnDOneModel tnDOneModell5=new TnDOneModel(1,"TestName","","2 Nov 2020","","20 mins", " 40 Mcqs","Anatomy");


        list1.add(tnDOneModell);
        list1.add(tnDOneModell1);
        list1.add(tnDOneModell2);

        list1.add(tnDOneModell4);
        list1.add(tnDOneModell5);

        recyclerTnDThreeAdapter.submitList(list1);

        switch (position) {

            case 0: {
                rView_one.setVisibility(View.VISIBLE);
                rView_three.setVisibility(View.VISIBLE);
                break;
            }

            case 7: {
                rView_one.setVisibility(View.VISIBLE);
                rView_three.setVisibility(View.GONE);
                break;
            }
            default: {
                rView_one.setVisibility(View.GONE);
                rView_three.setVisibility(View.VISIBLE);
            }
        }

        return v;
    }

    public interface TestsClicked{

    }
}