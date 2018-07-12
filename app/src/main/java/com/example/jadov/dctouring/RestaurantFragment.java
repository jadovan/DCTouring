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
 * {@link Fragment} contains and retrieves information on restaurants around DC.
 */
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location(R.drawable.old_ebbitt_grill_restaurant, getString(R.string.old_ebbitt_grill_restaurant_name),
                getString(R.string.old_ebbitt_grill_restaurant_address), getString(R.string.old_ebbitt_grill_restaurant_phone),
                getString(R.string.old_ebbitt_grill_restaurant_website), getString(R.string.old_ebbitt_grill_restaurant_description)));
        locations.add(new Location(R.drawable.tortino_restaurant, getString(R.string.tortino_restaurant_name),
                getString(R.string.tortino_restaurant_address), getString(R.string.tortino_restaurant_phone),
                getString(R.string.tortino_restaurant_website), getString(R.string.tortino_restaurant_description)));
        locations.add(new Location(R.drawable.the_capital_grille_restaurant, getString(R.string.the_capital_grille_restaurant_name),
                getString(R.string.the_capital_grille_restaurant_address), getString(R.string.the_capital_grille_restaurant_phone),
                getString(R.string.the_capital_grille_restaurant_website), getString(R.string.the_capital_grille_restaurant_description)));
        locations.add(new Location(R.drawable.sweetgreen_restaurant, getString(R.string.sweetgreen_restaurant_name),
                getString(R.string.sweetgreen_restaurant_address), getString(R.string.sweetgreen_restaurant_phone),
                getString(R.string.sweetgreen_restaurant_website), getString(R.string.sweetgreen_restaurant_description)));
        locations.add(new Location(R.drawable.rasika_restaurant, getString(R.string.rasika_restaurant_name),
                getString(R.string.rasika_restaurant_address), getString(R.string.rasika_restaurant_phone),
                getString(R.string.rasika_restaurant_website), getString(R.string.rasika_restaurant_description)));

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
