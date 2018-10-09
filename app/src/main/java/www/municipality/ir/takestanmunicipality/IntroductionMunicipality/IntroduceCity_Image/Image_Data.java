package www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceCity_Image;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;

import www.municipality.ir.takestanmunicipality.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Image_Data extends Fragment {


    public Image_Data() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image__data, container, false);
        PhotoView photoView = view.findViewById(R.id.ImageData_Image);

        int value = getArguments().getInt("data");
        switch (value) {
            case 0:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.gaz));
                break;
            case 1:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.payankar));
                break;
            case 2:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.parvanehehdas));
                break;
            case 3:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.parvanetajdidbana));
                break;
            case 4:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.parvanegostaresh));
                break;
            case 5:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.tamdidparvaneh));
                break;
            case 6:
                photoView.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.adamkhalaf));
                break;
        }

        return view;
    }

}
