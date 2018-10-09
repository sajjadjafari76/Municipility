package www.municipality.ir.takestanmunicipality;

import android.app.Activity;

import org.json.JSONObject;
/**
 * Created by sajjadnet on 1/10/2018.
 */

public class Functions {

    private static Functions functions;
    private Activity context;

    private Functions(Activity context) {
        this.context = context;
    }
    public static Functions getInstance(Activity context) {
        if (functions == null) {
            functions = new Functions(context);
        }
        return functions;
    }


    public void Login(String UserName, String Pass, final GetLoginStatus status) {

        JSONObject dataSend = null;
        try {
            dataSend = new JSONObject();
//            Log.e("sdv", UserName + " | " + Pass);
            dataSend.put("email", UserName);
            dataSend.put("password", Pass);
        } catch (Exception er) {
            er.printStackTrace();
        }

//        Log.e("sdv", dataSend.toString() + " |");
//        CustomRequest LoginRequest = new CustomRequest(
//                "/login",
//                dataSend,
//                new CustomRequest.ResponseAction() {
//                    @Override
//                    public void onResponseAction(JSONObject jsonObject) {
//
//                        try {
//                            Log.e("LoginResponse", jsonObject.toString() + "|");
//
////                            {"data":{"firstName":"admin","lastName":"admin","email":"admin@email.com","level":null,
////                                    "api_token":"vzFkpPLLm4Do9VoQXLonxIZGyzG0xDGXOhGriDL9MGOYndPGRKeTlIOSaZCaSmoBAR1HTk09vquPAQJ48yHYggOoLf0dB8ceYFgQ",
////                                    "status":1}}|
//
//
//                            if (jsonObject.has("data")) {
//                                JSONObject object = jsonObject.getJSONObject("data");
//
//                                Tools.getInstance(context).write("Token", object.getString("api_token"));
//                                Tools.getInstance(context).write("UserId", object.getString("id"));
//                                Tools.getInstance(context).write("Type", Tools.getInstance(context).TypeOfUser(object.getInt("level")));
//                                Tools.getInstance(context).write("FirstName", object.getString("firstName"));
//                                Tools.getInstance(context).write("LastName", object.getString("lastName"));
//                                context.startActivity(new Intent(context, MainActivity.class));
//                                status.onReceived("Ok");
//
//                            }
//                        } catch (Exception er) {
//                            status.onError("Error");
//                            Log.e("LoginError", er.toString());
//                        }
//
//                    }
//
//                    @Override
//                    public void onErrorAction(VolleyError error) {
//                        error.printStackTrace();
//                        Log.e("LoginVolleyError", error.toString());
//                        status.onError("Error");
//                    }
//                }
//                , 0);
//
//        AppController.getInstance().addToRequestQueue(LoginRequest);

//        Tools.getInstance(context).write("Token", "vzFkpPLLm4Do9VoQXLonxIZGyzG0xDGXOhGriDL9MGOYndPGRKeTlIOSaZCaSmoBAR1HTk09vquPAQJ48yHYggOoLf0dB8ceYFgQ");
//        Tools.getInstance(context).write("Type", Tools.getInstance(context).TypeOfUser(1));
//        Tools.getInstance(context).write("FirstName", "سجاد");
//        Tools.getInstance(context).write("LastName", "جعفری");
//        context.startActivity(new Intent(context, MainActivity.class));
    }


    //****   Interface   ****//
    public interface GetLoginStatus {
        void onReceived(String Receiveddata);

        void onError(String Errordata);
    }
}
