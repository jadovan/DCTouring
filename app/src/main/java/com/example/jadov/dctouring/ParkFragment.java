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
        locations.add(new Location(R.drawable.national_zoo_park, "National Zoo",
                "3001 Connecticut Avenue NW\nWashington, DC 20008", "202-633-1000",
                "https://www.si.edu/museums/national-zoo",
                "Always free of charge and open 364 days a year, the Smithsonian’s National " +
                        "Zoo sits on 163 acres in the heart of Washington, D.C.’s Rock Creek Park. Founded " +
                        "in 1889, the Zoo is currently home to more than 1,500 animals across 300 different species."));
        locations.add(new Location(R.drawable.lincoln_park, "Lincoln Park",
                "11th St & E Capitol St SE\nWashington, DC 20003", "202-789-7000",
                "https://www.nps.gov/cahi/learn/historyculture/cahi_lincoln.htm",
                "Lincoln Park is the largest Capitol Hill Park and features monuments to " +
                        "two of the nation's greatest leaders, President Abraham Lincoln and Civil Rights " +
                        "Activist and Educator Mary McLeod Bethune. It is located directly east of the " +
                        "United States Capitol Building at East Capitol and 11th Street in the Northeastern " +
                        "quadrant of the City."));
        locations.add(new Location(R.drawable.meridian_hill_park, "Meridian Hill Park",
                "2330 15th NW Street\nWashington, DC 20009", "202-282-1063",
                "https://www.nps.gov/places/meridian-hill-park.htm",
                "In 1819, John Porter erected a mansion here on Meridian Hill so called because " +
                        "it was on the exact longitude of the original District of Columbia milestone " +
                        "marker, set down on April 15, 1791. In 1829, the mansion became departing President " +
                        "John Quincy Adams's home. After its conversion to a public park, Union troops " +
                        "encamped on the grounds during the Civil War. The U.S. government purchased " +
                        "the grounds in 1910 and hired landscape architects George Burnap and Horace " +
                        "Peaslee who planned an Italian style garden. The structures made revolutionary " +
                        "use of concrete aggregate as a building material."));
        locations.add(new Location(R.drawable.rock_creek_park, "Rock Creek Park",
                "5200 Glover Rd NW\nWashington, DC 20015", "202-895-6000",
                "https://www.nps.gov/rocr/index.htm",
                "Rock Creek Park is truly a gem in our nation's capital. This 1,754 acre city " +
                        "park was officially authorized in 1890, making it the third national park to " +
                        "be designated by the federal government. It offers visitors the opportunity " +
                        "to escape the bustle of the city and find a peaceful refuge, recreation, fresh " +
                        "air, majestic trees, wild animals, and thousands of years of human history."));
        locations.add(new Location(R.drawable.the_yards_park, "The Yards Park",
                "355 Water Street SE\nWashington, DC 20003", "202-465-7080",
                "https://www.capitolriverfront.org/yards-park",
                "The Yards Park, a premier waterfront destination, provides green space and " +
                        "water features for all to enjoy the outdoors along the Anacostia River. This " +
                        "award-winning park is an ideal place for recreation, special events, and festivals " +
                        "throughout the year."));

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
