package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerBottomSheetAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private RecyclerView recyclerView;
    private RecyclerBottomSheetAdapter recyclerBottomSheetAdapter;
    private TextView submit;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.qbank_bottom_sheet_main_layout,container,false);

      recyclerView=v.findViewById(R.id.rec_bottom_sheet_question);
     // submit=v.findViewById(R.id.tv_submit);


      recyclerView.setLayoutManager(new GridLayoutManager(getContext(),6,RecyclerView.VERTICAL,false));
      recyclerBottomSheetAdapter=new RecyclerBottomSheetAdapter(this);
      recyclerView.setAdapter(recyclerBottomSheetAdapter);
//      submit.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              BottomSheetFragment.this.dismiss();
//              FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
//              fr.replace(R.id.content,new QnAFragment());
//              fr.addToBackStack(null);
//              fr.commit();
//          }
//      });
    return v;
    }
}
