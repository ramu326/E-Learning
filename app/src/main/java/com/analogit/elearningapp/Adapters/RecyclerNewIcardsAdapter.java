package com.analogit.elearningapp.Adapters;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsTabsDecFragment;

import com.analogit.elearningapp.Fragments.IcardsTopicsFragment;
import com.analogit.elearningapp.Model.NewIcardsModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerNewIcardsAdapter extends RecyclerView.Adapter<RecyclerNewIcardsAdapter.IcardAdapter> {

    Context context;
    ArrayList<NewIcardsModel> arrayList;

    public RecyclerNewIcardsAdapter(Context context, ArrayList<NewIcardsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public IcardAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IcardAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_icards_first_tab_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IcardAdapter holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);
        holder.tvcards.setText(String.valueOf(arrayList.get(position).getIcard()+" Cards"));
        holder.tvsub.setText(arrayList.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class IcardAdapter extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView tvsub,tvcards;
        public IcardAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.cons_icards_view);
            imageView=itemView.findViewById(R.id.iv_icards_image);
            tvsub=itemView.findViewById(R.id.tv_text_anatomy);
            tvcards=itemView.findViewById(R.id.tv_total_cards);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     IcardsTopicsFragment icardsTopicsFragment=new IcardsTopicsFragment();
                    Bundle args=new Bundle();
                    args.putInt("sid",arrayList.get(getAdapterPosition()).getId());
                    args.putString("subject",arrayList.get(getAdapterPosition()).getSubject());
                    icardsTopicsFragment.setArguments(args);
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, icardsTopicsFragment).commit();
                }
            });
        }
    }

}
