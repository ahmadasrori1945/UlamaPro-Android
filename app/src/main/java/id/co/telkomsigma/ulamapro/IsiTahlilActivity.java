package id.co.telkomsigma.ulamapro;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class IsiTahlilActivity extends AppCompatActivity {


    String[] no={
            "1.",
            "2.",
            "3.",
            "4.",
            "5.",
            "6.",
            "7.",
    };
    String[] ayat={
            "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ",
            "اَلْحَمْدُ لِلّٰهِ رَبِّ الْعٰلَمِيْنَۙ",
            "الرَّحْمٰنِ الرَّحِيْمِۙ",
            "مٰلِكِ يَوْمِ الدِّيْنِۗ",
            "اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُۗ",
            "اِهْدِنَا الصِّرَاطَ الْمُسْتَقِيْمَ ۙ",
            "صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ ەۙ غَيْرِ الْمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّاۤلِّيْنَ",

    };
    String[] isi={
            "Dengan nama Allah Yang Maha Pengasih, Maha Penyayang",
            "Segala puji bagi Allah, Tuhan seluruh alam,",
            "Yang Maha Pengasih, Maha Penyayang,",
            "Pemilik hari pembalasan,",
            "Hanya kepada Engkaulah kami menyembah dan hanya kepada Engkaulah kami mohon pertolongan.",
            "Tunjukilah kami jalan yang lurus,",
            "(yaitu) jalan orang-orang yang telah Engkau beri nikmat kepadanya; bukan (jalan) mereka yang dimurkai, dan bukan (pula jalan) mereka yang sesat.",


    };

    ListView listmenuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isitahlil);

        listmenuy=(ListView)findViewById(R.id.list_isiquran);

        Adapter_isisholawat adapter=new Adapter_isisholawat(IsiTahlilActivity.this,ayat,isi,no);
        listmenuy.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
