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
 * {@link Fragment} contains and retrieves information on memorials and monuments around DC.
 */
public class MemorialFragment extends Fragment {

    public MemorialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.drawable.washington_monument, getString(R.string.washington_monument_name),
                getString(R.string.washington_monument_address), getString(R.string.washington_monument_phone),
                getString(R.string.washington_monument_website), getString(R.string.washington_monument_description)));
        locations.add(new Location(R.drawable.lincoln_memorial, getString(R.string.lincoln_memorial_name),
                getString(R.string.lincoln_memorial_address), getString(R.string.lincoln_memorial_phone),
                getString(R.string.lincoln_memorial_website), getString(R.string.lincoln_memorial_description)));
        locations.add(new Location(R.drawable.jefferson_memorial, getString(R.string.jefferson_memorial_name),
                getString(R.string.jefferson_memorial_address), getString(R.string.jefferson_memorial_phone),
                getString(R.string.jefferson_memorial_website), getString(R.string.jefferson_memorial_description)));
        locations.add(new Location(R.drawable.ww2_memorial, getString(R.string.ww2_memorial_name),
                getString(R.string.ww2_memorial_address), getString(R.string.ww2_memorial_phone),
                getString(R.string.ww2_memorial_website), getString(R.string.ww2_memorial_description)));
        locations.add(new Location(R.drawable.vietnam_memorial, getString(R.string.vietnam_memorial_name),
                getString(R.string.vietnam_memorial_address), getString(R.string.vietnam_memorial_phone),
                getString(R.string.vietnam_memorial_website), getString(R.string.vietnam_memorial_description)));
        locations.add(new Location(R.drawable.korean_memorial, getString(R.string.korean_memorial_name),
                getString(R.string.korean_memorial_address), getString(R.string.korean_memorial_phone),
                getString(R.string.korean_memorial_website), getString(R.string.korean_memorial_description)));

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
