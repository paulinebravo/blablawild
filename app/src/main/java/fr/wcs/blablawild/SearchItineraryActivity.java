package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.jar.Attributes;


import wcs.fr.blablawild.R;

public class SearchItineraryActivity extends AppCompatActivity {


    public final static String EXTRA_REQUEST = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText editTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        final EditText editTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);
        final EditText editTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);
        final Button buttonSearch = (Button) findViewById(R.id.buttonSearch);



        buttonSearch .setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {



                if (editTextSearchDeparture.length() != 0 || editTextSearchDestination.length() != 0)

            {   String mDeparture =  editTextSearchDeparture.getText().toString();
                String mDestination = editTextSearchDestination.getText().toString();
                String mDate = editTextSearchDate.getText().toString();
                SearchRequestModel result = new SearchRequestModel(mDeparture, mDestination, mDate);
                Intent Resultat = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                Resultat.putExtra(SearchItineraryActivity.EXTRA_REQUEST,result);
                startActivity(Resultat);

            }

            else

            {

                Toast.makeText(SearchItineraryActivity.this, getString(R.string.Toast), Toast.LENGTH_SHORT).show();


            }




            }

        }
        )
        ;


    }


}