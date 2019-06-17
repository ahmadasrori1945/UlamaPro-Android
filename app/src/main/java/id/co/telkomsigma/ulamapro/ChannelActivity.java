package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ChannelActivity extends AppCompatActivity {


    Typeface fontbold,font;
    ListView listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        LinearLayout ch1 = (LinearLayout)findViewById(R.id.channel1);

        ch1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(ChannelActivity.this, CommunityActivity.class);
                startActivity(i);
            }
        });

        LinearLayout ch2 = (LinearLayout)findViewById(R.id.channel2);

        ch2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(ChannelActivity.this, Community_twoActivity.class);
                startActivity(i);
            }
        });

        LinearLayout ch3 = (LinearLayout)findViewById(R.id.channel3);

        ch3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(ChannelActivity.this, Community_threeActivity.class);
                startActivity(i);
            }
        });

        LinearLayout ch4 = (LinearLayout)findViewById(R.id.channel4);

        ch4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i = new Intent(ChannelActivity.this, Community_fourActivity.class);
                startActivity(i);
            }
        });

        TextView a = (TextView) findViewById(R.id.text_angka);
        a.setTypeface(fontbold);
        TextView a1 = (TextView) findViewById(R.id.text_channel);
        a1.setTypeface(font);
        TextView b = (TextView) findViewById(R.id.text_angka2);
        b.setTypeface(fontbold);
        TextView b1 = (TextView) findViewById(R.id.text_channel2);
        b1.setTypeface(font);
        TextView c = (TextView) findViewById(R.id.text_angka3);
        c.setTypeface(fontbold);
        TextView c1 = (TextView) findViewById(R.id.text_channel3);
        c1.setTypeface(font);
        TextView d = (TextView) findViewById(R.id.text_angka4);
        d.setTypeface(fontbold);
        TextView d1 = (TextView) findViewById(R.id.text_channel4);
        d1.setTypeface(font);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
