package www.municipality.ir.takestanmunicipality.IntroduceCity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.IntroductionMunicipality.Introduction_Municipality_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Introduce_City extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private FrameLayout frameLayout;
    private CustomTextView title;
    private ImageView backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce__city);

        Toolbar toolbar = findViewById(R.id.ElectronicServices_Toolbar);
//        recyclerView = findViewById(R.id.ElectronicServices_Recycler);
        frameLayout = findViewById(R.id.IntroduceCity_Frame);
        title = findViewById(R.id.IntroduceCity_Title);
        backwards = findViewById(R.id.IntroduceCity_Backwards);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
//        recyclerView.setAdapter(new MyCustomAdapter(getdata()));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.IntroduceCity_Frame, new IntroductionCity_frag(title));
        transaction.commit();



        backwards.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
//        Log.e("frag", "frag : " + getSupportFragmentManager().getBackStackEntryCount());
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
//            Log.e("frag", "frag");
            getSupportFragmentManager().popBackStack();
        }else {
//            Log.e("frag", "not frag");
            finish();
        }
    }


}
