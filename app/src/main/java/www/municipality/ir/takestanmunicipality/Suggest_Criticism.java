package www.municipality.ir.takestanmunicipality;

import android.app.ProgressDialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import org.json.JSONException;
import org.json.JSONObject;

import www.municipality.ir.takestanmunicipality.Views.CustomTextView;


public class Suggest_Criticism extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, text;
    private int type = -1;
    private CustomTextView btn;
    private ProgressDialog progressDialog;

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

        progressDialog = new ProgressDialog(Suggest_Criticism.this);
        progressDialog.setMessage("در حال بارگذاری ...");
        progressDialog.setCancelable(false);

        String[] subjectType = {"پیشنهاد", "انتقاد", "گزارش خطا"};

        spinnerAdapter adapter =
                new spinnerAdapter(getApplicationContext(), R.layout.layout_custom_spinner);
        adapter.addAll(subjectType);
        adapter.add("یک موضوع را انتخاب کنید!");
        spinner.setAdapter(adapter);
//        spinner.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                Log.e("onTouch", event.getAction() + " | " + event.getDeviceId() + " | "+ event.getButtonState());
//
//                return false;
//            }
//        });
        spinner.setSelection(adapter.getCount());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = ++position;
                Log.e("fdfd1", type + " |");
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

                        progressDialog.show();
                        JSONObject object = new JSONObject();
                        try {
                            object.put("Name", name.getText().toString());
                            object.put("Email", email.getText().toString());
                            object.put("Type", type);
                            object.put("Text", text.getText().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("data", object.toString() + " |");

//                        AndroidNetworking.post(Globals.ApiURLAll2 +"suggest.php")
                        AsyncHttpPost post = new AsyncHttpPost(Globals.ApiURLAll2 + "suggest.php");

                        post.setTimeout(20000);

                        MultipartFormDataBody body = new MultipartFormDataBody();

                        body.addStringPart("data", object.toString());
                        post.setBody(body);

                        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
                            @Override
                            public void onCompleted(final Exception e, AsyncHttpResponse source, final String result) {

                                Log.e("UploadResponse", result + " |");

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        try {

                                            progressDialog.dismiss();
                                            JSONObject jsonObject = new JSONObject(result);

                                            if (jsonObject.getString("status").equals("1")) {

                                                name.getText().clear();
                                                email.getText().clear();
                                                text.getText().clear();
//                                                spinner.

                                                Toast.makeText(getApplicationContext(), jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(Suggest_Criticism.this, jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (JSONException e11) {
                                            e11.printStackTrace();
                                            progressDialog.dismiss();
                                            Toast.makeText(Suggest_Criticism.this, "خطایی رخ داد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                                            Log.e("mymessage", e11.toString() + " | ");
                                        }

                                    }
                                });

                            }
                        });

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "دسترسی به اینترنت وجود ندارد!", Toast.LENGTH_SHORT).show();
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

            return count > 0 ? count - 1 : count;


        }


    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    ||
                    activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) ? true : false;
        }
        return false;
    }


}
