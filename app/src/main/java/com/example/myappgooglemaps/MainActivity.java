package com.example.myappgooglemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myappgooglemaps.AdaptadorInfo.MyAppInfoAdap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener {
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMap();
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }
    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map= googleMap;
        setupMapFeatures();
    }
    private void setupMapFeatures() {
        LatLng uteqLocation = new LatLng(-1.0126029332107438, -79.4695118557211);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(uteqLocation, 15));
        map.getUiSettings().setZoomControlsEnabled(true);


        addMapMarker(new LatLng(-1.009721321156024, -79.46901496082862), "Paseo Shopping Quevedo", " Centro Comercial \n Dirección: XGRJ+29W, Transversal Central, Quevedo",R.mipmap.ic_shopingcar);
        addMapMarker(new LatLng(-1.0105888180326281, -79.46852330327172), "Unidad Educativa Quevedo", "Colegio \n Dirección: XGQJ+MJ8, Quevedo", R.mipmap.ic_school);
        addMapMarker(new LatLng(-1.0133551666585796, -79.46932345233444), "Lokos D'Asar", " Restaurante \n Dirección: XGPJ+H7G, Quevedo",R.mipmap.ic_restaurante);
        addMapMarker(new LatLng(-1.011803314239006, -79.47102015299073), "Cyber Universitario", "Tienda electronica \n Dirección: XGQH+6HH, Septima, Quevedo", R.mipmap.ic_electronica);
        addMapMarker(new LatLng(-1.0139238592767086, -79.46915956507176), "Hotel Golden", " Hotel \n Dirección: XGPJ+988, Quevedo",R.mipmap.ic_hotel);
        addMapMarker(new LatLng(-1.0141383890508655, -79.46831667319765), "Cafe Restaurante las Delicias del Olimpo", "Cafe Restaurante \n Dirección: XGPJ+8MM, Quevedo", R.mipmap.ic_cafe);

        map.setInfoWindowAdapter(new MyAppInfoAdap(this));
    }

    private void addMapMarker(LatLng pos, String titleText, String detailText,int resourceIcon) {
        MarkerOptions marker = new MarkerOptions()
                .position(pos)
                .title(titleText)
                .snippet(detailText)
                .icon(BitmapDescriptorFactory.fromResource(resourceIcon));
        map.addMarker(marker);
    }
}