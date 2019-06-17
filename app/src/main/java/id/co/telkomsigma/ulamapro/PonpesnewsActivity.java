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
import java.util.Calendar;
import java.util.Locale;

import id.co.telkomsigma.ulamapro.Activity.IsiQuranActivity;

public class PonpesnewsActivity extends AppCompatActivity {

    String[] judul={
            "Buka Bersama ",
            "Kajian Akbar",
            "Kuliah Subuh",
    };
    String[] tanggal={
            "26 November 2018",
            "28 November 2018",
            "29 November 2018",
    };
    String[] deskripsi={
            "Hadiri Buka bersama dengan anak yatin di panti ...",
            "Hadiri Kajian Akbar ba'da Dzuhur dengan ustad ...",
            "Hadiri Kajian subuh di masjid ...",

    };


    ListView listmenu;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private LinearLayout btDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponpesnews);

        listmenu=(ListView)findViewById(R.id.list_news);

        Adapter_ponpes adapter=new Adapter_ponpes(PonpesnewsActivity.this,judul,tanggal,deskripsi);
//        non_scroll_list.setAdapter(adapter);
        listmenu.setAdapter(adapter);

        Typeface font = Typeface.createFromAsset(PonpesnewsActivity.this.getAssets(), "fonts/Nexa Light.otf");
        Typeface fontbold = Typeface.createFromAsset(PonpesnewsActivity.this.getAssets(), "fonts/Nexa Bold.otf");

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
                Intent i = new Intent(PonpesnewsActivity.this, IsiQuranActivity.class);
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

