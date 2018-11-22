package www.municipality.ir.takestanmunicipality.Page_137.Request;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.github.florent37.expansionpanel.ExpansionHeader;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import www.municipality.ir.takestanmunicipality.AppController.AppController;
import www.municipality.ir.takestanmunicipality.DataModel.ParentModel;
import www.municipality.ir.takestanmunicipality.Page_137.Consistency_137;
import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Views.CustomTextView;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURLAllNews;


public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.myViewHolder>{

    private List<ParentModel> data;
    private Activity context;

    public MyRequestAdapter(List<ParentModel> datas, Activity context) {
        this.data = datas;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.parent_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, final int position) {

        final ExpansionLayoutCollection expansionLayoutCollection = new ExpansionLayoutCollection();
        expansionLayoutCollection.add(holder.expansionLayout);
        expansionLayoutCollection.openOnlyOne(false);

        final ParentModel model = data.get(position);

        holder.Content.setText(model.getContent());
        holder.TrackingCode.setText("کد پیگیری : " + model.getTrackingCode());


        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("log56", "uiouiouio");
                if (holder.expansionLayout.isExpanded()) {
                    holder.expansionLayout.collapse(true);
                }else {
                    holder.expansionLayout.expand(true);
                }

                    Log.e("sa343", "435345");
                    StringRequest request1 = new StringRequest(Request.Method.POST, ApiURLAllNews + "feed", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("Loggggg", response + " |");
                            try {
                                JSONArray array = new JSONArray(response);

                                if (array.getJSONObject(0).getString("status").equals("0")) {
                                    holder.Date.setText("");
                                    holder.Response.setText(array.getJSONObject(1).getString("msg"));
                                    return;
                                }

                                if (array.getJSONObject(0).getInt("status") == 1) {
                                    if (array.getJSONObject(3).getString("rs").equals("0")) {
                                        holder.Date.setText("");
                                        holder.Response.setText(" نتیجه : در انتظار بررسی مدیر سیستم ");
                                        holder.Response.setGravity(Gravity.CENTER);
                                    } else if (array.getJSONObject(3).getString("rs").equals("1")) {
                                        holder.Date.setText("");
                                        holder.Response.setText(" نتیجه : شهروند گرامی پیام شما در حال بررسی می باشد.");
                                        holder.Response.setGravity(Gravity.CENTER);
                                    } else if (array.getJSONObject(3).getString("rs").equals("2")) {
                                        holder.Date.setText(" پاسخ داده شده در تاریخ " + array.getJSONObject(5).getString("d"));
                                        holder.Response.setText(array.getJSONObject(2).getString("tr"));
                                        holder.Response.setGravity(Gravity.RIGHT);
                                    }
                                    holder.progressBar.setVisibility(View.GONE);
                                    holder.View1.setVisibility(View.VISIBLE);
                                    holder.Info.setText(/*"ارسال شده توسط آقای/خانم " + model.getInfo()*/ "");
                                }
                            } catch (Exception e) {
                                Log.e("error", e.toString() + " |");
//                            Toast.makeText(context, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                                holder.Response.setText("درخواست شما با مشکل موجه شد لطفا بعدا تلاش کنید!");
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(context, "با مشکلی مواجه شد لطفا دوباره تلاش کنید!", Toast.LENGTH_SHORT).show();
                            holder.Response.setText("درخواست شما با مشکل موجه شد لطفا بعدا تلاش کنید!");
                            Log.e("error1", error.toString() + " |");
//                        progressDialog.dismiss();
                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("trackCode", model.getTrackingCode());
                            return params;
                        }
                    };

                    request1.setRetryPolicy(new DefaultRetryPolicy(18000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                    AppController.getInstance().addToRequestQueue(request1);

            }
        });





    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder {

        ExpansionLayout expansionLayout;
        ExpansionHeader Header;
        private CustomTextView Content;
        private CustomTextView TrackingCode, Date, Response, Info;
        private LinearLayout Btn;
        private CardView Card;
        private ProgressBar progressBar;
        private RelativeLayout View1, myView;

        myViewHolder(View itemView) {
            super(itemView);
            Content = itemView.findViewById(R.id.Parent_Content);
            TrackingCode = itemView.findViewById(R.id.Parent_Code);
            expansionLayout = itemView.findViewById(R.id.Parent_Layout);
            Date = itemView.findViewById(R.id.Parent_Date);
            Response = itemView.findViewById(R.id.Parent_Response);
            Info = itemView.findViewById(R.id.Parent_Info);
            Btn = itemView.findViewById(R.id.Parent_Btn);
            Header = itemView.findViewById(R.id.Parent_Header);
            Card = itemView.findViewById(R.id.Parent_Card);
            progressBar = itemView.findViewById(R.id.Parent_Progress);
            View1 = itemView.findViewById(R.id.Parent_ViewChild1);
            myView = itemView.findViewById(R.id.Parent_MyHeader);
        }
    }

}
