package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsPagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerPastExamTopicsPages extends RecyclerView.Adapter<RecyclerPastExamTopicsPages.PastTopicsAdapter> {
    Context context;
    ArrayList<IcardsPastExamsTopicsPagesModel> arrayList;

    public RecyclerPastExamTopicsPages(Context context, ArrayList<IcardsPastExamsTopicsPagesModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PastTopicsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastTopicsAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.pastexams_pages_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastTopicsAdapter holder, int position) {
        Glide.with(context).load(arrayList.get(position).getPage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PastTopicsAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PastTopicsAdapter(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_exam_page);
        }
    }
}
