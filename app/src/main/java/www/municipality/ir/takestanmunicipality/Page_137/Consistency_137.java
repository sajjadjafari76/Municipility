package www.municipality.ir.takestanmunicipality.Page_137;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import www.municipality.ir.takestanmunicipality.appController.AppController;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;
import www.municipality.ir.takestanmunicipality.Views.CustomEdittext;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURLAllNews;

public class Consistency_137 extends AppCompatActivity {

    private CustomEdittext Code;
    private CustomTextView Date;
    //    private FloatingActionButton Btn;
    private ProgressDialog progressDialog;
    private CustomTextView Result;
    private Button Search;
    private ImageView Consistency137_Backwards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consistency_137);

        Code = findViewById(R.id.Consistency137_Code);
        Result = findViewById(R.id.Consistency137_Result);
        Search = findViewById(R.id.Consistency137_Search);
        Date = findViewById(R.id.Consistency137_Date);
        Consistency137_Backwards = findViewById(R.id.Consistency137_Backwards);


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(Consistency_137.this);
                progressDialog.setMessage("در حال ارسال ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                StringRequest request1 = new StringRequest(Request.Method.POST, ApiURLAllNews + "feed", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Loggggg", response + " |");
                        try {
                            progressDialog.dismiss();
                            JSONArray array = new JSONArray(response);

                            if (array.getJSONObject(0).getString("status").equals("0")) {
                                Date.setText("");
                                Result.setText(array.getJSONObject(1).getString("msg"));
                                return;
                            }
                            Log.e("error", array.getJSONObject(0).get("status") + " | " +
                                    array.getJSONObject(3).getString("rs").equals("0"));
                            if (array.getJSONObject(0).getInt("status") == 1) {
                                if (array.getJSONObject(3).getString("rs").equals("0")) {
                                    Date.setText("");
                                    Result.setText(" نتیجه : در انتظار بررسی مدیر سیستم ");
                                } else if (array.getJSONObject(3).getString("rs").equals("1")) {
                                    Date.setText("");
                                    Result.setText(" نتیجه : شهروند گرامی پیام شما در حال بررسی می باشد.");
                                } else if (array.getJSONObject(3).getString("rs").equals("2")){
                                    Date.setText(" پاسخ داده شده در تاریخ " + array.getJSONObject(5).getString("d"));
                                    Result.setText(array.getJSONObject(2).getString("tr"));
                                }
                            }
                        } catch (Exception e) {
                            Log.e("error", e.toString() + " |");
                            Toast.makeText(Consistency_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Consistency_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                        Log.e("error1", error.toString() + " |");
                        progressDialog.dismiss();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("trackCode", Code.getText().toString());
                        return params;
                    }
                };


                request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                AppController.getInstance().addToRequestQueue(request1);


            }
        });

        Search.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));


        Consistency137_Backwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static Spanned fromHtml(String html) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(html);
        }
    }
}
