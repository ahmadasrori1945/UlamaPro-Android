package id.co.telkomsigma.ulamapro.Activity;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.co.telkomsigma.ulamapro.R;
import id.co.telkomsigma.ulamapro.UserSessionManager;
import id.co.telkomsigma.ulamapro.adapter.Adapter_isiquran;
import id.co.telkomsigma.ulamapro.adapter.Adapter_quran;
import id.co.telkomsigma.ulamapro.model.ModelIsiQuran;
import id.co.telkomsigma.ulamapro.model.ModelQuran;
import id.co.telkomsigma.ulamapro.util.Connection;

public class IsiQuranActivity extends AppCompatActivity {

    UserSessionManager session;
    private List<ModelIsiQuran> listModel;
    private List <ModelIsiQuran> listModel2;
    private ModelIsiQuran model;
    private ModelIsiQuran model2;
    private Adapter_isiquran adapter;
    private ListView ListIsiAlquran;
    private TextView tvNull;
    Typeface font, fontbold;

    String nama, number;

    ListView listmenu;

    Connection conn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isiquran);

        font = Typeface.createFromAsset(this.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(this.getAssets(), "fonts/Nexa Bold.otf");
        session = new UserSessionManager(this);
        ListIsiAlquran = findViewById(R.id.list_isiAlquran);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getIntent().getStringExtra("nama"));

        Intent i = getIntent();
        nama = i.getStringExtra("nama");
        number = i.getStringExtra("number");
        getSurahData1();

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void getSurahData1() {
        System.out.println("http://api.alquran.cloud/surah/"+number);
        AndroidNetworking.get("http://api.alquran.cloud/surah/"+number)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {

                                     @Override
                                     public void onResponse(JSONObject response) {
                                         System.out.println(response + "asdwadadwadwad");
                                         try {
                                             if (response.getString("status").equals("OK")) {
                                                 listModel = new ArrayList<ModelIsiQuran>();
                                                 JSONArray data = response.getJSONObject("data").getJSONArray("ayahs");
                                                 for (int a = 0; a < data.length(); a++) {
                                                     JSONObject object = data.getJSONObject(a);
                                                     String nomor_ayat = object.getString("numberInSurah");
                                                     String text_ayat = object.getString("text");

//                                                     System.out.println(nomor_ayat + text_ayat);

                                                     model = new ModelIsiQuran(nomor_ayat, text_ayat, "");
                                                     listModel.add(model);
                                                 }

                                                 getSurahData2();
//
//                                                 adapter = new Adapter_isiquran(IsiQuranActivity.this,listModel);
//                                                 ListIsiAlquran.setAdapter(adapter);

                                             }

                                         } catch (JSONException e) {
                                             System.out.println("gagal"+e);
                                         }


                                     }

                                     @Override
                                     public void onError(ANError anError) {
                                         System.out.println("pusing"+anError);

                                     }
                                 });
    }

    private void getSurahData2() {
        System.out.println("http://api.alquran.cloud/surah/"+number+"/id.indonesian");
        AndroidNetworking.get("http://api.alquran.cloud/surah/"+number+"/id.indonesian")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject( new JSONObjectRequestListener (){

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getString("status").equals("OK")){
                                listModel2 = new ArrayList<ModelIsiQuran>();
                                JSONArray data = response.getJSONObject("data").getJSONArray("ayahs");
                                for (int b = 0 ; b <data.length();b++) {
                                    JSONObject object = data.getJSONObject(b);

                                    String text_indo = object.getString("text");

                                    model2 = new ModelIsiQuran("","",text_indo);
                                    listModel2.add(model2);
                                }

                                adapter = new Adapter_isiquran(IsiQuranActivity.this,listModel,listModel2);
                                ListIsiAlquran.setAdapter(adapter);

//                                Intent a = new Intent(IsiQuranActivity.this,Adapter_isiquran.class);
//                                int index = 0;
//                                a.putExtra("text_indo",listModel2.get(index).getText_indo());
//                                startActivity(a);
//

                            }
                        } catch (JSONException e) {
                            System.out.println("cathc"+e);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("error"+anError);
                    }
                });
    }


}




