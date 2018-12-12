package www.municipality.ir.takestanmunicipality.HostricalWorks.Khoramdasht;


import android.os.Bundle;
import android.support.annotation.NonNull;
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

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;


public class Khoramdasht_frag extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView;
        View view;
        view = inflater.inflate(R.layout.fragment_khramdasht_frag, container, false);

        recyclerView = view.findViewById(R.id.KhoramdashtFrag_Recycler);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getData()));

        return view;

    }


    private List<String> getData() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i <= 3 ; i++) {
            if (i==0) {
                String text = "خانه اربابی قاسم آباد";
                data.add(text);
            }else if (i==1) {
                String text = "خانه اربابی یاری آباد";
                data.add(text);
            }else if (i==2) {
                String text = "قنات تاریخی روستای رادکان";
                data.add(text);
            }
//            else if (i==3) {
//                String text = "بنای امامزاده صالح و سلیمان. خرمدشت";
//                data.add(text);
//            }
        }
        return data;
    }

    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        List<String> data;
        MyCustomAdapter(List<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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

            holder.textView.setText(data.get(position));
            switch (position) {
                case 0:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.ghasemabd));
                    break;
                case 1:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.yariabad));
                    break;
                case 2:
                    holder.image.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.radakan));
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
                            fragment = new Khoramdasht_GhasemAbad();
                            tag = "history";
                            break;
                        case 1:
                            fragment = new Khoramdasht_YariAbad();
                            tag = "history";
                            break;
                        case 2:
                            fragment = new Khoramdasht_Radakan();
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
