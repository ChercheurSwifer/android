package com.example.projet_android_larochette_alexis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ajoutercontact extends AppCompatActivity
{
    private EditText nom_ajd;
    private EditText mail_ajd;
    private EditText numero_ajd;
    private EditText villas;
    private Button validation;
    private String recup_nom_c,recup_mail_c,recup_numero,recup_villas;
    private Button sms,mail;
    private ImageView favoro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutercontact);
        villas = findViewById(R.id.villas);
        nom_ajd = findViewById(R.id.nom_ajd);
        mail_ajd = findViewById(R.id.email_ajd);
        numero_ajd = findViewById(R.id.numero_ajd);
        validation = findViewById(R.id.valider_ajd);
        sms = findViewById(R.id.sms);
        mail = findViewById(R.id.mail_envoie);
        favoro = findViewById(R.id.favorou);
        favoro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            favoro.setImageResource(android.R.drawable.btn_star_big_on);
        }
        });
            validation.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    recup_nom_c = nom_ajd.getText().toString();
                    recup_mail_c = mail_ajd.getText().toString();
                    recup_numero = numero_ajd.getText().toString();
                    recup_villas = villas.getText().toString();
                    copain c = new copain(1,R.drawable.avator, recup_nom_c, recup_numero, recup_mail_c,android.R.drawable.btn_star_big_on,recup_villas);
                    Intent Activity2 = new Intent(getApplicationContext(), Messagerie.class);
                    Activity2.putExtra("c", c);
                    startActivity(Activity2);
                }

                ;
            });

}

}