package com.example.myappgooglemaps.AdaptadorInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myappgooglemaps.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyAppInfoAdap implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    public MyAppInfoAdap(Context context) {
        mWindow= LayoutInflater.from(context).inflate(R.layout.vistamap, null);
    }

    @Override
    public View getInfoContents(@NonNull Marker marker) {
        TextView lugar = mWindow.findViewById(R.id.Nombrelugar);
        TextView direccion = mWindow.findViewById(R.id.Nombredireccion);
        lugar.setText(marker.getTitle());
        direccion.setText(marker.getSnippet());
        return mWindow;
        }

    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return null;
    }
}
