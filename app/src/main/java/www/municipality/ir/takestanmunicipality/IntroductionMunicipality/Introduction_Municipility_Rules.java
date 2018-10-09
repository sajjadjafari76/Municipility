package www.municipality.ir.takestanmunicipality.IntroductionMunicipality;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Introduction_Municipility_Rules extends Fragment {


    public Introduction_Municipility_Rules() {
        // Required empty public constructor
    }

    private CustomTextView title;

    public Introduction_Municipility_Rules( CustomTextView title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_introduction__municipility__rules, container, false);

        recyclerView = view.findViewById(R.id.IntroductionMunicipalityRules_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("قوانین شهرداری");


//        title.setEllipsize(TextUtils.TruncateAt.MARQUEE);

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 12 ; i++) {
            if (i==0) {
                String text = new String();
                text = "اصلاح قانون حفظ و گسترش فضای سبز در شهرها";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "آیین نامه حفاظتی کارگاه های ساختمانی";
                data.add(text);
            } else if (i==2) {
                String text = new String();
                text = "بازآفرینی شهری پایدار شهرستان تاکستان";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "ضوابط و مقررات ارتقاء کیفی سیما و منظر شهری";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "عوارض نوسازی شهرداری";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "قانون بلدیه";
                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "مختصری از قانون شهرداري";
                data.add(text);
            }else if (i==7) {
                String text = new String();
                text = "قانون مديريت پسماندها";
                data.add(text);
            }else if (i==8) {
                String text = new String();
                text = "ماده 100 شهرداری";
                data.add(text);
            }else if (i==9) {
                String text = new String();
                text = "مقررات کلی آیین نامه حفاظتی کارگاههای ساختمانی";
                data.add(text);
            }
        }
        return data;
    }

    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        List<String> data;
        MyCustomAdapter(List<String> data) {
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
                    Bundle bundle = new Bundle();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                    switch (position) {
                        case 0:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("اصلاح قانون حفظ و گسترش فضای سبز در شهرها");
                            bundle.putInt("data", 0);
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("آیین نامه حفاظتی کارگاه های ساختمانی");
                            bundle.putInt("data", 1);
                            tag = "position";
                            break;
                        case 2:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("بازآفرینی شهری پایدار شهرستان تاکستان");
                            bundle.putInt("data", 2);
                            tag = "maps";
                            break;
                        case 3:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("ضوابط و مقررات ارتقاء کیفی سیما و منظر شهری");
                            bundle.putInt("data", 3);
                            tag = "maps";
                            break;
                        case 4:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("عوارض نوسازی شهرداری");
                            bundle.putInt("data", 4);
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("قانون بلدیه");
                            bundle.putInt("data", 5);
                            tag = "maps";
                            break;
                        case 6:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("مختصری از قانون شهرداري");
                            bundle.putInt("data", 6);
                            tag = "maps";
                            break;
                        case 7:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("قانون مديريت پسماندها");
                            bundle.putInt("data", 8);
                            tag = "maps";
                            break;
                        case 8:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("ماده 100 شهرداری");
                            bundle.putInt("data", 9);
                            tag = "maps";
                            break;
                        case 9:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("مقررات کلی آیین نامه حفاظتی کارگاههای ساختمانی");
                            bundle.putInt("data", 10);
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.IntroductionMunicipality_Frame, fragment, tag);
                    transaction.commit();
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

            MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ElectronicItem_Card);
                textView = itemView.findViewById(R.id.ElectronicItem_Text);
                view1 = itemView.findViewById(R.id.ElectronicItem_View1);
                view2 = itemView.findViewById(R.id.ElectronicItem_View2);
            }
        }
    }


}
