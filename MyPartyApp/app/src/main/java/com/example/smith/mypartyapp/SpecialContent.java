package com.example.smith.mypartyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class SpecialContent extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_content);

        final TextView LocLo = (TextView) findViewById(R.id.textView);

        pdfView = (PDFView) findViewById(R.id.pdfView1);
        pdfView.fromAsset("blank2.pdf").load();

        pdfView = (PDFView) findViewById(R.id.pdfView2);
        pdfView.fromAsset("blank.pdf").load();




        LocLo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(SpecialContent.this, Loging.class);
                startActivity(Out);
            }
        });
    }
}


