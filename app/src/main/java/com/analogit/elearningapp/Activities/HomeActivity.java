package com.analogit.elearningapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.ListOfCourseModel;
import com.analogit.elearningapp.ApiModel.PostLoginModel;
import com.analogit.elearningapp.ApiModel.PreLoginModel;
import com.analogit.elearningapp.NewAdapter.RecyclerListofCourseAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.analogit.elearningapp.WebServices.SessionManager;
import com.chaos.view.PinView;
import com.google.gson.JsonObject;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    public EditText etMobile, etname, etmail;
    public String stmobile, stmail, stname, emailPattern;
    public Button btlogin, btverify, btregister, btgoto;
    CarouselView carouselView;

    public API REST_CLIENT;
    public String course;
    public ArrayList<ListOfCourseModel> arrayList = new ArrayList<>();
    public SessionManager session;
    public PinView pinView;
    public TextView tvmobile;
    public HashMap<String, String> user;
    private boolean medical = false;
    private boolean fmfg = false;
    public String Authorization, content = "application/json";
    public static final String PREF_NAME = "SharedPref";
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    public int PRIVATE_MODE = 0;
    public RecyclerView recyclerView;
    public ConstraintLayout conLogin, conOtp, conregister, conchoose;
    int[] images = new int[]{
            R.drawable.image_view, R.drawable.image_view, R.drawable.image_view
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btlogin = findViewById(R.id.bt_login);
        REST_CLIENT = RestClient.get();
        carouselView = findViewById(R.id.carousel);
        btverify = findViewById(R.id.bt_verify);
        etMobile = findViewById(R.id.et_mobile_no_login);
        carouselView.setPageCount(images.length);
        conLogin = findViewById(R.id.constraint_login);
        conOtp = findViewById(R.id.constraint_otp);
        conchoose = findViewById(R.id.constraint_choose);
        btregister = findViewById(R.id.bt_register);
        tvmobile = findViewById(R.id.tv_otp_number);
        pinView = findViewById(R.id.pinView);
        etname = findViewById(R.id.et_name);

        recyclerView = findViewById(R.id.rec_list_of_course);
        etmail = findViewById(R.id.et_mail);
        session = new SessionManager(HomeActivity.this);
        conregister = findViewById(R.id.constarint_register);
        pref = getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        user = session.getUserDetails();
        editor = pref.edit();
        btgoto = findViewById(R.id.bt_goto);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });

        if (session.isLoggedIn()) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stmobile = etMobile.getText().toString().trim();

                if (stmobile.length() == 0 || stmobile.length() > 10) {
                    etMobile.setError("Enter 10 Digit Mobile Number");

                } else {
                    JsonObject v1 = new JsonObject();
                    v1.addProperty("phone", stmobile);
                    Call<PreLoginModel> call = REST_CLIENT.getpreLogin(v1);
                    call.enqueue(new Callback<PreLoginModel>() {
                        PreLoginModel preLoginModelMap;

                        @Override
                        public void onResponse(Call<PreLoginModel> call, Response<PreLoginModel> response) {
                            if (response.isSuccessful()) {
                                preLoginModelMap = response.body();
                                tvmobile.setText("+91-" + stmobile);
                                Authorization = "token " + preLoginModelMap.getToken();
                                editor.putString("token", Authorization);
                                editor.commit();

                                conLogin.setVisibility(View.GONE);
                                conOtp.setVisibility(View.VISIBLE);
                                conregister.setVisibility(View.GONE);
                                conchoose.setVisibility(View.GONE);
                                if (preLoginModelMap.getStatus()==true) {
                                    conLogin.setVisibility(View.GONE);
                                    conOtp.setVisibility(View.GONE);
                                    conregister.setVisibility(View.GONE);
                                    conchoose.setVisibility(View.GONE);
                                    Authorization = "token " + preLoginModelMap.getToken();
                                    session.createLoginSession(stmobile);
                                    editor.putString("phone", preLoginModelMap.getPhone());
                                    editor.putString("name", preLoginModelMap.getUsername());
                                    editor.putString("email", preLoginModelMap.getEmail());
                                    editor.putString("token", Authorization);
                                    editor.commit();



                                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    conLogin.setVisibility(View.GONE);
                                    conOtp.setVisibility(View.VISIBLE);
                                    conregister.setVisibility(View.GONE);
                                    conchoose.setVisibility(View.GONE);
                                }

                            } else {
                                Toast.makeText(HomeActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<PreLoginModel> call, Throwable t) {

                        }
                    });

                }

            }
        });
        btverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pinview = pinView.getText().toString().trim();
                if (pinview.length() == 0 || pinview.equals("") || pinview == null) {
                    Toast.makeText(HomeActivity.this, "Enter valid OTP", Toast.LENGTH_SHORT).show();
                } else {
                    JsonObject v2 = new JsonObject();
                    v2.addProperty("phone", stmobile);
                    v2.addProperty("otp", pinview);

                    Call<PostLoginModel> call = REST_CLIENT.getOtpVerify(Authorization, v2, content);
                    call.enqueue(new Callback<PostLoginModel>() {
                        PostLoginModel postLoginModelMap;

                        @Override
                        public void onResponse(Call<PostLoginModel> call, Response<PostLoginModel> response) {

                            if (response.isSuccessful()) {
                                postLoginModelMap = response.body();
                                editor.putString("phone", postLoginModelMap.getPhone());
                                editor.putString("name", postLoginModelMap.getUserDetail().getUsername());
                                editor.putString("email", postLoginModelMap.getUserDetail().getEmail());
                                editor.commit();
                                conLogin.setVisibility(View.GONE);
                                conOtp.setVisibility(View.GONE);
                                conregister.setVisibility(View.VISIBLE);
                                conchoose.setVisibility(View.GONE);

                            } else {
                                Toast.makeText(HomeActivity.this, response.raw().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<PostLoginModel> call, Throwable t) {

                         //   Toast.makeText(HomeActivity.this, "Please check your connection", Toast.LENGTH_SHORT).show();

                        }
                    });
                }


            }
        });
        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stname = etname.getText().toString().trim();
                stmail = etmail.getText().toString().trim();
                emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (stname.length() == 0) {
                    Toast.makeText(HomeActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else if (!stmail.matches(emailPattern) || stmail.length() == 0) {
                    Toast.makeText(HomeActivity.this, "Please Enter Valid Email id", Toast.LENGTH_SHORT).show();

                }
                else {
                    conLogin.setVisibility(View.GONE);
                    conOtp.setVisibility(View.GONE);
                    conregister.setVisibility(View.GONE);
                    conchoose.setVisibility(View.VISIBLE);
                }

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));


        if (getApplication() != null) {
            Call<List<ListOfCourseModel>> call = REST_CLIENT.getcourse();
            call.enqueue(new Callback<List<ListOfCourseModel>>() {
                List<ListOfCourseModel> listOfCourseModelList;
                ListOfCourseModel listOfCourseModelMap;

                @Override
                public void onResponse(Call<List<ListOfCourseModel>> call, Response<List<ListOfCourseModel>> response) {
                    listOfCourseModelList = response.body();
                    if (response.isSuccessful()) {
                        if (listOfCourseModelList.size() != 0) {
                            for (int i = 0; i < listOfCourseModelList.size(); i++) {
                                listOfCourseModelMap = listOfCourseModelList.get(i);
                                arrayList.add(new ListOfCourseModel(listOfCourseModelMap.getId(), listOfCourseModelMap.getName_Exam()));
                            }
                        } else
                            Toast.makeText(HomeActivity.this, "No Courses", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(HomeActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                    RecyclerListofCourseAdapter recyclerListofCourseAdapter = new RecyclerListofCourseAdapter(getApplicationContext(), arrayList, HomeActivity.this);
                    recyclerView.setAdapter(recyclerListofCourseAdapter);
                    recyclerListofCourseAdapter.notifyDataSetChanged();


                }

                @Override
                public void onFailure(Call<List<ListOfCourseModel>> call, Throwable t) {
                   // Toast.makeText(HomeActivity.this, "check connection", Toast.LENGTH_SHORT).show();
                }
            });
        }


//        rbOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                course = "Medical Pg";
//               // Log.d("posjk0opjwfg", course);
//                rbOne.setChecked(true);
//                rbtwo.setChecked(false);
//            }
//        });
//        rbtwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                course = "Fmfg";
//               // Log.d("posjk0opjwfg", course);
//                rbtwo.setChecked(true);
//                rbOne.setChecked(false);
//
//
//            }
//        });
//        btgoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                JsonObject v3 = new JsonObject();
//
//                v3.addProperty("username", stname);
//                v3.addProperty("email", stmail);
//                v3.addProperty("course", course);
//                // Log.d("khfguierwqwutfg", stname + " " + stmail + " " + course + " " + Authorization + " " + content);
//
//
//                Call<RegisterModel> call = REST_CLIENT.getregister(Authorization, v3, content);
//                call.enqueue(new Callback<RegisterModel>() {
//                    RegisterModel registerModelMap;
//
//                    @Override
//                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//
//                        if (response.isSuccessful()) {
//                            registerModelMap = response.body();
//                            Log.d("detalisofuser", registerModelMap.getUserDetail().getUsername() + " " + registerModelMap.getPhone() + "   " + registerModelMap.getUserDetail().getEmail());
//                            session.createLoginSession(stmobile);
//                            editor.putString("phone", registerModelMap.getPhone());
//                            editor.putString("name", registerModelMap.getUserDetail().getUsername());
//                            editor.putString("email", registerModelMap.getUserDetail().getEmail());
//                            editor.commit();
//
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//
//
//                            finish();
//                        } else {
////                            Log.d("iogorhtoerwth", response.message());
////                            Log.d("iogorhtoerwth",response.raw().message());
////                            Log.d("iogorhtoerwth",response.errorBody().toString());
////                            Log.d("iogorhtoerwth",response.raw().toString());
//                            Toast.makeText(HomeActivity.this, response.message(), Toast.LENGTH_SHORT).show();
//
//                        }
//
////                        try {
////                            if (response.isSuccessful()) {
////                                Log.d("ojfoviewfger", response.message());
////                                registerModelMap=response.body();
////                                Log.d("detalisofuser", registerModelMap.getUserDetail().getUsername() + " " + registerModelMap.getPhone() + "   " + registerModelMap.getUserDetail().getEmail());
//
////                            } else {
//
////                            }
////                        } catch (Exception e) {
////                            Log.d("pkmfpofd", e.getMessage());
////                        }
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<RegisterModel> call, Throwable t) {
//                        Log.d("bfiwefw", t.getMessage());
//                        Log.d("bfiwefw", t.toString());
//                        Toast.makeText(HomeActivity.this, "check connection", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        });
    }
}
