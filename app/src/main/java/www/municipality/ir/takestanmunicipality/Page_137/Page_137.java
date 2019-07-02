package www.municipality.ir.takestanmunicipality.Page_137;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.MultipartFormDataBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import www.municipality.ir.takestanmunicipality.DataBase.MyTokenManager;
import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;
import www.municipality.ir.takestanmunicipality.Globals;
import www.municipality.ir.takestanmunicipality.IntroduceCity.Maps.WorkaroundMapFragment;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Tools;
import www.municipality.ir.takestanmunicipality.Views.CFProvider;
import www.municipality.ir.takestanmunicipality.Views.CustomEdittext;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;
import www.municipality.ir.takestanmunicipality.Voice.Record_Voice;
import www.municipality.ir.takestanmunicipality.appController.AppController;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURL;

public class Page_137 extends AppCompatActivity implements View.OnClickListener,
        OnMapReadyCallback {


    private String type = null;
    private String imgDecodableString, VoicePath, selectedVideoPath;
    private Uri selectedImage;
    private final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 200;
    private int GALLERY = 1, CAMERA = 2, GALLERYVIDEO = 3;
    private ProgressDialog progressDialog;
    private TextView Page_137_Result;
    private JSONObject data = new JSONObject();
    private ImageView page_137_Backwards;
    private RelativeLayout container;
    private CustomEdittext text, address, name, family, nationalCode, phone;
    private List<String> category = new ArrayList<>();
    private List<String> subCategory = new ArrayList<>();
    private List<String> subCategoryOne = new ArrayList<>();
    spinnerAdapter adapter, adapterSub, adapterSubOne;
    private Spinner SubCategory, SubCategoryOne;
    private List<String> Result = new ArrayList<>();

    //    private MapView mapView;
    private GoogleMap mMap;
    private Marker pointerMarker;
    WorkaroundMapFragment myMap;


    @Override
    protected void onStart() {
        super.onStart();


        if (!Tools.getInstance(this).read("voice", "").equals("")) {
            Page_137_Result.setText(new File(Tools.getInstance(this).read("voice", "")).getName());
            VoicePath = Tools.getInstance(this).read("voice", "");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_137);

        progressDialog = new ProgressDialog(Page_137.this);
        progressDialog.setMessage("در حال بارگذاری ...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        final Spinner spinnerSubjectType = findViewById(R.id.Page_137_SpinnerSubjectType);
        SubCategory = findViewById(R.id.Page_137_SpinnerSubjectTypeSubCategory);
        SubCategoryOne = findViewById(R.id.Page_137_SpinnerSubjectTypeSubCategoryOne);
        final CustomTextView btn = findViewById(R.id.Page_137_Btn);
        Page_137_Result = findViewById(R.id.Page_137_Result);
//        Page137_AddressName = findViewById(R.id.Page137_AddressName);
        text = findViewById(R.id.Page_137_Text);
        address = findViewById(R.id.Page_137_Address);
        name = findViewById(R.id.Page_137_Name);
        family = findViewById(R.id.Page_137_Family);
        nationalCode = findViewById(R.id.Page_137_NationalCode);
        phone = findViewById(R.id.Page_137_Phone);
        LinearLayout page_137_Image_Btn = findViewById(R.id.Page_137_Image_Btn);
        LinearLayout page_137_Voice_Btn = findViewById(R.id.Page_137_Voice_Btn);
        LinearLayout Page_137_Video_Btn = findViewById(R.id.Page_137_Video_Btn);
        page_137_Backwards = findViewById(R.id.page_137_Backwards);
        container = findViewById(R.id.Page_137_Container);

//        address.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        address.setSingleLine(true);
        address.setMarqueeRepeatLimit(-1);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int amount = Double.valueOf(point.x / 1.5).intValue();
        btn.getLayoutParams().width = amount;


        /*-- if user used previously of page 137 --*/
        if (MyTokenManager.getInstance(this).getTrackingCode().size() != 0) {

            name.setText(MyTokenManager.getInstance(this).getTrackingCode().get(0).getName());
            family.setText(MyTokenManager.getInstance(this).getTrackingCode().get(0).getFamily());
            nationalCode.setText(MyTokenManager.getInstance(this).getTrackingCode().get(0).getNationalCode());
            phone.setText(MyTokenManager.getInstance(this).getTrackingCode().get(0).getPhone());

        }

        adapter = new spinnerAdapter(this, R.layout.layout_custom_spinner);
        adapterSub = new spinnerAdapter(this, R.layout.layout_custom_spinner);
        adapterSubOne = new spinnerAdapter(this, R.layout.layout_custom_spinner);


        StringRequest request1 = new StringRequest(Request.Method.POST, Globals.ApiURLAll2 + "retrieve", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.e("Page137_Response", response);
                try {
                    JSONArray array1 = new JSONArray(response);

                    SubCategory.setVisibility(View.GONE);
                    SubCategoryOne.setVisibility(View.GONE);
                    Result.clear();

                    final List<CategoryModel> CategoryArray = new ArrayList<>();

                    for (int i = 0; i < array1.length(); i++) {

                        CategoryModel model = new CategoryModel();

                        model.setCatId(array1.getJSONObject(i).getString("id"));
                        model.setTitle(array1.getJSONObject(i).getString("id"));

                        CategoryArray.add(model);
                        category.add(array1.getJSONObject(i).getString("title"));

                    }


                    adapter.addAll(category);
                    adapter.add("یک موضوع را انتخاب کنید!");
                    spinnerSubjectType.setAdapter(adapter);
                    spinnerSubjectType.setSelection(adapter.getCount());


                    spinnerSubjectType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position > (category.size() - 1)) {

                            } else {
                                StepTwo(CategoryArray.get(position).getCatId());
//
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Page_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                Log.e("Page137_Error", error.toString() + " |");
                progressDialog.dismiss();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("request", "t1");
                return params;
            }

        };

        request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(request1);


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
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    // Explain to the user why we need to read the contacts
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

            }
        }


        btn.setOnClickListener(this);//click for send data to server
        page_137_Image_Btn.setOnClickListener(this); // click for show dialog which choose between camera & galley
        page_137_Voice_Btn.setOnClickListener(this);// open Voice Activity for recording voice
        Page_137_Video_Btn.setOnClickListener(this);// open gallery for choose video


        page_137_Backwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ScrollView Page137_Scrool = findViewById(R.id.Page137_Scrool);


        myMap = ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1));

        myMap.setListener(new WorkaroundMapFragment.OnTouchListener() {
            @Override
            public void onTouch() {
                Page137_Scrool.requestDisallowInterceptTouchEvent(true);
            }
        });
        myMap.onCreate(savedInstanceState);
        myMap.onResume();
        myMap.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                if (pointerMarker != null) {
                    pointerMarker.remove();
                }
                pointerMarker = mMap.addMarker(new MarkerOptions().position(latLng).title("مکان انتخابی شما"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                Log.e("lat", latLng.latitude + "  | " + latLng.longitude);
                try {
                    data.put("lat", String.valueOf(latLng.latitude));
                    data.put("lng", String.valueOf(latLng.longitude));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getAddressFromLocation(latLng.latitude, latLng.longitude);
//                data.put("lat", latLng)
            }
        });

        if (!data.has("lat") && !data.has("lng")) {
            try {
                data.put("lat", "36.06852");
                data.put("lng", "49.69690");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        LatLng takestan = new LatLng(36.06852, 49.69690);
//        mMap.addMarker(new MarkerOptions().position(takestan).title("تاکستان"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(takestan, 13));

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            // take picture from camera
            if (requestCode == CAMERA && resultCode == RESULT_OK) {
                Log.e("camera", "camera");

//                selectedImage = data.getData();
//                String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//                Cursor cursor = getContentResolver().query(selectedImage,
//                        filePathColumn, null, null, null);
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                imgDecodableString = cursor.getString(columnIndex);
//                Page_137_Result.setText(imgDecodableString);
//                cursor.close();
//
//                VoicePath = "";
//                selectedVideoPath = "";
//
//                File file = new File(imgDecodableString);


                Bitmap photo = (Bitmap) data.getExtras().get("data");
//                imageView.setImageBitmap(photo);
//                knop.setVisibility(Button.VISIBLE);


                // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                Uri tempUri = getImageUri(this, photo);


                // CALL THIS METHOD TO GET THE ACTUAL PATH
                File finalFile = new File(getRealPathFromURI(tempUri));
                imgDecodableString = finalFile.getPath();


                Page_137_Result.setText(finalFile.getName());

                Log.e("image12", finalFile.getPath() + " | " + (finalFile.getName()) + " |" + finalFile.getParent());


                //about voice
            } else if (resultCode == 1) {
                Log.e("voice", "voice");
                VoicePath = data.getStringExtra("voice");
                selectedVideoPath = null;
                imgDecodableString = null;
                Page_137_Result.setText(VoicePath);

                //use image of gallery
            } else if (requestCode == GALLERY && resultCode == RESULT_OK) {
                selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                VoicePath = null;
                selectedVideoPath = null;

                File file = new File(imgDecodableString);
                Page_137_Result.setText(file.getName());
                Log.e("image12", file.getPath() + " | " + (file.getName()) + " |" + file.getParent());

                // use videos of gallery
            } else if (resultCode == RESULT_OK) {
                if (requestCode == GALLERYVIDEO) {
                    Log.d("what", "gale");
                    if (data != null) {
                        Uri contentURI = data.getData();

                        selectedVideoPath = getPath(contentURI);

                        VoicePath = "";
                        imgDecodableString = "";

                        Page_137_Result.setText(new File(selectedVideoPath).getName());
                        Log.d("path", selectedVideoPath);

                    }
                }
            }
        } catch (Exception e) {
            Log.e("image11", e.toString() + " |");

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Page_137_Btn://click for send data to server

                Log.e("derrr",Result.toString() + " | " + Result.size());
                if (Result.size() != 3) {
                    Toast.makeText(this, "موضوع نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (text.getText().toString().isEmpty() || text.getText().toString().equals("")) {
                    Toast.makeText(this, "متن پیام نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (address.getText().toString().isEmpty() || address.getText().toString().equals("")) {
                    Toast.makeText(this, "آدرس نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (name.getText().toString().isEmpty() || name.getText().toString().equals("")) {
                    Toast.makeText(this, "نام نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (family.getText().toString().isEmpty() || family.getText().toString().equals("")) {
                    Toast.makeText(this, "فامیلی نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (nationalCode.getText().toString().length() != 10) {
                    Toast.makeText(this, "کد ملی رو درست وارد کنید!", Toast.LENGTH_SHORT).show();
                } else if (phone.getText().toString().isEmpty() || phone.getText().toString().equals("")) {
                    Toast.makeText(this, "شماره موبایل نمیتواند خالی باشد!", Toast.LENGTH_SHORT).show();
                } else if (phone.getText().toString().length() != 11) {
                    Toast.makeText(this, "لطفا شماره موبایل خود را درست وارد کنید!", Toast.LENGTH_SHORT).show();
                } else {

                    try {
                        data.put("content", text.getText().toString());
                        data.put("address", address.getText().toString());
                        data.put("name", name.getText().toString());
                        data.put("family", family.getText().toString());
                        data.put("mobile", phone.getText().toString());
                        data.put("nm", nationalCode.getText().toString());
                        data.put("type", Result.get(2)+","+Result.get(0)+","+Result.get(1));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.e("data", data.toString() + " |");

                    UploadInfo(data);
                }

                break;
            case R.id.Page_137_Image_Btn: // click for show dialog which choose between camera & galley

                if (hasMarshmallow()) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        showPictureDialog();
                    } else {
                        CustomTextView mytext = new CustomTextView(this);
                        mytext.setText("مجوز دسترسی داده نشده است!");
                        mytext.setTextColor(Color.WHITE);
                        mytext.setBackgroundColor(Color.rgb(231, 76, 60));
                        mytext.setPadding(17, 17, 17, 17);
                        mytext.setTypeface(CFProvider.getIRANIANSANS(this));
                        Toast toast = new Toast(this);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(mytext);
                        toast.show();
                    }
                } else {
                    showPictureDialog();
                }

                break;
            case R.id.Page_137_Voice_Btn: // open Voice Activity for recording voice

                startActivity(new Intent(this, Record_Voice.class));

                break;
            case R.id.Page_137_Video_Btn:// open gallery for choose video

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                galleryIntent.setType("video/*");
                startActivityForResult(galleryIntent, GALLERYVIDEO);


                break;
        }


        //        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
//            getSupportFragmentManager().popBackStack();
//        } else {
//            finish();
//        }

    }

    public void UploadInfo(JSONObject object) {
        progressDialog.show();
        Log.e("datasss", selectedVideoPath + " |" + imgDecodableString + " | " + VoicePath + " | " + type);


        Log.e("object", object.toString() + " |");


        if (selectedVideoPath != null) {
            Log.e("type", "Video");

            UploadContent(selectedVideoPath, object.toString(), Globals.ApiURLAll2 + "reciver");

        } else if (imgDecodableString != null) {
            Log.e("type", "image");


            UploadContent(imgDecodableString, object.toString(), Globals.ApiURLAll2 + "reciver");

        } else if (VoicePath != null) {


            Log.e("type", "voice");
            Page_137_Result.setText(Tools.getInstance(this).read("voice", ""));
            Tools.getInstance(this).write("voice", "");

            UploadContent(VoicePath, object.toString(), Globals.ApiURLAll2 + "reciver");
        } else {

            Log.e("dataNull", "null");
            UploadContent(VoicePath, object.toString(), Globals.ApiURLAll2 + "reciver");
        }

    }

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

        }

        @Override
        protected String doInBackground(String... params) {

//            UploadImage(Image);

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
                Toast.makeText(this, "مجوز صادر شد", Toast.LENGTH_SHORT).show();
                // TODO: 10/21/2017 13:58
            } else {
                Toast.makeText(this, "مجوز صادر نشد", Toast.LENGTH_SHORT).show();
                // TODO: 10/21/2017 13:58
            }
        }
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
//        pictureDialog.setTitle("انتخاب عکس");
        String[] pictureDialogItems = {
                "انتخاب از گالری",
                "دوربین"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Tools.getInstance(this).write("voice", "");
        AndroidNetworking.cancelAll();
    }

    private void clear() {
        address.getText().clear();
        name.getText().clear();
        family.getText().clear();
        phone.getText().clear();
        nationalCode.getText().clear();
        text.getText().clear();
    }

    public String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

//    public static boolean isValidIranianNationalCode(String input) {
//        if (!input.matches("^\\d{10}$"))
//            return false;
//
//        int check = Integer.parseInt(input.substring(9, 10));
//
//        int sum = Streams.intRange(0, 9)
//                .map((IntUnaryOperator) x ->
//                        Integer.parseInt(input.substring(x, x + 1)) * (10 - x))
//                .sum() % 11;
//
//        return (sum < 2 && check == sum) || (sum >= 2 && check + sum == 11);
//    }

    public boolean isValidIranianNationalCode() {
        char[] chArray = nationalCode.getText().toString().toCharArray();
        int[] numArray = new int[chArray.length];
        for (int i = 0; i < chArray.length; i++) {
            numArray[i] = (int) Character.forDigit(chArray[i], 100);
        }
        int num2 = numArray[9];
        switch (nationalCode.getText().toString()) {
            case "0000000000":
                return false;
            case "1111111111":
                return false;
            case "22222222222":
                return false;
            case "33333333333":
                return false;
            case "4444444444":
                return false;
            case "5555555555":
                return false;
            case "6666666666":
                return false;

            case "7777777777":
                return false;
            case "8888888888":
                return false;
            case "9999999999":
                return false;
        }
        int num3 = ((((((((numArray[0] * 10) + (numArray[1] * 9)) + (numArray[2] * 8)) + (numArray[3] * 7)) + (numArray[4] * 6)) + (numArray[5] * 5)) + (numArray[6] * 4)) + (numArray[7] * 3)) + (numArray[8] * 2);

        int num4 = num3 - ((num3 / 11) * 11);
        if ((((num4 == 0) && (num2 == num4)) || ((num4 == 1) && (num2 == 1))) || ((num4 > 1) && (num2 == Math.abs((int) (num4 - 11))))) {
            return true;
        } else {
            return false;
        }
    }

    // for captured image from camera
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    // for captured image from camera
    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (getContentResolver() != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public void UploadContent(String File, String Content, String Url) {

        AsyncHttpPost post = new AsyncHttpPost(Url);

        post.setTimeout(20000);

        MultipartFormDataBody body = new MultipartFormDataBody();

//        Log.e("sasasas", Tag + " | " + Id + " | " + Tools.getInstance(context).read("Token",""));

//        ContentResolver cR = getContentResolver();
////        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        String type11 =/* mime.getExtensionFromMimeType(*/cR.getType(TypeFile)/*)*/;

        Log.e("UploadResponse", File + " | " /*+ type11*/);
        body.addStringPart("key", Content);
        if (File != null) {
//            body.addStringPart("MIME", type11 );
            body.addFilePart("file", new File(File));
        }
        post.setBody(body);

        AsyncHttpClient.getDefaultInstance().executeString(post, new AsyncHttpClient.StringCallback() {
            @Override
            public void onCompleted(final Exception e, AsyncHttpResponse source, String result) {

                Log.e("UploadResponse", result + " |");

                try {

                    final JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.getString("status").equals("0")) {
                        Log.e("mymessage", jsonObject.getString("msg") + " | ");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                progressDialog.dismiss();
                                try {
                                    Toast.makeText(Page_137.this, jsonObject.getString("msg") + "", Toast.LENGTH_LONG).show();
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }

                            }
                        });
                    } else {
                        TrackingCodeModel data = new TrackingCodeModel();
                        data.setAddress(address.getText().toString());
                        data.setType(type);
                        data.setCode(jsonObject.getString("trackcode"));
                        data.setPhone(phone.getText().toString());
                        data.setName(name.getText().toString());
                        data.setFamily(family.getText().toString());
                        data.setNationalCode(nationalCode.getText().toString());
                        data.setContent(text.getText().toString());

                        MyTokenManager.getInstance(getBaseContext()).setTrackingCode(data);

                        Log.e("mymessage", jsonObject.getString("msg") + " | ");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                clear();
                                VoicePath = null;
                                imgDecodableString = null;
                                selectedVideoPath = null;
                                Page_137_Result.setText("");

                                progressDialog.dismiss();
                                try {
                                    Toast.makeText(Page_137.this, jsonObject.getString("msg") + "", Toast.LENGTH_LONG).show();
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                    Log.e("mymessage", e11.toString() + " | ");
                }

            }
        });

    }

    private void getAddressFromLocation(final double latitude, final double longitude) {

        Log.e("sajjad", "running");

//        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);


        try {
//            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
//
//            if (addresses.size() > 0) {
//                Address fetchedAddress = addresses.get(0);
//                Log.e("sajjad", "running12 : " + fetchedAddress.getAddressLine(0) + " | " + fetchedAddress.getMaxAddressLineIndex() );
//                StringBuilder strAddress = new StringBuilder();
//                for (int i = 0; i < fetchedAddress.getMaxAddressLineIndex(); i++) {
//                    strAddress.append(fetchedAddress.getAddressLine(i)).append(" ");
//                    Log.e("sajjad", "running11 : " + fetchedAddress.getAddressLine(i) );
//                }

//                Page137_AddressName.setText(fetchedAddress.getAddressLine(0));
//                Log.e("sajjad", "running : " + fetchedAddress.getAddressLine(0) );

//            } else {
//                Page137_AddressName.setText("Searching Current Address");
//            }

            StringRequest request1 = new StringRequest(Request.Method.GET, "https://map.ir/reverse?lon=" + longitude + "&lat=" + latitude, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("Page137_Response", response);
                    try {

                        JSONObject object = new JSONObject(response);
                        Log.e("Page137_Respons121e", object.getString("address"));

                        address.setText(object.getString("country") + " ، " + object.getString("address_compact") + " " + object.getString("village"));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Page_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                    Log.e("Page137_Error", error.toString() + " |");

                }
            }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
//                    params.put("lon", String.valueOf(latitude));
//                    params.put("lat", String.valueOf(longitude));
                    return params;
                }

            };

            Log.e("Page137_Erro11r", request1.getUrl() + " |");


            request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(request1);

        } catch (Exception e) {
            e.printStackTrace();
//            address.setText("Could not get address..!");
        }
    }


    private class CategoryModel {

        private String CatId;
        private String Title;
//        private List<CategoryModel> SubCategory = new ArrayList<>();

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getCatId() {
            return CatId;
        }

        public void setCatId(String catId) {
            CatId = catId;
        }

//        public List<CategoryModel> getSubCategory() {
//            return SubCategory;
//        }
//
//        public void setSubCategory(List<CategoryModel> subCategory) {
//            SubCategory = subCategory;
//        }
    }


    private void StepTwo(final String id) {
        adapterSub.clear();
        subCategory.clear();


        StringRequest request1 = new StringRequest(Request.Method.POST, Globals.ApiURLAll2 + "retrieve", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.e("StepTwo_Response", response);
                try {
                    JSONArray array1 = new JSONArray(response);

                    if (array1.length() == 0 ) {
                        SubCategory.setVisibility(View.GONE);
                        return;
                    }

                    Result.clear();
                    SubCategory.setVisibility(View.VISIBLE);
                    SubCategoryOne.setVisibility(View.GONE);
                    final List<CategoryModel> CategoryArray = new ArrayList<>();

                    for (int i = 0; i < array1.length(); i++) {

                        CategoryModel model = new CategoryModel();

                        model.setCatId(array1.getJSONObject(i).getString("id"));
//                        model.setTitle(array1.getJSONArray(i).getString(1));

                        CategoryArray.add(model);
                        subCategory.add(array1.getJSONObject(i).getString("title"));

                    }


                    adapterSub.addAll(subCategory);
                    adapterSub.add("یک موضوع را انتخاب کنید!");
                    SubCategory.setAdapter(adapterSub);
                    SubCategory.setSelection(adapterSub.getCount());


                    SubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id1) {
                            if (position > (subCategory.size() - 1)) {

                            } else {
                                StepThree(id, CategoryArray.get(position).getCatId());
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Page_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                Log.e("Page137_Error", error.toString() + " |");
                progressDialog.dismiss();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("request", "t2");
                params.put("data", id);
                return params;
            }

        };

        request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(request1);


    }

    private void StepThree(final String idOne, final String idTwo) {
        adapterSubOne.clear();
        subCategoryOne.clear();

        StringRequest request1 = new StringRequest(Request.Method.POST, Globals.ApiURLAll2 + "retrieve", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Log.e("StepThree_Response", response);
                try {
                    JSONArray array1 = new JSONArray(response);

                    if (array1.length() == 0 ) {
                        SubCategoryOne.setVisibility(View.GONE);
                        return;
                    }

                    SubCategoryOne.setVisibility(View.VISIBLE);

                    final List<CategoryModel> CategoryArray = new ArrayList<>();

                    for (int i = 0; i < array1.length(); i++) {

                        CategoryModel model = new CategoryModel();

                        model.setCatId(array1.getJSONObject(i).getString("id"));
//                        model.setTitle(array1.getJSONArray(i).getString(1));

                        CategoryArray.add(model);
                        subCategoryOne.add(array1.getJSONObject(i).getString("title"));

                    }


                    adapterSubOne.addAll(subCategoryOne);
                    adapterSubOne.add("یک موضوع را انتخاب کنید!");
                    SubCategoryOne.setAdapter(adapterSubOne);
                    SubCategoryOne.setSelection(adapterSubOne.getCount());


                    SubCategoryOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position > (subCategoryOne.size() - 1)) {

                            } else {

                                Result.add(0, idOne);
                                Result.add(1, idTwo);
                                Result.add(2, CategoryArray.get(position).getCatId());

                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Page_137.this, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                Log.e("Page137_Error", error.toString() + " |");
                progressDialog.dismiss();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("request", "t3");
                params.put("dataOne", idOne);
                params.put("dataTwo", idTwo);
                return params;
            }

        };

        request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(request1);


    }


}