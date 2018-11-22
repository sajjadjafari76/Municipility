package www.municipality.ir.takestanmunicipality.IntroduceCity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import www.municipality.ir.takestanmunicipality.Globals;
import www.municipality.ir.takestanmunicipality.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceCity_Maps_Online extends Fragment {


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
        return view;
    }

}
