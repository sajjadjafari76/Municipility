package www.municipality.ir.takestanmunicipality;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

public class ElectronicServices extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic_services);

        Toolbar toolbar = findViewById(R.id.ElectronicServices_Toolbar);
        RecyclerView recyclerView = findViewById(R.id.ElectronicServices_Recycler);
        ImageView backwards = findViewById(R.id.ElectronicServices_Backwards);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyCustomAdapter(getdata()));

        backwards.setOnClickListener(this);
    }

    private List<String> getdata() {
        List<String> data = new ArrayList<>();

        for (int i = 0; i < 6 ; i++) {
            if (i==0) {
                String text = "فرم ارزیابی خدمات شهری";
                data.add(text);
            }else if (i==1) {
                String text = "فرم تکریم ارباب رجوع";
                data.add(text);
            }else if (i==2) {
                String text = "فرم ملاقات مردمی با شهردار";
                data.add(text);
            }else if (i==3) {
                String text = "سامانه 137 شهرداری";
                data.add(text);
            }
        }
        return data;
    }

    @Override
    public void onClick(View v) {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mainactivity_menu,menu);
//
//        return true;
//    }

    private class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyCustomView> {

        List<String> data;
        public MyCustomAdapter(List<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyCustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyCustomView(LayoutInflater
                    .from(getApplicationContext()).inflate(R.layout.layout_electronic_item,null));
        }

        @Override
        public void onBindViewHolder(MyCustomView holder, final int position) {

            if ( (position % 2) == 0 ) {
                holder.view1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.back_card));
            }

            holder.textView.setText(data.get(position));
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        if (!Tools.getInstance(getApplicationContext()).isOnline()) {
                            Toast.makeText(ElectronicServices.this, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = null;
                            switch (position) {
                                case 0:
                                    intent = new Intent(getApplicationContext(), WebView_Electronic.class);
                                    intent.putExtra("info", "1");
                                    break;
                                case 1:
                                    intent = new Intent(getApplicationContext(), WebView_Electronic.class);
                                    intent.putExtra("info", "2");
                                    break;
                                case 2:
                                    intent = new Intent(getApplicationContext(), WebView_Electronic.class);
                                    intent.putExtra("info", "3");
                                    break;
                                case 3:
                                    intent = new Intent(getApplicationContext(), WebView_Electronic.class);
                                    intent.putExtra("info", "4");
                                    break;
                                case 4:
                                    intent = new Intent(getApplicationContext(), WebView_Electronic.class);
                                    intent.putExtra("info", "5");
                                    break;
                            }
                            startActivity(intent);

                        }
                    }catch (Exception e){
                        Toast.makeText(ElectronicServices.this, "اینترنت در دسترس نیست!", Toast.LENGTH_SHORT).show();
                        Log.e("error", e.toString() + " | " + e.toString());
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyCustomView extends RecyclerView.ViewHolder {

            private CardView cardView;
            private CustomTextView textView;
            private RelativeLayout view1, view2;

            public MyCustomView(View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.ElectronicItem_Card);
                textView = itemView.findViewById(R.id.ElectronicItem_Text);
                view1 = itemView.findViewById(R.id.ElectronicItem_View1);
                view2 = itemView.findViewById(R.id.ElectronicItem_View2);
            }
        }
    }

}
