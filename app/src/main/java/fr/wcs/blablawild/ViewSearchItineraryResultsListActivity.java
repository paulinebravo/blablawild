package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;


import java.util.Date;

import wcs.fr.blablawild.R;

import static fr.wcs.blablawild.SearchItineraryActivity.EXTRA_REQUEST;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        SearchRequestModel Date;

        Intent Resultat = getIntent();
        SearchRequestModel result = Resultat.getParcelableExtra(EXTRA_REQUEST);


        this.setTitle (result.getmDeparture() +" " + getString(R.string.fleche)+" "+ result.getmDestination ());

        Toast.makeText(ViewSearchItineraryResultsListActivity.this,getString(R.string.Toast2)+" "+result.getmDate(),Toast.LENGTH_LONG).show();



    }


}
