package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

import wcs.fr.blablawild.R;


/**
 * Created by apprenti on 06/03/17.
 */


public class SearchRequestModel implements Parcelable {



    private String mDeparture;
    private String mDestination;
    private String mDate;


    public SearchRequestModel(String mDeparture, String mDestination, String mDate) {

        super();
        this.mDeparture = mDeparture;
        this.mDestination = mDestination;
        this.mDate = mDate;


    }

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


    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>() {

        @Override

        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);

        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];

        }

    };

    private SearchRequestModel(Parcel in) {
        mDeparture = in.readString();
        mDestination = in.readString();
        mDate = in.readString();

    }


}

