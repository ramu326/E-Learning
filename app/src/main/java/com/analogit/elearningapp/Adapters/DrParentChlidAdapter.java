package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.analogit.elearningapp.Fragments.DrLearnVideoPlayFragment;
import com.analogit.elearningapp.Fragments.QbankExamModuleFragment;
import com.analogit.elearningapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DrParentChlidAdapter extends BaseExpandableListAdapter {
    ArrayList<String> drParentlist;
    Map<String, List<String>> hashmap;
    public  DrParentChlidAdapter(  ArrayList<String> drParentlist,
            Map<String, List<String>> hashmap){
        this.drParentlist=drParentlist;
        this.hashmap=hashmap;
    }
    @Override
    public int getGroupCount() {
        return drParentlist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashmap.get(drParentlist.get(i)).size();
    }

    @Override
    public String getGroup(int i) {
        return drParentlist.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return hashmap.get(drParentlist.get(i)).get(i1);
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
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dr_parent_row,viewGroup,false);
            ((TextView)(view.findViewById(R.id.tv_dr_parent_textview))).setText(getGroup(i));
            return view;
        }else
            ((TextView)(view.findViewById(R.id.tv_dr_parent_textview))).setText(getGroup(i));

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if(view==null){

            ConstraintLayout linearLayout;
            view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.dr_child_row,viewGroup,false);
            ((TextView)(view.findViewById(R.id.tv_child))).setText(getChild(i,i1));
            linearLayout=view.findViewById(R.id.ll_new_sub_go_qutions_module);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity)v.getContext();
                    DrLearnVideoPlayFragment drLearnVideoPlayFragment=new DrLearnVideoPlayFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,drLearnVideoPlayFragment).addToBackStack(null).commit();
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
