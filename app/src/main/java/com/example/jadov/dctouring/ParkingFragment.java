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

        locations.add(new Location(R.drawable.pmi_parking, getString(R.string.pmi_parking_name),
                getString(R.string.pmi_parking_address), getString(R.string.pmi_parking_phone),
                getString(R.string.pmi_parking_website), getString(R.string.pmi_parking_description)));
        locations.add(new Location(R.drawable.fairfax_parking, getString(R.string.fairfax_parking_name),
                getString(R.string.fairfax_parking_address), getString(R.string.fairfax_parking_phone),
                getString(R.string.fairfax_parking_website), getString(R.string.fairfax_parking_description)));
        locations.add(new Location(R.drawable.gallery_place_parking, getString(R.string.gallery_place_parking_name),
                getString(R.string.gallery_place_parking_address), getString(R.string.gallery_place_parking_phone),
                getString(R.string.gallery_place_parking_website), getString(R.string.gallery_place_parking_description)));
        locations.add(new Location(R.drawable.hilton_parking, getString(R.string.hilton_parking_name),
                getString(R.string.hilton_parking_address), getString(R.string.hilton_parking_phone),
                getString(R.string.hilton_parking_website), getString(R.string.hilton_parking_description)));

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
