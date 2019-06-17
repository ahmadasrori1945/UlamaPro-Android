package id.co.telkomsigma.ulamapro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class UserSessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    static final String SERVER_URL = "server_access";
    static final String SERVER_DEFAULT_API_URL = "http://nuconnect.digitalevent.id/";
    static final String SERVER_DEFAULT_URL = "https://apidiarium.digitalevent.id";

    static final String USER_NAME = "username";
    static final String USER_PASSWORD = "password";
    static final String USER_JWT_TOKEN = "device_token";
    static final String USER_FULL_NAME = "user_full_name";
    static final String USER_NICK_NAME = "user_nick_name";
    static final String USER_IS_LOGIN = "is_login";
    static final String USER_NOTIF = "notification";
    static final String USER_NAMA = "nama";
    public static String ACTIVITY_KEY;
    String nama;


    private static final String PREFER_NAME = "diarium_telkomsigma";

    public UserSessionManager(Context context) {
        this._context = context;

        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);

        editor = pref.edit();
    }

    public String getNama() {
        return pref.getString("nama", "");
    }

    public void setNama(String nama) {
        editor.putString("nama", nama);
        editor.commit();
    }

    public void setToken(String token){
        editor.putString(USER_JWT_TOKEN, token);
        editor.commit();
    }

    public String  getToken(){
        return pref.getString(USER_JWT_TOKEN, "-");
    }

    public void setLoginState(boolean state) {
        editor.putBoolean(USER_IS_LOGIN, state);
        editor.commit();
    }
    public void setUserName(boolean state) {
        editor.putBoolean(USER_NAME, state);
        editor.commit();
    }
    public String  getUserName(){
        return pref.getString(USER_NAME, "-");
    }


    public String getServerURL(){
        return pref.getString(SERVER_URL,SERVER_DEFAULT_API_URL);
    }

    public boolean isLogin(){
        return pref.getBoolean(USER_IS_LOGIN, false);
    }

    public void checkLogin() {
        // Check login status
        if (!this.isLogin()) {
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(USER_IS_LOGIN, false);
    }

    public void setCity(String city){

        editor.putString("city", city);
        editor.commit();
    }

    public String getCity(){
        return pref.getString("city", "-");
    }


    public void setCountry(String country){

        editor.putString("country", country);
        editor.commit();
    }

    public String getCountry(){
        return pref.getString("country", "-");
    }

    public void setPrayerTime(String imsak,String subuh,String terbit,String dzuhur,String ashar,String maghrib,String isya){

        editor.putString("imsak", imsak);
        editor.putString("subuh", subuh);
        editor.putString("terbit", terbit);
        editor.putString("dzuhur", dzuhur);
        editor.putString("ashar", ashar);
        editor.putString("maghrib", maghrib);
        editor.putString("isya", isya);
        editor.commit();
    }

    public String[] getPrayerTime(){
        String ret[] = new String[5];
        //ret[0] =  pref.getString("imsak", "--:--");
        ret[0] =  pref.getString("subuh", "--:--");
        //ret[2] =  pref.getString("terbit", "--:--");
        ret[1] =  pref.getString("dzuhur", "--:--");
        ret[2] =  pref.getString("ashar", "--:--");
        ret[3] =  pref.getString("maghrib", "--:--");
        ret[4] =  pref.getString("isya", "--:--");

        return ret;
    }




}

