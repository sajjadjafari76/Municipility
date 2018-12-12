package www.municipality.ir.takestanmunicipality;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;
import me.relex.circleindicator.CircleIndicator;
import www.municipality.ir.takestanmunicipality.ContextMenu.FeedContextMenu;
import www.municipality.ir.takestanmunicipality.ContextMenu.FeedContextMenuManager;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Historical_Works;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Introduce_City;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.Introduction_Municipality;
import www.municipality.ir.takestanmunicipality.Page_137.Main_137;
import www.municipality.ir.takestanmunicipality.Recreation.Recreation;
import www.municipality.ir.takestanmunicipality.TourismServices.Tourism_Services;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class MainActivity extends AppCompatActivity  implements FeedContextMenu.OnFeedContextMenuItemClickListener {

    private CountDownTimer timer;
    private CustomTextView name, title, content;
    private ImageView image, more;
    private PagerContainer container;
    private ViewPager pager;
    private boolean doubleBackToExitPressedOnce;
    public static int ChangeImage = 1;

//    private static final String LOCALE_KEY = "localekey";
//    private static final String IR_LOCALE = "IR";
//    private static final String ENGLISH_LOCALE = "en_US";
//    private static final String LOCALE_PREF_KEY = "localePref";
//    private Locale locale;

    @Override
    protected void onStart() {
        super.onStart();
        if (ChangeImage == 1) {
            title.setText("عمارت قدیمی بنیاد علوی");
            content.setText("این بنا به عنوان یکی از آثار ملی ایران به ثبت رسیده است");
            image.setBackground(getResources().getDrawable(R.drawable.bonyad_alavi));
        }else if (ChangeImage == 2) {
            title.setText("امام زاده هفت صندوق ");
            content.setText("از بناهای قدیمی، دوران قاجار میباشد و در شهرستان تاکستان واقع شده است");
            image.setBackground(getResources().getDrawable(R.drawable.emamzadeh_sandogh));
        }else if (ChangeImage == 3) {
            title.setText("قز قلعه ( قلعه دختر )");
            content.setText("قز قلعه از جمله آثار اواخر دوره ی ساسانی یا اوایل اسلام می باشد.");
            image.setBackground(getResources().getDrawable(R.drawable.qiz_qaleh));
        }
        timer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.MainActivity_Toolbar);
        CircleIndicator indicator = findViewById(R.id.MainActivity_Indicator);
        name = findViewById(R.id.ActivityMain_Name);
//        more = findViewById(R.id.ActivityMain_More);
        title = findViewById(R.id.ActivityMain_Title);
        content = findViewById(R.id.ActivityMain_Content);
        image = findViewById(R.id.ActivityMain_Image);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        container = findViewById(R.id.ActivityMain_PagerContainer);
        pager = container.getViewPager();
        pager.setAdapter(new MyPagerAdapter());
        pager.setClipChildren(false);
        pager.setOffscreenPageLimit(10);
        indicator.setViewPager(pager);

        DisplayMetrics metrics = new DisplayMetrics();
//        metrics.xdpi;

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int amount = Double.valueOf(point.x/2.5).intValue();
        pager.getLayoutParams().width = amount;

        new CoverFlow.Builder()
                .with(pager)
                .scale(0.3f)
//                .pagerMargin(10)
//                .spaceSize(-10f)
//                .rotationY(15f)
                .build();

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                final Animation in = new AlphaAnimation(0.0f, 1.0f);
                in.setDuration(300);

                switch (position) {
                    case 0:
                        name.setText("سامانه ارتباط مردمی 137");
                        name.startAnimation(in);
                        break;
                    case 1:
                        name.setText("اخبار شهر");
                        name.startAnimation(in);
                        break;
                    case 2:
                        name.setText("خدمات الکترونیکی شهرداری");
                        name.startAnimation(in);
                        break;
                    case 3:
                        name.setText("معرفی شهر");
                        name.startAnimation(in);
                        break;
                    case 4:
                        name.setText("آثار تاریخی");
                        name.startAnimation(in);
                        break;
                    case 5:
                        name.setText("مراکز تفریحی");
                        name.startAnimation(in);
                        break;
                    case 6:
                        name.setText("خدمات گردشگری");
                        name.startAnimation(in);
                        break;
                    case 7:
                        name.setText("اوقات شرعی");
                        name.startAnimation(in);
                        break;
                    case 8:
                        name.setText("معرفی شهرداری");
                        name.startAnimation(in);
                        break;
                    case 9:
                        name.setText(getResources().getString(R.string.Report));
                        name.startAnimation(in);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                Toast.makeText(MainActivity.this, "onPageScrollStateChanged", Toast.LENGTH_SHORT).show();
            }
        });


        timer = new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                if (title.getVisibility() == View.INVISIBLE) {
                    final Animation out = new AlphaAnimation(0.0f, 1.0f);
                    out.setDuration(1000);
                    title.startAnimation(out);
                    content.startAnimation(out);
                    title.setVisibility(View.VISIBLE);
                    content.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFinish() {
//                title.setText("done! " );
                final Animation out = new AlphaAnimation(1.0f, 0.0f);
                out.setDuration(1000);
                title.startAnimation(out);
                content.startAnimation(out);
                title.setVisibility(View.INVISIBLE);
                content.setVisibility(View.INVISIBLE);

            }
        }.start();

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();

//                Resources resources = getResources();
//                SharedPreferences sharedPreferences = getSharedPreferences("localePref", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                if(sharedPreferences.getString(LOCALE_KEY, ENGLISH_LOCALE).equals(IR_LOCALE)){
//                    locale = new Locale(ENGLISH_LOCALE);
//                    editor.putString(LOCALE_KEY, ENGLISH_LOCALE);
//                } else {
//                    locale = new Locale(IR_LOCALE);
//                    editor.putString(LOCALE_KEY, IR_LOCALE);
//                }
//                editor.apply();
//
//                Configuration configuration = resources.getConfiguration();
//                configuration.setLocale(locale);
//                getResources().updateConfiguration(configuration,
//                        getResources().getDisplayMetrics());
//                recreate();

            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

           getWindow().setStatusBarColor(
                    darkenColor(
                            ContextCompat.getColor(this, R.color.status_Color)));
        }


//        more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PopupMenu popup = new PopupMenu(getApplicationContext(),name);
////            popup.setOnMenuItemClickListener(getApplicationContext());
//                popup.inflate(R.menu.mainactivity_popup);
//                popup.show();
//
//                Log.e("sear", "clicked");
//                FeedContextMenuManager.getInstance().toggleContextMenuFromView(v, 0, MainActivity.this );
//
//            }
//        });

    }

    @Override
    public void onReportClick(int feedItem) {
        FeedContextMenuManager.getInstance().hideContextMenu();
    }

    @Override
    public void onSharePhotoClick(int feedItem) {
        FeedContextMenuManager.getInstance().hideContextMenu();
    }

    @Override
    public void onCopyShareUrlClick(int feedItem) {
        FeedContextMenuManager.getInstance().hideContextMenu();
    }

    @Override
    public void onCancelClick(int feedItem) {
        FeedContextMenuManager.getInstance().hideContextMenu();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mainactivity_menu, menu);
//
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == R.id.Menu_Action) {
//
//            return true;
//        }
//        return false;
//    }

    private class MyPagerAdapter extends PagerAdapter {

        int[] myImage = {R.drawable.img_137, R.drawable.img_resane_shahri, R.drawable.img_electronic_municipility,
                R.drawable.img_moarefi_shahr, R.drawable.img_asar_tarikhi, R.drawable.img_tafrihi, R.drawable.img_gardeshgari,
                R.drawable.img_mecca, R.drawable.img_aboutshahrdari, R.drawable.img_report};


//        int[] myImage = {R.drawable.img_electronic_municipility, R.drawable.img_moarefi_shahr, R.drawable.img_asar_tarikhi,
//                R.drawable.img_tafrihi, R.drawable.img_resane_shahri, R.drawable.img_gardeshgari, R.drawable.img_mecca,
//                R.drawable.img_137, R.drawable.img_aboutshahrdari, R.drawable.img_report};

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_item, null);
            ImageView imageView = view.findViewById(R.id.LayoutItem_Image);
            imageView.setBackground(getResources().getDrawable(myImage[position]));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (ChangeImage == 1) {
                        ChangeImage = 2;
                    }else if (ChangeImage == 2){
                        ChangeImage = 3;
                    }else if (ChangeImage == 3){
                        ChangeImage = 1;
                    }

//                    Random random = new Random();
//                    Log.e("random", uniqueRandomNumber() + " |");
//                    ChangeImage = uniqueRandomNumber();


                    switch (position) {
                        case 0:
                            startActivity(new Intent(getApplicationContext(), Main_137.class));
                            break;
                        case 1:
                            startActivity(new Intent(getApplicationContext(), News.class));
                            break;
                        case 2:
                            startActivity(new Intent(getApplicationContext(), ElectronicServices.class));
                            break;
                        case 3:
                            startActivity(new Intent(getApplicationContext(), Introduce_City.class));
                            break;
                        case 4:
                            startActivity(new Intent(getApplicationContext(), Historical_Works.class));
                            break;
                        case 5:
                            startActivity(new Intent(getApplicationContext(), Recreation.class));
                            break;
                        case 6:
                            startActivity(new Intent(getApplicationContext(), Tourism_Services.class));
                            break;
                        case 7:
                            if (isOnline()) {
                                startActivity(new Intent(getApplicationContext(), Religious_Prayers.class));
                            }else {
                                Toast.makeText(MainActivity.this, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case 8:
                            startActivity(new Intent(getApplicationContext(), Introduction_Municipality.class));
                            break;
                        case 9:
                            startActivity(new Intent(getApplicationContext(), Suggest_Criticism.class));
                            break;
                    }
                }
            });

            container.addView(view);
            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return myImage.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }


    }

    private int uniqueRandomNumber() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<5; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
//        for (int i=0; i<3; i++) {
//            System.out.println(list.get(i));
//        }
//
        return list.get(1);
    }

    // Code to darken the color supplied (mostly color of toolbar)
    private static int darkenColor(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo != null)
        {
            return (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    ||
                    activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) ?  true : false;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Upload");
        menu.add(0, v.getId(), 0, "Search");
        menu.add(0, v.getId(), 0, "Share");
        menu.add(0, v.getId(), 0, "Bookmark");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer.onFinish();
    }

    @Override
    public void onBackPressed() {

        if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "جهت خروج دکمه برگشت را مجددا کلیک کنید!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        } else {
            startActivity(new Intent(getApplicationContext(), Exit_Page.class));
            finish();
        }

    }
}
