package com.analogit.elearningapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import com.analogit.elearningapp.Fragments.AllTandDFragment;
import com.analogit.elearningapp.Fragments.AllVideoFragment;
import com.analogit.elearningapp.Fragments.BothTestNDiscussionFragment;
import com.analogit.elearningapp.Fragments.DRLearnFragment;
import com.analogit.elearningapp.Fragments.DummyQbankFragment;
import com.analogit.elearningapp.Fragments.HomeFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.QBankFragment;
import com.analogit.elearningapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    Toolbar toolbar;

    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    public BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);


        navigationView=findViewById(R.id.nav_view);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_reset_layout);
        navigationView.getMenu().getItem(17).setActionView(R.layout.menu_setting_layout);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content,homeFragment);
        // transaction.addToBackStack(null);
        transaction.commit();

        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("anilll",String.valueOf(item.getItemId()));

                switch (item.getItemId()){
                    case R.id.bottom_home:
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content,homeFragment);
                        transaction.commit();


                        break;
                    case R.id.bottom_qbank:
                       // QBankFragment qBankFragment=new QBankFragment();
                        FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.content,new DummyQbankFragment());

                        transaction1.commit();

                        break;

                    case R.id.bottom_youtube:
                        AllVideoFragment allVideoFragment=new AllVideoFragment();
                        FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.content,allVideoFragment);

                        transaction2.commit();
                        break;
                    case R.id.bottom_td:
                        BothTestNDiscussionFragment bothTestNDiscussionFragment=new BothTestNDiscussionFragment();
                        FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.content,bothTestNDiscussionFragment);
                        transaction3.commit();
                        break;
                    case R.id.bottom_stock:
                     //   GraphFragment graphFragment=new GraphFragment();
                        FragmentTransaction transaction4=getSupportFragmentManager().beginTransaction();
                        transaction4.replace(R.id.content,new DRLearnFragment());

                        transaction4.commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

}