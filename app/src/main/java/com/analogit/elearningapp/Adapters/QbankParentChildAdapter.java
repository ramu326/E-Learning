package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.analogit.elearningapp.Fragments.QbankExamModuleFragment;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

public class QbankParentChildAdapter extends BaseExpandableListAdapter {
    ArrayList<String> parentlist;
    Map<String, List<String>> hashmap;

    public QbankParentChildAdapter(ArrayList<String> parentlist
            , Map<String, List<String>> hashmap) {
        this.parentlist = parentlist;
        this.hashmap = hashmap;

    }

    @Override
    public int getGroupCount() {
        return parentlist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return hashmap.get(parentlist.get(i)).size();
    }

    @Override
    public String getGroup(int i) {
        return parentlist.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return hashmap.get(parentlist.get(i)).get(i1);
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
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.qbank_parents_row, viewGroup, false);
            ((TextView) (view.findViewById(R.id.parentTextView))).setText(getGroup(i));
            return view;

        } else
            ((TextView) (view.findViewById(R.id.parentTextView))).setText(getGroup(i));
        return view;


    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
       view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.qbank_child_row, viewGroup, false);
      LinearLayout linearLayout=view.findViewById(R.id.ll_new_sub_go_qutions_module);
      linearLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              AppCompatActivity activity=(AppCompatActivity)v.getContext();
              QbankExamModuleFragment qbankExamModuleFragment=new QbankExamModuleFragment();
              activity.getSupportFragmentManager().beginTransaction().replace(R.id.content,qbankExamModuleFragment).addToBackStack(null).commit();
          }
      });
            ((TextView) (view.findViewById(R.id.learn_subjects_sub_tpoics_sub_with_topic))).setText(getChild(i,i1));
            return view;
        } else return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
