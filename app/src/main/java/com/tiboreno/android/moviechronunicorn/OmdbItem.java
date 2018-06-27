package com.tiboreno.android.moviechronunicorn;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class OmdbItem {

    String Title;
    String Year;
    String Released;
    String Runtime;
    String Language;
    String Country;
    String Type;
    String Poster;
    public static final String date_format = "dd MMM yyyy";

    public OmdbItem(String title, String year, String released, String runtime, String language, String country, String type, String poster) {
        Title = title;
        Year = year;
        Released = released;
        Runtime = runtime;
        Language = language;
        Country = country;
        Type = type;
        Poster = poster;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getFormattedReleased(){
        if(Released == null || Released.isEmpty()){
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(date_format);
        try {
            return formatter.parse(Released);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public OmdbItemView getView(Context mContext){
        OmdbItemView view = new OmdbItemView(mContext);
        view.setItem(this);
        return  view;
    }

    @Override
    public String toString() {
        return "OmdbItem{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Released='" + Released + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Language='" + Language + '\'' +
                ", Country='" + Country + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
