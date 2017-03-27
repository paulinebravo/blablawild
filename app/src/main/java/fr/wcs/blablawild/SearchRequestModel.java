package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;



/**
 * Created by apprenti on 06/03/17.
 */


public class SearchRequestModel implements Parcelable {


    private String mDeparture;
    private String mDestination;
    private String mDate;


    private SearchRequestModel() {

    }

    public SearchRequestModel(String departure, String destination, String date) {

        super();
        this.mDeparture = departure;
        this.mDestination = destination;
        this.mDate = date;


    }

    private SearchRequestModel(Parcel in) {
        mDeparture = in.readString();
        mDestination = in.readString();
        mDate = in.readString();

    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {

        @Override

        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);

        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };


    public String getmDeparture() {
        return mDeparture;
    }


    public String getmDestination() {
        return mDestination;
    }


    public String getmDate() {
        return mDate;
    }

    @Override
    public int describeContents() {

        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDeparture);
        dest.writeString(mDestination);
        dest.writeString(mDate);
    }


}








