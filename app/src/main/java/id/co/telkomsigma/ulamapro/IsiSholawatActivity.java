package id.co.telkomsigma.ulamapro;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class IsiSholawatActivity extends AppCompatActivity {


    String[] no={
            "1.",

    };
    String[] ayat={
            "أللّٰـهُمَّ صَلِّ عَلٰى مُحّمَّدٍ نِالنَّـبِىِ اْلأُمِّىِّ وَعَلٰى اٰلِهِ وَسَلِّمِْ",

    };
    String[] isi={
            "Ya Alloh! Limpahkanlah sholawat kepada Muhammad yang tiada dapat membaca dan menulis (Ummy) dan semoga keselamatan tercurah kepada segenap keluarganya",

    };

    ListView listmenuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isisholawat);

        listmenuy=(ListView)findViewById(R.id.list_isiquran);

        Adapter_isisholawat adapter=new Adapter_isisholawat(IsiSholawatActivity.this,ayat,isi,no);
        listmenuy.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
