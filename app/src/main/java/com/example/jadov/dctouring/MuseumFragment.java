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
        locations.add(new Location(R.drawable.natural_history_museum, "Natural History Museum",
                "10th St & Constitution Ave NW\nWashington, DC 20560",
                "202-633-1000", "https://naturalhistory.si.edu/",
                "The National Museum of Natural History (NMNH) is part of the Smithsonian " +
                        "Institution, the world’s preeminent museum and research complex. The Museum " +
                        "is dedicated to inspiring curiosity, discovery, and learning about the " +
                        "natural world through its unparalleled research, collections, exhibitions, " +
                        "and education outreach programs. Opened in 1910, the green-domed museum on " +
                        "the National Mall was among the first Smithsonian building constructed " +
                        "exclusively to house the national collections and research facilities."));
        locations.add(new Location(R.drawable.african_american_museum, "African American Museum",
                "15th St & Constitution Ave NW\nWashington, DC 20004",
                "202-633-1000", "https://www.si.edu/museums/african-american-museum",
                "The National Museum of African American History and Culture is a place " +
                        "where all Americans can learn about the richness and diversity of the African " +
                        "American experience, what it means to their lives, and how it helped us shape this nation."));
        locations.add(new Location(R.drawable.air_and_space_museum, "Air and Space Museum",
                "6th St & Independence Ave SW\nWashington, DC 20560",
                "202-633-1000", "https://www.si.edu/museums/air-and-space-museum",
                "Launch into the history of flight by surrounding yourself with icons of " +
                        "air and space travel. The flagship building on the National Mall in Washington, " +
                        "D.C, contains twenty-three galleries exhibiting hundreds of aircraft, spacecraft, " +
                        "missiles, rockets, and other flight-related artifacts. The museum has a planetarium " +
                        "and an IMAX theater for out-of-this-world escapes."));
        locations.add(new Location(R.drawable.american_art_museum, "American Art Museum",
                "8th St & F St NW\nWashington, DC 20004",
                "202-633-1000", "https://www.si.edu/museums/american-art-museum",
                "The nation’s first collection of American art offers an unparalleled record " +
                        "of the American experience, capturing the aspirations, character and imagination " +
                        "of the American people throughout three centuries. The museum is home to one " +
                        "of the largest and most inclusive collections of American art in the world, " +
                        "including works by such stylistically diverse luminaries as John Singleton " +
                        "Copley, Winslow Homer, and Georgia O’Keeffe, housed in one of the oldest public " +
                        "buildings constructed in early Washington."));
        locations.add(new Location(R.drawable.american_indian_museum, "American Indian Museum",
                "4th St & Independence Ave SW\nWashington, DC 20024",
                "202-633-1000", "https://www.si.edu/museums/american-indian-museum",
                "The National Museum of the American Indian cares for one of the world’s " +
                        "most expansive collections of Native objects, photographs, and media, covering " +
                        "the entire Western Hemisphere from the Arctic Circle to Tierra del Fuego. The " +
                        "museum’s sweeping curvilinear architecture, its indigenous landscaping, and " +
                        "its exhibitions, all designed in collaboration with tribes and communities, " +
                        "combine to give visitors from around the world the sense and spirit of Native America."));

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
