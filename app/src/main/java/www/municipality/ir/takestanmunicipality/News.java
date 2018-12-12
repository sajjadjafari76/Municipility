package www.municipality.ir.takestanmunicipality;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;
import www.municipality.ir.takestanmunicipality.appController.AppController;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURLAllNews;

public class News extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private CustomTextView empty;
    private ImageView News_Backwards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        empty = findViewById(R.id.News_Empty);
        News_Backwards = findViewById(R.id.News_Backwards);
        recyclerView = findViewById(R.id.News_Recycler);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        progressDialog = new ProgressDialog(News.this);
        progressDialog.setMessage("در حال بارگذاری ...");
        progressDialog.show();

        final StringRequest request1 = new StringRequest(Request.Method.POST, ApiURLAllNews + "feed", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Loggggg", response + " |");
                try {
                    List<NewsModel> data = new ArrayList<>();

                    JSONArray array = new JSONArray(response);

                    if (array.length() == 0) {
                        empty.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        return;
                    }

                    for (int i = 0 ; i < array.length() ; i++) {
                        NewsModel model = new NewsModel();
                        model.setImage(array.getJSONArray(i).getString(0));
                        model.setTopic(array.getJSONArray(i).getString(1));
                        model.setContent(array.getJSONArray(i).getString(2));
                        model.setDate(array.getJSONArray(i).getString(3));
                        data.add(model);
                    }
                    SlideInUpAnimator animator = new SlideInUpAnimator(new OvershootInterpolator(1f));
                    animator.setInterpolator(new OvershootInterpolator());
                    recyclerView.setItemAnimator(animator);
                    recyclerView.getItemAnimator().setMoveDuration(1000);
                    recyclerView.getItemAnimator().setChangeDuration(1000);
                    MainAdapter adapter = new MainAdapter(getApplicationContext(), data);
                    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
                    alphaAdapter.setDuration(1000);
                    recyclerView.setAdapter(adapter);

                    progressDialog.dismiss();
                } catch (Exception e) {
                    progressDialog.dismiss();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                empty.setText("خطایی رخ داد لطفا دوباره تلاش کنید!");
                empty.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                Log.e("error1", error.toString() + " |");
                progressDialog.dismiss();
            }
        });

        request1.setRetryPolicy(new DefaultRetryPolicy(10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(request1);


        News_Backwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

        private Context mContext;
        private List<NewsModel> mDataSet;

        public MainAdapter(Context context, List<NewsModel> dataSet) {
            mContext = context;
            mDataSet = dataSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.news_layout, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

//            Display display = getWindowManager().getDefaultDisplay();
//            Point size = new Point();
//            display.getSize(size);
//            int width = size.x;
//            int height = size.y;

//            DisplayMetrics displaymetrics = new DisplayMetrics();
//            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//
//            int screenHeight = displaymetrics.heightPixels;
//            int screenWidth = displaymetrics.widthPixels;
//
//            Log.e("screen", displaymetrics.heightPixels + " | " + displaymetrics.widthPixels);
//
//            double imgHeight = screenHeight;
//            double imgWidth =  screenWidth;

            Picasso.with(mContext)
                    .load(mDataSet.get(position).Image)
                    .error(R.drawable.no_image)
                    .resize( 400,400)
                    .onlyScaleDown()
                    .into(holder.Image);

            holder.Topic.setText(mDataSet.get(position).Topic);
            holder.Content.setText(mDataSet.get(position).getContent());
            holder.Date.setText(mDataSet.get(position).getDate());
        }

        @Override
        public int getItemCount() {
            return mDataSet.size();
        }

        public void remove(int position) {
            mDataSet.remove(position);
            notifyItemRemoved(position);
        }

        public void add(NewsModel text, int position) {
            mDataSet.add(position, text);
            notifyItemInserted(position);
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView Image;
            public CustomTextView Topic, Content, Date;

            public ViewHolder(View itemView) {
                super(itemView);
                Image = itemView.findViewById(R.id.NewsLayout_Image);
                Topic = itemView.findViewById(R.id.NewsLayout_Topic);
                Content = itemView.findViewById(R.id.NewsLayout_Content);
                Date = itemView.findViewById(R.id.NewsLayout_Date);
            }
        }
    }

    public class NewsModel {

        private String Image;
        private String Topic;
        private String Content;
        private String Date;

        public String getImage() {
            return Image;
        }

        public void setImage(String image) {
            Image = image;
        }

        public String getTopic() {
            return Topic;
        }

        public void setTopic(String topic) {
            Topic = topic;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }
    }

}
