package com.widiyanto.user.majalahberita;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by BonCabe on 7/17/2016.
 */

//shaf

@SuppressWarnings({"ALL", "WeakerAccess"})
public class SharedPref {
    private SharedPreferences sp;
    private SharedPreferences.Editor spe;
    private Context context;

    public SharedPref(Context ctx) {
        sp = ctx.getSharedPreferences("com.widiyanto.user.majalahberita", Context.MODE_PRIVATE);
        spe = sp.edit();
    }

    public void resetAll(){
        setIdUser(null);
        setIsLogin(false);
    }

    public void setNamaLengkap (String NamaLengkap) {
        spe.putString("namalengkap", NamaLengkap);
        spe.commit();
    }

    public String getNamaLengkap(){
        return sp.getString("namalengkap",null);
    }

    public void setUserName (String UserName) {
        spe.putString("username", UserName);
        spe.commit();
    }
    public String getUserName() {
        return sp.getString("username",null);
    }

    public void setEmail (String Email){
        spe.putString("email",Email);
        spe.commit();
    }
    public String getEmail(){
        return sp.getString("email",null);
    }

    public void setAlamat (String Alamat) {
        spe.putString("alamat", Alamat);
        spe.commit();
    }
    public String getAlamat () {
        return sp.getString("alamat",null);
    }

    public void setNomerHP (String NomerHP) {
        spe.putString("nomerhp", NomerHP );
        spe.commit();
    }
    public String getNomerHP () {
        return sp.getString("nomerhp" , null);
    }

    public void setIsLogin(boolean isLogin){
        spe.putBoolean("islogedin",isLogin);
        spe.commit();
    }

    public boolean getIsLogin(){
        return sp.getBoolean("islogedin",false);
    }


    public void setIdUser(String idUser){
        spe.putString("iduser",idUser);
        spe.commit();
    }

    public String getIdUser(){
        return sp.getString("iduser",null);
    }

}

