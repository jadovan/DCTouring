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

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
            holder = new ViewHolder();
            holder.locationImageView = convertView.findViewById(R.id.location_image);
            holder.nameTextView = convertView.findViewById(R.id.location_name);
            holder.addressTextView = convertView.findViewById(R.id.location_address);
            holder.locationContainer = convertView.findViewById(R.id.location_container);
            holder.backgroundColor = ContextCompat.getColor(getContext(), backgroundColorResourceId);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Location currentLocation = getItem(position);

        holder.locationImageView.setImageResource(currentLocation.getImageResourceId());
        holder.nameTextView.setText(currentLocation.getName());
        holder.addressTextView.setText(currentLocation.getAddress());
        holder.locationContainer.setBackgroundColor(holder.backgroundColor);

        return convertView;
    }

    // Create ViewHolder to increase loading efficiency
    static class ViewHolder {
        private ImageView locationImageView;
        private TextView nameTextView;
        private TextView addressTextView;
        private View locationContainer;
        private int backgroundColor;
    }
}
