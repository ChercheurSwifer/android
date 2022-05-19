package com.example.projet_android_larochette_alexis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Adapter extends ArrayAdapter<copain>
{
    private TweetViewHolder viewHolder;

    public Adapter(Context context, List<copain> tweets)
    {
        super(context, 0, tweets);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_adapter,parent, false);
        }

         viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.pseudo = convertView.findViewById(R.id.pseudo);
            viewHolder.text = convertView.findViewById(R.id.numero);
            viewHolder.avatar = convertView.findViewById(R.id.avatar);
            viewHolder.adresseemail = convertView.findViewById(R.id.adresseemail);
            viewHolder.sms = convertView.findViewById(R.id.sms);
            viewHolder.mail = convertView.findViewById(R.id.mail_envoie);
            viewHolder.magico = convertView.findViewById(R.id.magical);
            convertView.setTag(viewHolder);
        }

        final copain copain = getItem(position);
        viewHolder.pseudo.setText(copain.getPseudo());
        viewHolder.text.setText(copain.getText());
        viewHolder.avatar.setImageResource(copain.getColor());
        viewHolder.adresseemail.setText(copain.getAdressemail());
        viewHolder.magico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.w("app","contact:" +copain.getPseudo());
                viewHolder.magico.setImageResource(android.R.drawable.btn_star_big_on);

            }
        });

        viewHolder.pseudo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent tutu = new Intent(getContext(),detaillo.class);
                tutu.putExtra("c",copain);
                safeOpenActivityIntent(getContext(),tutu);

            }
        });

        viewHolder.sms.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
                smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.setData(Uri.parse("sms:" + copain.getText()));
                safeOpenActivityIntent(getContext(),smsIntent);

            }
        });

        viewHolder.mail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.addCategory(Intent.CATEGORY_DEFAULT);
                smsIntent.setType("vnd.android.cursor.dir/email");
                smsIntent.setData(Uri.parse("mailto:" + copain.getAdressemail()));
                safeOpenActivityIntent(getContext(),smsIntent);

            }
        });
        return convertView;
    }

    public static void safeOpenActivityIntent(Context context, Intent activityIntent)
    {

        if (activityIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(activityIntent);
        } else {
            Toast.makeText(context, "app not available", Toast.LENGTH_LONG).show();
        }
    }

    private class TweetViewHolder{
        public TextView pseudo;
        public TextView text;
        public TextView adresseemail;
        public ImageView avatar;
        public Button sms;
        public Button mail;
        public FloatingActionButton magico;
    }



}
