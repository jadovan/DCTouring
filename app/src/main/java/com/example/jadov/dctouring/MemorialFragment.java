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
        locations.add(new Location(R.drawable.washington_monument, "Washington Monument",
                "2 15th Street NW\nWashington, DC 20024", "202-426-6841",
                "https://www.nps.gov/wamo/index.htm",
                "Built to honor George Washington, the United States' first president, the " +
                        "555-foot marble obelisk towers over Washington, D.C. The Washington Monument " +
                        "is currently closed to visitors to allow for modernization of the elevator."));
        locations.add(new Location(R.drawable.lincoln_memorial, "Lincoln Memorial",
                "2 Lincoln Memorial Circle NW\nWashington, DC 20002", "202-426-6841",
                "https://www.nps.gov/linc/index.htm",
                "\"In this temple, as in the hearts of the people for whom he saved the " +
                        "Union, the memory of Abraham Lincoln is enshrined forever.\" Beneath these " +
                        "words, the 16th President of the United States sits immortalized in marble " +
                        "as an enduring symbol of unity, strength, and wisdom."));
        locations.add(new Location(R.drawable.jefferson_memorial, "Thomas Jefferson Memorial",
                "16 East Basin Drive SW\nWashington, DC 20024", "202-426-6841",
                "https://www.nps.gov/thje/index.htm",
                "Dedicated by President Franklin Delano Roosevelt on April 13, 1943, the " +
                        "Thomas Jefferson Memorial stands in a straight line with the White House. " +
                        "Architect John Russell Pope, influenced by Jefferson's taste in classical " +
                        "architecture, echoed the style seen in Jefferson's two most famous buildings " +
                        "- Monticello and the University of Virginia Rotunda."));
        locations.add(new Location(R.drawable.ww2_memorial, "World War II Memorial",
                "1750 Independence Avenue SW\nWashington, DC 20024", "202-426-6841",
                "https://www.nps.gov/wwii/index.htm",
                "Through stone architecture and bronze sculptures, the World War II Memorial " +
                        "recognizes the ways Americans served, honors those who fell, and recognizes " +
                        "the victory they achieved to restore freedom and end tyranny around the globe."));
        locations.add(new Location(R.drawable.vietnam_memorial, "Vietnam Veterans Memorial",
                "5 Henry Bacon Drive NW\nWashington, DC 20002", "202-426-6841",
                "https://www.nps.gov/vive/index.htm",
                "Honoring the men and women who served in the controversial Vietnam War, " +
                        "the Vietnam Veterans Memorial chronologically lists the names of more than " +
                        "58,000 Americans who gave their lives in service to their country."));
        locations.add(new Location(R.drawable.korean_memorial, "Korean War Veterans Memorial",
                "10 Daniel French Drive SW\nWashington, DC 20002", "202-426-6841",
                "https://www.nps.gov/kowa/index.htm",
                "Our nation honors her sons and daughters who answered the call to defend " +
                        "a country they never knew and a people they never met. "));

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
