package com.example.projet_android_larochette_alexis;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageView;

public class copain implements Parcelable
{
    private int id;
    private int color;
    private String pseudo;
    private String text;
    private String adressemail;
    private String ville;
    private int issou;

    public copain(int id,int color, String pseudo, String text,String adressemail, int issou,String ville)
    {
        this.id = id;
        this.color = color;
        this.pseudo = pseudo;
        this.text = text;
        this.adressemail = adressemail;
        this.issou = issou;
        this.ville = ville;
    }

    protected copain(Parcel in)
    {
        id = in.readInt();
        color = in.readInt();
        pseudo = in.readString();
        text = in.readString();
        adressemail = in.readString();
        issou = in.readInt();
        ville = in.readString();
    }

    public static final Creator<copain> CREATOR = new Creator<copain>() {
        @Override
        public copain createFromParcel(Parcel in) {
            return new copain(in);
        }

        @Override
        public copain[] newArray(int size) {
            return new copain[size];
        }
    };

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getIssou() {
        return issou;
    }

    public void setIssou(int issou) {
        this.issou = issou;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(id);
        dest.writeInt(color);
        dest.writeString(pseudo);
        dest.writeString(text);
        dest.writeString(adressemail);
        dest.writeInt(issou);
        dest.writeString(ville);
    }

    @Override
    public String toString() {
        return "copain{" +
                "id=" + id +
                ", color=" + color +
                ", pseudo='" + pseudo + '\'' +
                ", text='" + text + '\'' +
                ", adressemail='" + adressemail + '\'' +
                ", ville='" + ville + '\'' +
                ", issou=" + issou +
                '}';
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}

