package www.municipality.ir.takestanmunicipality.DataBase;

import android.content.Context;
import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;

public class MyTokenManager {

    private MyDataBase mDb;
    private static MyTokenManager INSTANCE;
    private Context mContext;

    private MyTokenManager(Context context){
        mContext = context.getApplicationContext();
    }

    public static synchronized MyTokenManager getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new MyTokenManager(context);
        }
        return INSTANCE;
    }

    public void setTrackingCode(TrackingCodeModel code) {
        mDb = new MyDataBase(mContext);
        mDb.setTrackingCode(code);
    }

    public List<TrackingCodeModel> getTrackingCode() {
        mDb = new MyDataBase(mContext);
        return mDb.getTrackingCode();
    }

}
