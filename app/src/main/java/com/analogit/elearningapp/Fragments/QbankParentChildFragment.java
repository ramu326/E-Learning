package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.analogit.elearningapp.Adapters.QbankParentChildAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QbankParentChildFragment extends Fragment {

    ExpandableListView expandableListView;
    View v;

    ArrayList<String> parentlist=new ArrayList<String>();
    Map<String, List<String>> hashmap = new HashMap<>();


    public QbankParentChildFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_parent_child, container, false);
        expandableListView = v.findViewById(R.id.expandable_listview);

        QbankParentChildAdapter qbankParentChildAdapter =(new QbankParentChildAdapter(parentlist,hashmap));


        parentlist.add("general Embbryylogy One");
        parentlist.add("general Embbryylogy  Two");
        parentlist.add("general Embbryylogy  Three");
        parentlist.add("general Embbryylogy  Four");

        for (int i = 0; i < parentlist.size(); i++) {
            ArrayList childlist = new ArrayList();
            childlist.add("General Anatomy one");
            childlist.add("General Anatomy two");
            childlist.add("General Anatomy Three");
            childlist.add("General Anatomy Four");

            hashmap.put(parentlist.get(i), childlist);

        }



        expandableListView.setAdapter(qbankParentChildAdapter);
        for (int i=0;i<parentlist.size();i++)
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