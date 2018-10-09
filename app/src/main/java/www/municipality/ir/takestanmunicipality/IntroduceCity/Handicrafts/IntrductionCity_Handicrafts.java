package www.municipality.ir.takestanmunicipality.IntroduceCity.Handicrafts;


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
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Arbabi;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Farsajin;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Garmabe;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Haft;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_HasanAbad;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Kamal;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_Vali;
import www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad.ZiaAbad_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntrductionCity_Handicrafts extends Fragment {


    public IntrductionCity_Handicrafts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_zia_abad_frag, container, false);

        recyclerView = view.findViewById(R.id.ZiaAbadFrag_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        return view;

    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 6 ; i++) {
            if (i==0) {
                String text = new String();
                text = "گلیم بافی و سبد";
                data.add(text);
            }else if (i==1) {
                String text = new String();
                text = "قفل سازی";
                data.add(text);
            }else if (i==2) {
                String text = new String();
                text = "گیوه بافی";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "کلش بافی";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "لایه چینی";
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

            holder.view1.setVisibility(View.GONE);
            holder.view2.setVisibility(View.VISIBLE);


            if ( (position % 2) == 0 ) {
                holder.view2.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.back_card));
            }

            holder.textView.setText(data.get(position).toString());
            switch (position) {
                case 0:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.gelimbafi_2));
                    break;
                case 1:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.ghoflsazi));
                    break;
                case 2:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.givebafi_2));
                    break;
                case 3:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.kolashbafi));
                    break;
                case 4:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.layechini));
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
                            fragment = new Handicrafts_GelimBafi();
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Handicrafts_GhoflSazi();
                            tag = "history";
                            break;
                        case 2:
                            fragment = new Handicrafts_GiveBafi();
                            tag = "history";
                            break;
                        case 3:
                            fragment = new Handicrafts_KolashBafi();
                            tag = "history";
                            break;
                        case 4:
                            fragment = new Handicrafts_LayeChini();
                            tag = "history";
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
