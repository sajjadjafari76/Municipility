package www.municipality.ir.takestanmunicipality.HostricalWorks.ZiaAbad;


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

import www.municipality.ir.takestanmunicipality.HostricalWorks.Esfarvarin.Esfarvarin_frag;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Khoramdasht.Khoramdasht_frag;
import www.municipality.ir.takestanmunicipality.HostricalWorks.Markazi.Markazi_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiaAbad_frag extends Fragment {


    public ZiaAbad_frag() {
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

        for (int i = 0; i < 9 ; i++) {
            if (i==0) {
                String text = new String();
                text = "امامزاده عبدالله فارسجین";
                data.add(text);
            }else if (i==1) {
                String text = new String();
                text = "امامزاده كمال ضياءآباد";
                data.add(text);
            }else if (i==2) {
                String text = new String();
                text = "امامزاده هفت صندوق";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "امامزاده ولي ضياءآباد";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "بنای موسو به آتشکده حسن آباد";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "خانه های اربابی ضیاباد";
                data.add(text);
//            }else if (i==6) {
//                String text = new String();
//                text = "قز قلعه ضیاءآباد";
//                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "گرمابه قدیمی پیش دره فارسجین";
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
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.farsajin));
                    break;
                case 1:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.kamal));
                    break;
                case 2:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.haft));
                    break;
                case 3:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.vali));
                    break;
                case 4:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.hasanabad));
                    break;
                case 5:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.arbabi));
                    break;
//                case 6:
//                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.boqe_pir));
//                    break;
                case 6:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.garmabe));
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
                            fragment = new ZiaAbad_Farsajin();
                            tag = "history";
                            break;
                        case 1:
                            fragment = new ZiaAbad_Kamal();
                            tag = "history";
                            break;
                        case 2:
                            fragment = new ZiaAbad_Haft();
                            tag = "history";
                            break;
                        case 3:
                            fragment = new ZiaAbad_Vali();
                            tag = "history";
                            break;
                        case 4:
                            fragment = new ZiaAbad_HasanAbad();
                            tag = "history";
                            break;
                        case 5:
                            fragment = new ZiaAbad_Arbabi();
                            tag = "history";
                            break;
//                        case 6:
//                            fragment = new ZiaAbad_frag();
//                            tag = "history";
//                            break;
                        case 6:
                            fragment = new ZiaAbad_Garmabe();
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
