package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.jar.Attributes;




public class SearchItineraryActivity extends AppCompatActivity {

    EditText meditTextSearchDeparture;
    EditText meditTextSearchDestination;
    EditText meditTextSearchDate;
    Button buttonSearch;

    public final static String EXTRA_REQUEST = "Result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

       meditTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        meditTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);
       meditTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);
       buttonSearch = (Button) findViewById(R.id.buttonSearch);



        buttonSearch .setOnClickListener(new View.OnClickListener()  {
            public void onClick(View v) {



                if (meditTextSearchDeparture.length() != 0 || meditTextSearchDestination.length() != 0)

            {
                String departure =  meditTextSearchDeparture.getText().toString();
                String destination = meditTextSearchDestination.getText().toString();
                String date = meditTextSearchDate.getText().toString();
                SearchRequestModel Result = new SearchRequestModel(departure, destination, date);
                Intent Resultat = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                Resultat.putExtra(SearchItineraryActivity.EXTRA_REQUEST,Result);
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