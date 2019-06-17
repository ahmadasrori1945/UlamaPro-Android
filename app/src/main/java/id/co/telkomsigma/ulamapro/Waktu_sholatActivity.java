package id.co.telkomsigma.ulamapro;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Waktu_sholatActivity extends AppCompatActivity {

    Typeface fontbold,font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waktu_sholat);

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
