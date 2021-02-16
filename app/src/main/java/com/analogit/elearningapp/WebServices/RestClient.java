package com.analogit.elearningapp.WebServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

//    //Base Url
   public static String BASE_URL = "http://13.127.67.157/e1/";
   public  static  String Image_Url="http://13.127.67.157";
    private static API REST_CLIENT;
    static {
        setupRestClient();
    }
    public static API get() {
        return REST_CLIENT;
    }
    private static void setupRestClient(){

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        REST_CLIENT=retrofit.create(API.class);
    }





}
