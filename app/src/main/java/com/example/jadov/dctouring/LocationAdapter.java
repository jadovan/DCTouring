package com.example.jadov.dctouring;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link LocationAdapter} represents an adapter for viewing list views within a fragment.
 * It contains the methods to retrieve specific attributes to be displayed in the list view.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    private int backgroundColorResourceId;

    public LocationAdapter(Context context, ArrayList<Location> locations,
                           int backgroundColorResourceId) {
        super(context, 0, locations);
        this.backgroundColorResourceId = backgroundColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        Location currentLocation = getItem(position);

        ImageView locationImageView = listItemView.findViewById(R.id.location_image);
        locationImageView.setImageResource(currentLocation.getImageResourceId());


        TextView nameTextView = listItemView.findViewById(R.id.location_name);
        nameTextView.setText(currentLocation.getName());

        TextView addressTextView = listItemView.findViewById(R.id.location_address);
        addressTextView.setText(currentLocation.getAddress());

        View locationContainer = listItemView.findViewById(R.id.location_container);
        int backgroundColor = ContextCompat.getColor(getContext(), backgroundColorResourceId);
        locationContainer.setBackgroundColor(backgroundColor);

        return listItemView;
    }
}
