package com.example.smith.mypartyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Loging extends AppCompatActivity implements View.OnClickListener{
    private Button login, twitter,facebook;
    private EditText Password,Username;
    private TextView Follow,Register,ForgotPass,Logintxt;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loging);


        db = new DbHelper(this);
        session = new Session(this);

        login = (Button) findViewById(R.id.bLogin);
        twitter = (Button) findViewById(R.id.btwtr);
        facebook =(Button)findViewById(R.id.bfb);
        Password =(EditText) findViewById(R.id.etPassword);
        Username = (EditText) findViewById(R.id.etUsername);
        Register = (TextView) findViewById(R.id.tvRegiseterHere);
        Follow = (TextView)findViewById(R.id.etFollow);
        ForgotPass = (TextView) findViewById(R.id.etForgotPass);
        Logintxt = (TextView) findViewById(R.id.tvLogintxt);

        login.setOnClickListener(this);
        twitter.setOnClickListener(this);
        facebook.setOnClickListener(this);
        Register.setOnClickListener(this);
        ForgotPass.setOnClickListener(this);

      //  if (session.loggein()){
       //     startActivity(new Intent(Loging.this,MyEventBody.class));
     //       finish();
   //     }


       }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bLogin:
                login();
                break;

            case R.id.tvRegiseterHere:
                startActivity(new Intent(Loging.this,Registration.class));
                finish();
                break;

            case R.id.etForgotPass:
                startActivity(new Intent(Loging.this,forgot_Password.class));
                finish();
                break;

            case R.id.btwtr:
                Toast.makeText(getApplicationContext(), "....Underconstruction...!!!", Toast.LENGTH_SHORT).show();
                break;


            case R.id.bfb:
                Toast.makeText(getApplicationContext(), "....Underconstruction...!!!", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
    }

    private void login() {
            String username = Username.getText().toString();
            String password = Password.getText().toString();

            if (db.checkUser(username,password)){
                session.setLoggedin(true);
                startActivity(new Intent(Loging.this,MyEventBody.class));
                finish();
            }else {
                Toast.makeText(getApplicationContext(),"Wrong Username/Password",Toast.LENGTH_LONG).show();
            }
    }

}
