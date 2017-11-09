package com.example.smith.mypartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener{
    private Button Register;
    private EditText Event_ID,Username,Email,Password,Confirm_password;
    private DbHelper db;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);


        db = new DbHelper(this);
        session = new Session(this);

        Event_ID = (EditText) findViewById(R.id.etEventID);
        Username = (EditText) findViewById(R.id.etUsername);
        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        Confirm_password = (EditText)findViewById(R.id.etConfirmP);
        Register = (Button) findViewById(R.id.bRegister);

        Register.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bRegister:
                register();
                break;
            default:
        }
    }

    public void register (){
        String eventid = Event_ID.getText().toString();
        String username = Username.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String confirm_password = Confirm_password.getText().toString();

        if (eventid.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill In the empty fields",Toast.LENGTH_LONG).show();
        }else if (!password.contentEquals(confirm_password)){
            Toast.makeText(getApplicationContext(),"Password Does Not Match",Toast.LENGTH_LONG).show();
        }else{
        db.addUser(eventid,username,email,password,confirm_password);
        Toast.makeText(getApplicationContext(),"User Registered Successfully!!",Toast.LENGTH_LONG).show();

        startActivity(new Intent(Registration.this,Loging.class));
        }
    }
}