package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TahlilActivity extends AppCompatActivity {

//    Adapter_tahlil listAdapter;
//    ExpandableListView expListView;
//    List<String> listDataHeader;
//    HashMap<String, List<String>> listDataChild;


    String[] no={
            "1.",
            "2.",
            "3.",
            "4.",
            "5."
    };

    String[] isi={
            "Keutamaan Surat Alkahfi",
            "Surat Yasiin",
            "Keutamaan Surat Alfatihah",
            "Surat AlMulk",
            "Surat Alwaqiah",

    };

    ListView listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahlil);
        listmenu=(ListView)findViewById(R.id.list_tahlil);

        Adapter_sholawat adapter=new Adapter_sholawat(TahlilActivity.this,no,isi);
        listmenu.setAdapter(adapter);

        listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                // String Slecteditem= judul[+position];
                //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(TahlilActivity.this, IsiTahlilActivity.class);
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

//        // get the listview
//        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//
//        // preparing list data
//        prepareListData();
//
//        listAdapter = new Adapter_tahlil(this, listDataHeader, listDataChild);
//
//        // setting list adapter
//        expListView.setAdapter(listAdapter);
//    }
//
//    /*
//     * Preparing the list data
//     */
//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("Doa Tahlil ");
//        listDataHeader.add("Al - Fatihah ");
//        listDataHeader.add("Tahlil ");
//        listDataHeader.add ("Al - Fatihah (2)");
//        listDataHeader.add ("Tahlil (2)");
//        listDataHeader.add ("Al - Fatihah (3)");
//        listDataHeader.add ("Al Ikhlas");
//        listDataHeader.add ("Al Alaq");
//        listDataHeader.add ("AN Naas");
//        listDataHeader.add ("Al Fatihah (4)");
//        listDataHeader.add ("5 AYAT AWAL SURAT AL BAQARAH");
//        listDataHeader.add ("Ayat Kursi");
//        listDataHeader.add ("Surat Al - Baqarah Ayat 284 - 286");
//
//
//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("بِسْمِ اللهِ الرَّ حْمَنِ الرَّ حِيْمِ");
//        top250.add("اِلَى حَضَرَةِ النَّبِيِّ الْمُصْطَفَى صَلَّى اللهُ عَلَيهِ وَسَلَّمَ وَاَلِهِ وَاَزْوَا جِهِ وَاَوْلاَ دِهِ وَذُرِّيَّا تِهِ الْفَتِحَةْ");
//        top250.add("Bismillaa hirrahmaanir rahiim\n" +
//                "\n" +
//                "Ilaahadharatin nabiyyil musthofaa shollallahu ‘alaihi wa sallama, wa aahlihi wa azwajihii wa aulaadihi wa dzurriyyatihi. Al fatihah….");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("بِسْمِ اللهِ الرَّ حْمَنِ الرَّ حِيْمِ" );
//        nowShowing.add("Bismillaa hirrahmaanir rahiim");
//        nowShowing.add("الْحَمْدُ لِلهِ رَبِّ الْعِا لَمِيْنَ . اَلرَّحْمَنِ الرَّحِيْمِ . مَلِكِ يَوْمَ الدِّيْنِ . اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُ . اِهْدِ نَاالصِّرَاطَ الَّمُسْتَقِيْمَ . صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ غَيْرِ الّمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّالِّيْنَ . اَمِينْ");
//        nowShowing.add("Alhamdulillaahi rabbill’aalamiin. Arrohmaanir rahiim. Maalikiyaumiddin. Iyyaakana’budu wa iyyaakanasta’iin. Ihdinash shiraathal mustaqiim. Shiraathal ladziina an’amta ‘alaihim ghoiril maghdhuubi’alaihim waladhaalliin. Aamiinn");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("ثُمَّ اِلَي حَضَرَاتِ اِخْوَا نِهِ مِنَ الْاَنْبِيَاءِ وَ الْمُرْسَلِيْنَ وَالْاَوْلِيَاءِ وَاَلشَّهَدَاءِ وَاَلصَّا لِحِيْنَ وَاَلصَّحَا بَةِوَ التَّا بِعِيّنَ وَالْعُلَمَاءِ الْعَا مِلِيْنَ وَالْمُصَنِّفِيْنَ الْمُخْلِصِيْنَ وَ جَمِيْعِ الْمَلَئِكَةِ الْمُقَرَّ بِيْنَ خُصُوْصًا سَيِّدِنَا الشَّيْخِ عَيْدِ الْقَادِرِا لْجَيْلَا نِى . الْفَاتِحَةْ\n" +
//                "\n");
//        comingSoon.add("Tsumma ilaa hadhorooti ikhwaanihi minal anbiyaa’I wal mursaliina wal auliyaa’I wash syuhadaa’I wash shoolihiina wash shohaabati wat taabi’iina wal ulamaa’il aamiliina walmushonni final mukh’lishina wa jamii’il malaa ikatil muqorrobiina khusuushon sayyidinaa asy syaikhi’abdil qoodiril jailaani . Al Fatihah.");
//        comingSoon.add("Artinya  :");
//        comingSoon.add("kemudian kepada yang terhormat para handai taulan dari para nabi dan rosul, para wali, para syuhada’, orang orang saleh, para sahabat, para ulama yang mengamalkan ilmunya, para pengarang yang ikhlas dan kepada segenap malaikat yang mendekatkan diri kepada Allah, terutama kepada penghulu kita syaikh Abdul Qadir Jailani. (Lanjutkan membaca Al Fatihah)");
//
//
//        List<String> alfatihah = new ArrayList<String>();
//        alfatihah.add("بِسْمِ اللهِ الرَّ حْمَنِ الرَّ حِيْم");
//        alfatihah.add ("Bismillaa hirrahmaanir rahiim");
//        alfatihah.add ("الْحَمْدُ لِلهِ رَبِّ الْعِا لَمِيْنَ . اَلرَّحْمَنِ الرَّحِيْمِ . مَلِكِ يَوْمَ الدِّيْنِ . اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُ . اِهْدِ نَاالصِّرَاطَ الَّمُسْتَقِيْمَ . صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ غَيْرِ الّمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّالِّيْنَ . اَمِينْ");
//        alfatihah.add ("Alhamdulillaahi rabbill’aalamiin. Arrohmaanir rahiim. Maalikiyaumiddin. Iyyaakana’budu wa iyyaakanasta’iin. Ihdinash shiraathal mustaqiim. Shiraathal ladziina an’amta ‘alaihim ghoiril maghdhuubi’alaihim waladhaalliin. Aamiinn");
//        alfatihah.add("Artinya :");
//        alfatihah.add ("Dengan menyebut nama Allah yang maha pengasih lagi maha penyayang. Segala puji bagi Allah, Tuhan semesta alam. Yang maha pengasih lagi maha penyayang. Yang menguasai hari pembalasan. Hanya kepada Engkaulah kami menyembah. Dan hanya kepada Engkaulah pula kami memohon pertolongan. Tunjukkanlah kami ke jalan yang lurus, yaitu jalan orang orang yang telah Engkau anugerahi nikmat kepada mereka, bukan jalan mereka yang dimurkai dan bukan pula jalan mereka yang sesat, semoga engkau kabulkan permohonan kami.");
//
//
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
//        listDataChild.put(listDataHeader.get(2), alfatihah);
//    }
//}

