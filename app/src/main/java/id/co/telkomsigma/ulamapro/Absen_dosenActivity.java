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
import android.widget.Button;
import android.widget.TextView;





public class Absen_dosenActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSIONS = 1;
    private static final int PERMISSION_ALL = 100;
    Typeface font,fontbold;
    String[] PERMISSIONS = {
            Manifest.permission.CAMERA
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_dosen);

        font = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(),"fonts/Nexa Bold.otf");

        TextView scan = (TextView) findViewById(R.id.text_scan);
        scan.setTypeface(font);
        TextView scan2 = (TextView) findViewById(R.id.text_scan3);
        scan2.setTypeface(font);

        Button scann = (Button) findViewById(R.id.scan);
        scann.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                if(!hasPermissions(Absen_dosenActivity.this, PERMISSIONS)){
                    ActivityCompat.requestPermissions(Absen_dosenActivity.this, PERMISSIONS, PERMISSION_ALL);
                } else {
                    Intent i = new Intent(getApplicationContext(), ScannerFloorActivity.class);
                    startActivity(i);
                }
            }
        });

        Button kirimm = (Button) findViewById(R.id.kirim);
        kirimm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                    Intent i = new Intent(getApplicationContext(), Hasil_donasiActivity.class);
                    startActivity(i);
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
