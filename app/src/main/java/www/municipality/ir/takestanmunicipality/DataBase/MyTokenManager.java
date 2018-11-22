package www.municipality.ir.takestanmunicipality.DataBase;

import android.content.Context;

import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;

public class MyTokenManager {

    private MyDataBase mDb;
    private static MyTokenManager INSTANCE;
    private Context mContext;

    public MyTokenManager(Context context){
        mContext = context;
    }

    public static synchronized MyTokenManager getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new MyTokenManager(context);
        }
        return INSTANCE;
    }

    public boolean setTrackingCode(TrackingCodeModel code) {
        mDb = new MyDataBase(mContext);
        return mDb.setTrackingCode(code);
    }

//
    public List<TrackingCodeModel> getTrackingCode() {
        mDb = new MyDataBase(mContext);
        return mDb.getTrackingCode();
    }
//
//
//    public void setChildInfo(List<ChildModel> models) {
//        mDb = new MyDataBase(mContext);
//        mDb.setAllChildInfo(models);
//    }
//
//    public List<ChildModel> getChildInfo() {
//        mDb = new MyDataBase(mContext);
//        return mDb.getChildInfo();
//    }
//
//    public boolean setChildApps(String childApps, String key) {
//        mDb = new MyDataBase(mContext);
//        return mDb.setChildApps(childApps, System.currentTimeMillis(), key);
//    }
//
//    public MyDataBase.childApps getChildApps() {
//        mDb = new MyDataBase(mContext);
//        return mDb.getChildApps();
//    }

}
