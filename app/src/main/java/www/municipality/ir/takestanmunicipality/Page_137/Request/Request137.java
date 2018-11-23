package www.municipality.ir.takestanmunicipality.Page_137.Request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.DataBase.MyTokenManager;
import www.municipality.ir.takestanmunicipality.DataModel.ChildModel;
import www.municipality.ir.takestanmunicipality.DataModel.ParentModel;
import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Request137 extends AppCompatActivity {

    private RecyclerView recycler;
    private CustomTextView Empty;
    private ImageView Request137_Backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request137);

        recycler = findViewById(R.id.Main137_Recycler);
         Empty = findViewById(R.id.Request137_Empty);
        Request137_Backwards = findViewById(R.id.Request137_Backwards);


        Request137_Backwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ggg", "7878787");
                finish();
            }
        });

         if (MyTokenManager.getInstance(getApplicationContext()).getTrackingCode().size() == 0) {
             recycler.setVisibility(View.GONE);
             Empty.setVisibility(View.VISIBLE);
             return;
         }

        List<ParentModel> models = new ArrayList<>();

        for (int i = 0 ; i < MyTokenManager.getInstance(getApplicationContext()).getTrackingCode().size()  ; i++) {
            ParentModel model = new ParentModel();
            model.setContent(MyTokenManager.getInstance(getApplicationContext()).getTrackingCode().get(i).getContent());
            model.setTrackingCode(MyTokenManager.getInstance(getApplicationContext()).getTrackingCode().get(i).getCode());
            model.setInfo(MyTokenManager.getInstance(getApplicationContext()).getTrackingCode().get(i).getFamily());
            models.add(model);
        }


        MyRequestAdapter adapter = new MyRequestAdapter(models,this);
        recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recycler.setAdapter(adapter);


    }


    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        private List<TrackingCodeModel> data;

        MyCustomAdapter(List<TrackingCodeModel> data) {
            this.data = data;
        }

        @Override
        public MyCustomAdapter.MyCustomView onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyCustomAdapter.MyCustomView(LayoutInflater
                    .from(getApplicationContext()).inflate(R.layout.trackingcode_layput,null));
        }

        @Override
        public void onBindViewHolder(MyCustomAdapter.MyCustomView holder, final int position) {

//            if ( (position % 2) == 0 ) {
//                holder.cardView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.back_card));
//            }

            Log.e("mycodemycode",data.get(position).getCode() + " | " + position );
            holder.Code.setText("شماره پیگیری : " + data.get(position).getCode());
            holder.Content.setText(data.get(position).getContent());

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Fragment fragment = null;
//                    String tag = null;
//                    Bundle bundle = new Bundle();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.addToBackStack(null).setCustomAnimations(R.anim.fadeout, R.anim.fadein);

//                    transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout);
//                    fragment.setArguments(bundle);
//                    transaction.replace(R.id.IntroductionMunicipality_Frame, fragment, tag);
//                    transaction.commit();

                    Toast.makeText(Request137.this, "clicked", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyCustomView extends RecyclerView.ViewHolder {

            private CardView cardView;
            private CustomTextView Content, Code;

            MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.TrackingCode_Card);
                Code = itemView.findViewById(R.id.TrackingCode_Code);
                Content = itemView.findViewById(R.id.TrackingCode_Content);
            }
        }
    }


    private ArrayList<ParentObject> generateCrimes() {

        ArrayList<ParentObject> parentObjects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Object> childList = new ArrayList<>();
            childList.add(new ChildModel("34543", "tr","fg","gf"));

            Crime crimes1 = new Crime();
            crimes1.setChildObjectList(childList);
            parentObjects.add(crimes1);
        }

        return parentObjects;
    }

}
