package edu.fsu.cs.cen4020.potterpals;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

/**
 * Created by sap15e on 10/28/2017.
 */

public class MyContentProvider extends ContentProvider {
    public static final int DBVERSION = 1;
    public final static String DBNAME = "POTTER";
    public final static String TABLE_NAMESTABLE = "LoginTable";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_GENDER = "gender";
    public final static String COLUMN_DEPARTMENT = "department";

    public static final Uri CONTENT_URI = Uri.parse("content://edu.fsu.cs.cen4020.potterpals.provider/" + TABLE_NAMESTABLE);

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAMESTABLE + "(" + " _ID INTEGER PRIMARY KEY, "
             + COLUMN_NAME +
            " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_GENDER + " TEXT, " + COLUMN_DEPARTMENT +
            " TEXT)";

    private MainDataBaseHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        // TODO: Create Database
        mOpenHelper = new MainDataBaseHelper(getContext());
        return true;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: insert Employee information

        long id = mOpenHelper.getWritableDatabase().insert(TABLE_NAMESTABLE, null, values);
        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: update Employee information
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // TODO: delete Employee information
        return mOpenHelper.getWritableDatabase().delete(TABLE_NAMESTABLE, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: query Employee by selection

        return mOpenHelper.getReadableDatabase().query(TABLE_NAMESTABLE, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    protected static final class MainDataBaseHelper extends SQLiteOpenHelper {
        MainDataBaseHelper(Context context) { super(context, DBNAME, null, DBVERSION); }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

        }
    }
}
