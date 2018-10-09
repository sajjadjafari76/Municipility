package www.municipality.ir.takestanmunicipality.TourismServices;

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


public class Tourism_Services_frag extends Fragment {


    public Tourism_Services_frag() {
        // Required empty public constructor
    }

    private CustomTextView title;


    public Tourism_Services_frag(CustomTextView title) {
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_tourism__services_frag, container, false);

        recyclerView = view.findViewById(R.id.TourismServicesFrag_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));


        title.setText("خدمات گردشگری");

        return view;
    }



    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 7 ; i++) {
            if (i==0) {
                String text = new String();
                text = "منطقه شکار ممنوع خراسانلو";
                data.add(text);
            }else if (i == 1){
                String text = new String();
                text = "بافت اصیل روستای تاکند";
                data.add(text);
            }else if (i == 2){
                String text = new String();
                text = "منطقه حفاظت شده باشگل";
                data.add(text);
            }else if (i == 3){
                String text = new String();
                text = "جشن انگور قاقازان";
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
                            fragment = new TourismServicesKhorasanlo();
                            title.setText("منطقه شکار ممنوع خراسانلو");
                            tag = "history";
                            break;
                        case 1:
                            fragment = new TourismServicesTakand();
                            title.setText("بافت اصیل روستای تاکند");
                            tag = "history";
                            break;
                        case 2:
                            fragment = new TourismServicesBashgol();
                            title.setText("منطقه حفاظت شده باشگل");
                            tag = "history";
                            break;
                        case 3:
                            fragment = new TourismServicesGrapes();
                            title.setText("جشن انگور قاقازان");
                            tag = "history";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    transaction.replace(R.id.TourismServices_Frame, fragment, tag);
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
