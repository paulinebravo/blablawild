package fr.wcs.blablawild;

import java.text.ParseException;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import wcs.fr.blablawild.R;

import static fr.wcs.blablawild.SearchItineraryActivity.EXTRA_REQUEST;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
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


        Toast.makeText(ViewSearchItineraryResultsListActivity.this, getString(R.string.Toast2) + " " + Result.getmDate(), Toast.LENGTH_LONG).show();
        this.setTitle(Result.getmDeparture() + " " + getString(R.string.fleche) + " " + Result.getmDestination());

        // [...]
        mListViewResults = (ListView) findViewById(R.id.driverlist);
        ArrayList<TripResultModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }

        mResultsAdapter = new TripResultAdapter(this, results);

        mListViewResults.setAdapter(mResultsAdapter);

        // [...]
    }

}


