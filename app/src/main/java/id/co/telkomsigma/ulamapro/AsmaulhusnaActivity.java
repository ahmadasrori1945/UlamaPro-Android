package id.co.telkomsigma.ulamapro;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class AsmaulhusnaActivity extends AppCompatActivity {

    String[] asmaul ={
            "الرَّحْمَنُ","الرَّحِيمُ","الْمَلِكُ","الْقُدُّوسُ","السَّلاَمُ",
            "الْمُؤْمِنُ","الْمُهَيْمِنُ","الْعَزِيزُ","الْجَبَّارُ","الْمُتَكَبِّرُ",
            "الْخَالِقُ","الْبَارِئُ","الْمُصَوِّرُ","الْغَفَّارُ","الْقَهَّارُ",
//            "الْوَهَّابُ","الرَّزَّاقُ","الْفَتَّاحُ","اَلْعَلِيْمُ","الْقَابِضُ",
//            "الْبَاسِطُ","الْخَافِضُ","الرَّافِعُ","الْمُعِزُّ","المُذِلُّ",
//            "السَّمِيعُ","الْبَصِيرُ","الْحَكَمُ","الْعَدْلُ","اللَّطِيفُ",
//            "الْخَبِيرُ","الْحَلِيمُ","الْعَظِيمُ","الْغَفُورُ","الشَّكُورُ",
//            "الْعَلِيُّ","الْكَبِيرُ","الْحَفِيظُ","المُقيِت","الْحسِيبُ",
//            "الْجَلِيلُ","الْكَرِيمُ","الرَّقِيبُ","الْمُجِيبُ","الْوَاسِعُ",
//            "الْحَكِيمُ","الْوَدُودُ","الْمَجِيدُ","الْبَاعِثُ","الشَّهِيدُ",
//            "الْحَقُّ","الْوَكِيلُ","الْقَوِيُّ","الْمَتِينُ","الْمَتِينُ",
//            "الْحَمِيدُ","الْمُحْصِي","الْمُبْدِئُ","الْمُعِيدُ","الْمُحْيِي",
//            "اَلْمُمِيتُ","الْحَيُّ","الْقَيُّومُ","الْوَاجِدُ","الْمَاجِدُ",
//            "الْواحِدُ","الْواحِدُ","الْواحِدُ","الْقَادِرُ","الْمُقْتَدِرُ",
//            "الْمُقَدِّمُ","الْمُؤَخِّرُ","الأوَّلُ","الآخِرُ","الظَّاهِرُ",
//            "الْبَاطِنُ","الْوَالِي","الْمُتَعَالِي","الْبَرُّ","التَّوَابُ",
//            "الْمُنْتَقِمُ","العَفُوُّ","الرَّؤُوفُ","مَالِكُ الْمُلْكِ","ذُوالْجَلاَلِوَالإكْرَامِ",
//            "الْمُقْسِطُ","الْجَامِعُ","الْغَنِيُّ","الْمُغْنِي","اَلْمَانِعُ",
//            "الضَّارَّ","النَّافِعُ","النُّورُ","الْهَادِي","الْبَدِيعُ",
//            "اَلْبَاقِي","الْوَارِثُ","الرَّشِيدُ","الصَّبُورُ",



    };
    String[] isi ={
            "Ar Rahman","Ar Rahiim","Al Malik","Al Quddus",
            "As Salaam","Al Mu’min","Al Muhaimin","Al ‘Aziiz","Al Jabbar",
            "Al Mutakabbir","Al Khaliq","Al Baari’","Al Mushawwir","Al Ghaffaar","Al Qahhaar",
//            "Al Wahhaab","Ar Razzaaq","Al Fattaah","Al Alim","Al Qaabidh",
//            "Al Baasith","Al Khaafidh","Ar Raafi’","Al Mu’izz","Al Mudzil",
//            "Al Samii’","Al Bashiir","Al Hakam","Al ‘Adl","Al Lathiif",
//            "Al Khabiir","Al Haliim","Al ‘Azhiim","Al Ghafuur","As Syakuur",
//            "Al ‘Aliy","Al Kabiir","Al Hafizh","Al Muqiit","Al Hasiib",
//            "Al Jaliil","Al Kariim","Ar Raqiib","Al Mujiib","Al Waasi’",
//            "Al Hakiim","Al Waduud","Al Majiid","Al Baa’its","As Syahiid",
//            "Al Haqq","Al Wakiil","Al Qawiyyu","Al Matiin","Al Waliyy",
//            "Al Hamiid","Al Mushii","Al Mubdi’","Al Mu’iid","Al Muhyii",
//            "Al Mumiitu","Al Hayyu","Al Qayyuum","Al Waajid","Al Maajid",
//            "Al Wahiid","Al ‘Ahad","As Shamad","Al Qaadir","Al Muqtadir",
//            "Al Muqaddim","Al Mu’akkhir","Al Awwal","Al Aakhir","Az Zhaahir",
//            "Al Baathin","Al Waali","Al Muta’aalii","Al Barri","At Tawwaab",
//            "Al Muntaqim","Al Afuww","Ar Ra`uuf","Malikul Mulk","Dzul Jalaali Wal Ikraam",
//            "Al Muqsith","Al Jamii’","Al Ghaniyy","Al Mughnii","Al Maani",
//            "Ad Dhaar","An Nafii’","An Nuur","Al Haadii","Al Baadii",
//            "Al Baaqii","Al Waarits","Ar Rasyiid","As Shabuur",

    };
    Typeface font,fontbold;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_asmaulhusna);

        gridView = (GridView) findViewById(R.id.gridview_asmaul);

        Adapter_asmaulhusna gridAdapter = new Adapter_asmaulhusna(this,asmaul,isi);
        gridView.setAdapter(gridAdapter);

        font = Typeface.createFromAsset(AsmaulhusnaActivity.this.getAssets(), "fonts/Nexa Light.otf");
       fontbold = Typeface.createFromAsset(AsmaulhusnaActivity.this.getAssets(), "fonts/Nexa Bold.otf");

        TextView textView = (TextView) findViewById(R.id.text_bismillah);
        textView.setTypeface(fontbold);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
