package com.medipro.Fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.medipro.MenuActivity;
import com.medipro.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorDetailsFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener {
    View view;
    ImageView ivBack,ivShare;
   // TextView tvCallDoctor;
    LatLng dip = new LatLng(12.555, 77.45);
    GoogleMap myMap;
    MapView mMapView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_doctor_details, container, false);
        MenuActivity.llTopBar.setVisibility(View.GONE);
        mMapView=(MapView)view.findViewById(R.id.map);
        ivBack=(ImageView)view.findViewById(R.id.iv_back);
        ivShare=(ImageView)view.findViewById(R.id.iv_share);
       // tvCallDoctor=(TextView)view.findViewById(R.id.tv_call_doctor);
        try {
           // rootView = inflater.inflate(R.layout.fragment, container, false);
            MapsInitializer.initialize(this.getActivity());
          //  mMapView = (MapView)View.findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);
        }
        catch (InflateException e){
            Log.e("TAG", "Inflate exception");
        }

        onClick();
//        SupportMapFragment map = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.fragment);
//        map.getMapAsync(this);

        return view;

    }
    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState); mMapView.onSaveInstanceState(outState);
    }
    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(dip).title("Marathahalli").icon(BitmapDescriptorFactory.defaultMarker()));
        CameraPosition cameraPosition=new CameraPosition(dip,20,15,20);
//        tilt-directly facing the Earth
//        bearing-Direction that the camera is pointing in, in degrees clockwise from north.
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
    }
    private void onClick() {
        ivBack.setOnClickListener(this);
        ivShare.setOnClickListener(this);
       // tvCallDoctor.setOnClickListener(this);
//        ivBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getFragmentManager().popBackStack();
//            }
//        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.iv_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String SharingBody ="Sharing Body";
                String SharingSub ="Sharing Sub";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,SharingSub);
                sharingIntent.putExtra(Intent.EXTRA_TEXT,SharingBody);
                startActivity(Intent.createChooser(sharingIntent,"Share via"));

        }

        }

    }

