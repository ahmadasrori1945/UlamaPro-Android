package id.co.telkomsigma.ulamapro;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TasbihActivity extends AppCompatActivity {

    int current;
    int length;
    Typeface fontbold,font;
    TextView a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);

        current = 0;
        length = 33;
        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        a = (TextView) findViewById(R.id.text_total);
        a.setTypeface(fontbold);
        b = (TextView) findViewById(R.id.texttasbih);
        b.setTypeface(fontbold);

        a.setText("Total : "+length);
        b.setText(""+current);

        RelativeLayout clickButton = (RelativeLayout) findViewById(R.id.click);
        clickButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(current>=length){
                    current = 1;
                }else{
                    current++;
                }

                b.setText(""+current);
                return false;
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
