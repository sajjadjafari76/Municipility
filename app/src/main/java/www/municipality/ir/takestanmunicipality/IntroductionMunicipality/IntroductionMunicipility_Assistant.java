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

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionMunicipility_Assistant extends Fragment {


    public IntroductionMunicipility_Assistant() {
        // Required empty public constructor
    }

    private CustomTextView title;

    public IntroductionMunicipility_Assistant( CustomTextView title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_introduction_municipility__assistant, container, false);

        recyclerView = view.findViewById(R.id.IntroductionMunicipality_Assistant);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("معاونت ها و سازمان ها");

        return view;
    }


    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 6 ; i++) {
            if (i==0) {
                String text = new String();
                text = "سازمان حمل و نقل و ترافیک شهرداری تاکستان";
                data.add(text);
            } else if (i==1) {
                String text = new String();
                text = "شرح وظایف واحد فضای سبز";
                data.add(text);
            } else if (i==2) {
                String text = new String();
                text = "معاونت خدمات شهری";
                data.add(text);
            }else if (i==3) {
                String text = new String();
                text = "معاونت شهر سازی";
                data.add(text);
            }else if (i==4) {
                String text = new String();
                text = "معاونت شهرسازی و معماری";
                data.add(text);
            }else if (i==5) {
                String text = new String();
                text = "معاونت مالی اداری شهـرداري";
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
                            title.setText("سازمان حمل و نقل و ترافیک شهرداری تاکستان");
                            bundle.putInt("data",11);
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("شرح وظایف واحد فضای سبز");
                            bundle.putInt("data",12);
                            tag = "position";
                            break;
                        case 2:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("معاونت خدمات شهری");
                            bundle.putInt("data",13);
                            tag = "maps";
                            break;
                        case 3:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("معاونت شهر سازی");
                            bundle.putInt("data",14);
                            tag = "maps";
                            break;
                        case 4:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("معاونت شهرسازی و معماری");
                            bundle.putInt("data",15);
                            tag = "maps";
                            break;
                        case 5:
                            fragment = new Introduction_Municipility_Rules_Data();
                            title.setText("معاونت مالی اداری شهـرداري");
                            bundle.putInt("data",16);
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
