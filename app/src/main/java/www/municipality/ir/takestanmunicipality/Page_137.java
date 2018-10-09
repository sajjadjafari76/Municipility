package www.municipality.ir.takestanmunicipality;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.callback.HttpConnectCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import www.municipality.ir.takestanmunicipality.AppController.AppController;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;
import www.municipality.ir.takestanmunicipality.Views.CustomEdittext;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

import static com.koushikdutta.async.AsyncServer.LOGTAG;
import static www.municipality.ir.takestanmunicipality.Globals.ApiURL;

public class Page_137 extends AppCompatActivity implements View.OnClickListener {


    String[] subjectType = {"آتش نشانی", "اتوبوس", "آرامستان ها", "آسفالت"};
    private int type = -1;
    private final int ACTIVITY_SELECT_IMAGE = 159;
    private String imgDecodableString;
    private Uri selectedImage;
    private final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 200;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_137);


        final Spinner spinnerSubjectType = findViewById(R.id.Page_137_SpinnerSubjectType);
//        final Spinner spinnerRegion = findViewById(R.id.Page_137_SpinnerRegion);
        final CustomTextView btn = findViewById(R.id.Page_137_Btn);
        ImageView backwars = findViewById(R.id.Spage_137_Backwards);
        final CustomEdittext text = findViewById(R.id.Page_137_Text);
        final CustomEdittext address = findViewById(R.id.Page_137_Address);
        final CustomEdittext name = findViewById(R.id.Page_137_Name);
        final CustomEdittext family = findViewById(R.id.Page_137_Family);
        final CustomEdittext telephone = findViewById(R.id.Page_137_Telephone);
        final CustomEdittext phone= findViewById(R.id.Page_137_Phone);
        LinearLayout page_137_Image_Btn= findViewById(R.id.Page_137_Image_Btn);

        spinnerAdapter adapter =
                new spinnerAdapter(getApplicationContext(),R.layout.layout_custom_spinner);
        adapter.addAll(subjectType);
        adapter.add("یک موضوع را انتخاب کنید!");
        spinnerSubjectType.setAdapter(adapter);
        spinnerSubjectType.setSelection(adapter.getCount());
        spinnerSubjectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        spinnerAdapter adapterRegion =
//                new spinnerAdapter(getApplicationContext(),R.layout.layout_custom_spinner);
//        adapterRegion.add("منطقه موردنظر خود را انتخاب کنید!");
//        spinnerRegion.setAdapter(adapterRegion);
//        spinnerRegion.setSelection(adapterRegion.getCount());

        spinnerSubjectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                if (spinnerSubjectType.getSelectedItem().equals("this is a test")) {
//
//                }else {
//                    Toast.makeText(Page_137.this, spinnerSubjectType.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
//
//                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject object = new JSONObject();
                try {
                    object.put("text", text.getText().toString());
                    object.put("address", address.getText().toString());
                    object.put("name", name.getText().toString());
                    object.put("family", family.getText().toString());
                    object.put("phone", phone.getText().toString());
                    object.put("telephone", telephone.getText().toString());
                    object.put("type", type);
                    object.put("Area", "nothing");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("data", object.toString() + " |");

                JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, "http://stit.ir/samaneh/webnews.php", object, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response", response.toString() + " |");
                        Toast.makeText(getApplicationContext(), "اطلاعات با موفقیت ارسال شد.", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.toString() + " |");
                        Toast.makeText(getApplicationContext(), "خطایی رخ داد لطفا دوباره تکرار کنید.", Toast.LENGTH_SHORT).show();
                    }
                });

                request1.setRetryPolicy(new DefaultRetryPolicy(10000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                AppController.getInstance().addToRequestQueue(request1);


            }
        });

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // Explain to the user why we need to read the contacts
                }

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

            }
        }

        page_137_Image_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasMarshmallow()) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        // Create intent to Open Image applications like Gallery, Google Photos
                        Intent i = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
                    }else {
                        CustomTextView mytext = new CustomTextView(getApplicationContext());
                        mytext.setText("مجوز دسترسی داده نشده است!");
                        mytext.setTextColor(Color.WHITE);
                        mytext.setBackgroundColor(Color.rgb(231,76,60));
                        mytext.setPadding(17,17,17,17);
                        mytext.setTypeface(CFProvider.getIRANIANSANS(getApplicationContext()));
                        Toast toast = new Toast(getApplicationContext());
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(mytext);
                        toast.show();
                    }
                }else {

                }
            }
        });

        backwars.setOnClickListener(this);


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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        try {
            if (requestCode == ACTIVITY_SELECT_IMAGE && resultCode == RESULT_OK) {

                selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                Log.e("uploadImage", imgDecodableString+" m|");
                cursor.close();

                Log.e("image" , imgDecodableString + " |");


                File file = new File(imgDecodableString);

                Log.e("image12" , file.getPath() + " | " + (file.getName()) + " |" + file.getParent());



                UploadImage(file);
//
//                UploadImageAsyncTask asyncTask = new UploadImageAsyncTask(file);
//                asyncTask.execute();




//                JSONObject object = new JSONObject();
//                try {
//                    object.put("type", type);
//                    object.put("Area", "nothing");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                Log.e("data", object.toString() + " |");
//
//                JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, "http://stit.ir/samaneh/webnews.php", object, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.e("response", response.toString() + " |");
//                        Toast.makeText(getApplicationContext(), "اطلاعات با موفقیت ارسال شد.", Toast.LENGTH_SHORT).show();
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("Error", error.toString() + " |");
//                        Toast.makeText(getApplicationContext(), "خطایی رخ داد لطفا دوباره تکرار کنید.", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                request1.setRetryPolicy(new DefaultRetryPolicy(10000,
//                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//                AppController.getInstance().addToRequestQueue(request1);






//                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

//                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://stit.ir/samaneh/imageupload.php", new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        Log.e("Myresponse",""+response);
//                        Toast.makeText(getApplicationContext(), ""+response, Toast.LENGTH_SHORT).show();
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("Mysmart",""+error);
//                        Toast.makeText(getApplicationContext(), ""+error, Toast.LENGTH_SHORT).show();
//
//                    }
//                }){
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String,String> param = new HashMap<>();
//
//                        Log.i("Mynewsam",imgDecodableString);
//
//                        param.put("image",new File(imgDecodableString).toString());
//
//                        return param;
//                    }
//                };
//
////                requestQueue.add(stringRequest);
//
//                AppController.getInstance().addToRequestQueue(stringRequest);
//



            }
        }catch (Exception e) {
            Log.e("image11" , e.toString() + " |");
        }
    }

    @Override
    public void onClick(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }


    public void UploadImage( File Image){


        AsyncHttpPost post = new AsyncHttpPost(
                "http://stit.ir/samaneh/imageupload.php"
        );

        post.setTimeout(20000);

        MultipartFormDataBody body = new MultipartFormDataBody();

        Log.e("sasasas", Image.getPath() + " | ");
        body.addFilePart("image",Image);
        post.setBody(body);

        Log.e("UploadImageResponse1",  " | " + body.toString());
        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(final Exception e, AsyncHttpResponse source, String result) {



//                progressDialog.dismiss();
                try {
                    Log.e("UploadImageResponse", result  );
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Page_137.this, "عکس با موفقت ارسال شد!", Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch(Exception e1) {
                    e1.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Page_137.this, "خطایی رخ داد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                        }
                    });


                }

            }
        });

//
//        AsyncHttpPost post = new AsyncHttpPost("http://stit.ir/samaneh/imageupload.php");
//        MultipartFormDataBody body = new MultipartFormDataBody();
//        body.addFilePart("image", Image);
//        post.setBody(body);
//
//        AsyncHttpClient.getDefaultInstance().execute(post, new HttpConnectCallback() {
//            @Override
//            public void onConnectCompleted(Exception ex, AsyncHttpResponse res) {
//                Log.i(LOGTAG, "Uploaded");
//            }
//        });

    }
//

    public boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    private class UploadImageAsyncTask extends AsyncTask<String, Void, String> {

        File Image;

        public UploadImageAsyncTask(File file) {
            this.Image = file;
        }

        @Override
        protected void onPreExecute() {
//            loadingView.show(getActivity().getSupportFragmentManager(),"");
            progressDialog = new ProgressDialog(getApplicationContext());
            progressDialog.setMessage("در حال بارگذاری ...");

            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            UploadImage(Image);

            return "";
        }


        @Override
        protected void onPostExecute(String aVoid) {

        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "مجوز صادر شد", Toast.LENGTH_SHORT).show();
                // TODO: 10/21/2017 13:58
            } else {
                Toast.makeText(getApplicationContext(), "مجوز صادر نشد", Toast.LENGTH_SHORT).show();
                // TODO: 10/21/2017 13:58
            }
        }
    }
}
