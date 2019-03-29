package com.moco.myapplications.poolthrough;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RideDetailsActivity extends AppCompatActivity {

    private TextView name, description, rating;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_details);

        name = (TextView) findViewById(R.id.dNameId);
        description = (TextView) findViewById(R.id.dDescriptionId);
        rating = (TextView) findViewById(R.id.dRatingID);

        extras = getIntent().getExtras();

        if(extras != null) {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            rating.setText(extras.getString("rating"));
        }
    }
}
