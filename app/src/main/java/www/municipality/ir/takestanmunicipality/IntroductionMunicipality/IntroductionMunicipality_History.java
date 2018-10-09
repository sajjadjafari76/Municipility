package www.municipality.ir.takestanmunicipality.IntroductionMunicipality;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionMunicipality_History extends Fragment {


    public IntroductionMunicipality_History() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_introduction_municipality__history, container, false);

        CustomTextView customTextView = view.findViewById(R.id.IntroductionMunicipilityHistory_Text);

        customTextView.setText("در سال 1316  خورشیدی همزمان با تشکیل بخش های کشور ،بخشی نیز شامل تاکستان و ضیاء آباد تحت عنوان بخش ضیاء آباد در ضیاءآباد تشکیل گردید.  درسال 1317 به دلیل فراوانی باغ های انگور  و تنوع گونه های آن ،به دستور رضاشاه و به همت فرهنگستان زبان ،نام آن از  سیادن siyaden به  تاکستان Takestan  یعنی شهر انگور Grape City  تغییر یافت.دوسال پس شکل گیری بخشداری،دفتر بخشداری مرکزی به دلایلی چند به تاکستان منتقل گردید. \n" +
                "تاکستان  درسال 1337 خورشیدی دارای شهرداری شد .در سال 1341 رسما نام بخش ازضیاءآباد به تاکستان تغییر داده شدو در سال1359 نام بخشداری مزبور به بخشداری مرکزی تاکستان نامور گردید و در همین سال از شهرستان قزوین جدا شد و شهرستان تاکستان شکل گرفت.\n" +
                " نام کهن  و قدیمی این شهر در متون کهن از جمله کتیبه پئوتین گرایا که به زبان یونانی قدیم است و اکنون در موزه شهر وین کشور اتریش نگهداری می شود و به دوره هخامنشیان تعلق دارد، سیادن siyaden  ذکر شده است .  \n");

        return view;
    }

}
