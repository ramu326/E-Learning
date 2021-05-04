package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.QbankBookMarkModel;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.QbankBookmarkFargment;
import com.analogit.elearningapp.Fragments.QbankModulesStartExamFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.Model.GrandTestModel;

import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerQbankBookmarkAdapter extends RecyclerView.Adapter<RecyclerQbankBookmarkAdapter.BookmarkAdapter>{
   Context context;
   ArrayList<QbankBookMarkModel>arrayList;

    public RecyclerQbankBookmarkAdapter(Context context, ArrayList<QbankBookMarkModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public BookmarkAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookmarkAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.qbnak_bookmark_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter holder, int position) {

        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.subName.setText(arrayList.get(position).getName());
        holder.bookMark.setText(String.valueOf(arrayList.get(position).getBookmark())+" BookMarks");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class BookmarkAdapter extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        TextView subName,bookMark;
        CircleImageView imageView;
        public BookmarkAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.constaraint_bookbark_qbank);
            subName=itemView.findViewById(R.id.tv_bookbark_sub_name);
            bookMark=itemView.findViewById(R.id.tv_bookbark_sub_work_status);
            imageView=itemView.findViewById(R.id.iv_bookbark_sub_image);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, new QbankBookmarkFargment()).commit();

                }
            });

        }
    }
}