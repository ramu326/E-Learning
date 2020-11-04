package com.analogit.elearningapp.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerSubjectsAdapter;
import com.analogit.elearningapp.R;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rView;
    RecyclerSubjectsAdapter recyclerSubjectsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_with_all_modules_layout);
        //rView=findViewById(R.id.qwam_layout_rec);
       // recyclerSubjectsAdapter=new RecyclerSubjectsAdapter(this);
       /// rView.setAdapter(recyclerSubjectsAdapter);
       // rView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

    }
}
