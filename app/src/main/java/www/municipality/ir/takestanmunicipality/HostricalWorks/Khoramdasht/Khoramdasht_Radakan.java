package www.municipality.ir.takestanmunicipality.HostricalWorks.Khoramdasht;


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
import www.municipality.ir.takestanmunicipality.TourismServices.SliderAdapter;

public class Khoramdasht_Radakan extends Fragment {


    private ArrayList<Drawable> SliderArray = new ArrayList<>();
    private ViewPager mPager;
    private CircleIndicator indicator;
    private  int currentPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_khoramdasht__radakan, container, false);
        mPager = view.findViewById(R.id.KhoramdashtRadakan_Pager);
        indicator = view.findViewById(R.id.KhoramdashtRadakan_Indigator);
//        textView = view.findViewById(R.id.TourismServices_Text);
//        textView.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        for (int i = 0; i <5 ; i++) {
            if (i == 0) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.radakan));
            }else if (i == 1) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.radakan_1));
            }else if (i == 2) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(),R.drawable.radakan_2));
            }
        }

        ImageSlider();

        return view;
    }

    public void ImageSlider() {

        if (SliderArray.size() != 0) {
            mPager.setAdapter(new SliderAdapter(getActivity(), SliderArray));
            indicator.setViewPager(mPager);


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
