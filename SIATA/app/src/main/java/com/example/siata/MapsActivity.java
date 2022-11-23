package com.example.siata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.example.siata.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    ArrayList<Estaciones> PosEstaciones = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

    /**
     * Coordenadas de referencia
     */

    final double MI_LATITUD = 6.16697164311577;
    final double MI_LONGITUD = 75.57830929756166;

    public static double Distancias(LatLng StartP, LatLng EndP) {

        final double RADIO_TIERRA = 6371.01;

        double Lat1 = StartP.latitude;
        double Lat2 = EndP.latitude;
        double Long1 = StartP.longitude;
        double Long2 = EndP.longitude;
        double dLat = Math.toRadians(Lat2 - Lat1);
        double dLong = Math.toRadians(Long2 - Long1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(Lat1))
                * Math.cos(Math.toRadians(Lat2)) * Math.sin(dLong / 2)
                * Math.sin(dLong / 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = RADIO_TIERRA * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.parseInt(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.parseInt(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return RADIO_TIERRA * c;
    }

    public static double DistanciaNodos(double latitudNodo1, double longitudNodo1,
                                         double latitudNodo2, double longitudNodo2) {
        latitudNodo1 = Math.toRadians(latitudNodo1);
        longitudNodo1 = Math.toRadians(longitudNodo1);

        latitudNodo2 = Math.toRadians(latitudNodo2);
        longitudNodo2 = Math.toRadians(longitudNodo2);

        final double RADIO_TIERRA = 6371.01;    // Kilómetros

        double distancia = RADIO_TIERRA * Math.acos(Math.sin(latitudNodo1) * Math.sin(latitudNodo2)
                + Math.cos(latitudNodo1) * Math.cos(latitudNodo2) * Math.cos(longitudNodo1 - longitudNodo2));

        return distancia;
    }

    private void matrizPMI() {
        for (int i = 0; i < n; i++) {
            pmi[i][0] = PosEstaciones.get(i).getConcentracion();
        }
    }

    //Distancia entre 2 puntos
    private double r(int i, int j){
        x1=PosEstaciones.get(i).getLatitud();
        x2=PosEstaciones.get(j).getLatitud();
        y1=PosEstaciones.get(i).getLongitud();
        y2=PosEstaciones.get(j).getLongitud();
        r=Math.sqrt((Math.pow(x1-x2,2))+(Math.pow(y1-y2,2)));
       return r;
    }

    private void matrizA() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fi = r(i, j);
                a[i][j] = Math.sqrt((1 + (Math.pow(fi, 2))));
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng medellin = new LatLng(6.217, -75.567);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 12));

        googleMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        AñadirEstaciones();

        for (int i = 0; i < PosEstaciones.size(); i++) {

            String Codigo = PosEstaciones.get(i).getCodigo();
            String Municipio = PosEstaciones.get(i).getMunicipio();
            double Latitud = PosEstaciones.get(i).getLatitud();
            double Longitud = PosEstaciones.get(i).getLongitud();
            int Concentracion = PosEstaciones.get(i).getConcentracion();

            LatLng Marcadores = new LatLng(Latitud, Longitud);

            mMap.addMarker(new MarkerOptions().position(Marcadores).icon(BitmapDescriptorFactory.defaultMarker
                    (BitmapDescriptorFactory.HUE_VIOLET)).title("Codigo:" + Codigo + " " + "Municipio:" + Municipio
                    + " " + "Concentracion:" + Concentracion));
        }
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }

    /*
    public void Interporlacion() {

        double [] Latitud = new double[PosEstaciones.size()];
        double [] Longitud = new double[PosEstaciones.size()];

        for (int i = 0; i < PosEstaciones.size(); i++) {

            double Latitud = PosEstaciones.get(i).getLatitud();
            double Longitud = PosEstaciones.get(i).getLongitud();
            int Concentracion = PosEstaciones.get(i).getConcentracion();

        }
    }
     */
}