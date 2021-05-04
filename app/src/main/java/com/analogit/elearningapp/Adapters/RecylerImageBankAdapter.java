package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.DiscussionModel;

import com.analogit.elearningapp.R;

public class RecylerImageBankAdapter  extends ListAdapter<DiscussionModel,RecylerImageBankAdapter.MyViewholder> {

    Fragment fragment;
    public RecylerImageBankAdapter(Fragment fragment) {
        super(DiscussionModel.discussionModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_bank_child_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    class MyViewholder extends RecyclerView.ViewHolder{

        TextView tvNotes;
        ConstraintLayout clDescription;
        ConstraintLayout clVideos;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tvNotes=itemView.findViewById(R.id.tv_image_bank_notes);
            clDescription=itemView.findViewById(R.id.constraintlayout_description);
            clVideos=itemView.findViewById(R.id.constraintlayout_video);
            tvNotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clDescription.setVisibility(View.VISIBLE);
                    clVideos.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
