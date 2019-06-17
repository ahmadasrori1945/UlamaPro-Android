package id.co.telkomsigma.ulamapro;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail_inboxActivity extends AppCompatActivity {

    Typeface fontbold,font;
    TextView a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_inbox);

        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        a = (TextView) findViewById(R.id.text_judul);
        a.setTypeface(fontbold);
        b = (TextView) findViewById(R.id.text_isi);
        b.setTypeface(fontbold);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
