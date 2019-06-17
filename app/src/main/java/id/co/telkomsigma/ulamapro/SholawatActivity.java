package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SholawatActivity extends AppCompatActivity {


    String[] no={
            "1.",
            "2.",
            "3.",
            "4.",
            "5."
    };

    String[] isi={
            "Sholawat Ma'tsuroh",
            "Sholawat Ibrohimiyah",
            "Sholawat Al-Fatih",
            "Sholawat Ummy",
            "Sholawat Mukafa'ah",

    };

    ListView listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholawat);

        listmenu=(ListView)findViewById(R.id.list_sholawat);

        Adapter_sholawat adapter=new Adapter_sholawat(SholawatActivity.this,no,isi);
        listmenu.setAdapter(adapter);

        listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                // String Slecteditem= judul[+position];
                //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SholawatActivity.this, IsiSholawatActivity.class);
                startActivity(i);
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
