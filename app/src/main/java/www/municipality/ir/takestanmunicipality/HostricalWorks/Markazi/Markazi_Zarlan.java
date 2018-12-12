package www.municipality.ir.takestanmunicipality.HostricalWorks.Markazi;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
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
import www.municipality.ir.takestanmunicipality.TourismServices.SliderAdapter;

public class Markazi_Zarlan extends Fragment {



    private ArrayList<Drawable> SliderArray = new ArrayList<>();
    private ViewPager mPager;
    private CircleIndicator indicator;
    private  int currentPage = 0;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_markazi__zarlan, container, false);
        mPager = view.findViewById(R.id.MarkaziZarlan_Pager);
        indicator = view.findViewById(R.id.MarkaziZarlan_Indigator);
//        textView = view.findViewById(R.id.TourismServices_Text);
//        textView.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        for (int i = 0; i <3 ; i++) {
            if (i == 0) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.zarlan));
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
