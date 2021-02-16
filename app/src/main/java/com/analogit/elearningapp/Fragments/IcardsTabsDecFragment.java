package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.analogit.elearningapp.Adapters.DrParentChlidAdapter;
import com.analogit.elearningapp.Adapters.IcardsParentChildAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IcardsTabsDecFragment extends Fragment {


View v;
ExpandableListView expandableListView;
    ArrayList<String> icardsParentlist=new ArrayList<>();

    Map<String, List<String>> hashmap=new HashMap<>();
    public IcardsTabsDecFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_icards_tabs_dec, container, false);
        expandableListView=v.findViewById(R.id.icards_expandable_listview);



        IcardsParentChildAdapter icardsParentChildAdapter=new IcardsParentChildAdapter(icardsParentlist,hashmap);

        icardsParentlist.add("General Embbrylogy One");
        icardsParentlist.add("General Embbrylogy Two");
        icardsParentlist.add("General Embbrylogy Three");
        icardsParentlist.add("General Embbrylogy Four");
        for(int i=0;i<icardsParentlist.size();i++){
            ArrayList icardschildlist=new ArrayList();
            icardschildlist.add("General Anatomy One");
            icardschildlist.add("General Anatomy Two");
            icardschildlist.add("General Anatomy Three");
            icardschildlist.add("General Anatomy Four");
            hashmap.put(icardsParentlist.get(i),icardschildlist);

        }
        expandableListView.setAdapter(icardsParentChildAdapter);
        for (int i=0;i<icardsParentlist.size();i++)
            expandableListView.expandGroup(i);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        return v;
    }
}