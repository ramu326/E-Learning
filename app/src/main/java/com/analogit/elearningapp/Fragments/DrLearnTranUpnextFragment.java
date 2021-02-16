package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.DrParentChlidAdapter;
import com.analogit.elearningapp.Adapters.RecyclerOverViewAdapter;
import com.analogit.elearningapp.Adapters.RecyclerSlideImagesAdapter;
import com.analogit.elearningapp.Model.AllQuestionsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrLearnTranUpnextFragment extends Fragment {

View v;
RecyclerView recyclerView,transrecyclerview,recslides;
ArrayList<AllQuestionsModel>arrayList;
    ExpandableListView expandableListView;
    ArrayList<String> drParentlist=new ArrayList<>();
    ArrayList<String>drChildlist=new ArrayList<>();
    Map<String, List<String>> hashmap=new HashMap<>();
int position;
    public DrLearnTranUpnextFragment(int position) {

       this.position=position; // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        switch (position){
            case 0:
                v=inflater.inflate(R.layout.transcript_layout,container,false);
                transrecyclerview=v.findViewById(R.id.trans_script_rec);
                RecyclerOverViewAdapter recyclerOverViewAdapter=new RecyclerOverViewAdapter(this);
                transrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                transrecyclerview.setAdapter(recyclerOverViewAdapter);
                ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
                break;
            case 1:
                v=inflater.inflate(R.layout.slides_images,container,false);
                recslides=v.findViewById(R.id.rec_slides_images);
                RecyclerSlideImagesAdapter recyclerSlideImagesAdapter=new RecyclerSlideImagesAdapter(getContext(),arrayList);
                recslides.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                recslides.setAdapter(recyclerSlideImagesAdapter);
                break;
            case 2:

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
//                v= inflater.inflate(R.layout.fragment_dr_learn_tran_upnext, container, false);
//                recyclerView=v.findViewById(R.id.fr_tran_upnext_rec);
//                RecyclerMorningRoundDecAdapter recyclerMorningRoundDecAdapter=new RecyclerMorningRoundDecAdapter(this);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//                recyclerView.setAdapter(recyclerMorningRoundDecAdapter);
                ( (MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

                break;
        }

        return v;
    }
}