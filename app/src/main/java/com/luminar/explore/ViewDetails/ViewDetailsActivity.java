package com.luminar.explore.ViewDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.luminar.explore.R;
import com.squareup.picasso.Picasso;

public class ViewDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String name,address,country,url;
    Double lat,lon;
    TextView tvNameOnImage,tvName,tvAddress;
    ImageView iv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        getDetails();

        init();

        tvName.setText(name);
        tvAddress.setText(address);
        tvNameOnImage.setText(name);

        Picasso.get().load(url).into(iv);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mv);
        mapFragment.getMapAsync(this);

    }

    private void init(){
        tvName = findViewById(R.id.tvName);
        tvNameOnImage = findViewById(R.id.tvNameOnImage);
        tvAddress = findViewById(R.id.tvAddress);
        iv = findViewById(R.id.iv);
    }

    private void getDetails() {
        Intent i = getIntent();
        name = i.getStringExtra("name");
        address = i.getStringExtra("address");
        country = i.getStringExtra("country");
        lat = i.getDoubleExtra("lat",0);
        lon = i.getDoubleExtra("lon",0);
        url = i.getStringExtra("url");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(lat, lon);
        mMap.addMarker(new
                MarkerOptions().position(latLng).title(name));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
    }
}