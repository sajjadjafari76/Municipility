package www.municipality.ir.takestanmunicipality.HostricalWorks;

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

import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_History;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Maps;
import www.municipality.ir.takestanmunicipality.IntroduceCity.IntroduceCity_Position;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Introduce_City;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class Historical_Works extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout frameLayout;
    private CustomTextView title;
    private ImageView backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical__works);

        Toolbar toolbar = findViewById(R.id.ElectronicServices_Toolbar);
        title = findViewById(R.id.IntroduceCity_Title);
        frameLayout = findViewById(R.id.IntroduceCity_Frame);
        backwards = findViewById(R.id.HistoricalWorks_Backwards);

        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.IntroduceCity_Frame, new Historical_Works_frag(title));
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
