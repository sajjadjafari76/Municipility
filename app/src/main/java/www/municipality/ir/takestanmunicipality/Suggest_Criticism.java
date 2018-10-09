package www.municipality.ir.takestanmunicipality;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

import www.municipality.ir.takestanmunicipality.AppController.AppController;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURL;

public class Suggest_Criticism extends AppCompatActivity implements View.OnClickListener{

    private EditText name, email, text;
    private int type = -1;
    private CustomTextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest__criticism);

        final Spinner spinner = findViewById(R.id.Suggest_Spinner);
        ImageView backwards = findViewById(R.id.Suggest_Backwards);
        name = findViewById(R.id.Suggest_Criticism_Name);
        email = findViewById(R.id.Suggest_Criticism_Email);
        text = findViewById(R.id.Suggest_Criticism_Text);
        btn = findViewById(R.id.Suggest_Criticism_Btn);

        String[] subjectType = {"پیشنهاد", "انتقاد", "گزارش خطا"};

        spinnerAdapter adapter =
                new spinnerAdapter(getApplicationContext(),R.layout.layout_custom_spinner);
        adapter.addAll(subjectType);
        adapter.add("یک موضوع را انتخاب کنید!");
        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isOnline()) {

                        Log.e("Em ail", Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() + " |");
                        if (name.getText().toString().isEmpty() || name.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "نام و نام خانوادگی نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                        } else if (email.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "ایمیل نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                        } else if (type == -1) {
                            Toast.makeText(getApplicationContext(), "موضوع مورد نظر خود را وارد کنید!", Toast.LENGTH_SHORT).show();
                        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                            Toast.makeText(getApplicationContext(), "ایمیل به درستی وارد نشده است!", Toast.LENGTH_SHORT).show();
                        } else if (text.getText().toString().length() < 5) {
                            Toast.makeText(getApplicationContext(), "حداقل تعداد متن پیام 5 تا میباشد!", Toast.LENGTH_SHORT).show();
                        } else {

                            JSONObject object = new JSONObject();
                            try {
                                object.put("name", name.getText().toString());
                                object.put("Email", email.getText().toString());
                                object.put("type", type);
                                object.put("text", text.getText().toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Log.e("data", object.toString() + " |");

                            JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, "http://stit.ir/samaneh/webContact.php", object, new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.e("response", response.toString() + " |");
                                    Toast.makeText(Suggest_Criticism.this, "اطلاعات با موفقیت ارسال شد.", Toast.LENGTH_SHORT).show();
                                    name.getText().clear();
                                    email.getText().clear();
                                    text.getText().clear();
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("Error", error.toString() + " |");
                                    Toast.makeText(Suggest_Criticism.this, "خطایی رخ داد لطفا دوباره تکرار کنید.", Toast.LENGTH_SHORT).show();
                                }
                            });

                            request1.setRetryPolicy(new DefaultRetryPolicy(10000,
                                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                            AppController.getInstance().addToRequestQueue(request1);


                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "دسترسی به اینترنت ممکن نیست!", Toast.LENGTH_SHORT).show();
                    }
                }

            });


        backwards.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }


    public class spinnerAdapter extends ArrayAdapter<String> {

        public spinnerAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            // TODO Auto-generated constructor stub

        }

        @Override
        public int getCount() {

            // TODO Auto-generated method stub
            int count = super.getCount();

            return count>0 ? count-1 : count ;


        }


    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo != null)
        {
            return (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    ||
                    activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) ?  true : false;
        }
        return false;
    }

}
