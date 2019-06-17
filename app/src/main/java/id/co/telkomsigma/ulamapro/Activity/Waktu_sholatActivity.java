package id.co.telkomsigma.ulamapro.Activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.co.telkomsigma.ulamapro.R;
import id.co.telkomsigma.ulamapro.UserSessionManager;

public class Waktu_sholatActivity extends AppCompatActivity {

    UserSessionManager sess;
    String time;

    Typeface fontbold,font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waktu_sholat);
        sess = new UserSessionManager(getApplicationContext());

        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        TextView a = (TextView) findViewById(R.id.text_tanggal);
        a.setTypeface(fontbold);
        TextView b = (TextView) findViewById(R.id.tv_lokasi);
        b.setTypeface(fontbold);
        TextView c = (TextView) findViewById(R.id.text_sholat);
        c.setTypeface(font);
        TextView d = (TextView) findViewById(R.id.text_jam);
        d.setTypeface(fontbold);
        TextView e = (TextView) findViewById(R.id.text_hariini);
        e.setTypeface(fontbold);
//        subuh
        TextView a1 = (TextView) findViewById(R.id.text_subuh);
        a1.setTypeface(fontbold);
        TextView b1 = (TextView) findViewById(R.id.text_jamsubuh);
        b1.setTypeface(fontbold);
//        terbit
        TextView a2 = (TextView) findViewById(R.id.text_terbit);
        a2.setTypeface(fontbold);
        TextView b2 = (TextView) findViewById(R.id.text_jamterbit);
        b2.setTypeface(fontbold);
//        dzuhur
        TextView a3 = (TextView) findViewById(R.id.text_dzuhur);
        a3.setTypeface(fontbold);
        TextView b3 = (TextView) findViewById(R.id.text_jamdzuhur);
        b3.setTypeface(fontbold);
//        ashar
        TextView a4 = (TextView) findViewById(R.id.text_ashar);
        a4.setTypeface(fontbold);
        TextView b4 = (TextView) findViewById(R.id.text_jamashar);
        b4.setTypeface(fontbold);
//        maghrib
        TextView a5 = (TextView) findViewById(R.id.text_maghrib);
        a5.setTypeface(fontbold);
        TextView b5 = (TextView) findViewById(R.id.text_jammaghrib);
        b5.setTypeface(fontbold);
//        isya
        TextView a6 = (TextView) findViewById(R.id.text_isya);
        a6.setTypeface(fontbold);
        TextView b6 = (TextView) findViewById(R.id.text_jamisya);
        b6.setTypeface(fontbold);



        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Date date = new Date();
        a.setText(dateFormat.format(date));

        b.setText(sess.getCity()+" , "+sess.getCountry());
        calculatePrayerTime(d,c);

        b1.setText(sess.getPrayerTime()[0]);
        b3.setText(sess.getPrayerTime()[1]);
        b4.setText(sess.getPrayerTime()[2]);
        b5.setText(sess.getPrayerTime()[3]);
        b6.setText(sess.getPrayerTime()[4]);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void calculatePrayerTime(TextView txtTime, TextView txtName) {

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
                    System.out.println("time = "+time);
                    String waktu = time;
                    if(i==0){
                        txtName.setText("Subuh");
                    }else if(i==1){
                        txtName.setText("Dzuhur");
                    }else if(i==2){
                        txtName.setText("Ashar");
                    }else if(i==3){
                        txtName.setText("Maghrib");
                    }else if(i==4){
                        txtName.setText("Isya");
                    }
                    txtTime.setText(pTime[i]);
                    break;
                }else{
                    if(i==pTime.length-1){
                        Date today = new Date();
                        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
                        String dateNow3 = new SimpleDateFormat("yyyy-MM-dd").format(tomorrow);

                        txtName.setText("Subuh");
                        txtTime.setText(pTime[0]);
                        time = dateNow3+" "+pTime[0]+":00";
                        System.out.println("time = "+time);
                        String waktu = time;
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    
}
