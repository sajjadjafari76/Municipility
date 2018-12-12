package www.municipality.ir.takestanmunicipality;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import www.municipality.ir.takestanmunicipality.appController.AppController;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURL;

public class Religious_Prayers extends AppCompatActivity implements View.OnClickListener {

    private CustomTextView date;
    private CustomTextView horizon, morning, rise, noon, sunset, west;
    private ProgressDialog progressDialog;
    private LinearLayout View, View1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_religious__prayers);

        date = findViewById(R.id.ReligiousPrayers_Date);
        horizon = findViewById(R.id.ReligiousPrayers_Horizon);
        morning = findViewById(R.id.ReligiousPrayers_Morning);
        rise = findViewById(R.id.ReligiousPrayers_Rise);
        sunset = findViewById(R.id.ReligiousPrayers_Sunset);
        noon = findViewById(R.id.ReligiousPrayers_Noon);
        west = findViewById(R.id.ReligiousPrayers_West);
        ImageView backwards = findViewById(R.id.ReligiousPrayers_Backwards);
        View = findViewById(R.id.ReligiousPrayers_View);
        View1 = findViewById(R.id.ReligiousPrayers_View1);

        progressDialog = new ProgressDialog(Religious_Prayers.this);
        progressDialog.setMessage("در حال بارگذاری ...");
        progressDialog.show();

        StringRequest request1 = new StringRequest(Request.Method.GET, ApiURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Loggggg" , response + " |");
                try {
                    View.setVisibility(android.view.View.VISIBLE);
                    JSONObject array = new JSONObject(response);
                    date.setText( "امروز  - " +  array.getString("Today").substring(0, 9) );
                    horizon.setText( "به افق " +  array.getString("CityName") );
                    morning.setText( array.getString("Imsaak").substring(0, 5));
                    rise.setText( array.getString("Sunrise").substring(0, 5) );
                    noon.setText(array.getString("Noon").substring(0, 5) );
                    west.setText( array.getString("Maghreb").substring(0, 5) );
                    sunset.setText(array.getString("Sunset").substring(0, 5) );

                } catch (JSONException e) {
                    View.setVisibility(android.view.View.GONE);
                    View1.setVisibility(android.view.View.VISIBLE);
                    progressDialog.dismiss();
                    Log.e("error" , e.toString() + " |");
                    e.printStackTrace();
                }

                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                View.setVisibility(android.view.View.GONE);
                View1.setVisibility(android.view.View.VISIBLE);
                Log.e("error1" , error.toString() + " |");
                progressDialog.dismiss();
            }
        });

        request1.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(request1);


        backwards.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

}
