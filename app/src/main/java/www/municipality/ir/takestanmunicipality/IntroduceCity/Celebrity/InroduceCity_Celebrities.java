package www.municipality.ir.takestanmunicipality.IntroduceCity.Celebrity;


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

import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.IntroductionMunicipility_Assistant;
import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.Introduction_Municipility_Rules_Data;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class InroduceCity_Celebrities extends Fragment {


    private CustomTextView title;

    public InroduceCity_Celebrities( CustomTextView title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_inroduce_city__celebrities, container, false);

        recyclerView = view.findViewById(R.id.IntroductionCity_Celebrity);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("مفاخر و مشاهیر");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 11 ; i++) {
            if (i==0) {
                String text = new String();
                text = "استاد علی پدرام";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "سرلشگر شهید خلبان حسین لشگری";
                data.add(text);
            } else if (i==2) {
                String text = new String();
                text = "آیت اله سید حسن موسوی شالی";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "پهلوان احسان لشگری";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "حاج سید ابوالقاسم برهان";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "شهید احمد اللهیاری";
                data.add(text);
            }else if (i==6) {
                String text = new String();
                text = "شهید سید نورالدین ابراهیمی ";
                data.add(text);
            }else if (i==7) {
                String text = new String();
                text = "حجه الاسلام حاج شیخ عبدالکریم رحیمی اسفرورینی";
                data.add(text);
            }else if (i==8) {
                String text = new String();
                text = "آیت اله سید محمد ضیاء آبادی";
                data.add(text);
            }else if (i==9) {
                String text = new String();
                text = "شهید اصغر نجفی";
                data.add(text);
            }else if (i==10) {
                String text = new String();
                text = "ملا قاضی ارداقی";
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
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("استاد علی پدرام");
                            bundle.putInt("data",1);
                            tag = "history";
                            break;
                        case 1:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("سرلشگر شهید خلبان حسین لشگری");
                            bundle.putInt("data",2);
                            tag = "position";
                            break;
                        case 2:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("آیت اله سید حسن موسوی شالی");
                            bundle.putInt("data",3);
                            tag = "maps";
                            break;
                        case 3:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("پهلوان احسان لشگری");
                            bundle.putInt("data",4);
                            tag = "maps";
                            break;
                        case 4:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("حاج سید ابوالقاسم برهان");
                            bundle.putInt("data",5);
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("شهید احمد اللهیاری");
                            bundle.putInt("data",6);
                            tag = "maps";
                            break;
                        case 6:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("شهید سید نورالدین ابراهیمی ");
                            bundle.putInt("data",7);
                            tag = "maps";
                            break;
                        case 7:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("حجه الاسلام حاج شیخ عبدالکریم رحیمی اسفرورینی");
                            bundle.putInt("data",8);
                            tag = "maps";
                            break;
                        case 8:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("آیت اله سید محمد ضیاء آبادی");
                            bundle.putInt("data",9);
                            tag = "maps";
                            break;
                        case 9:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("شهید اصغر نجفی");
                            bundle.putInt("data",10);
                            tag = "maps";
                            break;
                        case 10:
                            fragment = new IntroduceCityCelebration_Data();
                            title.setText("ملا قاضی ارداقی");
                            bundle.putInt("data",11);
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    fragment.setArguments(bundle);
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

