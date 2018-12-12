package www.municipality.ir.takestanmunicipality.Page_137;

import android.content.Intent;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceMunicipility_Mayor;
import www.municipality.ir.takestanmunicipality.MainActivity;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Page_137.Request.Request137;
import www.municipality.ir.takestanmunicipality.Tools;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Main_137 extends AppCompatActivity {

    private RecyclerView recycler;
    private ImageView Main137_Backwards;
    private UserProfileAdapter adapter;
//    private TabLayout tabLayout;
//    private ViewPager UserProfile_ViewPager;
    private Button MyRequest, Register, Track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_137);

//        tabLayout = findViewById(R.id.Main137_TabLayout);
//        UserProfile_ViewPager = findViewById(R.id.UserProfile_ViewPager);
//        adapter = new UserProfileAdapter(getSupportFragmentManager());
//        UserProfile_ViewPager.setOffscreenPageLimit(3);
//        UserProfile_ViewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(UserProfile_ViewPager);
//        createTab();

//        Button consistency = findViewById(R.id.consistency);
//        Button request = findViewById(R.id.request);
//        imageView = findViewById(R.id.Main137_Consistency);

//         recycler = findViewById(R.id.Main137_Recycler);
//         recycler.setLayoutManager(
//                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
//         recycler.setAdapter(
//                 new MyCustomAdapter(MyTokenManager.getInstance(getApplicationContext()).getTrackingCode()));


//         imageView.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 startActivity(new Intent(getApplicationContext(), Page_137.class));
//                finish();
//             }
//         });

//        consistency.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
//        request.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
//
//        consistency.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Consistency_137.class));
//                finish();
//            }
//        });
//
//        request.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Page_137.class));
//                finish();
//            }
//        });


        MyRequest = findViewById(R.id.Main137_MyRequest);
        Register = findViewById(R.id.Main137_Register);
        Track = findViewById(R.id.Main137_Track);
        Main137_Backwards = findViewById(R.id.Main137_Backwards);


        DisplayMetrics metrics = getResources().getDisplayMetrics();

        Point point = new Point();

        Log.e("metric" , metrics.ydpi + " ");
        Log.e("point" , point.y + " ");

//        Register.getLayoutParams().width = Double. metrics.ydpi /2;
//        Register.getLayoutParams().height = ;
//
//        MyRequest.getLayoutParams().width = ;
//        MyRequest.getLayoutParams().height = ;
//
//        Track.getLayoutParams().width = ;
//        Track.getLayoutParams().height = ;


        MyRequest.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
        Register.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
        Track.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));

        MyRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Request137.class));
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Tools.getInstance(getApplicationContext()).isOnline()) {
                    startActivity(new Intent(getApplicationContext(), Page_137.class));
                }else {
                    Toast.makeText(Main_137.this, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Consistency_137.class));
            }
        });

        Main137_Backwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

    }


    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        private List<TrackingCodeModel> data;

        MyCustomAdapter(List<TrackingCodeModel> data) {
            this.data = data;
        }

        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyCustomAdapter.MyCustomView(LayoutInflater
                    .from(getApplicationContext()).inflate(R.layout.trackingcode_layput,null));
        }

        @Override
        public void onBindViewHolder(MyCustomAdapter.MyCustomView holder, final int position) {

//            if ( (position % 2) == 0 ) {
//                holder.cardView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.back_card));
//            }

            Log.e("mycodemycode",data.get(position).getCode() + " | " + position );
            holder.Code.setText("شماره پیگیری : " + data.get(position).getCode());
            holder.Content.setText(data.get(position).getContent());

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Fragment fragment = null;
//                    String tag = null;
//                    Bundle bundle = new Bundle();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);

//                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
//                    fragment.setArguments(bundle);
//                    transaction.replace(R.id.IntroductionMunicipality_Frame, fragment, tag);
//                    transaction.commit();

                    Toast.makeText(Main_137.this, "clicked", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyCustomView extends RecyclerView.ViewHolder {

            private CardView cardView;
            private CustomTextView Content, Code;

            MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.TrackingCode_Card);
                Code = itemView.findViewById(R.id.TrackingCode_Code);
                Content = itemView.findViewById(R.id.TrackingCode_Content);
            }
        }
    }

    public class UserProfileAdapter extends FragmentPagerAdapter {

        public UserProfileAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new IntroduceMunicipility_Mayor();

            }else if (position == 1){
                return new IntroduceMunicipility_Mayor();
            }else {
                return new IntroduceMunicipility_Mayor();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


//    private void createTab() {
//        TextView tabOne = new TextView(getApplicationContext());
//        tabOne.setText("ثبت درخواست");
//        tabOne.setTextSize(14);
//        tabOne.setGravity(Gravity.CENTER);
////        tabOne.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.BackgroundTab));
//        tabOne.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
//        tabLayout.getTabAt(2).setCustomView(tabOne);
//
//
//        TextView tabTwo = new TextView(getApplicationContext());
//        tabTwo.setText("درخواست های من");
//        tabTwo.setTextSize(14);
//        tabTwo.setGravity(Gravity.CENTER);
////        tabTwo.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.BackgroundTab));
//        tabTwo.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
//        tabLayout.getTabAt(1).setCustomView(tabTwo);
//
//        TextView tabThree = new TextView(getApplicationContext());
//        tabThree.setText("پیگیری درخواست");
//        tabThree.setTextSize(14);
//        tabThree.setGravity(Gravity.CENTER);
////        tabThree.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.BackgroundTab));
//        tabThree.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
//        tabLayout.getTabAt(0).setCustomView(tabThree);
//
//    }


}
