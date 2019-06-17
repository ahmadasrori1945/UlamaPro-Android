package id.co.telkomsigma.ulamapro;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Detail_ponpesActivity extends AppCompatActivity {

    Typeface fontbold,font;
    TextView a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ponpes);

        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        a = (TextView) findViewById(R.id.text_judul);
        a.setTypeface(fontbold);
        c = (TextView) findViewById(R.id.text_tanggal);
        c.setTypeface(font);
        b = (TextView) findViewById(R.id.text_deskripsi);
        b.setTypeface(fontbold);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
