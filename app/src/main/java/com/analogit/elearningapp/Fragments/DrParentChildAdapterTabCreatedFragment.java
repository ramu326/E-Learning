package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.analogit.elearningapp.Adapters.DrParentChlidAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrParentChildAdapterTabCreatedFragment extends Fragment {

  View v;
    ExpandableListView expandableListView;
    ArrayList<String> drParentlist=new ArrayList<>();
    ArrayList<String>drChildlist=new ArrayList<>();
    Map<String, List<String>> hashmap=new HashMap<>();
    public DrParentChildAdapterTabCreatedFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_dr_parent_child_adapter_tab_created, container, false);

        expandableListView=v.findViewById(R.id.expandable_listview_dr);
        DrParentChlidAdapter drParentChlidAdapter=new DrParentChlidAdapter(drParentlist,hashmap);

        drParentlist.add("General Embbrylogy One");
        drParentlist.add("General Embbrylogy Two");
        drParentlist.add("General Embbrylogy Three");
        drParentlist.add("General Embbrylogy Four");
        for(int i=0;i<drParentlist.size();i++){
            ArrayList drchildlist=new ArrayList();
            drchildlist.add("General Anatomy One");
            drchildlist.add("General Anatomy Two");
            drchildlist.add("General Anatomy Three");
            drchildlist.add("General Anatomy Four");
            hashmap.put(drParentlist.get(i),drchildlist);

        }
        expandableListView.setAdapter(drParentChlidAdapter);
        for (int i=0;i<drParentlist.size();i++)
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