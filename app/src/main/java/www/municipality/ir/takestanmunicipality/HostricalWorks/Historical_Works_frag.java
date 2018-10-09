package www.municipality.ir.takestanmunicipality.HostricalWorks;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.HostricalWorks.Esfarvarin.Esfarvarin_frag;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Khoramdasht.Khoramdasht_frag;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Markazi.Markazi_frag;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_frag;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Maps;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;


public class Historical_Works_frag extends Fragment {

    private CustomTextView title;

    public Historical_Works_frag() {
    }

    public Historical_Works_frag(CustomTextView title) {
    this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_historical__works_frag, container, false);

        recyclerView = view.findViewById(R.id.ElectronicServices_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("آثار تاریخی");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 11 ; i++) {
            if (i==0) {
                String text = new String();
                text = "بخش مرکزی";
                data.add(text);
            }else if (i==1) {
                String text = new String();
                text = "بخش خرمدشت";
                data.add(text);
            }else if (i==2) {
                String text = new String();
                text = "بخش ضیاءآباد";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "بخش اسفرورین";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "بقعه پیر";
                data.add(text);
            } else if (i==5) {
                String text = new String();
                text = "ساختمان بانک مرکزی";
                data.add(text);
//            }else if (i==6) {
//                String text = new String();
//                text = "بنای عمارت میراث فرهنگی";
//                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "تپه تاریخی خله کوه";
                data.add(text);
            }else if (i==7) {
                String text = new String();
                text = "میل خرم آبادی";
                data.add(text);
            }else if (i==8) {
                String text = new String();
                text = "قلعه دختر ( قزقلعه )";
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
                holder.view2.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.back_card));
            }

            holder.view1.setVisibility(View.GONE);
            holder.view2.setVisibility(View.VISIBLE);

            holder.textView.setText(data.get(position).toString());
            switch (position) {
                case 0:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.khondo));
                    break;
                case 1:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.yariabad));
                    break;
                case 2:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.farsajin));
                    break;
                case 3:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.esfarvarin));
                    break;
                case 4:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.boqe_pir));
                    break;
                case 5:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.bonyad_alavi));
                    break;
//                case 6:
//                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.khoramabad));
//                    break;
                case 6:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.kale_koh));
                    break;
                case 7:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.khoramabad));
                    break;
                case 8:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.qiz_qaleh));
                    break;
            }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = null;
                    String tag = null;
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                    switch (position) {
                        case 0:
                            fragment = new Markazi_frag();
                            title.setText("بخش مرکزی");
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Khoramdasht_frag();
                            title.setText("بخش خرمدشت");
                            tag = "history";
                            break;
                        case 2:
                            fragment = new ZiaAbad_frag();
                            title.setText("بخش ضیاءآباد");
                            tag = "history";
                            break;
                        case 3:
                            fragment = new Esfarvarin_frag();
                            title.setText("بخش اسفرورین");
                            tag = "history";
                            break;
                        case 4:
                            fragment = new HistoricalWorks_BoghePir();
                            title.setText("بقعه پیر");
                            tag = "history";
                            break;
                        case 5:
                            fragment = new HistoricalWorks_BankMarkazi();
                            title.setText("ساختمان بانک مرکزی");
                            tag = "position";
                            break;
//                        case 6:
//                            fragment = new IntroduceCity_Maps();
//                            title.setText("بنای عمارت میراث فرهنگی");
//                            tag = "maps";
//                            break;
                        case 6:
                            fragment = new HistoricalWorks_khaleKoh();
                            title.setText("تپه تاریخی خله کوه");
                            tag = "maps";
                            break;
                        case 7:
                            fragment = new HistoricalWorks_KhoramAbad();
                            title.setText("میل خرم آباد");
                            tag = "maps";
                            break;
                        case 8:
                            fragment = new HistoricalWorks_Ghaledokhtar();
                            title.setText("قلعه دختر ( قزقلعه )");
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    transaction.replace(R.id.IntroduceCity_Frame, fragment, tag);
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
            private ImageView image;
            private RelativeLayout view1, view2;

            MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ElectronicItem_Card);
                textView = itemView.findViewById(R.id.ElectronicItem_Text1);
                image = itemView.findViewById(R.id.ElectronicItem_Image);
                view1 = itemView.findViewById(R.id.ElectronicItem_View1);
                view2 = itemView.findViewById(R.id.ElectronicItem_View2);
            }
        }
    }


}
