package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsBookmarkModel;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerIcardsBookMarksAdapter  extends RecyclerView.Adapter<RecyclerIcardsBookMarksAdapter.BookMarksData> {

    Context context;
    ArrayList<IcardsBookmarkModel>audioModel;

    public RecyclerIcardsBookMarksAdapter(Context context, ArrayList<IcardsBookmarkModel> audioModel) {
        this.context = context;
        this.audioModel = audioModel;
    }

    @NonNull
    @Override
    public BookMarksData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookMarksData(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_bookbork_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookMarksData holder, int position) {

    }

    @Override
    public int getItemCount() {
        return audioModel.size();
    }

    public class BookMarksData extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout;
        public BookMarksData(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.cons_bookmarks_audio);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, new IcardsZoomImagesFragment()).commit();
                }
            });
        }
    }
}
