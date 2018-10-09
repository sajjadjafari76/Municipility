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
public class IntroductionMunicipility_Program extends Fragment {


    public IntroductionMunicipility_Program() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introduction_municipility__program, container, false);

        CustomTextView textView = view.findViewById(R.id.IntroductionMunicipalityProgram_Text);

        textView.setText("\uD83D\uDC48توجه به حاشیه نشینی \n" +
                "\uD83D\uDC48جمع آوری آبهای سطحی \n" +
                "\uD83D\uDC48تسهیل در برقراری ارتباط بین بافت شهری و بالای کمربندی \n" +
                "\uD83D\uDC48درامدزایی پایدار \n" +
                "\uD83D\uDC48احیاء و بازآفرینی بافت فرسوده \n" +
                "\uD83D\uDC48احداث پارکهای تخصصی با محوریت بانوان-سالمندان -دانشجویان -پارک پرواز - پارک علمی - پارک تحقیقات داروئی با توجه به فراوانی گونه های گیاهی - پارک انگور - پارک خانواده - پارک ترافیک ، پارک گل و گیاه و...\n" +
                "\uD83D\uDC48استفاده از پتانسیل های موجود در بخش خصوصی \n" +
                "\uD83D\uDC48رفع معضلات عبور ریل راه آهن و کاهش اختلاف شمال و جنوب راه آهن \n" +
                "\uD83D\uDC48احداث کمربند جنوبی\n" +
                "\uD83D\uDC48توسعه ارتباط الکترونیکی و سامانه اداری\n" +
                "\uD83D\uDC48ایجاد بازارچه های روز در مراکز محلی\n" +
                "\uD83D\uDC48جذب بخش خصوصی جهت سرمایه گذاری در پارک جنگلی \n" +
                "\uD83D\uDC48 ساماندهی تابلوهای تبلیغاتی و راهنمای شهری \n" +
                "\uD83D\uDC48فراهم کردن ناوگان حمل و نقل عمومی ارزان \n" +
                "\uD83D\uDC48توجه به سیما و منظر شهری \n" +
                "\uD83D\uDC48تمرکز بر معرفی انگور از طریق کاشت درخت در معابر و ساخت نماد \n" +
                "\uD83D\uDC48ساماندهی عوامل سد معبر و مشاغل مزاحم \n" +
                "\uD83D\uDC48توسعه فرهنگ ترافیک و تردد \n" +
                "\uD83D\uDC48جذب توریست با استفاده از ظرفیت منطقه توریستی باشگول و مزرعه بادی کهک \n" +
                "\uD83D\uDC48 ارتقای ورزش همگانی و توسعه فضای شهری\n");

        return view;
    }

}
