package com.example.projet_android_larochette_alexis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Messagerie extends AppCompatActivity
{
    private ListView listView;
    private FloatingActionButton ajouter_contact;
    private copain c;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);
        listView = findViewById(R.id.recyclo);

        ajouter_contact = findViewById(R.id.ajout_contact);
        ajouter_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent Activity3 = new Intent(getApplicationContext(),ajoutercontact.class);
                startActivity(Activity3);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent == null)
            return;

        c  = intent.getParcelableExtra("c");
        if (c != null)
            Log.w("app","c =" + c.toString());;

        afficherliste();

    }

    public void openSMSapp() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", c.getText(), null)));
        } catch (Exception e) {
            Log.e("SMS", e.toString());
            e.printStackTrace();
        }
    }

    private void openEmailApp()
    {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + c.getAdressemail())));
        } catch (Exception e) {
            Log.e("EMAIL", e.toString());
            e.printStackTrace();
        }
    }

    public static void sort(final List<copain> tweets) {

        Collections.sort(tweets, new Comparator<copain>() {


            @Override
            public int compare(copain i1, copain i2) {

                return i1.getId()- i2.getId();

            }

        });

    }
    private List<copain> genererTweets()
    {
        List<copain> tweets = new ArrayList<>();
        tweets.add(new copain(4,R.drawable.franck, "Ebel Franck",    "INCONNU","lol@faillinvoc.fr",android.R.drawable.btn_star,"Trapanaf"));
        tweets.add(new copain(2,R.drawable.coronesse, "Coroenne Antoine","0781375220","tock@quiestla.fr",android.R.drawable.btn_star,"Maubeuge"));
        tweets.add(new copain(3,R.drawable.captureo, "Docker Docker","0729594856","docker@marche.fr",android.R.drawable.btn_star,"trojan"));
        tweets.add(new copain(5,R.drawable.dickdick, "Flinois Dyklan",    "0315454872","mv@ytb.fr",android.R.drawable.btn_star,"Paris"));
        tweets.add(new copain(6,R.drawable.photox, "Gueudet Carole",   "INCONNU","carole@gmail.com",android.R.drawable.btn_star,"Marseille"));
        tweets.add(new copain(7,R.drawable.lol, "Ocap Kevin",    "0648525475","kevin@gmail.fr",android.R.drawable.btn_star,"Dijon"));
        tweets.add(new copain(8,R.drawable.hi, "Pietrzak Aimé",   "0421544885","tamir@free.fr",android.R.drawable.btn_star,"Vandee"));
        tweets.add(new copain(9,R.drawable.yosra, "Yosra Rekik", "INCONNU","yosra@outlook.fr",android.R.drawable.btn_star,"Lille"));
        sort(tweets);
        if(c != null)
        {
            tweets.add(c);
            sort(tweets);
        }
        return tweets;

    }

    private void afficherliste()
    {
        List<copain> tweets = genererTweets();

        Adapter adapter = new Adapter(Messagerie.this, tweets);
        listView.setAdapter(adapter);
}}
