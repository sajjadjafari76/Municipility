package www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroduceCity_Image;


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

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceCity_Image extends Fragment {


    public IntroduceCity_Image() {
        // Required empty public constructor
    }
    private CustomTextView title;
    public IntroduceCity_Image( CustomTextView title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_introduce_city__image, container, false);

        recyclerView = view.findViewById(R.id.IntroductionCityImage_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("فلوچارت کاری شهرداری");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 7 ; i++) {
            if (i==0) {
                String text = new String();
                text = "پاسخ استعلام گاز";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "پايانکار";
                data.add(text);
            }else if (i==2) {
                String text = new String();
                text = "پروانه احداث";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "پروانه تجديد بنا";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "پروانه گسترشي";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "تمديد پروانه";
                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "گواهي عدم خلاف";
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
                    Bundle bundle = new Bundle();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);
                    switch (position) {
                        case 0:
                            fragment = new Image_Data();
                            title.setText("پاسخ استعلام گاز");
                            bundle.putInt("data" ,0);
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Image_Data();
                            title.setText("پايانکار");
                            bundle.putInt("data" ,1);
                            tag = "position";
                            break;
                        case 2:
                            fragment = new Image_Data();
                            title.setText("پروانه احداث");
                            bundle.putInt("data" ,2);
                            tag = "position";
                            break;
                        case 3:
                            fragment = new Image_Data();
                            title.setText("پروانه تجديد بنا");
                            bundle.putInt("data" ,3);
                            tag = "maps";
                            break;
                        case 4:
                            fragment = new Image_Data();
                            title.setText("پروانه گسترشي");
                            bundle.putInt("data" ,4);
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new Image_Data();
                            title.setText("تمديد پروانه");
                            bundle.putInt("data" ,5);
                            tag = "maps";
                            break;
                        case 6:
                            fragment = new Image_Data();
                            title.setText("گواهي عدم خلاف");
                            bundle.putInt("data" ,6);
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.IntroductionMunicipality_Frame, fragment, tag);
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
