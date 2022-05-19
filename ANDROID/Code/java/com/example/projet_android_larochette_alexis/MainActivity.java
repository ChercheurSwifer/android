package com.example.projet_android_larochette_alexis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button button_valid;
    private EditText nom_entry;
    private EditText prenom_entry;
    String recup_nom,recup_prenom;
    private static final String stock = "coronex";
    private static final String clex = "cle";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nom_entry =findViewById(R.id.nom_entry);
        this.prenom_entry =findViewById(R.id.prenom_entry);
        this.button_valid = findViewById(R.id.button_valid);
        verification();
        button_valid.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v)
            {
                recup_nom = nom_entry.getText().toString();
                recup_prenom = prenom_entry.getText().toString();
                if(recup_nom.isEmpty())
                {
                    nom_entry.setError("Erreur Mettez un nom !");
                    nom_entry.requestFocus();
                }
                else if(recup_prenom.isEmpty())
                {
                    prenom_entry.setError("Erreur Mettez un prenom ! ");
                    prenom_entry.requestFocus();
                }
                else {
                    SharedPreferences sp = getSharedPreferences(stock,MODE_PRIVATE);
                    SharedPreferences.Editor entvalencienne = sp.edit();
                    entvalencienne.putString(clex,recup_nom + " " + recup_prenom );
                    entvalencienne.apply();
                    Intent Activity2 = new Intent(getApplicationContext(),Messagerie.class);
                    startActivity(Activity2);
                    Toast.makeText(getApplicationContext(), "Bienvenue !" + recup_nom + " " + recup_prenom, Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    public void verification()
    {
        SharedPreferences sp = getSharedPreferences(stock,MODE_PRIVATE);
        String recuperation = sp.getString(clex,null);
        if(recuperation != null && !recuperation.isEmpty())
        {
            Intent Activity2 = new Intent(getApplicationContext(),Messagerie.class);
            startActivity(Activity2);
            Toast.makeText(getApplicationContext(), "Bienvenue ! " + recuperation, Toast.LENGTH_LONG).show();
            finish();
        }
    }

}
