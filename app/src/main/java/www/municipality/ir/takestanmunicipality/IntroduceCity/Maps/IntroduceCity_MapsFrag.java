package www.municipality.ir.takestanmunicipality.IntroduceCity.Maps;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceMunicipility_Mayor;
import www.municipality.ir.takestanmunicipality.Page_137.Main_137;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;
import www.municipality.ir.takestanmunicipality.Views.CustomButton;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;


public class IntroduceCity_MapsFrag extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager UserProfile_ViewPager;
    private UserProfileAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_introduce_city__maps2, container, false);

//             tabLayout = view.findViewById(R.id.MapsFrag_TabLayout);
//        UserProfile_ViewPager = view.findViewById(R.id.MapsFrag_ViewPager);
//        adapter = new UserProfileAdapter(getActivity().getSupportFragmentManager());
////        UserProfile_ViewPager.setOffscreenPageLimit(2);
//        UserProfile_ViewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(UserProfile_ViewPager);
//
//        createTab();

        CustomButton CityMapOnline = view.findViewById(R.id.CityMapOnline);
        CustomButton CityMapOffline = view.findViewById(R.id.CityMapOffline);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        CityMapOnline.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        CityMapOnline.getLayoutParams().width = width / 2;
        CityMapOffline.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        CityMapOffline.getLayoutParams().width = width / 2;

        CityMapOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                transaction.replace(R.id.IntroduceCity_Frame, new IntroduceCity_Maps());
                transaction.commit();
            }
        });

        CityMapOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                transaction.replace
                        (R.id.IntroduceCity_Frame, new IntroduceCity_Maps_Online());
                transaction.commit();
            }
        });


        return view;
    }


    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        private List<TrackingCodeModel> data;

        MyCustomAdapter(List<TrackingCodeModel> data) {
            this.data = data;
        }

        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyCustomAdapter.MyCustomView(LayoutInflater
                    .from(getActivity()).inflate(R.layout.trackingcode_layput,null));
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

//                    Toast.makeText(IntroduceCity_MapsFrag.this, "clicked", Toast.LENGTH_SHORT).show();
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

                return new IntroduceCity_Maps_Online();
            }else{
                return new IntroduceCity_Maps();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }


        private void createTab() {
        TextView tabOne = new TextView(getActivity());
        tabOne.setText("نقشه آنلاین");
        tabOne.setTextSize(14);
        tabOne.setGravity(Gravity.CENTER);
//        tabOne.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.BackgroundTab));
        tabOne.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        tabLayout.getTabAt(0).setCustomView(tabOne);


        TextView tabTwo = new TextView(getActivity());
        tabTwo.setText("نقشه آفلاین");
        tabTwo.setTextSize(14);
        tabTwo.setGravity(Gravity.CENTER);
//        tabTwo.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.BackgroundTab));
        tabTwo.setTypeface(CFProvider.getIRANIANSANS(getActivity()));
        tabLayout.getTabAt(1).setCustomView(tabTwo);

    }

}
