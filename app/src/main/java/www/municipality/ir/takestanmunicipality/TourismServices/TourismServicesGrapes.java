package www.municipality.ir.takestanmunicipality.TourismServices;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import www.municipality.ir.takestanmunicipality.R;


public class TourismServicesGrapes extends Fragment {


    public TourismServicesGrapes() {
        // Required empty public constructor
    }

    private ArrayList<Drawable> SliderArray = new ArrayList<Drawable>();
    private View view;
    private ViewPager mPager;
    private CircleIndicator indicator;
    private  int currentPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tourism_services_grapes, container, false);
        mPager = view.findViewById(R.id.TourismServicesGrapes_Pager);
        indicator = view.findViewById(R.id.TourismServicesGrapes_Indicator);
//        textView = view.findViewById(R.id.TourismServices_Text);
//        textView.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        for (int i = 0; i <3 ; i++) {
            if (i == 0) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.grapes));
            }else if (i == 1) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.grapes_1));
            }
        }

        ImageSlider();

        return view;

    }


    public void ImageSlider() {

        if (SliderArray.size() != 0) {
            mPager.setAdapter(new SliderAdapter(getActivity(), SliderArray));
            indicator.setViewPager(mPager);


            // Auto start of viewpager
            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == SliderArray.size()) {
                        currentPage = 0;
                    }
                    mPager.setCurrentItem(currentPage++, true);
                }
            };
            Timer swipeTimer = new Timer();
            swipeTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(Update);
                }
            }, 2000, 2500);
        }

    }


}
