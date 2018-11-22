package www.municipality.ir.takestanmunicipality.IntroduceCity.Maps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import www.municipality.ir.takestanmunicipality.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceCity_Maps_Online extends Fragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap mMap;

    public IntroduceCity_Maps_Online() {
        // Required empty public constructor
    }

    private WebView MapsOnline_WebView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_introduce_city__maps__online, container, false);
//
//        MapsOnline_WebView = view.findViewById(R.id.MapsOnline_WebView);
////        MapsOnline_WebView.loadUrl("http://www.google.com");
//
//        MapsOnline_WebView.getSettings().setLoadsImagesAutomatically(true);
//        MapsOnline_WebView.getSettings().setJavaScriptEnabled(true);
//        MapsOnline_WebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//
//        MapsOnline_WebView.loadUrl("http://137.takestancity.ir/access/android/map/index.html");



//        SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//


        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng takestan = new LatLng(36.06852, 49.69690);
        mMap.addMarker(new MarkerOptions().position(takestan).title("تاکستان"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(takestan,13));
    }
}
