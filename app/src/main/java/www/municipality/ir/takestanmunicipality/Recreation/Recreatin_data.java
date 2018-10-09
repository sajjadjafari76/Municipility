package www.municipality.ir.takestanmunicipality.Recreation;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.TourismServices.SliderAdapter;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recreatin_data extends Fragment {


    public Recreatin_data() {
        // Required empty public constructor
    }

    private ArrayList<Drawable> SliderArray = new ArrayList<Drawable>();
    private View view;
    private ViewPager mPager;
    private CircleIndicator indicator;
    private int currentPage = 0;
    private CustomTextView text;
//    private RelativeLayout introduceCityCelebration_View;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recreatin_data, container, false);
        mPager = view.findViewById(R.id.RecreationData_Pager);
        indicator = view.findViewById(R.id.RecreationData_Indicator);
        text = view.findViewById(R.id.RecreationData_Text);
//        introduceCityCelebration_View = view.findViewById(R.id.RecreationData_View);
//        textView = view.findViewById(R.id.TourismServices_Text);
//        textView.setTypeface(CFProvider.getIRANIANSANS(getActivity()));

        int data = getArguments().getInt("data");

        switch (data) {
            case 0:
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.parkjangli));
                text.setText("پارک جنگلی تاکستان به عنوان تنها تفرجگاه طبیعی مردم این شهر است که به همت اداره کل منابع طبیعی احداث شده اما برای توسعه آن مشارکت عمومی مردم و دستگاه های اجرایی را می طلبد.\n" +
                        "\n" +
                        "علی اکبر اسدالهی مدیر کل منابع طبیعی و آبخیزداری استان نیز ضمن اشاره به تاکیدات مقام معظم رهبری در خصوص اهمیت درختکاری گفت: معظم له بارها بر اهمیت منابع طبیعی تاکید داشته و فرموده اند «پیام من به همه مردم این است که درختکاری، ایجاد فضای سبز و حفاظت از محیط زیست حفظ جنگلها و دیگر منابع حیاتی کشور را یک وظیفه اسلامی، انقلابی، و وجدانی بشمارند» ایشان منابع طبیعی را از مباحث توسعه پایدار می دانند.\n" +
                        "اسدالهی با انتقاد از از برخی دستگاه ها در صیانت از منابع طبیعی و جلوگیری از تخریب عرصه های ملی بیان کرد: در جامعه ما برای جلوگیری از منکراتی مثل ربا خواری و اعتیاد و همچنین عفاف و حجاب کارهای فرهنگی زیادی انجام شده و خوشبختانه اثرات مثبت فراوانی داشته ولی متاسفانه برای جنگل خواری و زمین خواری و سایر مواردی که به حوزه منابع طبیعی و محیط زیست آسیب وارد می سازد کار فرهنگی موثری انجام نشده است.\n" +
                        "\n" +
                        "اگر جامعه به تخریب جنگلها و مراتع حساسیت نشان دهد کسی جرات تخریب منابع طبیعی را به خود نخواهد داد.\n" +
                        "اسدالهی با مثبت ارزیابی کردن نگاه حمایتی نماینده مردم تاکستان و همچنین فرماندار شهرستان از طرح های منابع طبیعی گفت: برای آبیاری پارک جنگلی شهدای تاکستان طرح های مختلفی را بررسی کرده ایم که به زودی طرح پیشنهادی خود را ارائه خواهیم کرد.\n");
                break;
            case 1:
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.paintball));
                text.setText("پینت بال یک نوع ورزش گروهی است که به طور کلی دو گروه از بازیکنان سعی در حذف یک دیگر با گلوله\u200Cهای رنگی می\u200Cکنند. پینت بال را می\u200Cشود در فارسی در قیاس با تیراندازی، رنگ\u200Cاندازی نامید. \n" +
                        "تجهیزات بازی رنگ\u200Cاندازی به نوع بازی بستگی دارند به عنوان مثال وودبال اسپیدبال یا سناریوبال و همین طور به میزان پولی که قرار است برای تجهیزات خرج شود. به هر حال هر بازیکن سه وسیلهٔ اصلی را باید داشته\u200C باشد. تفنگ تیراندازی، توپ\u200Cهای رنگی و عینک یا کلاه محافظ\n" +
                        "\n" +
                        "پینت بال یک ورزش گروهی است لذا جهت حضور در یک سانس نیازمند حداقل نفرات (6 نفر تا حداکثر 12 نفر) می\u200Cباشید، هزینه ورودی سانس برای هر نفر (شامل 10,000 تومان ورودی به همراه 16,000 تومان برای 80 عدد تیر) به مبلغ 26,000 تومان می\u200Cباشد که با 20% تخفیف به مبلغ 21,000 تومان فروخته می\u200Cشود. زمان هر سانس 2 ساعت می\u200Cباشد. در صورتی که در حین بازی به توپ\u200Cهای بیشتر نیاز داشتید می\u200Cتوانید از محل باشگاه اقدام به تهیه توپ های اضافی بکنید.\n");
                break;
            case 2:
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.sinama));
                text.setText("سال 80 بود که به دلیل حمایت نکردن بخش دولتی و استقبال کم مردم تنها سینمای این شهرستان تعطیل شد.\n" +
                        "\n" +
                        "این سینمای خصوصی این روزها در شلوغی سمساری ها و فروشگاه های لوازم خانگی گم و به انبار کشمش تبدیل شده است، اما مردم هنوز خیابان آیت اله طالقانی تاکستان را به نام خیابان سینما می شناسند.\n" +
                        "\n" +
                        "در طول این سالها مجبور بودند برای  تماشای فیلم به سینماهای قزوین بروند که خود مستلزم صرف هزینه و وقت است.\n" +
                        "\n" +
                        "و حالا بعد از 15 سال سینمای تاکستان در مجتمع فرهنگی امام علی(ع) این شهر افتتاح شد.\n" +
                        "\n" +
                        "رییس اداره فرهنگ و ارشاد اسلامی شهرستان تاکستان گفت : در جلسه کمسیون بند 5 تجهیز سینماها مقرر شد سینمای این شهر از مزایای طرح تجهیز سینما بهره مند شود.\n" +
                        "\n" +
                        "طاهرخانی افزود: تاکستان در زمره 65 شهر مورد تایید وزارت فرهنگ و ارشاد وسازمان سینمایی برای استفاده از این طرح اعلام شده است.\n" +
                        "\n" +
                        "وی گفت:با استفاده از مزایای این طرح سالن آمفی تئاتر مجتمع فرهنگی و هنری امام علی (ع) به پرده عریض،صدای دالبی و سیستم رمزخوان تجهیز شده است ودر کنار نمایش تئاتر برای علاقه مندان ، فیلمهای سینمایی را هم نمایش میدهد. .\n");
                break;
            case 3:
                SliderArray.add(ContextCompat.getDrawable(getActivity(), R.drawable.shahrbazi));
                text.setText("شهر بازی تاکستان پارکی است که از وسایل سرگرمی و تفریحی و همچنین سواری برای سرگرم کردن گروه بزرگی از مردم تشکیل شده\u200Cاست که نسبت به پارک\u200Cهای ساده یا زمین\u200Cهای بازی داخل شهری، امکانات سرگرم کنندهٔ بیشتری دارند.\n" +
                        "به\u200Cطور کلی ۲ نوع شهربازی وجود دارد: شهر بازی سرپوشیده و سر باز که در شهر بازی\u200Cهای سرپوشیده دستگاه\u200Cهای الکترونیکی و رایانه\u200Cای موجود می\u200Cباشد.\n" +
                        "شهربازی تاکستان مجموعه\u200Cای از مسیرهای گردشگری و دیگر سرگرمی\u200Cها است  که با هدف گرد هم آوردن گروه کثیری از مردم  تاکستان کنار هم چیده شده\u200Cاند. این پارک\u200Cها حول محور های مختلف برای سرگرمی مردم تاکستان در ورودی شهر از سمت زنجان به تاکستان ساخته شده است.\n" +
                        "\n");
                break;
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
