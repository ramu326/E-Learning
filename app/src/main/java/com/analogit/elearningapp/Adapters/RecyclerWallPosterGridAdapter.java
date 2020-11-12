package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.ImagesBankFragment;
import com.analogit.elearningapp.Fragments.WallPosterZoomFragment;
import com.analogit.elearningapp.Model.WallPosterGridModel;
import com.analogit.elearningapp.R;

public class RecyclerWallPosterGridAdapter extends ListAdapter<WallPosterGridModel, RecyclerWallPosterGridAdapter.MyViewholder> {
        Fragment fragment;
    public RecyclerWallPosterGridAdapter(Fragment fragment) {
        super(WallPosterGridModel.imageGridModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wall_poster_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    class MyViewholder extends RecyclerView.ViewHolder{

        CardView cardView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.wall_poster_grid_card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity appCompatActivity=(AppCompatActivity)view.getContext();
                    WallPosterZoomFragment imagesBankFragment=new WallPosterZoomFragment();
                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,imagesBankFragment).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 24;
    }
}
