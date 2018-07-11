package com.example.jadov.dctouring;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} represents an adapter for viewing fragments in a tab layout.
 * It contains the methods to retrieve a specific fragment and its title.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 5;
    private Context context;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MemorialFragment();
        } else if (position == 1) {
            return new MuseumFragment();
        } else if (position == 2) {
            return new ParkFragment();
        } else if (position == 3) {
            return new RestaurantFragment();
        } else {
            return new ParkingFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.memorial_category);
        } else if (position == 1) {
            return context.getString(R.string.museum_category);
        } else if (position == 2) {
            return context.getString(R.string.park_category);
        } else if (position == 3) {
            return context.getString(R.string.restaurant_category);
        } else {
            return context.getString(R.string.parking_category);
        }
    }
}
