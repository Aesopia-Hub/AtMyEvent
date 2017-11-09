package com.example.smith.mypartyapp;

import android.app.Dialog;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class VenueDetails extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (googleServicesAvailable()) {
            Toast.makeText(this, "Ready TO Map!", Toast.LENGTH_LONG).show();
            setContentView(R.layout.fragment);
            initMap();
        }else
        {
            //No Google Maps Layout
        }

    }

    private void initMap() {

        MapFragment mapfragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapfragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable() {

        GoogleApiAvailability Api = GoogleApiAvailability.getInstance();
        int isAvailable = Api.isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (Api.isUserResolvableError(isAvailable)) {
            Dialog dialog = Api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Can't connect to Google Play Service", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;
        goToLocationZoom(-25.856385, 28.188744,15);
    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mGoogleMap.moveCamera(update);
    }
    private void goToLocationZoom(double lat, double lng,float zoom) {
        LatLng ll = new LatLng(lat,lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,zoom);
        mGoogleMap.moveCamera(update);
    }

    public void geoLocate (View view) throws IOException {

        EditText et = (EditText) findViewById(R.id.editText);
        String location = et.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location,1);
        Address address = list.get(0);
        String locality = address.getLocality();


        Toast.makeText(this,locality,Toast.LENGTH_LONG).show();

        double lat = address.getLatitude();
        double lng = address.getLongitude();
        goToLocationZoom(lat,lng,15);

    }

    //@Override
    //public void onMapReady(GoogleMap googleMap) {
    //    mMap = googleMap;
   // }

  //  @Override
  //  public void onDestroy() {
  //      super.onDestroy();
  //      mMapView.onDestroy();
  //  }

 //   @Override
 //   public void onLowMemory() {
  //      super.onLowMemory();
 //      mMapView.onLowMemory();
 //   }

   // @Override
    //public void onPause() {
      //  super.onPause();
        //mMapView.onPause();
    //}

    //@Override
    //public void onResume() {
      //  super.onResume();
        //mMapView.onResume();
    //}

//    @Override
  //  public void onSaveInstanceState(Bundle outState) {
    //    super.onSaveInstanceState(outState);
      //  mMapView.onSaveInstanceState(outState);
//    }
}
