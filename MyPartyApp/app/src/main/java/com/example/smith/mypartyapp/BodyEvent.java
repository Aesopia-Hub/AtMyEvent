package com.example.smith.mypartyapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class BodyEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_event);

        final Button bInvitation2 = (Button) findViewById(R.id.bInvite2);
        final Button bVenue2 = (Button) findViewById(R.id.bVD);
        final Button bSpecialContent2 = (Button) findViewById(R.id.bSC);
        final Button bSpeci = (Button) findViewById(R.id.bSCO);
        final TextView ReeLogO = (TextView) findViewById(R.id.tvMF);


        final MaterialBetterSpinner mySpinner = (MaterialBetterSpinner) findViewById(R.id.spStatus);
        mySpinner.setOnItemSelectedListener(this);

        mySpinner.setVisibility(View.VISIBLE);
        mySpinner.setHintTextColor(Color.WHITE);

        ArrayList<String> status = new ArrayList<String>();
        status.add("Checking In");
        status.add("On My Way");
        status.add("Can't Make It");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(BodyEvent.this, android.R.layout.simple_spinner_item, status);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


        bInvitation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "Fetching Invitation Details", Toast.LENGTH_SHORT).show();

                Intent I = new Intent(BodyEvent.this, InvitationDetails.class);
                startActivity(I);

            }

        });

        bVenue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent VenueIntent = new Intent(BodyEvent.this, VenueDetails.class);
                BodyEvent.this.startActivity(VenueIntent);

                Toast.makeText(getApplicationContext(), "Loading Details", Toast.LENGTH_SHORT).show();

            }

        });

        bSpecialContent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent SpConIntent = new Intent(BodyEvent.this, AddContent.class);
                BodyEvent.this.startActivity(SpConIntent);

                Toast.makeText(getApplicationContext(), "Fetching The Content", Toast.LENGTH_SHORT).show();

            }

        });

        bSpeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent SpeciConIntent = new Intent(BodyEvent.this, SpecialContent.class);
                BodyEvent.this.startActivity(SpeciConIntent);

                Toast.makeText(getApplicationContext(), "Fetching The Content", Toast.LENGTH_SHORT).show();

            }

        });

        ReeLogO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(BodyEvent.this, Loging.class);
                startActivity(Out);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();
        Intent i = null;

        if (item == "Checking In") {
            i = new Intent(BodyEvent.this, Loging.class);
            startActivity(i);
            finish();
        } else if (item == "On My Way") {
            i = new Intent(BodyEvent.this, Registration.class);
            startActivity(i);
            finish();
        }

        Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "Selected", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

}