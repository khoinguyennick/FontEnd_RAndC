package com.Desert.helloworld;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilsSession {
    final static String FileName = "MyFileName";

    public static String readSharedSetting(Context ctx,String settingName,String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        return sharedPref.getString(settingName,defaultValue);
    }

    public static void saveSharedSetting(Context ctx,String settingName, String settingValue){
        SharedPreferences sharedPref = ctx.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(settingName,settingValue);
        editor.apply();
    }

    public static void sharedPrefesSave(Context ctx, String name){
        SharedPreferences sharedPref = ctx.getSharedPreferences("Name",0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Name",name);
        editor.commit();
    }
}
