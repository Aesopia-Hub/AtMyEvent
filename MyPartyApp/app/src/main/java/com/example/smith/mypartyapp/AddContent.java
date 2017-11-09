package com.example.smith.mypartyapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

public class AddContent extends AppCompatActivity {
    private static final int IMAGE_GALLERY_REQUEST = 20;
    private static final int VIDEO_GALLERY_REQUEST = 20;

    ImageView imPic;
    Uri outPutfileUri;

    public static final int CAM_REQUEST = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    private TextView resultText;

    private final int VIDEO_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_content);

        final Button imageGall = (Button) findViewById(R.id.bAlbum);
        final Button Viewguest = (Button) findViewById(R.id.bViewGuest);
        final Button Chat = (Button) findViewById(R.id.bInbox);
        final Button bLogout = (Button) findViewById(R.id.bLogOut);
        final Button bCamera = (Button) findViewById(R.id.bCam);
        final Button bVideo = (Button) findViewById(R.id.bVid);
        final Button bVoice = (Button) findViewById(R.id.bNote);
        //final TextView resultText = (TextView) findViewById(R.id.tvAddCon);

        resultText = (TextView) findViewById(R.id.tvAddCon);
        // final MaterialBetterSpinner addC = (MaterialBetterSpinner) findViewById(R.id.spIVS);

        // ArrayAdapter<String> myMenu = new ArrayAdapter<String>(AddContentActivity.this, android.R.layout.simple_spinner_item, specialMenu);
        // myMenu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //addC.setAdapter(myMenu);

        Viewguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Opening...", Toast.LENGTH_SHORT).show();

                Intent guestIntent = new Intent(AddContent.this,UsersListActivity.class);
                startActivity(guestIntent);

            }
        });

        // Album.setOnClickListener(new View.OnClickListener() {
        //  @Override
        // public void onClick(View v) {

        // Toast.makeText(getApplicationContext(), "Still in Process", Toast.LENGTH_SHORT).show();


        //   }
        // });

        Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "....Opening Chat", Toast.LENGTH_SHORT).show();

                Intent chatIntent = new Intent(AddContent.this,Chat.class);
                startActivity(chatIntent);


            }
        });

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();

                Intent Out = new Intent(AddContent.this, Loging.class);
                startActivity(Out);
            }


        });

        bCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Opening Camera", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File(Environment.getExternalStorageDirectory(),
                        "MyPhoto.jpg");
                outPutfileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutfileUri);
                startActivityForResult(intent, REQUEST_TAKE_PHOTO);
            }

        });

        //bVideo.setOnClickListener(new View.OnClickListener() {
        //  @Override
        // public void onClick(View v) {

        //   Toast.makeText(getApplicationContext(), "Opening Video", Toast.LENGTH_LONG).show();
        // }
        //  });

        // bVoice.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //      public void onClick(View v) {

        //       Toast.makeText(getApplicationContext(), "Opening Voice Recorder", Toast.LENGTH_LONG).show();
        //   }
        // });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        {
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
                Toast.makeText(this, outPutfileUri.toString(), Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == VIDEO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                Toast.makeText(getApplicationContext(), "Video Successfully Recorded!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onButtonClick(View view) {

        Toast.makeText(getApplicationContext(), "Opening a recorder", Toast.LENGTH_LONG).show();

        if (view.getId() == R.id.bNote) {

            promptSpeechInput();

        }
    }

    private void promptSpeechInput() {

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say Something!");

        try {
            startActivityForResult(i, 100);
        }
        catch (ActivityNotFoundException a)
        {
            Toast.makeText(AddContent.this,"Sorry! Your device doesn't support speech language!",Toast.LENGTH_LONG).show();
        }

    }

    public void onActivityResults(int request_code, int results_code, Intent i)
    {
        super.onActivityResult(request_code, results_code,i);

        switch (request_code)
        {
            case 100 : if (results_code == RESULT_OK && i !=null)
            {

                ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                resultText.setText(result.get(0));
            }
                break;
        }
    }
    public void onVideoButton (View view){

        Toast.makeText(getApplicationContext(), "Opening Video", Toast.LENGTH_LONG).show();

        Intent video_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file = getFilepath();
        Uri video_uri = Uri.fromFile(video_file);
        video_intent.putExtra(MediaStore.EXTRA_OUTPUT, video_uri);
        video_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(video_intent,VIDEO_REQUEST_CODE);


    }

    public File getFilepath(){

        File folder = new File("SDCARD/Video_App");
        if (!folder.exists())
        {
            folder.mkdir();
        }

        File video_file = new File(folder,"sample_video.mp4");

        return video_file;
    }

    public void onImageGallery(View view){

        Toast.makeText(getApplicationContext(), "....Opening Gallery!!!", Toast.LENGTH_SHORT).show();

        Intent PhotoPickerIntent = new Intent(Intent.ACTION_PICK);

        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath  = pictureDirectory.getPath();

        Uri data = Uri.parse(pictureDirectoryPath);

        PhotoPickerIntent.setDataAndType(data, "image/*");

        startActivityForResult(PhotoPickerIntent,IMAGE_GALLERY_REQUEST);

    }
    public void onVideoGallery(View view){

        Toast.makeText(getApplicationContext(), "....Opening Gallery!!!", Toast.LENGTH_SHORT).show();

        Intent VideoPickerIntent = new Intent(Intent.ACTION_PICK);

        File videoDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        String videoDirectoryPath = videoDirectory.getPath();

        Uri data = Uri.parse(videoDirectoryPath);

        VideoPickerIntent.setDataAndType(data, "video/*");

        startActivityForResult(VideoPickerIntent,VIDEO_GALLERY_REQUEST);
    }
}
