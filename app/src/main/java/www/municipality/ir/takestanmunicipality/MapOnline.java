package www.municipality.ir.takestanmunicipality;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.auth0.jwt.algorithms.Algorithm;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class MapOnline extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_online);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        //HMAC
//        Algorithm algorithmHS = Algorithm.HMAC256("secret");
//
////RSA
//        RSAPublicKey publicKey = algorithmHS.getSigningKeyId();//Get the key instance
//                RSAPrivateKey privateKey = //Get the key instance
//                Algorithm algorithmRS = Algorithm.RSA256(publicKey, privateKey);

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
