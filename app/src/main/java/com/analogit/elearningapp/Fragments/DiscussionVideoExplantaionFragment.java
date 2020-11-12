package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.RecyclerDiscussionVideoExplantaionAdapter;
import com.analogit.elearningapp.R;


public class DiscussionVideoExplantaionFragment extends Fragment {

   View view;
RecyclerView rViewSub,rViewSubExplain;
    public DiscussionVideoExplantaionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_discussion_video_explantaion, container, false);

        RecyclerAllSubjectsAdapter recyclerAllSubjectsAdapter=new RecyclerAllSubjectsAdapter(this);
        RecyclerDiscussionVideoExplantaionAdapter recyclerDiscussionVideoExplantaionAdapter=new RecyclerDiscussionVideoExplantaionAdapter(this);

        rViewSub=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub);
        rViewSub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        rViewSub.setAdapter(recyclerAllSubjectsAdapter);
        rViewSubExplain=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub_explantaion);

        rViewSubExplain.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rViewSubExplain.setAdapter(recyclerDiscussionVideoExplantaionAdapter);
        return view;
    }
}