package com.example.jadov.dctouring;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} contains and retrieves information on parking around DC.
 */
public class ParkingFragment extends Fragment {

    public ParkingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.drawable.pmi_parking, "PMI Parking Garage",
                "2300 M St. NW \nWashington, DC 20037", "202-785-9191",
                "https://www.pmi-parking.com/home.aspx", "Enter this location at " +
                "1151 24th St. NW. This is a PMI Parking facility located on the east side of 24th " +
                "St. NW between M and L Streets NW. This garage serves The Westin Georgetown and is " +
                "located in the back of the hotel and across the street from Hope Cleaners."));
        locations.add(new Location(R.drawable.fairfax_parking, "Fairfax at Embassy Row Hotel Valet",
                "2100 Massachusetts Ave. NW \nWashington, DC 20008", "202-293-2100",
                "https://fairfaxwashingtondc.com/", "Enter this location at 2100 " +
                "Massachusetts Ave. NW. This is the Fairfax at Embassy Row Hotel valet. It is " +
                "located on the south side of Massachusetts Ave. NW between 21st St. NW and 22nd St. NW."));
        locations.add(new Location(R.drawable.gallery_place_parking, "Gallery Place Parking Garage",
                "732 6th St NW \nWashington, DC 20001", "202-393-2923",
                "https://www.galleryplace.com/", "Enter this location at 732 6th " +
                "St. NW. This is the Gallery Place garage, operated by Colonial Parking. It is " +
                "located on the west side of 6th St. NW between G St. NW and H St. NW The entrance " +
                "is marked by a blue 'P' sign with white lettering."));
        locations.add(new Location(R.drawable.hilton_parking, "Washington Hilton Parking Garage",
                "1920 19th St NW \nWashington, DC 20009", "202-483-3000",
                "http://www3.hilton.com/en/hotels/district-of-columbia/washington-hilton-DCAWHHH/index.html",
                "Enter this location at 1919 Connecticut Ave. NW. This is the Washington " +
                        "Hilton garage, operated by Towne Park. It is located on the east side of " +
                        "Connecticut Ave. between T St. NW St. and 20th St. NW The entrance is along " +
                        "the roundabout in front of the hotel."));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.blue_background);
        final ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Intent locationIntent = new Intent(getActivity(), LocationInformationActivity.class);
                locationIntent.putExtra("Current Location", (Parcelable) listItem);
                startActivity(locationIntent);
            }
        });
        return rootView;
    }
}
