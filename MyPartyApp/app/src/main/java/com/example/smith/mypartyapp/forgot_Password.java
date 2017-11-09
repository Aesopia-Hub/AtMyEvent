package com.example.smith.mypartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Smith on 2017/10/21.
 */

public class forgot_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        final TextView Mforgot = (TextView) findViewById(R.id.tvMessage);
        final TextView mail = (EditText)findViewById(R.id.etMail);
        final Button reset = (Button) findViewById(R.id.bReset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplication(), "Sending Mail...Please Wait!!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(forgot_Password.this,Loging.class));
            }
        });


    }
}
