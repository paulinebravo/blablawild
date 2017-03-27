package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SubmitItineraryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);



    final EditText meditTextDestination = (EditText) findViewById(R.id.editTextDestination);
    final EditText meditTextDeparture = (EditText) findViewById(R.id.editTextDeparture);
    final EditText meditTextDate = (EditText) findViewById(R.id.editTextDate);
    final EditText meditTextPrice = (EditText) findViewById(R.id.editTextPrice);
    final Button buttonPublish = (Button) findViewById(R.id.buttonPublish);

    buttonPublish.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent Publication = new Intent(SubmitItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
            startActivity(Publication);

            String Destination = meditTextDestination.getText().toString();
            String Departure = meditTextDeparture.getText().toString();
            int price = Integer.parseInt(meditTextPrice.getText().toString());
            String Date = meditTextDate.getText().toString();



            FirebaseDatabase itineraryDatabase;
            DatabaseReference refItinerary;
            itineraryDatabase = FirebaseDatabase.getInstance();

            refItinerary = itineraryDatabase.getReference("Itineraries");
            ItineraryModel newPurpose = new ItineraryModel(Date, price, Departure, Destination);
            refItinerary.push().setValue(newPurpose);

            finish();

        }



    } );
    }
}

