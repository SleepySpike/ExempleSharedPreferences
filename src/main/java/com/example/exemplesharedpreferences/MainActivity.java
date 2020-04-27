package com.example.exemplesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplesharedpreferences.Entities.Adherent;
import com.example.exemplesharedpreferences.Utilities.Constants;
import com.example.exemplesharedpreferences.Utilities.Functions;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        final Button btnCreate = findViewById(R.id.btnCreate);
        final Button btnDeconnection = findViewById(R.id.btnDeconnection);
        final TextView txtAdherent = findViewById(R.id.txtAdherent);

        //On récupère l'adhérent enregistré dans les sharedPreferences
        String adherentJson = Functions.getSharedPreferences(context, Constants.SHARED_ADHERENT);

        if(!adherentJson.isEmpty())
        {
            Gson gson = new Gson();
            Adherent adherent = gson.fromJson(adherentJson,Adherent.class);

            txtAdherent.setText("Bonjour" + adherent.getPrenom() + " + " + adherent.getNom());

            btnCreate.setVisibility(View.INVISIBLE);
            btnDeconnection.setVisibility(View.VISIBLE);
        }


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FormAdherentActivity.class);
                startActivity(intent);
            }
        });

        btnDeconnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Functions.removeSharedPreferences(context,Constants.SHARED_ADHERENT);

                btnCreate.setVisibility(View.VISIBLE);
                btnDeconnection.setVisibility(View.INVISIBLE);
                txtAdherent.setVisibility(View.INVISIBLE);
            }
        });
/*
        //Fichier de sauvegarde interne à Android (nom + mode)
        SharedPreferences sharedPreferences = context.getSharedPreferences("test",MODE_PRIVATE);

        //ouvre le fichier en mode édition (mode écriture)
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("claude");
        //On fonctionne avec un système de keyvalue
        //editor.putString("toto","titi");
        //editor.putString("claude","henry");

            editor.commit();

        String titi = sharedPreferences.getString("toto","");
        String henry = sharedPreferences.getString("claude","");

        Toast.makeText(context, titi + " + " + henry, Toast.LENGTH_LONG).show(); */
    }
}
