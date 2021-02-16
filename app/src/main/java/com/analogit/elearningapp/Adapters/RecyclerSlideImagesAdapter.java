package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.AllQuestionsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class RecyclerSlideImagesAdapter extends RecyclerView.Adapter<RecyclerSlideImagesAdapter.Myviewholder> {

    Context cont;
    ArrayList<AllQuestionsModel>allQuestionsModels;

    public RecyclerSlideImagesAdapter(Context cont, ArrayList<AllQuestionsModel> allQuestionsModels) {
        this.cont = cont;
        this.allQuestionsModels = allQuestionsModels;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slides_images_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class Myviewholder extends RecyclerView.ViewHolder{

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
