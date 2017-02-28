package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import wcs.fr.blablawild.R;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();

        String Depart = intent.getStringExtra("editTextSearchDeparture");
        String Destination = intent.getStringExtra("editTextSearchDestination");

        setTitle (Depart + " " + getString(R.string.fleche)+" "+ Destination );

    }


}
