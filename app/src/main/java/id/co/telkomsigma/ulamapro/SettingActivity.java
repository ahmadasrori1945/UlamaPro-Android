package id.co.telkomsigma.ulamapro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {
    UserSessionManager session;

    Typeface font,fontbold;
    String[] judul={
            "Adzan",
            "Kajian",
            "Buka Puasa",
            "Kajian Islami",
            "Event Masjid",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        session = new UserSessionManager(getApplicationContext());
        font = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getApplication().getAssets(), "fonts/Nexa Bold.otf");

        TextView pengguna = (TextView) findViewById(R.id.text_pengguna);
        pengguna.setTypeface(fontbold);
        TextView name = (TextView) findViewById(R.id.tv_name);
        name.setTypeface(fontbold);
        TextView c = (TextView) findViewById(R.id.text_pengguna3);
        c.setTypeface(fontbold);
        TextView d = (TextView) findViewById(R.id.text_pengguna5);
        d.setTypeface(fontbold);
        TextView title = (TextView) findViewById(R.id.tv_titile_versi);
        title.setTypeface(fontbold);
        TextView versiapp = (TextView) findViewById(R.id.tv_versiApp);
        versiapp.setTypeface(fontbold);

        Button logout = (Button) findViewById(R.id.btm_logout);

        ListView listmenuy = (ListView) findViewById(R.id.list_setting);

        Adapter_setting adapter = new Adapter_setting(SettingActivity.this, judul);
        listmenuy.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alretexit = new
                        AlertDialog.Builder(SettingActivity.this);
                alretexit.setMessage("Anda yakin untuk keuar?").setCancelable(false)
                        .setPositiveButton("Ya",
                                new AlertDialog.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        session.logoutUser();
                                    }
                                })
                        .setNegativeButton("Tidak",
                                new AlertDialog.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog a = alretexit.create();
                a.show();
                onDestroy();

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
