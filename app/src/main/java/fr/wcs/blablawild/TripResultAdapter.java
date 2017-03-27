package fr.wcs.blablawild;


import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;



class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {

    TextView mID;
    TextView mFirstName;
    TextView mLastname;
    TextView mDate;
    TextView mDeparture;
    TextView mDestination;
    TextView mPrice;


    public TripResultAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);

    }


    @Override
    protected void populateView(View view, ItineraryModel newPurpose) {

        mDate = (TextView)view.findViewById(R.id.textViewDepartureTime);
        mFirstName = (TextView)view.findViewById(R.id.textViewFirstname);
        mPrice = (TextView)view.findViewById(R.id.textViewPrice);

        mDate.setText(newPurpose.getDate());
        mFirstName.setText(String.valueOf(newPurpose.getFirstname()));
        mPrice.setText(Integer.toString(newPurpose.getPrice()));


    }
}