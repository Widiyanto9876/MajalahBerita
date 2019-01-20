package com.widiyanto.user.majalahberita.Helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.widiyanto.user.majalahberita.Entity.EntityRegister;
import com.widiyanto.user.majalahberita.SharedPref;

public class DBHelper extends SQLiteAssetHelper {

    private Context mContext;
    public static final String DBNAME = "DBRegister.db";
    public static final int DBVERSION = 1;
    private SQLiteDatabase mDatabase;

    private SharedPref sharedPref;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        this.mContext = context;
    }

    public void openDatabase() {
        mDatabase = getWritableDatabase();
    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }


    public int checkLogin(String username, String pass) {
        int id = -1;
        openDatabase();

        callSharedPref();

        Cursor cursor = mDatabase.rawQuery("Select * From User where UserName=? AND Password=?", new String[]{username,
                pass});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            id = cursor.getInt(0);
            sharedPref.setNamaLengkap(cursor.getString(3));
            sharedPref.setEmail(cursor.getString(2));
            sharedPref.setUserName(cursor.getString(1));
            sharedPref.setAlamat(cursor.getString(5));
            sharedPref.setNomerHP(cursor.getString(4));
            sharedPref.setIdUser(String.valueOf(id));
            cursor.close();
        }

        closeDatabase();
        return id;
    }

    public void sendRegister(EntityRegister regis) {
        openDatabase();

        mDatabase.rawQuery("insert into User (UserName, Email, NamaPengguna, NomerHP, Alamat, Password) values (?,?,?,?,?,?)", new String[]{
                regis.getUserName(), regis.getEmail(), regis.getNamaPengguna(), regis.getNomerHp(), regis.getAlamat(), regis.getPassword()
        });

        closeDatabase();
    }

    public void callSharedPref() {
        sharedPref = new SharedPref(mContext);
    }

    public void deleteDatabase() {
        closeDatabase();
        mContext.deleteDatabase(DBNAME);
    }
}
