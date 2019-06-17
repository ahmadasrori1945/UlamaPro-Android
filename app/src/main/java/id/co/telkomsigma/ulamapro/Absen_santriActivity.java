package id.co.telkomsigma.ulamapro;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.telkomsigma.ulamapro.Activity.HomeActivity;


public class Absen_santriActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS = 1;
    private static final int PERMISSION_ALL = 100;
    Typeface font,fontbold;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_santri);

        font = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        TextView scan = (TextView) findViewById(R.id.text_scan);
        scan.setTypeface(font);

        ImageView gokamera = (ImageView) findViewById(R.id.imageView8);
        gokamera.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                if(!hasPermissions(Absen_santriActivity.this, PERMISSIONS)){
                    ActivityCompat.requestPermissions(Absen_santriActivity.this, PERMISSIONS, PERMISSION_ALL);
                } else {
                    Intent i = new Intent(getApplicationContext(), ScannerFloorActivity.class);
                    startActivity(i);
                }
            }
        });

        ImageView goback= (ImageView) findViewById(R.id.profile);
        goback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
            }
        });

        ImageView golist= (ImageView) findViewById(R.id.logouts);
        golist.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent i = new Intent(getApplicationContext(), Daftar_santriActivity.class);
                startActivity(i);
            }
        });



//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
//    @Override
//    public boolean onSupportNavigateUp(){
//        finish();
//        return true;
//    }
}
