package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.Model.ImageModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerDrNotesAdapter extends RecyclerView.Adapter<RecyclerDrNotesAdapter.AdapterNotes> {

    Context context;
    ArrayList<DoctorModel>arrayList;

    public RecyclerDrNotesAdapter(Context context, ArrayList<DoctorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterNotes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterNotes(LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_notes_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotes holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AdapterNotes extends RecyclerView.ViewHolder{

        public AdapterNotes(@NonNull View itemView) {
            super(itemView);
        }
    }
}
