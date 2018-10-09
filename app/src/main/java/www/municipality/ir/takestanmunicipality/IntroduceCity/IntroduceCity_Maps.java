package www.municipality.ir.takestanmunicipality.IntroduceCity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import www.municipality.ir.takestanmunicipality.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceCity_Maps extends Fragment {


    public IntroduceCity_Maps() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduce_city__maps, container, false);

        PhotoView photoView = (PhotoView)view.findViewById(R.id.IntroduceCityMaps_Image);
        photoView.setImageResource(R.drawable.map_image);
        photoView.setScaleType(ImageView.ScaleType.FIT_XY);

        return view;
    }

}
