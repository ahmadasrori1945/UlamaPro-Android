package id.co.telkomsigma.ulamapro;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;

import id.co.telkomsigma.ulamapro.Activity.IsiQuranActivity;

public class Daftar_santriActivity extends AppCompatActivity {


    String[] nik={
            "1234556",
            "2654324",
            "3853212",
            "4984230",
            "5212131",
            "6434231",
            "7553423",
            "8756342",
            "9432355",
            "1042315",
    };
    String[] nama={
            "Mutia Rahma",
            "Fanny Shaf",
            "Veronita",
            "Vicky",
            "Nuranisa",
            "Fauzan",
            "Gilang",
            "Hasbi",
            "Didik",
            "Gigih",
    };
    String[] Waktu_absensi={
            "08.30",
            "08.30",
            "08.30",
            "Belum Absen",
            "08.30",
            "08.30",
            "Belum Absen",
            "08.30",
            "08.30",
            "08.30",

    };

    ListView listmenu;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private LinearLayout btDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarsantri);

        listmenu=(ListView)findViewById(R.id.list_santri);

        Adapter_santri adapter=new Adapter_santri(Daftar_santriActivity.this,nik,nama,Waktu_absensi);
        listmenu.setAdapter(adapter);

        Typeface font = Typeface.createFromAsset(Daftar_santriActivity.this.getAssets(), "fonts/Nexa Light.otf");
        Typeface fontbold = Typeface.createFromAsset(Daftar_santriActivity.this.getAssets(), "fonts/Nexa Bold.otf");

        TextView textView = (TextView) findViewById(R.id.text_judul);
        textView.setTypeface(fontbold);
        TextView textView1 = (TextView) findViewById(R.id.tanggal);
        textView1.setTypeface(fontbold);
        TextView textView2 = (TextView) findViewById(R.id.hasil);
        textView2.setTypeface(fontbold);

        listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                // String Slecteditem= judul[+position];
                //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Daftar_santriActivity.this, IsiQuranActivity.class);
                startActivity(i);
            }
        });

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvDateResult = (TextView) findViewById(R.id.hasil);
        btDatePicker = (LinearLayout) findViewById(R.id.pilihtanggal);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void showDateDialog(){

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }
}

