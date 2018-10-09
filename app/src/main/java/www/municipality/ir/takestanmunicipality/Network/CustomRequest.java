package www.municipality.ir.takestanmunicipality.Network;


import android.util.Log;
//
//import com.android.volley.DefaultRetryPolicy;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import static www.municipality.ir.takestanmunicipality.Globals.ApiURL;


public class CustomRequest  {
//
//    public CustomRequest(String url, JSONObject jsonRequest, final ResponseAction responseAction, int type) {
//        super((type == 0) ? Request.Method.POST : Request.Method.GET, ApiURL + url, jsonRequest, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                if (response != null) {
//                    responseAction.onResponseAction(response);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                if (error!= null) {
//                    responseAction.onErrorAction(error);
//                }
//            }
//        });
//
//        this.setRetryPolicy(new DefaultRetryPolicy(10000,
//                                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//    }
//
//     public static abstract class ResponseAction {
//         public abstract void onResponseAction(JSONObject jsonObject);
//         public abstract void onErrorAction(VolleyError error);
//    }

//    @Override
//    public Map<String, String> getHeaders() throws AuthFailureError {
//        HashMap<String, String> params = new HashMap<String, String>();
////        params.put("Content-Type", "application/json");
//        params.put("Accept", "application/json");
//        Log.e("eeee", params.toString() + " |");
//        return params;
//    }
//
//    @Override
//    protected Map<String, String> getParams() throws AuthFailureError {
//        HashMap<String, String> params = new HashMap<>();
////        params.put("Content-Type", "application/json");
//        params.put("Accept", "sajjad");
//        Log.e("eeee", params.toString() + " |");
//        return params;
//    }
}
