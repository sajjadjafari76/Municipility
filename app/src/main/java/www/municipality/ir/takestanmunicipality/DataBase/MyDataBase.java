package www.municipality.ir.takestanmunicipality.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import www.municipality.ir.takestanmunicipality.DataModel.TrackingCodeModel;

public class MyDataBase extends SQLiteOpenHelper {

    private static final String TAG = "MyDataBase";

    private static final String DATABASE_NAME = "kangaroo_db";
    private static final int DATABASE_VERSION = 1;
    private static final String CHILD_APPS_TABLE_NAME = "tbl_child_apps";

    private final String CHILD_APPS_COL_ID = "col_id";
    private final String CHILD_APPS_COL_TRACKING_CODE = "col_code";
    private final String CHILD_APPS_COL_TYPE = "col_type";
    private final String CHILD_APPS_COL_CONTENT = "col_content";
    private final String CHILD_APPS_COL_ADDRESS = "col_address";
    private final String CHILD_APPS_COL_NAME = "col_name";
    private final String CHILD_APPS_COL_FAMILY = "col_family";
    private final String CHILD_APPS_COL_PHONE = "col_phone";
    private final String CHILD_APPS_COL_NATIONAL_CODE = "col_national_code";
    private final String CHILD_APPS_TABLE = "CREATE TABLE IF NOT EXISTS " + CHILD_APPS_TABLE_NAME + "(" +
            CHILD_APPS_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            CHILD_APPS_COL_TYPE + " TEXT, " +
            CHILD_APPS_COL_CONTENT + " TEXT, " +
            CHILD_APPS_COL_ADDRESS + " TEXT, " +
            CHILD_APPS_COL_NAME + " TEXT, " +
            CHILD_APPS_COL_FAMILY + " TEXT, " +
            CHILD_APPS_COL_PHONE + " TEXT, " +
            CHILD_APPS_COL_NATIONAL_CODE + " TEXT, " +
            CHILD_APPS_COL_TRACKING_CODE + " TEXT );";


    MyDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CHILD_APPS_TABLE);
        }catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG , e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    // Child
    public boolean setTrackingCode(TrackingCodeModel code) {

        try {
            ContentValues cp = new ContentValues();
            cp.put(CHILD_APPS_COL_TYPE, code.getType());
            cp.put(CHILD_APPS_COL_CONTENT, code.getContent());
            cp.put(CHILD_APPS_COL_ADDRESS, code.getAddress());
            cp.put(CHILD_APPS_COL_NAME, code.getName());
            cp.put(CHILD_APPS_COL_FAMILY, code.getFamily());
            cp.put(CHILD_APPS_COL_PHONE, code.getPhone());
            cp.put(CHILD_APPS_COL_NATIONAL_CODE, code.getNationalCode());
            cp.put(CHILD_APPS_COL_TRACKING_CODE, code.getCode());

            SQLiteDatabase database = getWritableDatabase();
            long status = database.insert(CHILD_APPS_TABLE_NAME, null, cp);

            if (status > 0) {
                database.close();
                return true;
            }else {
                database.close();
                return false;
            }

        }catch (Exception e) {
            Log.e(TAG , e.toString());
            return false;
        }
    }

    public List<TrackingCodeModel> getTrackingCode() {
        List<TrackingCodeModel> models = new ArrayList<>();
        Cursor cursor;
        SQLiteDatabase database = getReadableDatabase();
        cursor = database
                .rawQuery("SELECT * FROM " + CHILD_APPS_TABLE_NAME + " ORDER BY " + CHILD_APPS_COL_ID + " DESC "/*+ " WHERE " + TOKEN_COL_Parent_ACCESS_TOKEN + "=" + value*/, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (!cursor.isAfterLast()) {
                TrackingCodeModel model = new TrackingCodeModel();
                model.setType( cursor.getString(1));
                model.setContent( cursor.getString(2));
                model.setAddress( cursor.getString(3));
                model.setName( cursor.getString(4));
                model.setFamily( cursor.getString(5));
                model.setPhone( cursor.getString(6));
                model.setNationalCode( cursor.getString(7));
                model.setCode( cursor.getString(8));
                models.add(model);
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
        return models;
    }

}
