package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.telkomsigma.ulamapro.Activity.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText passField, userField;
    UserSessionManager session;
    private boolean doubleBackToExitPressedOnce = false;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AndroidNetworking.initialize(getApplicationContext());
        session = new UserSessionManager(LoginActivity.this);
        userField = (EditText) findViewById(R.id.edit_username);
        passField = (EditText) findViewById(R.id.edit_password);
        btnLogin = (Button) findViewById(R.id.btn_login);


        if (session.isLogin()) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            i.putExtra("key", "none");
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userField.getText().toString();
                String password = userField.getText().toString();
                attemptLogin(username, password);


                if (userField.getText().toString().equals(username) &&
                        passField.getText().toString().equals(password)) {
                    Intent a = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(a);
                    finish();
                    ;
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong username or Password", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }

    private void attemptLogin(String username, final String password) {
        AndroidNetworking.post(session.getServerURL()+"api_login/"+"auth")
                .addBodyParameter("username", username)
                .addBodyParameter("password", password)
                .addBodyParameter("device_id", "android")
                .addBodyParameter("version_apk", "3.2.1")
                .addBodyParameter("device_token", "sdffff")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response+ "qwertytuio");
                        JSONObject body = new JSONObject();
                        try {
                            if (response.getInt("success")== 1){
                                //get data from json object {}
                                JSONObject object = response.getJSONObject("");
                                String username = object.getString("username");
                                String name = object.getString("name");
                                String user_name = object.getString("user_name");
                                String user_role = object.getString("user_role");
                                String email = object.getString("email");


                                passField.setText(password);
                                userField.setText(username);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        Toast.makeText(LoginActivity.this,"wrong username or password",Toast.LENGTH_SHORT).show();// handle error
                    }
                });
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }
}
