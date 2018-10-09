package www.municipality.ir.takestanmunicipality.IntroductionMunicipality;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import www.municipality.ir.takestanmunicipality.HostricalWorks.Historical_Works_frag;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Introduction_Municipality extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout frameLayout;
    private CustomTextView title;
    private ImageView backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction__municipality);


        Toolbar toolbar = findViewById(R.id.IntroductionMunicipality_Toolbar);
        title = findViewById(R.id.IntroductionMunicipality_Title);
        frameLayout = findViewById(R.id.IntroductionMunicipality_Frame);
        backwards = findViewById(R.id.IntroductionMunicipality_Backwards);

        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.IntroductionMunicipality_Frame, new Introduction_Municipality_frag(title));
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
