package www.municipality.ir.takestanmunicipality.IntroduceCity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.IntroduceCity.Celebrity.InroduceCity_Celebrities;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Handicrafts.IntrductionCity_Handicrafts;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Maps.IntroduceCity_MapsFrag;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceCity_Image.IntroduceCity_Image;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionCity_frag extends Fragment {


    public IntroductionCity_frag() {
        // Required empty public constructor
    }
    private CustomTextView title;

    public IntroductionCity_frag( CustomTextView title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_introduction_city_frag, container, false);

        recyclerView = view.findViewById(R.id.IntroductionCityFrag_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("معرفی شهر");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 7 ; i++) {
            if (i==0) {
                String text = new String();
                text = "پیشینه تاریخی شهر";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "موقعیت جغرافیایی شهر";
                data.add(text);
            }else if (i==2) {
                String text = new String();
                text = "صنایع دستی";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "نقشه شهر";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "نقاشی قدیمی اوژن فلاندن";
                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "مفاخر و مشاهیر";
                data.add(text);
            }
        }
        return data;
    }

    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        List<String> data;
        public MyCustomAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyCustomAdapter.MyCustomView(LayoutInflater
                    .from(getActivity()).inflate(R.layout.layout_electronic_item,null));
        }

        @Override
        public void onBindViewHolder(MyCustomAdapter.MyCustomView holder, final int position) {

            if ( (position % 2) == 0 ) {
                holder.view1.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.back_card));
            }

            holder.textView.setText(data.get(position).toString());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = null;
                    String tag = null;
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                    switch (position) {
                        case 0:
                            fragment = new IntroduceCity_History();
                            title.setText("پیشینه تاریخی شهر");
                            tag = "history";
                            break;
                        case 1:
                            fragment = new IntroduceCity_Position();
                            title.setText("موقعیت جغرافیایی شهر");
                            tag = "position";
                            break;
                        case 2:
                            fragment = new IntrductionCity_Handicrafts();
                            title.setText("صنایع دستی");
                            tag = "position";
                            break;
                        case 3:
                            fragment = new IntroduceCity_MapsFrag();
                            title.setText("نقشه شهر");
                            tag = "maps";
                            break;
                        case 4:
                            fragment = new IntroduceCity_Paint();
                            title.setText("نقاشی قدیمی اوژن فلاندن");
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new InroduceCity_Celebrities(title);
                            title.setText("مفاخر و مشاهیر");
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    transaction.replace(R.id.IntroduceCity_Frame, fragment, tag);
                    transaction.commit();
//                    Log.e("logmeeeee", getActivity().getSupportFragmentManager().getBackStackEntryCount()+ " |");
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyCustomView extends RecyclerView.ViewHolder {

            private CardView cardView;
            private CustomTextView textView;
            private RelativeLayout view1, view2;

            public MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ElectronicItem_Card);
                textView = itemView.findViewById(R.id.ElectronicItem_Text);
                view1 = itemView.findViewById(R.id.ElectronicItem_View1);
                view2 = itemView.findViewById(R.id.ElectronicItem_View2);
            }
        }
    }



}
