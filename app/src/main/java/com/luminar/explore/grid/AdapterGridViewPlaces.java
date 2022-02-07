package com.luminar.explore.grid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.luminar.explore.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AdapterGridViewPlaces extends BaseAdapter {

    Context context;
    String[] name,url,country;

    public AdapterGridViewPlaces(Context applicationContext, String[] country, String[] name, String[] url) {
        context = applicationContext;
        this.name = name;
        this.country = country;
        this.url = url;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        View gridView;

        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView =layoutInflater.inflate(R.layout.item_gv_places,parent,false);
        } else
            gridView = (View) view;

        ImageView iv = gridView.findViewById(R.id.iv);
        TextView tvName = gridView.findViewById(R.id.tvName);
        TextView tvCountry = gridView.findViewById(R.id.tvCountry);
        tvName.setText(name[i]);
        tvCountry.setText(country[i]);
        Picasso.get().load(url[i]).into(iv);

        return gridView;
    }
}
