package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import id.co.telkomsigma.ulamapro.Activity.HomeActivity;


public class SplashScreenActivity extends AppCompatActivity {

    UserSessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new UserSessionManager(this);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        //getSupportActionBar().();

        Thread splashTread = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    // do nothing
                } finally {

                    if (session.isLogin()){
                        Intent a = new Intent(SplashScreenActivity.this, HomeActivity.class);
                        startActivity(a);
                    }else {
                        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        };
        splashTread.start();
    }
}
