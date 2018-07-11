package com.example.jadov.dctouring;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * {@link LocationInformationActivity} represents the detailed information about a list view element.
 * It contains the methods to retrieve all the attributes of a list view and display it to the user.
 */
public class LocationInformationActivity extends AppCompatActivity {

    // declare variables
    private Location currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_information);

        // Collect intent data
        Intent intent = getIntent();
        currentLocation = intent.getParcelableExtra("Current Location");

        // Collect all location values
        int locationImage = currentLocation.getImageResourceId();
        String locationName = currentLocation.getName();
        String locationAddress = currentLocation.getAddress();
        String locationPhone = currentLocation.getPhone();
        String locationWebsite = currentLocation.getWebsite();
        String locationDescription = currentLocation.getDescription();

        // Find and set location image ImageView
        ImageView image = findViewById(R.id.location_image);
        image.setImageResource(locationImage);

        // Find and set location name TextView
        TextView name = findViewById(R.id.location_name);
        name.setText(locationName);

        // Find and set location address TextView
        TextView address = findViewById(R.id.location_address);
        address.setText(locationAddress);
        Linkify.addLinks(address, Linkify.MAP_ADDRESSES);
        address.setLinksClickable(true);
        address.setLinkTextColor(Color.WHITE);

        // Find and set location phone TextView
        TextView phone = findViewById(R.id.location_phone);
        phone.setText(locationPhone);
        Linkify.addLinks(phone, Linkify.PHONE_NUMBERS);
        phone.setLinksClickable(true);
        phone.setLinkTextColor(Color.WHITE);

        // Find and set location website TextView
        TextView website = findViewById(R.id.location_website);
        website.setText(locationWebsite);
        Linkify.addLinks(website, Linkify.WEB_URLS);
        website.setLinksClickable(true);
        website.setLinkTextColor(Color.WHITE);

        // Find and set location description TextView
        TextView description = findViewById(R.id.location_description);
        description.setText(locationDescription);
    }

}
