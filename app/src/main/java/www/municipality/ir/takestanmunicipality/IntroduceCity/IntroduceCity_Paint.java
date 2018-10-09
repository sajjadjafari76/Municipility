package www.municipality.ir.takestanmunicipality.IntroduceCity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceCity_Paint extends Fragment {


    public IntroduceCity_Paint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_introduce_city__paint, container, false);

//        PhotoView photoView = view.findViewById(R.id.IntroduceCity_Paint);
//        photoView.setImageResource(R.drawable.paint);
//        photoView.setScaleType(ImageView.ScaleType.FIT_XY);

        CustomTextView customTextView = view.findViewById(R.id.IntroduceCityPaint_Text);

        customTextView.setText("نقاش و جهانگرد فرانسوی، اوژن فلاندن، در ۱۲۵۷/۱۸۴۱ از تاکستان امروزی، که در آن زمان سیاهْ دُهُن، نامیده می\u200Cشد، دیدن کرده و این بنا را توصیف و تصویری از آن کشیده است. \n" +
                "بقعه پیر در آن هنگام، در کنار ده، بنایی عظیم با تزییناتی از آجرهای کوچک با حجمهای مختلف بوده که کنگره و گیلوییهایش روی هم واقع شده بوده و تنها درِ آن، براثر آوار زیاد، بسته بوده است. \n" +
                "این بنای بشدت آسیب دیده، محوطه\u200Cای مربع با گنبدی کشیده داشته و به گفته فلاندن،  طرح بنا به سبک هندی و از دوره مغول بوده است. \n" +
                "او در نقاشی خود، بنا را عظیم نشان داده است.  \n" +
                "سرپایه های اصلی، یک آجره و سایر پس نشینها یک نیمه است. \n" +
                "درِ چوبی بقعه، حدود ۲۰۰ در ۱۰۰ سانتیمتر و دارای کتیبه ای است که میله های آهنی از آن محافظت می\u200Cکند. \n" +
                "بالای در نعل درگاه چوبی و سپس تیغه آجری سبب استقرار سرچهارکه کشیِ افقی شده است. \n" +
                "چهار رگ بالای سرچهارکه افقی، زمینه کتیبه گودی را به وجود آورده است. ");

        return view;
    }

}
