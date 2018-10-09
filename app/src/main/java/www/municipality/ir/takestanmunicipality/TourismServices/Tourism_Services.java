package www.municipality.ir.takestanmunicipality.TourismServices;

import android.media.Image;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Tourism_Services extends AppCompatActivity implements View.OnClickListener{


    private FrameLayout frameLayout;
    private CustomTextView title;
    private ImageView backwards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism__services);


        Toolbar toolbar = findViewById(R.id.TourismServices_Toolbar);
        title = findViewById(R.id.TourismServices_Title);
        frameLayout = findViewById(R.id.TourismServices_Frame);
        backwards = findViewById(R.id.TourismServices_Backwards);

        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.TourismServices_Frame, new Tourism_Services_frag(title));
        transaction.commit();

        backwards.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }
}
