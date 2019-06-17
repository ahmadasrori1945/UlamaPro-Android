package id.co.telkomsigma.ulamapro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NotifikasiActivity extends AppCompatActivity {

    String[] waktu={
            "30m ago",
            "30m ago",
            "1 hour ago",
            "1 hour ago",
            "1 hour ago",
            "1 hour ago",
            "2 hour ago",
            "2 hour ago",
            "2 hour ago",
            "2 hour ago",
    };
    String[] judul={
            "Khotbah Jumat",
            "Khotbah Jumat",
            "Kajian Dhuha",
            "Kajian Dhuha",
            "Khotbah Jumat",
            "Khotbah Jumat",
            "Khotbah Jumat",
            "Kajian Dhuha",
            "Kajian Dhuha",
            "Khotbah Jumat",
    };
    String[] isi={
            "Pengisi Khotbah Ust. Prof Dr Didi ..",
            "Pengisi Kajian Ust. Prof Dr Didi ..",
            "Pengisi Khotbah Ust. Prof Dr Aniq ..",
            "Pengisi Kajian Ust. Prof Dr Suto ..",
            "Pengisi Khotbah Ust. Prof Dr Didi ..",
            "Pengisi Kajian Ust. Prof Dr Didi ..",
            "Pengisi Khotbah Ust. Prof Dr Didi ..",
            "Pengisi Kajian Ust. Prof Dr Didi ..",
            "Pengisi Khotbah Ust. Prof Dr Didi ..",
            "Pengisi Kajian Ust. Prof Dr Didi ..",

    };

    ListView listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        listmenu=(ListView)findViewById(R.id.list_notifikasi);

        Adapter_notification adapter=new Adapter_notification(NotifikasiActivity.this,judul,isi,waktu);
        listmenu.setAdapter(adapter);

        listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                // String Slecteditem= judul[+position];
                //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(NotifikasiActivity.this, Detail_inboxActivity.class);
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
