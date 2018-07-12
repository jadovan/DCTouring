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
 * {@link Fragment} contains and retrieves information on museums around DC.
 */
public class MuseumFragment extends Fragment {

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(R.drawable.natural_history_museum, getString(R.string.natural_history_museum_name),
                getString(R.string.natural_history_museum_address), getString(R.string.natural_history_museum_phone),
                getString(R.string.natural_history_museum_website), getString(R.string.natural_history_museum_description)));
        locations.add(new Location(R.drawable.african_american_museum, getString(R.string.african_american_museum_name),
                getString(R.string.african_american_museum_address), getString(R.string.african_american_museum_phone),
                getString(R.string.african_american_museum_website), getString(R.string.african_american_museum_description)));
        locations.add(new Location(R.drawable.air_and_space_museum, getString(R.string.air_and_space_museum_name),
                getString(R.string.air_and_space_museum_address), getString(R.string.air_and_space_museum_phone),
                getString(R.string.air_and_space_museum_website), getString(R.string.air_and_space_museum_description)));
        locations.add(new Location(R.drawable.american_art_museum, getString(R.string.american_art_museum_name),
                getString(R.string.american_art_museum_address), getString(R.string.american_art_museum_phone),
                getString(R.string.american_art_museum_website), getString(R.string.american_art_museum_description)));
        locations.add(new Location(R.drawable.american_indian_museum, getString(R.string.american_indian_museum_name),
                getString(R.string.american_indian_museum_address), getString(R.string.american_indian_museum_phone),
                getString(R.string.american_indian_museum_website), getString(R.string.american_indian_museum_description)));

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
