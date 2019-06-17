package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
//
//import com.androidnetworking.AndroidNetworking;
//import com.androidnetworking.common.Priority;
//import com.androidnetworking.error.ANError;
//import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

//import co.id.telkomsigma.palapaone.R;
//import co.id.telkomsigma.palapaone.controller.expo.ScannerActivity;
//import co.id.telkomsigma.palapaone.util.SessionManager;
//import co.id.telkomsigma.palapaone.util.connection.ConstantUtils;
//import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ScannerFloorActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    String tag, type;
//    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
//
//        session = new SessionManager(getApplicationContext());

        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");
        type = intent.getStringExtra("type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Scan Qr-Code");
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        Log.v("TAG", rawResult.getText()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        String url = rawResult.getText();
//        builder.setMessage(url);
//        if (url.substring(0,4).equals("http")) {
//            if (!session.isLogin()) {
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            } else {
//                sendAuth(url, session.getId());
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//
//            }
//        } else {
//            builder.setMessage("Invalid QR CODE");
//        }

        AlertDialog alert1 = builder.create();
        alert1.show();

        mScannerView.resumeCameraPreview(this);
    }

//    private void sendAuth(final String qrvalue, final String userid) {
//        AndroidNetworking.post("http://palapaone.id/telkomhub/api/floors/getfloor")
//                .addBodyParameter("qrvalue", qrvalue)
//                .addBodyParameter("user_id", userid)
//                .setTag("test")
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // do anything with response
//                        System.out.println("sdjwj"+response+userid+qrvalue);
//                        try {
//                            if (response.getString(ConstantUtils.LOGIN.TAG_SUCCESS).equals("1")) {
//                                Toast.makeText(getApplicationContext(), "Log Success!"+userid, Toast.LENGTH_SHORT).show();
//                            } else {
//                                Toast.makeText(getApplicationContext(), "Log Failed!"+userid, Toast.LENGTH_SHORT).show();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                    }
//                });
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}

