package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Model.DiscussionModel;
import com.analogit.elearningapp.Model.DiscussionVideoModel;
import com.analogit.elearningapp.R;

public class RecyclerDiscussionVideoExplantaionAdapter extends ListAdapter<DiscussionVideoModel,RecyclerDiscussionVideoExplantaionAdapter.MyViewholder>
{
    Fragment fragment;
    public RecyclerDiscussionVideoExplantaionAdapter(Fragment fragment) {
        super(DiscussionVideoModel.discussionVideoModelItemCallback);
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.discussion_video_explantaion_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

    }

    class  MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
