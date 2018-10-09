package www.municipality.ir.takestanmunicipality.IntroductionMunicipality;


import android.graphics.drawable.Drawable;
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

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceMunicipility_Mayor extends Fragment {


    public IntroduceMunicipility_Mayor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_introduce_municipility__mayor, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.IntroduceMunicipilityMayor_Recycler);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));

        return view;
    }

    private List<MayorData> getdata() {
        List<MayorData> data = new ArrayList<>();

        for (int i = 0; i < 6 ; i++) {
            if (i==0) {
                MayorData mayorData = new MayorData();
                mayorData.setName("مهندس بهزاد پور 1396 تاکنون");
                mayorData.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.behzadpour));
//                mayorData.setStart("1376/3/30");
//                mayorData.setEnd("1397/7/10");
                data.add(mayorData);
            } else if (i==1) {
                MayorData mayorData = new MayorData();
                mayorData.setName("سعید طاهرخانی (سرپرست شهرداری) ");
                mayorData.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.taherkhani));
//                mayorData.setStart("1357/11/22");
//                mayorData.setEnd("1397/7/10");
                data.add(mayorData);
            }else if (i==2) {
                MayorData mayorData = new MayorData();
                mayorData.setName("مهندس گودرز رحمانی ");
                mayorData.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.godarz));
//                mayorData.setStart("1376/3/30");
//                mayorData.setEnd("1397/7/10");
                data.add(mayorData);
            }else if (i==3) {
                MayorData mayorData = new MayorData();
                mayorData.setName("مهندس تقی پور");
                mayorData.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.taghipour));
//                mayorData.setStart("1357/11/22");
//                mayorData.setEnd("1397/7/10");
                data.add(mayorData);
            }else if (i==4) {
                MayorData mayorData = new MayorData();
                mayorData.setName("رضا طاهرخانی سرپرست شهرداری ");
                mayorData.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.rezataherkhani));
//                mayorData.setStart("1376/3/30");
//                mayorData.setEnd("1397/7/10");
                data.add(mayorData);
            }
        }
        return data;
    }

    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        List<MayorData> data;
        MyCustomAdapter(List<MayorData> data) {
            this.data = data;
        }

        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyCustomAdapter.MyCustomView(LayoutInflater
                    .from(getActivity()).inflate(R.layout.layout_custom_table,null));
        }

        @Override
        public void onBindViewHolder(MyCustomAdapter.MyCustomView holder, final int position) {
//
            if ( (position % 2) == 1 ) {
                holder.root.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.back_card));
            }

            Log.e("name : ", data.toString() + " | " + data.get(position).getName());

            holder.imageView.setImageDrawable(data.get(position).drawable);
            holder.name.setText(data.get(position).getName());
//            holder.start.setText(data.get(position).getStart());
//            holder.end.setText(data.get(position).getEnd());


        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyCustomView extends RecyclerView.ViewHolder {

            private CustomTextView name, start, end;
            private  RelativeLayout root;
            private ImageView imageView;

            MyCustomView(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.CustomTable_Name);
                start = itemView.findViewById(R.id.CustomTable_Start);
                end = itemView.findViewById(R.id.CustomTable_End);
                root = itemView.findViewById(R.id.CustomTable_Root);
                imageView = itemView.findViewById(R.id.CustomTable_Image);
            }
        }
    }

    private class MayorData {

        private String Name;
        private String Start;
        private String End;
        private Drawable drawable;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getStart() {
            return Start;
        }

        public void setStart(String start) {
            Start = start;
        }

        public String getEnd() {
            return End;
        }

        public void setEnd(String end) {
            End = end;
        }

        public Drawable getDrawable() {
            return drawable;
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }
    }
}
