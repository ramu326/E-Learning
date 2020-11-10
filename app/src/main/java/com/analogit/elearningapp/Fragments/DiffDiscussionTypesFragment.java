package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerDiscussionAdapter;
import com.analogit.elearningapp.R;

public class DiffDiscussionTypesFragment extends Fragment {


    View v;
    RecyclerView rView;
    int position;
    public  DiffDiscussionTypesFragment(int position){
        this.position=position;

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_new_discussion,container,false);
        rView=v.findViewById(R.id.new_discussion_video_rec);

                rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                RecyclerDiscussionAdapter recyclerDiscussionAdapter=new RecyclerDiscussionAdapter(this);
                rView.setAdapter(recyclerDiscussionAdapter);
        return v;
    }
}
