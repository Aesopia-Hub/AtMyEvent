package com.example.smith.mypartyapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Smith on 2017/10/26.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        prefs =ctx.getSharedPreferences("myapp.db",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin (boolean loggedin){
        editor.putBoolean("loggedInMode",loggedin);
        editor.commit();
    }

    public boolean loggein(){
        return prefs.getBoolean("loggedInMode",false);
    }

}
