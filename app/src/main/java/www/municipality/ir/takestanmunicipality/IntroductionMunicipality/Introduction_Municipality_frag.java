package www.municipality.ir.takestanmunicipality.IntroductionMunicipality;


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

import www.municipality.ir.takestanmunicipality.HostricalWorks.HistoricalWorks_BankMarkazi;
import www.municipality.ir.takestanmunicipality.HostricalWorks.HistoricalWorks_BoghePir;
import www.municipality.ir.takestanmunicipality.HostricalWorks.HistoricalWorks_Ghaledokhtar;
import www.municipality.ir.takestanmunicipality.HostricalWorks.HistoricalWorks_KhoramAbad;
import www.municipality.ir.takestanmunicipality.HostricalWorks.HistoricalWorks_khaleKoh;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Historical_Works_frag;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Maps;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceCity_Image.IntroduceCity_Image;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Introduction_Municipality_frag extends Fragment {


    public Introduction_Municipality_frag() {
        // Required empty public constructor
    }

    private CustomTextView title;

    public Introduction_Municipality_frag( CustomTextView title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_introduction__municipality_frag, container, false);

        recyclerView = view.findViewById(R.id.IntroductionMunicipalityFrag_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("معرفی شهرداری");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 8 ; i++) {
            if (i==0) {
                String text = new String();
                text = "تاریخچه شهرداری";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "درباره شهردار";
                data.add(text);
            } else if (i==2) {
                String text = new String();
                text = "ارتباط با شهردار";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "قوانین شهرداری";
                data.add(text);
//            }
//            else if (i==4) {
//                String text = new String();
//                text = "معاونت ها و سازمان ها";
//                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "برنامه های شهردار در افق 1400";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "فلوچارت کاری شهرداری";
                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "آرم شهرداری تاکستان";
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

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                    switch (position) {
                        case 0:
                            fragment = new IntroductionMunicipality_History();
                            title.setText("تاریخچه شهرداری");
                            tag = "history";
                            break;
                        case 1:
                            fragment = new IntroductionMuncipality_About();
                            title.setText("درباره شهردار");
                            tag = "position";
                            break;
                        case 2:
                            fragment = new IntroductionMunicipality_Connectivity();
                            title.setText("ارتباط با شهردار");
                            tag = "maps";
                            break;
                        case 3:
                            fragment = new Introduction_Municipility_Rules(title);
                            title.setText("قوانین شهرداری");
                            tag = "maps";
                            break;
//                        case 4:
//                            fragment = new IntroductionMunicipility_Assistant(title);
//                            title.setText("معاونت ها و سازمان ها");
//                            tag = "maps";
//                            break;
                        case 4:
                            fragment = new IntroductionMunicipility_Program();
                            title.setText("برنامه های شهردار در افق 1400");
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new IntroduceCity_Image(title);
                            title.setText("فلوچارت کاری شهرداری");
                            tag = "maps";
                            break;
                        case 6:
                            fragment = new IntroductionMunicipality_Logo();
                            title.setText("آرم شهرداری تاکستان");
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);

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
