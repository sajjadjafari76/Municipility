package www.municipality.ir.takestanmunicipality.TourismServices;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import www.municipality.ir.takestanmunicipality.R;

public class SliderAdapter extends PagerAdapter {

    private ArrayList<Drawable> images;
    private LayoutInflater inflater;
    private Context context;

    public SliderAdapter(Context context, ArrayList<Drawable> images) {
        Log.e("sajjadjadapter", images.toString()+ " /");
        this.context = context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.custom_slider, view, false);
        ImageView myImage = (ImageView) myImageLayout
                .findViewById(R.id.image);
//        myImage.set(images.get(position));

        Log.e("sajjadj", images.get(position) + " |");
//        Picasso.with(context).load(ApiURLImage + images.get(position))
//                .fit()
//                .into(myImage);
        myImage.setImageDrawable(images.get(position));

        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
