package www.municipality.ir.takestanmunicipality.IntroduceCity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;


public class IntroduceCity_History extends Fragment {


    public IntroduceCity_History() {
        // Required empty public constructor
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce_city__history, container, false);

//        JustifiedTextView content = view.findViewById(R.id.IntroduceCityHistory_Content);
//        content.setTypeface(CFProvider.getIRANIANSANS(getActivity()));

        return view;
    }

}
