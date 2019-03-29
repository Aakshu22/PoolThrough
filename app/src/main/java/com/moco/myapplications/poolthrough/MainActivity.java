package com.moco.myapplications.poolthrough;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(MainActivity.this, BookTicketActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else if (id == R.id.nav_schedule) {
            startActivity(new Intent(MainActivity.this, ScheduleActivity.class));

        } else if (id == R.id.nav_rides) {
            startActivity(new Intent(MainActivity.this, RidesActivity.class));

        } else if (id == R.id.nav_pass) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    @SuppressWarnings("MissingPermission")
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng stop1 = new LatLng(19.0160026, 72.8707424); //kamathipura
        LatLng stop2 = new LatLng(19.0029305, 72.8688663); //dadar
        LatLng stop3 = new LatLng(19.0565413, 72.856548); //bandra
        LatLng stop4 = new LatLng(19.0806331, 72.8586176); //airport
        LatLng stop5 = new LatLng(19.1058459, 72.8667454); //andheri
        LatLng stop6 = new LatLng(19.1359792, 72.8657736); //goregaon
        LatLng stop7 = new LatLng(19.1698622, 72.8711627); //malad
        LatLng stop8 = new LatLng(19.1969803, 72.8787605); //kandivali
        LatLng stop9 = new LatLng(19.2279311, 72.8786721); //borivali
        LatLng stop10 = new LatLng(19.2620454,72.889097); //dahisar
        LatLng stop11 = new LatLng(19.2870684,72.9104866);//ghodbandar
        LatLng stop12 = new LatLng(19.2767983, 72.9187618); //versova

        googleMap.addMarker(new MarkerOptions().position(stop1).title("Kamathipura"));
        googleMap.addMarker(new MarkerOptions().position(stop2).title("Dadar"));
        googleMap.addMarker(new MarkerOptions().position(stop3).title("Bandra"));
        googleMap.addMarker(new MarkerOptions().position(stop4).title("Airport"));
        googleMap.addMarker(new MarkerOptions().position(stop5).title("Andheri"));
        googleMap.addMarker(new MarkerOptions().position(stop6).title("Goregaon"));
        googleMap.addMarker(new MarkerOptions().position(stop7).title("Malad"));
        googleMap.addMarker(new MarkerOptions().position(stop8).title("Kandivali"));
        googleMap.addMarker(new MarkerOptions().position(stop9).title("Borivali"));
        googleMap.addMarker(new MarkerOptions().position(stop10).title("Dahisar"));
        googleMap.addMarker(new MarkerOptions().position(stop11).title("Ghodbandar"));
        googleMap.addMarker(new MarkerOptions().position(stop12).title("Versova"));

        CameraPosition cameraPosition = CameraPosition.builder().target(stop5).zoom(12).build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        googleMap.setMyLocationEnabled(true);
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
