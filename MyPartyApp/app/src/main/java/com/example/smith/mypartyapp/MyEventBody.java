package com.example.smith.mypartyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyEventBody extends AppCompatActivity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_event_body);

        final Button bInvitation = (Button) findViewById(R.id.bInvitation);
        final Button bVenue = (Button) findViewById(R.id.bVenue);
        final Button bSpecialContent = (Button) findViewById(R.id.bSpecialContent);
        final Button bAccept = (Button) findViewById(R.id.bAccept);
        final TextView LinklogO = (TextView) findViewById(R.id.tvME);

       // session = new Session(this);
       // if (!session.loggein())
     //   {
      //      session.setLoggedin(false);
    //        finish();
     //       Intent Out = new Intent(MyEventBody.this, Loging.class);
       //     startActivity(Out);
        //}

        // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Spinnerlist);
        //  MaterialBetterSpinner splog = (MaterialBetterSpinner) findViewById(R.id.spinner);
        //   splog.setAdapter(arrayAdapter);

        bInvitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MyEventBody.this,InvitationDetails.class);
                startActivity(i);

            }

        });

        bVenue.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        Intent VenueIntent = new Intent (MyEventBody.this, VenueDetails.class);
        MyEventBody.this.startActivity(VenueIntent);

         }

        });

        bSpecialContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent SpConIntent = new Intent (MyEventBody.this, SpecialContent.class);
                MyEventBody.this.startActivity(SpConIntent);

            }

        });

        bAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Accepted",Toast.LENGTH_SHORT).show();

                Intent AcceptIntent = new Intent(MyEventBody.this, BodyEvent.class);
                MyEventBody.this.startActivity(AcceptIntent);

            }

        });

        LinklogO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(MyEventBody.this, Loging.class);
                startActivity(Out);

            }
        });
    }
}
