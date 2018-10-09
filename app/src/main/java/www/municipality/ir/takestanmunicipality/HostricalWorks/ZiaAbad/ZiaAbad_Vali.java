package www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiaAbad_Vali extends Fragment {


    private ArrayList<Drawable> SliderArray = new ArrayList<Drawable>();
    private View view;
    private ViewPager mPager;
    private CircleIndicator indicator;
    private int currentPage = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_zia_abad__vali, container, false);
        mPager = view.findViewById(R.id.MarkaziVali_Pager);
        indicator = view.findViewById(R.id.MarkaziVali_Indigator);
//        textView = view.findViewById(R.id.TourismServices_Text);
//        textView.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.vali));
            }else if (i==1) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.vali_1));
            }else if (i==2) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.vali_2));
            } else if (i==3) {
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.vali_3));
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