package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.analogit.elearningapp.Fragments.DrLearnVideoPlayFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IcardsParentChildAdapter extends BaseExpandableListAdapter {
    ArrayList<String> icardsParentlist;
    Map<String, List<String>> hashmap;

    public IcardsParentChildAdapter(ArrayList<String> icardsParentlist, Map<String, List<String>> hashmap) {
        this.icardsParentlist = icardsParentlist;
        this.hashmap = hashmap;
    }

    @Override
    public int getGroupCount() {
        return icardsParentlist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashmap.get(icardsParentlist.get(i)).size();
    }

    @Override
    public String getGroup(int i) {
        return icardsParentlist.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return hashmap.get(icardsParentlist.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.icards_parent_row,viewGroup,false);
            ((TextView)(view.findViewById(R.id.tv_icards_parent_textview))).setText(getGroup(i));
            return view;
        }else
            ((TextView)(view.findViewById(R.id.tv_icards_parent_textview))).setText(String.valueOf(getGroup(i)));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){

            ConstraintLayout linearLayout;//icards_child_view
            view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.icards_child_row,viewGroup,false);
            ((TextView)(view.findViewById(R.id.icards_child))).setText(getChild(i,i1));
            linearLayout=view.findViewById(R.id.icards_child_view);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    IcardsZoomImagesFragment icardsZoomImagesFragment=new IcardsZoomImagesFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,icardsZoomImagesFragment).addToBackStack(null).commit();
                }
            });
            return view;
        }else

            return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
