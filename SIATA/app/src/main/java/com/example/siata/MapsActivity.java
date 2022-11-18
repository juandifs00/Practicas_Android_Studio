package com.example.siata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.siata.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    ArrayList<Estaciones> PosEstaciones = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AñadirEstaciones();

        double Distancia = DistanciaPuntos();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void AñadirEstaciones() {
        PosEstaciones.add(new Estaciones("69","Caldas",6.0930777, -75.637764, 18));
        PosEstaciones.add(new Estaciones("90","Sabaneta",6.1455002, -75.6212616, 21));
        PosEstaciones.add(new Estaciones("48","Medellin",6.1523128, -75.6274872, 36));
        PosEstaciones.add(new Estaciones("78","La Estrella",6.1555305, -75.6441727, 14));
        PosEstaciones.add(new Estaciones("38","Itagüi", 6.1684971, -75.6443558, 21));
        PosEstaciones.add(new Estaciones("88","Envigado", 6.1686831, -75.5819702, 17));
        PosEstaciones.add(new Estaciones("28","Medellin", 6.1856666, -75.59720609999999, 27));
        PosEstaciones.add(new Estaciones("84","Medellin", 6.1998701, -75.56095120000001, 17));
        PosEstaciones.add(new Estaciones("79","Medellin", 6.2218938, -75.61060329999999, 22));
        PosEstaciones.add(new Estaciones("83","Medellin", 6.2372341, -75.610466, 22));
        PosEstaciones.add(new Estaciones("94","Medellin", 6.236361, -75.4984741, 9));
        PosEstaciones.add(new Estaciones("80","Medellin", 6.2589092, -75.5482635, 17));
        PosEstaciones.add(new Estaciones("86","Medellin", 6.2904806, -75.5555191, 19));
        PosEstaciones.add(new Estaciones("103","Medellin", 6.2849998, -75.5830536, 16));
        PosEstaciones.add(new Estaciones("85","Medellin", 6.2778502, -75.6364288, 18));
        PosEstaciones.add(new Estaciones("87","Bello", 6.3375502, -75.56780240000001, 10));
        PosEstaciones.add(new Estaciones("82","Copacabana", 6.3453598, -75.5047531, 12));
        PosEstaciones.add(new Estaciones("101","Girardota", 6.3732505, -75.4483109, 8));
        PosEstaciones.add(new Estaciones("81","Barbosa", 6.4369602, -75.3303986, 7));
    }

    public static double DistanciaPuntos(double latitudPunto1, double longitudPunto1, double latitudPunto2, double longitudPunto2) {
        latitudPunto1 = Math.toRadians(latitudPunto1);
        longitudPunto1 = Math.toRadians(longitudPunto1);

        latitudPunto2 = Math.toRadians(latitudPunto2);
        longitudPunto2 = Math.toRadians(longitudPunto2);

        final double RADIO_TIERRA = 6371.01;    // Kilómetros

        double distancia = RADIO_TIERRA * Math.acos(Math.sin(latitudPunto1) * Math.sin(latitudPunto2)
                + Math.cos(latitudPunto1) * Math.cos(latitudPunto2) * Math.cos(longitudPunto1 - longitudPunto2));

        return distancia;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng medellin = new LatLng(6.217, -75.567);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 12));

        googleMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }
}