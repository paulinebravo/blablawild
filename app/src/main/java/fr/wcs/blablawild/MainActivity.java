package fr.wcs.blablawild;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();


        final Button buttonItineraire = (Button) findViewById(R.id.buttonItineraire);
        buttonItineraire.setOnClickListener(new View.OnClickListener() {


            @Override


            public void onClick(View v) {

                Intent Search = new Intent(MainActivity.this, SearchItineraryActivity.class);
                startActivity(Search);
            }

        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final Button buttonProposition = (Button) findViewById(R.id.buttonProposition);
        buttonProposition.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent Propose = new Intent(MainActivity.this, SubmitItineraryActivity.class);
                startActivity(Propose);


            }
        });


        final Button buttonCompte = (Button) findViewById(R.id.buttonCompte);
        buttonCompte.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent goLogin = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(goLogin);
            }
        });


    }
}




