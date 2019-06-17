package id.co.telkomsigma.ulamapro.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import id.co.telkomsigma.ulamapro.adapter.Adapter_quran;
import id.co.telkomsigma.ulamapro.model.ModelQuran;
import id.co.telkomsigma.ulamapro.util.Connection;

public class QuranActivity extends AppCompatActivity {
    UserSessionManager session;
    private List<ModelQuran> listModel;
    private ModelQuran model;
    private Adapter_quran adapter;
    private ListView listFriendsRequest;
    private TextView tvNull;
    Typeface font, fontbold;

    ListView listmenu;

    Connection conn ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        font = Typeface.createFromAsset(this.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(this.getAssets(), "fonts/Nexa Bold.otf");
        session = new UserSessionManager(this);
        listFriendsRequest = findViewById(R.id.list_quran);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getQuranSurat();
    }

    private void getQuranSurat (){
        AndroidNetworking.get("http://api.alquran.cloud/surah")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response + "asdwadadwadwad");
                        try {
                            if(response.getString("status").equals("OK")){
                                listModel = new ArrayList<ModelQuran>();
                                JSONArray data = response.getJSONArray("data");

                                    for (int a = 0; a < data.length(); a++) {
                                        JSONObject object = data.getJSONObject(a);
                                        String nama = object.getString("englishName");
                                        String nomor = object.getString("number");
                                        String asma = object.getString("name");
                                        String jml_ayat = object.getString("numberOfAyahs");

                                        System.out.println(nama + nomor);

//                                        String ayat = object.getString("numberOfAyahs");

                                        model = new ModelQuran(nama, asma, "", jml_ayat, nomor);
                                        listModel.add(model);
                                    }
                                    adapter = new Adapter_quran(QuranActivity.this, listModel);
                                    listFriendsRequest.setAdapter(adapter);

                                    listFriendsRequest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            Intent i = new Intent(QuranActivity.this,IsiQuranActivity.class);
                                            i.putExtra("number",listModel.get(position).getNomor());
                                            i.putExtra("nama",listModel.get(position).getNama());
                                            startActivity(i);
                                        }
                                    });

                                }

                            }catch (JSONException e) {
                            System.out.println("gagagagal"+e);


                        }


                        }

                    @Override
                    public void onError(ANError anError) {
                        System.out.println("pusing"+anError);
                    }



                });
    }



}