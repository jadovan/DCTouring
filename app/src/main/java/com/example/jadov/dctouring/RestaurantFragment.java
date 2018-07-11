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
        locations.add(new Location(R.drawable.old_ebbitt_grill_restaurant, "Old Ebbitt Grill",
                "675 15th Street NW\nWashington, DC 20005", "202-347-4800",
                "http://www.ebbitt.com/",
                "Old Ebbitt Grill is just steps from The White House and museums in " +
                        "downtown Washington. Established in 1856, it was a favorite of Presidents " +
                        "Grant, Cleveland, Harding and Theodore Roosevelt and is still a popular " +
                        "meeting spot for political insiders, journalists, celebrities and theater-goers."));
        locations.add(new Location(R.drawable.tortino_restaurant, "Tortino Restaurant",
                "1228 11th Street NW\nWashington, DC 20001", "202-312-5570",
                "http://tortinorestaurant.com/",
                "Chef Noé’s journey through Italy and the kitchens of esteemed chefs have " +
                        "culminated in a wonderful expression of contemporary Italian cuisine and a " +
                        "dream come true through the opening of the restaurant Tortino. The dining " +
                        "room of Tortino is elegant with soft textures that lend to both comfort and " +
                        "sophistication. Executive Chef and owner Noé welcomes you to experience his vision."));
        locations.add(new Location(R.drawable.the_capital_grille_restaurant, "The Capital Grille",
                "601 Pennsylvania Avenue NW\nWashington, DC 20004", "202-737-6200",
                "https://www.thecapitalgrille.com/home",
                "From the moment you step into The Capital Grille, the experience is one " +
                        "of comfortable elegance. African mahogany paneling and Art Deco chandeliers " +
                        "provide a warm, stately setting for our nationally renowned dry-aged steaks, " +
                        "fresh seafood, and acclaimed world-class wines. With service as gracious as " +
                        "it is attentive, we look forward to impressing you."));
        locations.add(new Location(R.drawable.sweetgreen_restaurant, "SweetGreen",
                "221 Pennsylvania Avenue SE\nWashington, DC 20003", "202-547-9338",
                "https://www.sweetgreen.com/",
                "Founded in 2007, sweetgreen is a destination for simple, seasonal, " +
                        "healthy food. We believe the choices we make about what we eat, where it " +
                        "comes from and how it’s prepared have a direct and powerful impact on the " +
                        "health of individuals, communities and the environment. That’s why we’re " +
                        "building a transparent supply network, why we cook from scratch, and why " +
                        "we’re building a community of people who support real food."));
        locations.add(new Location(R.drawable.rasika_restaurant, "Rasika",
                "633 D Street NW\nWashington, DC 20004", "202-637-1222",
                "https://rasikarestaurant.com/",
                "Showcasing Tawa (Griddle), Sigri (open Barbeque), Tandoori and regional " +
                        "dishes. We have a temperature controlled wine cellar, offer small plates " +
                        "and a modern lounge."));

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
