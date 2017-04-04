package fr.wcs.blablawild;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by apprenti on 28/03/17.
 */

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    //Création de l'objet
    private FirebaseAuth firebaseAuth;

    private TextView textViewEmail;
    private Button buttonLogout;
    private Button buttonMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //On initialise l'authentification de firebase
        firebaseAuth = FirebaseAuth.getInstance();

        //si l'utilisateur n'est pas loggé
        //l'utilisateur en cours sera null
        if (firebaseAuth.getCurrentUser() == null) {
            //ferme cette activity
            finish();
            //renvoie à la login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        else {

        //récupère utilisateur en cours
        FirebaseUser user = firebaseAuth.getCurrentUser();


        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        buttonLogout = (Button) findViewById(R.id.buttonDisconnect);
        buttonMenu = (Button) findViewById(R.id.buttonMenu);


        textViewEmail.setText("Bienvenue "+user.getEmail());

        //On relie le listener au bouton
        buttonLogout.setOnClickListener(this);
        buttonMenu.setOnClickListener(this);
    }}

    @Override
    public void onClick(View view) {

        if(view == buttonLogout){

            firebaseAuth.signOut();
            //l'activité est fermée
            finish();
            //On est renvoyé à login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(view == buttonMenu){
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    }





