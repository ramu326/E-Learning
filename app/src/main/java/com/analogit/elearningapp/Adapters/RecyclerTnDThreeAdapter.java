package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.GeneralIndructionFragmment;
import com.analogit.elearningapp.Fragments.TdStartFragment;
import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.Model.TndThreeModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTnDThreeAdapter extends ListAdapter<TndThreeModel,RecyclerTnDThreeAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerTnDThreeAdapter(Fragment fragment) {
        super(TndThreeModel.tndThreeModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_discussion_second_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }
    @Override
    public void submitList(@Nullable List<TndThreeModel> list) {
        super.submitList(list == null ? null : new ArrayList<TndThreeModel>(list));
    }

    class  MyViewholder extends RecyclerView.ViewHolder{

        CardView cardView;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.test_discussion_second_row_card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity appCompatActivity=(AppCompatActivity)view.getContext();
                    Fragment fragment=new GeneralIndructionFragmment();
                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
