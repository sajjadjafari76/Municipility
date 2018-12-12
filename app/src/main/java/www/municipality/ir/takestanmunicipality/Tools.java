package www.municipality.ir.takestanmunicipality;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by "SAJJAD JAFARI"
 * Author by sajjad jafari
 * Hamnama Application
 * 16 Novambr 2017 && 1396/8/25
 */

public class Tools {

    private static Tools tools;
    private static SharedPreferences sharedPreferences;
    private static String Name = "Restaurant";
    public Context context;

    private Tools(Context context){this.context = context;}

    public static synchronized Tools getInstance(Context myContext) {
        if (tools == null)
        {
            tools = new Tools(myContext);
            if (sharedPreferences == null)
            {
                sharedPreferences = myContext.getSharedPreferences(Name, Context.MODE_PRIVATE);
            }
        }
        return tools;
    }

    public String FormattedPrice(String number) {
        String FormattedNumber = "";
        for (int i=0; i<number.length(); i++) {
            if (((number.length()) - i) % 3 == 0 && i != 0) {
                FormattedNumber += ",";
            }
            FormattedNumber += number.charAt(i);
        }
        return FormattedNumber;
    }

    public String read(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }
    public void write(String key, String value) {
        SharedPreferences.Editor text = sharedPreferences.edit();
        text.putString(key , value);
        text.apply();
    }

    public boolean isOnline() {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo != null)
        {
            return (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    ||
                    activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) ?  true : false;
        }
        return false;
    }

    public int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}
