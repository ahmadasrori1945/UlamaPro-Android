package id.co.telkomsigma.ulamapro;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Hasil_donasiActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS = 1;
    private static final int PERMISSION_ALL = 100;
    Typeface font,fontbold;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_donasi);

        font = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        TextView scan = (TextView) findViewById(R.id.textView);
        scan.setTypeface(font);
        TextView scan2 = (TextView) findViewById(R.id.textView11);
        scan2.setTypeface(font);
        TextView scan1 = (TextView) findViewById(R.id.textView12);
        scan1.setTypeface(font);
        TextView scan21 = (TextView) findViewById(R.id.textView13);
        scan21.setTypeface(font);

        ImageView gokamera = (ImageView) findViewById(R.id.imageView8);
        gokamera.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                if(!hasPermissions(Hasil_donasiActivity.this, PERMISSIONS)){
                    ActivityCompat.requestPermissions(Hasil_donasiActivity.this, PERMISSIONS, PERMISSION_ALL);
                } else {
                    Intent i = new Intent(getApplicationContext(), ScannerFloorActivity.class);
                    startActivity(i);
                }
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
