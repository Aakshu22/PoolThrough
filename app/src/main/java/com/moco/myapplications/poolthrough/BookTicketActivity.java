package com.moco.myapplications.poolthrough;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.Math;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BookTicketActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView fare;
    Button pay;
    Spinner dropdown;
    Spinner dropdown2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        fare = (TextView) findViewById(R.id.textView5);
        pay = (Button) findViewById(R.id.button);

        fare.setText("Fare: 0");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //get the spinner from the xml.
        dropdown = findViewById(R.id.spinner);
        dropdown2 = findViewById(R.id.spinner2);
        //create a list of items for the spinner.
        String[] items = new String[]{"Kamathipura", "Dadar", "Bandra", "Airport", "Andheri", "Goregaon", "Malad", "Kandivali", "Borivali", "Dahisar", "Ghodbandar", "Versova"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter);

/*
        if(item2selected) {

        }
*/

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookTicketActivity.this, PaymentActivity.class));
            }
        });
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(19.1058459, 72.8667454)).zoom(9).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                googleMap.clear();
                int src_pos = dropdown.getSelectedItemPosition();
                LatLng source = new LatLng(retrieveLatPos(src_pos), retrieveLongPos(src_pos));
                LatLng destination = new LatLng(retrieveLatPos(position), retrieveLongPos(position));
                googleMap.addMarker(new MarkerOptions().position(source).title(retrieveStopName(src_pos)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                googleMap.addMarker(new MarkerOptions().position(destination).title(retrieveStopName(position)));
                CameraPosition cameraPosition = CameraPosition.builder().target(destination).zoom(11).build();
                googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                int cost = 10*Math.abs(src_pos-position);
                fare.setText("Fare: " + String.valueOf(cost));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //googleMap.setMyLocationEnabled(true);
    }

    public double retrieveLatPos(int pos){
        switch (pos){
            case 0:
                return 19.0160026;
            case 1:
                return 19.0029305;
            case 2:
                return 19.0565413;
            case 3:
                return 19.0806331;
            case 4:
                return 19.1058459;
            case 5:
                return 19.1359792;
            case 6:
                return 19.1698622;
            case 7:
                return 19.1969803;
            case 8:
                return 19.2279311;
            case 9:
                return 19.2620454;
            case 10:
                return 19.2870684;
            case 11:
                return 19.2767983;
        }
        return 19.0160026;
    }

    public double retrieveLongPos(int pos){
        switch (pos){
            case 0:
                return 72.8707424;
            case 1:
                return 72.8688663;
            case 2:
                return 72.856548;
            case 3:
                return 72.8586176;
            case 4:
                return 72.8667454;
            case 5:
                return 72.8657736;
            case 6:
                return 72.8711627;
            case 7:
                return 72.8787605;
            case 8:
                return 72.8786721;
            case 9:
                return 72.889097;
            case 10:
                return 72.9104866;
            case 11:
                return 72.9187618;
        }
        return 72.8707424;
    }

    public String retrieveStopName(int pos){
        switch (pos){
            case 0:
                return "Kamathipura";
            case 1:
                return "Dadar";
            case 2:
                return "Bandra";
            case 3:
                return "Airport";
            case 4:
                return "Andheri";
            case 5:
                return "Goregaon";
            case 6:
                return "Malad";
            case 7:
                return "Kandivali";
            case 8:
                return "Borivali";
            case 9:
                return "Dahisar";
            case 10:
                return "Ghodbandar";
            case 11:
                return "Versova";
        }
        return "Kamathipura";
    }
}
