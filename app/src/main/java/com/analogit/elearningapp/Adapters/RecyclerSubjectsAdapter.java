package com.analogit.elearningapp.Adapters;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.BookMarksPracticeFragment;
import com.analogit.elearningapp.Fragments.BookmarkPractiseSelectionFragment;
import com.analogit.elearningapp.Fragments.ErrorsPracticeFragment;
import com.analogit.elearningapp.Fragments.QbankParentChildFragment;
import com.analogit.elearningapp.Model.SubjectsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerSubjectsAdapter extends ListAdapter<SubjectsModel,RecyclerSubjectsAdapter.MyViewholder> {
        Fragment fragment;

   public RecyclerSubjectsAdapter(Fragment fragment) {
        super(SubjectsModel.subjectsModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_qbank_row_practice,parent,false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void submitList(@Nullable List<SubjectsModel> list) {
        super.submitList(list == null ? null : new ArrayList<SubjectsModel>(list));
    }
    class MyViewholder extends RecyclerView.ViewHolder{
      ConstraintLayout Simage;
      TextView tvBookmarkPr,tvErrorPr;
//       ProgressBar progressBar;
//       TextView Bpractise,bError,Rating,Subject;
//       LinearLayout linearLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
          Simage=itemView.findViewById(R.id.constaraint_qbank);


            Simage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment myFragment = new QbankParentChildFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, myFragment).addToBackStack(null).commit();

                }
            });
//            tvBookmarkPr.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AppCompatActivity activity=(AppCompatActivity)view.getContext();
//
//                    BookmarkPractiseSelectionFragment bookMarksPracticeFragment=new BookmarkPractiseSelectionFragment(a);
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,bookMarksPracticeFragment).addToBackStack(null).commit();
//                }
//            });
//            tvErrorPr.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AppCompatActivity compatActivity=(AppCompatActivity)v.getContext();
//                    compatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content,new BookmarkPractiseSelectionFragment(b)).addToBackStack(null).commit();
//                }
//            });
        }

    }


}
