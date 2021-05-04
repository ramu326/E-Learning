package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.analogit.elearningapp.Fragments.DiscussionVideoExplantaionFragment;
import com.analogit.elearningapp.Fragments.GeneralIndructionFragmment;

import com.analogit.elearningapp.Fragments.TestDiscussionFinalreportAllTabsFragment;

import com.analogit.elearningapp.Model.TnDOneModel;
import com.analogit.elearningapp.Model.TndThreeModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.databinding.TestDiscussionSecondRowBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerTnDThreeAdapter extends ListAdapter<TnDOneModel,RecyclerTnDThreeAdapter.MyViewholder> {
    Fragment fragment;
    int a=0;
    public RecyclerTnDThreeAdapter(Fragment fragment) {
        super(TnDOneModel.tnDOneModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_discussion_second_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        TnDOneModel  model=getCurrentList().get(position);

        TestDiscussionSecondRowBinding binding=holder.binding;

        binding.date.setText(" from "+model.getStartDate()+" To "+model.getEndDate());

        binding.tvMins.setText(model.getDuration());

        binding.tvMcqs.setText(model.getNumberOfQuestions());

        binding.title.setText(model.getTitle());



    }
    @Override
    public void submitList(@Nullable List<TnDOneModel> list) {
        super.submitList(list == null ? null : new ArrayList<TnDOneModel>(list));
    }

    class  MyViewholder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView tvDiscussion,tvReview;
        TestDiscussionSecondRowBinding binding;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            binding=TestDiscussionSecondRowBinding.bind(itemView);

            binding.tvTakeTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment=new GeneralIndructionFragmment();
                    RecyclerTnDThreeAdapter.this.fragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();

                }
            });

//            cardView=itemView.findViewById(R.id.test_discussion_second_row_card_view);
//            tvDiscussion=itemView.findViewById(R.id.new_book_mark_test_discussion_discussion);
//            tvReview=itemView.findViewById(R.id.new_book_mark_test_discussion_review);
//            tvReview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AppCompatActivity appCompatActivity=(AppCompatActivity)v.getContext();
//                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new TestDiscussionFinalreportAllTabsFragment()).addToBackStack(null).commit();
//                }
//            });
//            tvDiscussion.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AppCompatActivity appCompatActivity=(AppCompatActivity)v.getContext();
//                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new DiscussionVideoExplantaionFragment(a)).addToBackStack(null).commit();
//                }
//            });
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AppCompatActivity appCompatActivity=(AppCompatActivity)view.getContext();
//                    Fragment fragment=new GeneralIndructionFragmment();
//                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).addToBackStack(null).commit();
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }
}
