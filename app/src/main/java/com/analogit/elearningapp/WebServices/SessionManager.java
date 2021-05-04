package com.analogit.elearningapp.WebServices;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "sp";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_NAME = "mobile";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String mobile) {

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, mobile);

        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        System.out.println("name and pwd is ......." + pref.getString(KEY_NAME, null));

        user.put(KEY_NAME, pref.getString(KEY_NAME, null));


        return user;
    }

    public void logoutUser() {

        editor.putBoolean(IS_LOGIN, false);
        editor.commit();


    }

    public boolean isLoggedIn() {

        return pref.getBoolean(IS_LOGIN, false);
    }
}
