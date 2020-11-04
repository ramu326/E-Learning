package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.QbankExamModuleFragment;
import com.analogit.elearningapp.Model.SubQbankModel;
import com.analogit.elearningapp.R;

public class RecyclerSubQbankAdapter extends ListAdapter<SubQbankModel,RecyclerSubQbankAdapter.MyViewholder> {
    Fragment fragment;
    public RecyclerSubQbankAdapter(Fragment fragment) {
        super(SubQbankModel.subQbankModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_sub_topics_quest_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    class MyViewholder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
linearLayout=itemView.findViewById(R.id.ll_new_sub_go_qutions_module);
linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AppCompatActivity appCompatActivity=(AppCompatActivity) view.getContext();
        Fragment fragment=new QbankExamModuleFragment();
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();

    }
});
            //                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    Fragment myFragment = new SpecificSubFragment();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, myFragment).addToBackStack(null).commit();
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
