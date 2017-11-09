package com.example.smith.mypartyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EventRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_registration);

        final EditText etEventID = (EditText) findViewById(R.id.etEventID);
        final EditText etGuestCode = (EditText) findViewById(R.id.etGuestCode);
        final Button bSubmit = (Button) findViewById(R.id.bSubmit);
        // final TextView etInvite = (TextView) findViewById(R.id.etInvite);
        final TextView LiinkLog = (TextView) findViewById(R.id.tvER);

        LiinkLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(EventRegistration.this, Loging.class);
                startActivity(Out);
            }
        });


    }
}
