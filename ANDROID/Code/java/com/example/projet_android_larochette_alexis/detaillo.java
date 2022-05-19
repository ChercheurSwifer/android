package com.example.projet_android_larochette_alexis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class detaillo extends AppCompatActivity
{
    private copain c;
    private ImageView photox;
    private TextView recupnomd;
    private TextView recupmaild;
    private TextView recupnumd;
    private TextView ville;
    private Button backtolist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaillo);
        Intent intent = getIntent();
        backtolist = findViewById(R.id.backtolist);
        backtolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        if (intent == null)
            return;

        c  = intent.getParcelableExtra("c");

        if (c == null)
        {
            Log.w("tag","contactnull");
            return;
        }
        if (c != null)
        {
            photox = findViewById(R.id.logo);
            photox.setImageResource(c.getColor());
            recupnomd = findViewById(R.id.recupnomd);
            recupnomd.setText(c.getPseudo());
            recupmaild = findViewById(R.id.recupmaild);
            recupmaild.setText(c.getAdressemail());
            recupnumd = findViewById(R.id.recupnumd);
            recupnumd.setText(c.getText());
            ville = findViewById(R.id.ville);
            ville.setText(c.getVille());
        }
    }
}
