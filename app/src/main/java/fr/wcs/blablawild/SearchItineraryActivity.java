package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.jar.Attributes;

import static fr.wcs.blablawild.R.id.editTextDate;


public class SearchItineraryActivity extends AppCompatActivity {

    EditText meditTextSearchDeparture;
    EditText meditTextSearchDestination;
    EditText meditTextSearchDate;
    Button buttonSearch;
    Calendar mCalendar;
    DatePickerDialog.OnDateSetListener date;

    public final static String EXTRA_REQUEST = "Result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

       meditTextSearchDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        meditTextSearchDestination = (EditText) findViewById(R.id.editTextSearchDestination);
       meditTextSearchDate = (EditText) findViewById(R.id.editTextSearchDate);
       buttonSearch = (Button) findViewById(R.id.buttonSearch);

        mCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };

        meditTextSearchDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, date,
                        mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


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
    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        meditTextSearchDate.setText(sdf.format(mCalendar.getTime()));
    }


}