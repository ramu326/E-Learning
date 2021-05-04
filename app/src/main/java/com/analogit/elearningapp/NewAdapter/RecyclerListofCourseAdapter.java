package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.HomeActivity;
import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.ListOfCourseModel;
import com.analogit.elearningapp.ApiModel.RegisterModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerListofCourseAdapter extends RecyclerView.Adapter<RecyclerListofCourseAdapter.listAdapter> {
    Context context;
    ArrayList<ListOfCourseModel> arrayList;
    HomeActivity homeActivity;
    int pos = -1;
    API REST_CLIENT = RestClient.get();
    String name;
    public RecyclerListofCourseAdapter(Context context, ArrayList<ListOfCourseModel> arrayList, HomeActivity homeActivity) {
        this.context = context;
        this.arrayList = arrayList;
        this.homeActivity = homeActivity;
    }

    @NonNull
    @Override
    public listAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new listAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter holder, final int position) {
        holder.textView.setText(arrayList.get(position).getName_Exam());
        if (pos == position) {
            holder.radioButton.setChecked(true);
        } else {
            holder.radioButton.setChecked(false);
        }
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = position;
                notifyDataSetChanged();
                name=arrayList.get(position).getName_Exam();
//                Log.d("jjedjnjdejjfwe",name);
//                Log.d("jjedjnjdejjfwe",homeActivity.stname);
//                Log.d("jjedjnjdejjfwe",homeActivity.stmail);


                Log.d("dkdhuhdksfdskjd", homeActivity.stname + " " + homeActivity.stmail + " " + arrayList.get(position).getName_Exam() + " " + homeActivity.Authorization + " " + homeActivity.content);

            }
        });
        homeActivity.btgoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject v3 = new JsonObject();

                v3.addProperty("username", homeActivity.stname);
                v3.addProperty("email", homeActivity.stmail);
                v3.addProperty("course", name);

                Log.d("khfguierwqwutfg",v3.toString());

                Call<RegisterModel> call = REST_CLIENT.getregister(homeActivity.Authorization, v3, homeActivity.content);
                call.enqueue(new Callback<RegisterModel>() {
                    RegisterModel registerModelMap;

                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {

                        if (response.isSuccessful()) {
                            registerModelMap = response.body();
                            Log.d("khfguierwqwutfg", homeActivity.stname + " " + homeActivity.stmail + " " + name + " " + homeActivity.Authorization + " " + homeActivity.content);
                            Log.d("khfguierwqwutfg", registerModelMap.getUserDetail().getUsername() + " " + registerModelMap.getPhone() + "   " + registerModelMap.getUserDetail().getEmail());
                            homeActivity.session.createLoginSession(homeActivity.stmobile);
                            homeActivity.editor.putString("phone", registerModelMap.getPhone());
                            homeActivity.editor.putString("name", registerModelMap.getUserDetail().getUsername());
                            homeActivity.editor.putString("email", registerModelMap.getUserDetail().getEmail());
                            homeActivity.editor.commit();

                            Intent intent = new Intent(homeActivity.getApplicationContext(), MainActivity.class);
                            homeActivity.startActivity(intent);
                            homeActivity.finish();
                        } else {
//                            Log.d("iogorhtoerwth", response.message());
//                            Log.d("iogorhtoerwth",response.raw().message());
//                            Log.d("iogorhtoerwth",response.errorBody().toString());
//                            Log.d("iogorhtoerwth",response.raw().toString());
                            Toast.makeText(homeActivity.getApplicationContext(), response.message(), Toast.LENGTH_SHORT).show();

                        }

//                        try {
//                            if (response.isSuccessful()) {
//                                Log.d("ojfoviewfger", response.message());
//                                registerModelMap=response.body();
//                                Log.d("detalisofuser", registerModelMap.getUserDetail().getUsername() + " " + registerModelMap.getPhone() + "   " + registerModelMap.getUserDetail().getEmail());

//                            } else {

//                            }
//                        } catch (Exception e) {
//                            Log.d("pkmfpofd", e.getMessage());
//                        }


                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                        Log.d("bfiwefw", t.getMessage());
                        Log.d("bfiwefw", t.toString());
                        Toast.makeText(homeActivity.getApplicationContext(), "check connection", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class listAdapter extends RecyclerView.ViewHolder {
        TextView textView;
        RadioButton radioButton;

        public listAdapter(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_medical_pg);
            radioButton = itemView.findViewById(R.id.radio_one);

        }
    }
}
