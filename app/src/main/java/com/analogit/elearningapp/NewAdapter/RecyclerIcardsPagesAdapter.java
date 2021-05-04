package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.ICardsPagesModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerIcardsPagesAdapter extends RecyclerView.Adapter<RecyclerIcardsPagesAdapter.IcardsPagesAdapter> {
    Context context;
    ArrayList<ICardsPagesModel>arrayList;

    public RecyclerIcardsPagesAdapter(Context context, ArrayList<ICardsPagesModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public IcardsPagesAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IcardsPagesAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_pages_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IcardsPagesAdapter holder, int position) {
        Glide.with(context).load(arrayList.get(position).getPage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class IcardsPagesAdapter extends RecyclerView.ViewHolder{
            ImageView imageView;
        public IcardsPagesAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_icard_page);
        }
    }
}

