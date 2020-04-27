package com.example.exemplesharedpreferences.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class Functions {

    public static boolean insertSharedPreferences(Context context, String key, String value)
    {
        //Fichier de sauvegarde interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        //ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Je vérifie si la clé existe, s'il n'y en pas je putString
        if(!sharedPreferences.contains(key))
        {
            editor.putString(key,value);
        }

        return editor.commit();
    }

    public static boolean updateSharedPreferences(Context context, String key, String value)
    {
        //Fichier de sauvegarde interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        //ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key,value);

        return editor.commit();
    }

    public static String getSharedPreferences (Context context, String key)
    {
        //Fichier de sauvegarde interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        return sharedPreferences.getString(key,"");
    }

    public static boolean removeSharedPreferences(Context context, String key)
    {
        //Fichier de sauvegarde interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);

        //ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.contains(key))
        {
            editor.remove(key);
        }

        return editor.commit();
    }

}
