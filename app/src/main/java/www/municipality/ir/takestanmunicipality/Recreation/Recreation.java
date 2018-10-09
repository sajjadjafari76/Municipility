package www.municipality.ir.takestanmunicipality.Recreation;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroductionCity_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Recreation extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private FrameLayout frameLayout;
    private CustomTextView title;
    private ImageView backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);

        Toolbar toolbar = findViewById(R.id.Recreation_Toolbar);
//        recyclerView = findViewById(R.id.ElectronicServices_Recycler);
        frameLayout = findViewById(R.id.Recreation_Frame);
        title = findViewById(R.id.Recreation_Title);
        backwards = findViewById(R.id.Recreation_Backwards);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

//        recyclerView.setLayoutManager(
//                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
//        recyclerView.setAdapter(new MyCustomAdapter(getdata()));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Recreation_Frame, new Recreation_Frag(title));
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
