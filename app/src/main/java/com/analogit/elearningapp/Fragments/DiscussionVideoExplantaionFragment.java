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
import com.analogit.elearningapp.Adapters.RecyclerImageBankSubjectAdapter;
import com.analogit.elearningapp.R;


public class DiscussionVideoExplantaionFragment extends Fragment {

   View view;
RecyclerView rViewSub,rViewSubExplain;
int a;
    public DiscussionVideoExplantaionFragment(int a) {
        // Required empty public constructor
        this.a=a;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

     if(a==0){
         view= inflater.inflate(R.layout.fragment_discussion_video_explantaion, container, false);

         RecyclerImageBankSubjectAdapter recyclerImageBankSubjectAdapter=new RecyclerImageBankSubjectAdapter(this);
         RecyclerDiscussionVideoExplantaionAdapter recyclerDiscussionVideoExplantaionAdapter=new RecyclerDiscussionVideoExplantaionAdapter(this);

         rViewSub=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub);
         rViewSub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
         rViewSub.setAdapter(recyclerImageBankSubjectAdapter);
         rViewSubExplain=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub_explantaion);
         rViewSubExplain.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
         rViewSubExplain.setAdapter(recyclerDiscussionVideoExplantaionAdapter);
     }
     else if(a==1){
         view= inflater.inflate(R.layout.fragment_discussion_video_explantaion, container, false);
         rViewSub=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub);
                rViewSub.setVisibility(View.GONE);
           RecyclerDiscussionVideoExplantaionAdapter recyclerDiscussionVideoExplantaionAdapter=new RecyclerDiscussionVideoExplantaionAdapter(this);
          rViewSubExplain=view.findViewById(R.id.fr_discussion_video_explantion_rec_sub_explantaion);
          rViewSubExplain.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
          rViewSubExplain.setAdapter(recyclerDiscussionVideoExplantaionAdapter);
     }
     else {

     }

        return view;
    }
}