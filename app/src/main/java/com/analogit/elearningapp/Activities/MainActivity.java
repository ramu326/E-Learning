package com.analogit.elearningapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.analogit.elearningapp.ApiModel.ListOfCourseModel;
import com.analogit.elearningapp.ApiModel.LogOutModel;
import com.analogit.elearningapp.Fragments.BothTestNDiscussionFragment;
import com.analogit.elearningapp.Fragments.DRLearnFragment;
import com.analogit.elearningapp.Fragments.DummyQbankFragment;
import com.analogit.elearningapp.Fragments.EditProfileFragment;
import com.analogit.elearningapp.Fragments.GroupDiscussionFragment;
import com.analogit.elearningapp.Fragments.GroupDiscussionQuestionPostFragment;
import com.analogit.elearningapp.Fragments.HomeFragment;
import com.analogit.elearningapp.Fragments.MorningRoundTabsFragment;
import com.analogit.elearningapp.Fragments.ResetFragment;
import com.analogit.elearningapp.Fragments.ShotsVideoFragment;
import com.analogit.elearningapp.Fragments.WallPosterGridfFragment;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.analogit.elearningapp.WebServices.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    Toolbar toolbar;
    TextView tvName, tvmobilenumber, tvemail;
    Spinner spinner;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;

    public BottomNavigationView bottomNavigationView;
    String Authorization, content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ArrayList<String> courselist = new ArrayList<>();
    int PRIVATE_MODE = 0, val = 1;
    API REST_CLIENT;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        REST_CLIENT = RestClient.get();
        pref = getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        //    user = session.getUserDetails();
        editor = pref.edit();
        View header = navigationView.getHeaderView(0);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        spinner = header.findViewById(R.id.spinner_all);
        tvName = header.findViewById(R.id.profile_name);
        tvemail = header.findViewById(R.id.profile_mail);
        tvmobilenumber = header.findViewById(R.id.profile_no);
        constraintLayout=header.findViewById(R.id.edit_profile);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction frr = getSupportFragmentManager().beginTransaction();
                frr.replace(R.id.content, new EditProfileFragment());
                frr.addToBackStack(null);
                frr.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // navigationView.getMenu().getItem(0).setActionView(R.layout.menu_reset_layout);
//        navigationView.getMenu().getItem(17).setActionView(R.layout.menu_setting_layout);


        tvName.setText(pref.getString("name", "-1"));
        tvemail.setText(pref.getString("email", "-1"));
        token = pref.getString("token", "-1");
        Log.d("iojeoihpefojwe",token);
      //  Authorization = "token " + token;
        tvmobilenumber.setText("+91-" + pref.getString("phone", "-1"));
        if (getApplicationContext() != null) {
            Call<List<ListOfCourseModel>> call = REST_CLIENT.getcourse();
            call.enqueue(new Callback<List<ListOfCourseModel>>() {
                List<ListOfCourseModel> listOfCourseModelList;
                ListOfCourseModel listOfCourseModelMap;

                @Override
                public void onResponse(Call<List<ListOfCourseModel>> call, Response<List<ListOfCourseModel>> response) {
                    listOfCourseModelList = response.body();
                    if (response.isSuccessful()) {
                        if (getApplicationContext() != null) {
                            for (int i = 0; i < listOfCourseModelList.size(); i++) {
                                listOfCourseModelMap = listOfCourseModelList.get(i);
                                courselist.add(listOfCourseModelMap.getName_Exam());
                            }
                            ArrayAdapter ai = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, courselist);
                            ai.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner.setAdapter(ai);
                            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#ffffff"));
                                    ((TextView) parent.getChildAt(0)).setTextSize(14);
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }

                    }
                }

                @Override
                public void onFailure(Call<List<ListOfCourseModel>> call, Throwable t) {

                }
            });
        }


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    //  menu_golive
                    case R.id.menu_fm_round:
                        FragmentTransaction m = getSupportFragmentManager().beginTransaction();
                        m.replace(R.id.content, new MorningRoundTabsFragment());
                        m.addToBackStack(null);
                        m.commit();
                        break;
                    case R.id.menu_golive:
                        DRLearnFragment homeLiveClassFragment = new DRLearnFragment();
                        Bundle args = new Bundle();
                        args.putInt("pos", val);
                        homeLiveClassFragment.setArguments(args);
                        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                        fr.replace(R.id.content, homeLiveClassFragment);
                        fr.addToBackStack(null);
                        fr.commit();
                        break;
                    case R.id.menu_mydoubts:
                        FragmentTransaction frr = getSupportFragmentManager().beginTransaction();
                        frr.replace(R.id.content, new GroupDiscussionQuestionPostFragment());
                        frr.addToBackStack(null);
                        frr.commit();

                        break;
                    case R.id.menu_group_discussion:
                        FragmentTransaction gdf = getSupportFragmentManager().beginTransaction();
                        gdf.replace(R.id.content, new GroupDiscussionFragment());
                        gdf.addToBackStack(null);
                        gdf.commit();
                        break;
                    case R.id.menu_wallposter:
                        FragmentTransaction w = getSupportFragmentManager().beginTransaction();
                        w.replace(R.id.content, new WallPosterGridfFragment());
                        w.addToBackStack(null);
                        w.commit();
                        break;
                    case R.id.menu_hyttest:
                        FragmentTransaction h = getSupportFragmentManager().beginTransaction();
                        h.replace(R.id.content, new BothTestNDiscussionFragment());
                        h.addToBackStack(null);
                        h.commit();
                        break;
                    case R.id.reset:
                        FragmentTransaction r = getSupportFragmentManager().beginTransaction();
                        r.replace(R.id.content, new ResetFragment());
                        r.addToBackStack(null);
                        r.commit();
                        break;
                    case R.id.logout:
                        Log.d("hdaagsajis",token);

                        Call<LogOutModel> call = REST_CLIENT.getlogout(token, content);
                        call.enqueue(new Callback<LogOutModel>() {
                            LogOutModel logOutModelMap;

                            @Override
                            public void onResponse(Call<LogOutModel> call, Response<LogOutModel> response) {
                                if (response.isSuccessful()) {
                                    logOutModelMap = response.body();
                                    SessionManager s = new SessionManager(getApplicationContext());
                                    editor.clear();
                                    editor.apply();
                                    editor.commit();
                                    s.logoutUser();

                                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    if(response.message().equals("Forbidden")){
                                        SessionManager s = new SessionManager(getApplicationContext());
                                        editor.clear();
                                        editor.apply();
                                        editor.commit();
                                        s.logoutUser();
                                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LogOutModel> call, Throwable t) {

                            }
                        });
                        break;


                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, homeFragment);
                        transaction.commit();


                        break;
                    case R.id.bottom_qbank:
                        // QBankFragment qBankFragment=new QBankFragment();
                        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.content, new DummyQbankFragment());

                        transaction1.commit();

                        break;

                    case R.id.bottom_youtube:
                        // AllVideoFragment allVideoFragment = new AllVideoFragment();
                        FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.content, new ShotsVideoFragment());

                        transaction2.commit();
                        break;
                    case R.id.bottom_td:
                        BothTestNDiscussionFragment bothTestNDiscussionFragment = new BothTestNDiscussionFragment();
                        FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.content, bothTestNDiscussionFragment);
                        transaction3.commit();
                        break;


                    case R.id.bottom_stock:
                        FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                        transaction4.replace(R.id.content, new DRLearnFragment());
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