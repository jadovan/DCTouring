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
 * {@link Fragment} contains and retrieves information on parks around DC.
 */
public class ParkFragment extends Fragment {

    public ParkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(R.drawable.national_zoo_park, getString(R.string.national_zoo_park_name),
                getString(R.string.national_zoo_park_address), getString(R.string.national_zoo_park_phone),
                getString(R.string.national_zoo_park_website), getString(R.string.national_zoo_park_description)));
        locations.add(new Location(R.drawable.lincoln_park, getString(R.string.lincoln_park_name),
                getString(R.string.lincoln_park_address), getString(R.string.lincoln_park_phone),
                getString(R.string.lincoln_park_website), getString(R.string.lincoln_park_description)));
        locations.add(new Location(R.drawable.meridian_hill_park, getString(R.string.meridian_hill_park_name),
                getString(R.string.meridian_hill_park_address), getString(R.string.meridian_hill_park_phone),
                getString(R.string.meridian_hill_park_website), getString(R.string.meridian_hill_park_description)));
        locations.add(new Location(R.drawable.rock_creek_park, getString(R.string.rock_creek_park_name),
                getString(R.string.rock_creek_park_address), getString(R.string.rock_creek_park_phone),
                getString(R.string.rock_creek_park_website), getString(R.string.rock_creek_park_description)));
        locations.add(new Location(R.drawable.the_yards_park, getString(R.string.the_yards_park_name),
                getString(R.string.the_yards_park_address), getString(R.string.the_yards_park_phone),
                getString(R.string.the_yards_park_website), getString(R.string.the_yards_park_description)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.blue_background);
        final ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                Intent locationIntent = new Intent(getActivity(), LocationInformationActivity.class);
                locationIntent.putExtra(getString(R.string.current_location_key), (Parcelable) listItem);
                startActivity(locationIntent);
            }
        });
        return rootView;
    }
}
