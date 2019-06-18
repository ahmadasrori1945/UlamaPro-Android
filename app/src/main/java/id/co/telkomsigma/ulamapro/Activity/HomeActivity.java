package id.co.telkomsigma.ulamapro.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import id.co.telkomsigma.ulamapro.Absen_dosenActivity;
import id.co.telkomsigma.ulamapro.ChannelActivity;
import id.co.telkomsigma.ulamapro.KIblatWebActivity;
import id.co.telkomsigma.ulamapro.NotifikasiActivity;
import id.co.telkomsigma.ulamapro.R;
import id.co.telkomsigma.ulamapro.SettingActivity;
import id.co.telkomsigma.ulamapro.SholawatActivity;
import id.co.telkomsigma.ulamapro.TahlilActivity;
import id.co.telkomsigma.ulamapro.UserSessionManager;
import id.co.telkomsigma.ulamapro.util.Connection;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

public class HomeActivity extends AppCompatActivity {

    private UserSessionManager sess;
    private boolean doubleBackToExitPressedOnce = false;
    private String time = "";



    private static final int PERMISSION_REQUEST_CODE =11 ;

    private TextView txtTime,txtLoc,txtSolatTime,txtSolatTimeName;
    private TextView tvEventStart;
    private Handler handler;
    private Runnable runnable;
    Connection conn;


    Typeface font, fontbold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sess = new UserSessionManager(getApplicationContext());
        conn = new Connection();


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView texttime = (TextView) findViewById(R.id.tvTime);
                                long clock = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("kk : mm : ss a");
                                String timeString = sdf.format(clock);
                                texttime.setText(timeString);

                            }
                        });
                    }
                } catch (InterruptedException e) {

                }
            }
        };
        t.start();

        Calendar calendar = Calendar.getInstance();
        String curentdate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textView = findViewById(R.id.text_tanggal);
        textView.setText(curentdate);
        textView.setTypeface(fontbold);

        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Bold.otf");

        TextView posisi = (TextView) findViewById(R.id.posisi);
        posisi.setTypeface(fontbold);
        TextView tanggal = (TextView) findViewById(R.id.text_tanggal);
        tanggal.setTypeface(fontbold);
        txtLoc = (TextView) findViewById(R.id.tv_lokasi);
        txtLoc.setTypeface(fontbold);
        txtSolatTime = (TextView) findViewById(R.id.waktu_solat);
        txtSolatTime.setTypeface(fontbold);
        txtSolatTimeName = (TextView) findViewById(R.id.text_sholatjadwal);
        txtSolatTimeName.setTypeface(fontbold);
        txtTime = (TextView) findViewById(R.id.countdown);
        txtTime.setTypeface(fontbold);
        TextView alquran = (TextView) findViewById(R.id.text_alquran);
        alquran.setTypeface(fontbold);
        TextView channel = (TextView) findViewById(R.id.text_channel);
        channel.setTypeface(fontbold);
        TextView sholawat = (TextView) findViewById(R.id.text_sholawat);
        sholawat.setTypeface(fontbold);
        TextView news = (TextView) findViewById(R.id.text_news);
        news.setTypeface(fontbold);

        TextView amal = (TextView) findViewById(R.id.text_amal);
        amal.setTypeface(fontbold);
        TextView tahlil = (TextView) findViewById(R.id.text_tahlil);
        tahlil.setTypeface(fontbold);
        TextView kiblat = (TextView) findViewById(R.id.text_kiblat);
        kiblat.setTypeface(fontbold);
        TextView sholat = (TextView) findViewById(R.id.text_sholat);
        sholat.setTypeface(fontbold);
//        TextView a6 = (TextView) findViewById(R.id.text_tanggal2);
//        a6.setTypeface(fontbold);
//        TextView a7 = (TextView) findViewById(R.id.text_deskripsi);
//        a7.setTypeface(fontbold);
//        TextView a8 = (TextView) findViewById(R.id.text_berita);
//        a8.setTypeface(fontbold);


//        NonScrollListView non_scroll_list = (NonScrollListView) findViewById(R.id.lv_nonscroll_list);


//        Adapter_ponpes adapter=new Adapter_ponpes(HomeActivity.this,judul,tanggal,deskripsi);
//        non_scroll_list.setAdapter(adapter);

        LinearLayout goto_waktu = (LinearLayout) findViewById(R.id.layout_waktusholat);
        goto_waktu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Waktu_sholatActivity.class);
                startActivity(i);
            }
        });

        LinearLayout goto_kiblat = (LinearLayout) findViewById(R.id.layout_kiblat);
        goto_kiblat.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), KIblatWebActivity.class);
                startActivity(i);
            }
        });

        ImageView goto_notif = (ImageView) findViewById(R.id.btnPopup);
        goto_notif.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), NotifikasiActivity.class);
                startActivity(i);
            }
        });

        ImageView goto_settings = (ImageView) findViewById(R.id.logouts);
        goto_settings.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
            }
        });


        LinearLayout goto_quran = (LinearLayout) findViewById(R.id.layout_quran);
        goto_quran.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), QuranActivity.class);
                startActivity(i);
            }
        });

        LinearLayout goto_tasbih = (LinearLayout) findViewById(R.id.layout_tasbih);
        goto_tasbih.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), ChannelActivity.class);
                startActivity(i);
            }
        });

//        news
        LinearLayout goto_jadwal = (LinearLayout) findViewById(R.id.layout_jadwal);
        goto_jadwal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), NotifikasiActivity.class);
                startActivity(i);
            }
        });

        LinearLayout goto_asmaul = (LinearLayout) findViewById(R.id.layout_sholawat);
        goto_asmaul.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SholawatActivity.class);
                startActivity(i);
            }
        });

        LinearLayout goto_absensantri = (LinearLayout) findViewById(R.id.layout_santri);
        goto_absensantri.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), TahlilActivity.class);
                startActivity(i);
            }
        });

        LinearLayout goto_absendosen = (LinearLayout) findViewById(R.id.layout_dosen);
        goto_absendosen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Absen_dosenActivity.class);
                startActivity(i);
            }
        });

//        LinearLayout goto_next_berita= (LinearLayout) findViewById(R.id.next_berita);
//        goto_next_berita.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View arg0) {
//                Intent i = new Intent(getApplicationContext(), PonpesnewsActivity.class);
//                startActivity(i);
//            }
//        });

        initLocation();
    }
    private void initLocation(){txtLoc.setText(sess.getCity()+" , "+sess.getCountry()); }

    @Override
    protected void onResume() {
        super.onResume();

//        AutoUpdater au = new AutoUpdater(HomeActivity.this);
//        au.cekServer();

        long mLocTrackingInterval = 1000 *10;
        float trackingDistance = 15;
        LocationAccuracy trackingAccuracy = LocationAccuracy.HIGH;

        LocationParams.Builder builder = new LocationParams.Builder()
                .setAccuracy(trackingAccuracy)
                .setDistance(trackingDistance)
                .setInterval(mLocTrackingInterval);

//        SmartLocation.with(getApplicationContext())
//                .location()
//                .config(LocationParams.BEST_EFFORT)
//                .oneFix()
//                .start(new OnLocationUpdatedListener() {
//                    @Override
//                    public void onLocationUpdated(Location location) {
//                        System.out.println("cek lat : "+location.getLatitude());
//                        System.out.println("cek lon : "+location.getLongitude());
//                    }
//                });

        if(!SmartLocation.with(getApplicationContext()).location().state().locationServicesEnabled()){
            AlertDialog.Builder b;

            b = new AlertDialog.Builder(HomeActivity.this);

            b.setTitle("Enable GPS")
                    .setMessage("GPS tidak aktif, aktifkan GPS ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .show();

        }
        // Check if the location services are enabled
        System.out.println("loc service :"+SmartLocation.with(getApplicationContext()).location().state().locationServicesEnabled());
// Check if any provider (network or gps) is enabled
        System.out.println("network or gps service :"+SmartLocation.with(getApplicationContext()).location().state().isAnyProviderAvailable());
// Check if GPS is available
        System.out.println("gps available :"+SmartLocation.with(getApplicationContext()).location().state().isGpsAvailable());


// Check if Network is available
        System.out.println("network available :"+SmartLocation.with(getApplicationContext()).location().state().isNetworkAvailable());
        // Check if the passive provider is available
        System.out.println("passive provider available "+SmartLocation.with(getApplicationContext()).location().state().isPassiveAvailable());
        // Check if the location is mocked
        System.out.println("mock available : "+SmartLocation.with(getApplicationContext()).location().state().isMockSettingEnabled());

        getLocation();
        calculateCountdown();
    }
    public void getLocation(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)){
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("Permintaan Lokasi")
                            .setMessage("Permintaan untuk lokasi")
                            .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                @RequiresApi(api = Build.VERSION_CODES.M)
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
                                }
                            })
                            .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //Toast.makeText(HomeActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
                }
            } else{
                SmartLocationCityName();
            }
        }else{
            SmartLocationCityName();
        }
    }

    public void SmartLocationCityName(){
        SmartLocation.with(getApplicationContext()).location()
                .start(new OnLocationUpdatedListener() {



                    @Override
                    public void onLocationUpdated(Location location) {

                        Double lat = location.getLatitude();
                        Double lon = location.getLongitude();
                        //  Toast.makeText(getApplicationContext(),lat+" "+lon+" ",Toast.LENGTH_LONG).show();

                        try {
                            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(lat, lon, 1);
                            String cityName = addresses.get(0).getAddressLine(0);
                            String stateName = addresses.get(0).getAddressLine(1);
                            String countryName = addresses.get(0).getAddressLine(2);

                            System.out.println(lat+" "+lon+" "+cityName);
                            String cityDoang = cityName.split(", ")[cityName.split(", ").length-4];
                            String countryDoang = cityName.split(", ")[cityName.split(", ").length-1];
                            System.out.println("cekcity :"+cityDoang);

                            sess.setCity(cityDoang);
                            sess.setCountry(countryDoang);

                            initLocation();
                            getPrayerTime();
                            //System.out.println(lat+" "+lon+" "+cityName+"-"+"-"+stateName+"-"+countryName);
                            // Toast.makeText(getApplicationContext(),lat+" "+lon+" "+cityName+"-"+"-"+stateName+"-"+countryName,Toast.LENGTH_LONG).show();
                        }catch (IOException ex){

                            System.out.println("exc"+ex);
                        }


                    }
                });

    }
    public void getPrayerTime(){
        AndroidNetworking.get("http://api.aladhan.com/v1/timingsByCity?city="+sess.getCity()+"&country="+sess.getCountry()+"&method=11&tune=3,3,-2,3,2,4,4,2,0")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        System.out.println(response);
                        try{

                            if(response.getString("status").equals("OK")){

                                JSONObject timing = response.getJSONObject("data").getJSONObject("timings");

                                String imsak = timing.getString("Imsak");
                                String subuh = timing.getString("Fajr");
                                String terbit = timing.getString("Sunrise");
                                String dzuhur = timing.getString("Dhuhr");
                                String ashar = timing.getString("Asr");
                                String maghrib = timing.getString("Maghrib");
                                String isya = timing.getString("Isha");

                                sess.setPrayerTime(imsak,subuh,terbit,dzuhur,ashar,maghrib,isya);

                                calculateCountdown();

                            }


                        }catch (Exception e){

                            System.out.println("gagal"+e);
                        }

                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        System.out.println(error);
                    }
                });
    }

    public void calculateCountdown(){
        System.out.println("masuk countdown");


        String []pTime = sess.getPrayerTime();

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Please here set your event date//YYYY-MM-DD

        //long currentDate1 = System.currentTimeMillis();
        Date currentDate1 = new Date();
        String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


        for(int i=0;i<pTime.length;i++){

            System.out.println("time = "+dateNow+" "+pTime[i]+":00");

            try {
                Date futureDate1 = dateFormat1.parse(dateNow+" "+pTime[i]+":00");
                if(!currentDate1.after(futureDate1)){
                    time = dateNow+" "+pTime[i]+":00";
                    System.out.println("masuk if time = "+time);
                    String waktu = time;
                    if(i==0){
                        txtSolatTimeName.setText("Subuh");
                    }else if(i==1){
                        txtSolatTimeName.setText("Dzuhur");
                    }else if(i==2){
                        txtSolatTimeName.setText("Ashar");
                    }else if(i==3){
                        txtSolatTimeName.setText("Maghrib");
                    }else if(i==4){
                        txtSolatTimeName.setText("Isya");
                    }
                    txtSolatTime.setText(pTime[i]);
                    countDownStart(waktu);
                    break;
                }else{
                    System.out.println("masuk else time = "+time+ "i = "+i);
                    System.out.println("masuk if else " + (pTime.length-1));
                    if(i==(pTime.length-1)){
                        System.out.println("masuk if else " + (pTime.length-1));
                        Date today = new Date();
                        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
                        String dateNow3 = new SimpleDateFormat("yyyy-MM-dd").format(tomorrow);

                        txtSolatTimeName.setText("Subuh");
                        txtSolatTime.setText(pTime[0]);
                        time = dateNow3+" "+pTime[0]+":00";
                        System.out.println("time = "+time);
                        String waktu = time;
                        countDownStart(waktu);
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    public void countDownStart(final String waktuSolat) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    // Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse(waktuSolat);
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()  - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTime.setText("( "+"- " + String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds)+")");
//                        txtHour.setText("" + String.format("%02d", hours));
//                        txtMinute.setText(""  + String.format("%02d", minutes));
//                        txtSecond.setText(""  + String.format("%02d", seconds));
                    } else {
                        //tvEventStart.setVisibility(View.VISIBLE);
                        //tvEventStart.setText("The event started!");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }
}

