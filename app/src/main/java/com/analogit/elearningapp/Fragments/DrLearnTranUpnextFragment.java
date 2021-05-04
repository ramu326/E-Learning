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
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDrNotesAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerDrVideosAdapter;
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
    ArrayList<DoctorModel>arrayList1=new ArrayList<>();
    ArrayList<DoctorModel>arrayList2=new ArrayList<>();
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
                transrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                RecyclerDrNotesAdapter recyclerDrNotesAdapter=new RecyclerDrNotesAdapter(getContext(),arrayList2);
                transrecyclerview.setAdapter(recyclerDrNotesAdapter);
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

                recyclerView=v.findViewById(R.id.rec_listview_dr);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                RecyclerDrVideosAdapter recyclerDrVideosAdapter = new RecyclerDrVideosAdapter(getContext(), arrayList1);
                recyclerView.setAdapter(recyclerDrVideosAdapter);

                ( (MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

                break;
        }

        return v;
    }
}