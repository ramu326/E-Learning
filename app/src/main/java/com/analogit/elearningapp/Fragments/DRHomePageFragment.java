package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAudioAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLearnAudioAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLearnNotesAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLearnSavedAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLearnVideoAdapter;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;


public class DRHomePageFragment extends Fragment {

 View v;
 RecyclerView recyclerView,recAudio,recNotes,recSaved;

    RecyclerLearnVideoAdapter recyclerLearnVideoAdapter;
    int pos;
    ArrayList<DoctorModel>arrayList=new ArrayList<>();
    ArrayList<DoctorModel>arrayListnotes=new ArrayList<>();
    ArrayList<DoctorModel>arrayListsaved=new ArrayList<>();

    public DRHomePageFragment(int pos) {
        this.pos=pos;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        switch (pos){
            case 0:
                v= inflater.inflate(R.layout.fragment_d_r_home_page, container, false);
                recyclerView=v.findViewById(R.id.learn_rec);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
                recyclerLearnVideoAdapter=new RecyclerLearnVideoAdapter(this);
                recyclerView.setAdapter(recyclerLearnVideoAdapter);

                break;

            case 1:
                v=inflater.inflate(R.layout.learn_audio_layout,container,false);
                recAudio=v.findViewById(R.id.learn_audio_rec);
                recAudio.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
                RecyclerLearnAudioAdapter recyclerAudioAdapter=new RecyclerLearnAudioAdapter(getContext(),arrayList);
                recAudio.setAdapter(recyclerAudioAdapter);
                break;

            case 2:
                v=inflater.inflate(R.layout.learn_notes_layout,container,false);
                recNotes=v.findViewById(R.id.learn_notes_rec);
                recNotes.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
                RecyclerLearnNotesAdapter recyclerLearnNotesAdapter=new RecyclerLearnNotesAdapter(getContext(),arrayListnotes);
                recNotes.setAdapter(recyclerLearnNotesAdapter);
                break;
            case 3:
                v=inflater.inflate(R.layout.learn_saved_layout,container,false);
                recSaved=v.findViewById(R.id.learn_saved_rec);
                recSaved.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
                RecyclerLearnSavedAdapter recyclerLearnSavedAdapter=new RecyclerLearnSavedAdapter(getContext(),arrayListsaved);
                recSaved.setAdapter(recyclerLearnSavedAdapter);
                break;
        }

        return v;
    }
}