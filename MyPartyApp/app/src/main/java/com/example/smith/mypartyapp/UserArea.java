package com.example.smith.mypartyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_area);
        final EditText etEventID = (EditText) findViewById(R.id.etEventID);
        final EditText etGuestID = (EditText) findViewById(R.id.etGuestID);
        final Button bSummit = (Button) findViewById(R.id.bSummit);
        final TextView LinkOut = (TextView) findViewById(R.id.tvLogUA);
        //final TextView tvInfotxt = (TextView) findViewById(R.id.tvInfotxt);

        bSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String GuestID = etGuestID.getText().toString();
                final String EventID = etEventID.getText().toString();

                Intent Intent = new Intent (UserArea.this, MyEventBody.class);
                UserArea.this.startActivity(Intent);

            }

        });

        LinkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(UserArea.this, Loging.class);
                startActivity(Out);
            }
        });

    }
}
