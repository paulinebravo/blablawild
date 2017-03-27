package fr.wcs.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 15/03/17.
 */

public class ItineraryModel {

    public int mID;
    public String mLastname;
    public String mFirstname;
    public String mDate;
    public int mPrice;
    public String mDeparture;
    public String mDestination;

    private ItineraryModel() {

    }

    public ItineraryModel(String date, int price, String departure, String destination) {
        mID = 0;
        mLastname = "Trudeau";
        mFirstname = "Justin";
        mDate = date;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;

    }

    public int getID() {

        return mID;
    }

    public String getLastname() {
        return mLastname;
    }

    public String getFirstname() {

        return mFirstname;
    }

    public String getDate() {

        return mDate;
    }

    public int getPrice() {

        return mPrice;
    }

    public String getDeparture() {

        return mDeparture;
    }

    public String getDestination() {

        return mDestination;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public void setLastname(String mLastname) {
        this.mLastname = mLastname;
    }

    public void setFirstname(String mFirstname) {
        this.mFirstname = mFirstname;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public void setmDeparture (String mDeparture) {
        this.mDeparture=mDeparture;
    }

    public void setDestination(String mDestination) {
        this.mDestination = mDestination;
    }



    }

