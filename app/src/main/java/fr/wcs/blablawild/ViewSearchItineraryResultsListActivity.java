package fr.wcs.blablawild;

import java.text.ParseException;

import android.database.DataSetObserver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.text.SimpleDateFormat;
import java.util.ArrayList;



import static fr.wcs.blablawild.SearchItineraryActivity.EXTRA_REQUEST;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    SearchRequestModel Result;
    Intent Resultat;
    ListView mListViewResults;
    ListAdapter mResultsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);


        Intent Resultat = getIntent();
        Result = Resultat.getParcelableExtra(EXTRA_REQUEST);
        this.setTitle(Result.getmDeparture()+" "+Result.getmDestination());

        // [...]

        mDatabase = FirebaseDatabase.getInstance().getReference("Itineraries"); //APPELLE BDD

        final TripResultAdapter mTripResultAdapter = new TripResultAdapter(mDatabase, this, R.layout.trip_item); //APPELLE ADAPTER


       mListViewResults = (ListView) findViewById(R.id.driverlist); // VA CHERCHER LV
       mListViewResults.setAdapter(mTripResultAdapter); // FUSIONNE ADAPTER ET LA LISTE



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        mTripResultAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                mListViewResults.setSelection(mTripResultAdapter.getCount() - 1);


    }

    } );

    }

}

