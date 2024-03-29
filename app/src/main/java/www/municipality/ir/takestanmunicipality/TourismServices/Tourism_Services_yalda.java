package www.municipality.ir.takestanmunicipality.TourismServices;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;


public class Tourism_Services_yalda extends Fragment {


    public Tourism_Services_yalda() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tourism__services_yalda, container, false);

        CustomTextView TourismServices_Content = view.findViewById(R.id.TourismServices_Content);

        TourismServices_Content.setText("شب یلدا از بلند ترین شب های سال است.شب یلدا یا همان شب چله در تمامی کشورهای نیم کره شمالی ،به ویژه  در ایران زمین جشنی برگذار می شود که به جشن شب یلدا مشهور است. شب یلدا با نبرد سپیدی وسیاهی ،دگرگونی زمستانی همراه است .از این پس روزها بلند تر وشب ها کوتاهتر می گردد.\n" +
                "شب یلدا نماد پیروزی نور،روشنایی،دانایی بر تاریکی ،سیاهی ونادانی است . این رسم باستانی است .مردم روزگاران گذشته  به مرور زمان وبه تجربه آموخته بودند\n" +
                "\n" +
                "که از روز های پس ار شب چله نور وروشنی خورشید فروزان بیشتر شده وکشاورزی رونق بیشتری می یابد.بنابراین خورشید را نماد نیک دانستند که با تاریکی و\n" +
                "ظلمت شب درنبرداست .پس آن را شب زایش خورشید نامیدند.به همین خاطر در فرهنگ اوستایی سال با فصل سرد آغاز میگردد و واژه sareda در زبان اوستایی که مفهوم سال را میرساند، در اصل به معنای سرد است. ابوریحان بیرونی درآثارالباقیه روز اول دی را (خور) می نامد.مسعودی نیز در کتاب قانون خود،نسخه موزه بریتانیا،واژه ی(خوره روز)  را آورده است .در برخی منابع هم واژه ی(خرم روز) آمده است.\n" +
                "\n" +
                "یلدا به معنای زایش است ، زایش خورشید ( مهر ، میترا ) ابوریجان بیرونی از جشن زایش خورشید یاد می کند  تاریکی نماینده اهریمن بوده است و چون  در طولانی ترین شب سال تاریکی اهریمنی شب بیشتر می شود این شب برای ایرانیان باستان  بدشگون بود و چون فرا می رسید آتش می افروختند تا تاریکی  و اهریمن نابود گردد  مردم دور هم جمع شده و شب را  با خوردن، نوشیدن ،شادی، پای کوبی و گفت گو به سر می بردند . سفره ای گسترده می شد و میوه های تازه فصل و برخی از میوه های خشک در آنان قرار داده می شد.\n" +
                "\n" +
                " در تاکستان  در همه ی دوره های تاریخی   بیشتر  واژه شب چله ، چله نشینی  به کار می رفته است که مقصود همان شب یلدا است  در این شب  فرزندان  و نوه ها و بستگان نزدیک به خانه بزرگ تر ها ، پدر بزرگ ها و مادر بزرگ ها می رفتند و پای کرسی دور هم جمع می شدند.  صاحب خانه  با چای  کشمش ، بادام ، گردو ، و میوه های فصل از میهمانان پذیرایی می کرد  مهمانان تا پاسی از شب می نشستند و به داستان ها و نقل های  بزرگتر ها  گوش فرا می دادند .گاهی  افراد با سواد شاهنامه خوانی می کردند. معمولا در دیگر شب های زمستانی هم جمع شدن در خانه بزرگ تر ها و شنیدن  نقل ها  حداقل در هفته 1 بار صورت می گرفت . \n" +
                "\n" +
                "تازه داماد ها به همراه هدیه  یا خونچه  که شامل: پارچه ،جواهر،کله قند و چند نوع میوه که گاهی به هفت نوع می رسید، از جمله گلابی ، هنداونه ، سیب و .... به خانه عروس می رفتند آجیل شب یلدا را  کشمش،بادام ، گردو ، قیسی ، برگه زد آلو ، برگه گلابی ، انجیر و خرما  تشکیل می داد  و میوه شب یلدا ، انار، هندوانه ، سیب ، و ... بود . نوشیدنی معمول   را چای ، شربت ، و اگر برف  بود  واره دوشا تشکیل می داد. واره دوشا ترکیبی از  برف تازه و تمیز و شیره انگور است ، که پس از مخلوط کردن به مصرف می رساندند غذای شب یلدا پلو و خورش قابلی ( خورشت قیمه ) \n" +
                "کوفته ، .... بود. در گذشته برخی از مردم ایران زمین  و  از جمله تاکستان  بر این باور بودند که  هندوانه شب چله حتما  باید فراهم شود  زیرا معتقد بودند  که هر کس در شب چله هندوانه بخورد  ، در فصل تابستان احساس تشنگی نمی کند ! .شب چره ( شب چرست ) اصطلاحی در زبان تاتی است  و منظور از آن  میوه های خشک و تر  و میوه های سرخ فام  می باشد که همراه دیگر خوارکی ها به مصرف می رسد و دارای شکون است و مصرف آن زمستان پر  برکت را نوید می دهد در شب نشینی ها و از جمله شب یلدا  گاهی که مادر بزرگ ها در آوردن  شب چره  تاخیر می کردند  جوانان  و دیگر مهمانان این شعر را می خواندند :\n" +
                "\n" +
                "هر که نوره شو چره                 آنبارشه مــوش بچره\n" +
                "\n" +
                "یک باور قدیمی در میان  مردمان تات ( ماد ) بیان می کند که  در شب یلدا ، اگر ننه سرما گریه کند ، باران می بارد   و اگر  پنبه های  لحافش   بیرون بریزد ، برف می بارد ، و اگر گردنبند مرواریدش پاره شود ، تگرگ می آید  !");

        return view;
    }

}
