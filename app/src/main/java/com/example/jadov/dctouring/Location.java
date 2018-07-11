package com.example.jadov.dctouring;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link Location} represents information about a location within Washington DC.
 * It contains basic information for that location such as image, name, address, phone number,
 * website, and description.
 */
public class Location implements Parcelable {

    // declare variables
    private int imageResourceId;
    private String name;
    private String address;
    private String phone;
    private String website;
    private String description;

    // default constructor for creating a location object
    public Location(int imageResourceId, String name, String address, String phone, String website,
                    String description) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.description = description;
    }

    // retrieve the image resource for the location
    public int getImageResourceId() {
        return imageResourceId;
    }

    // retrieve the name of the location
    public String getName() {
        return name;
    }

    // retrieve the address of the location
    public String getAddress() {
        return address;
    }

    // retrieve the phone number of the location
    public String getPhone() {
        return phone;
    }

    // retrieve the website of the location
    public String getWebsite() {
        return website;
    }

    // retrieve the description of the location
    public String getDescription() {
        return description;
    }

    // Write object values to parcel for storage
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResourceId);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(website);
        dest.writeString(description);
    }

    // Constructor used for parcel
    public Location(Parcel parcel) {
        imageResourceId = parcel.readInt();
        name = parcel.readString();
        address = parcel.readString();
        phone = parcel.readString();
        website = parcel.readString();
        description = parcel.readString();
    }

    // Creator - used when un-parceling our parcel (creating the object)
    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {

        @Override
        public Location createFromParcel(Parcel parcel) {
            return new Location(parcel);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[0];
        }
    };

    // Return hashcode of object
    @Override
    public int describeContents() {
        return hashCode();
    }

}
