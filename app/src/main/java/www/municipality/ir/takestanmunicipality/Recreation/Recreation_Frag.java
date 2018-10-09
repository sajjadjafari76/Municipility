package www.municipality.ir.takestanmunicipality.Recreation;


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

import www.municipality.ir.takestanmunicipality.IntroduceCity.Celebrity.InroduceCity_Celebrities;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Handicrafts.IntrductionCity_Handicrafts;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_History;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Maps;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Paint;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Position;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroductionCity_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recreation_Frag extends Fragment {


    public Recreation_Frag() {
        // Required empty public constructor
    }
    private CustomTextView title;

    public Recreation_Frag( CustomTextView title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_recreation_, container, false);

        recyclerView = view.findViewById(R.id.Recreation_Recycler);

//        title = view.findViewById(R.id.IntroduceCity_Title);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata1()));


        title.setText("مراکز تفریحی");

        return view;
    }


    private List<String> getdata1() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 4 ; i++) {
            if (i == 0) {
                String text = new String();
                text = "پارک جنگلی تاکستان";
                data.add(text);
            } else if (i == 1) {
                String text = new String();
                text = "پینت بال تاکستان";
                data.add(text);
            } else if (i == 2) {
                String text = new String();
                text = "سینمای تاکستان";
                data.add(text);
            } else if (i == 3) {
                String text = new String();
                text = "شهربازی تاکستان";
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
                holder.view2.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.back_card));
            }

            holder.view2.setVisibility(View.VISIBLE);
            holder.view1.setVisibility(View.GONE);


            holder.textView.setText(data.get(position));
            switch (position) {
                case 0:
                    holder.image.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.parkjangli));
                    break;
                case 1:
                    holder.image.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.paintball));
                    break;
                case 2:
                    holder.image.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.sinama));
                    break;
                case 3:
                    holder.image.setBackgroundDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.shahrbazi));
                    break;
            }


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
                            fragment = new Recreatin_data();
                            title.setText("پارک جنگلی تاکستان");
                            bundle.putInt("data",0);
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Recreatin_data();
                            title.setText("پینت بال تاکستان");
                            bundle.putInt("data",1);
                            tag = "position";
                            break;
                        case 2:
                            fragment = new Recreatin_data();
                            title.setText("سینمای تاکستان");
                            bundle.putInt("data",2);
                            tag = "position";
                            break;
                        case 3:
                            fragment = new Recreatin_data();
                            title.setText("شهربازی تاکستان");
                            bundle.putInt("data",3);
                            tag = "maps";
                            break;
                    }
                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.Recreation_Frame, fragment, tag);
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
            private ImageView image;

            public MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ElectronicItem_Card);
                textView = itemView.findViewById(R.id.ElectronicItem_Text1);
                view1 = itemView.findViewById(R.id.ElectronicItem_View1);
                view2 = itemView.findViewById(R.id.ElectronicItem_View2);
                image = itemView.findViewById(R.id.ElectronicItem_Image);
            }
        }
    }



}
