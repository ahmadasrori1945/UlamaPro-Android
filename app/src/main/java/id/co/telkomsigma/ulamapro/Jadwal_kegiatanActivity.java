package id.co.telkomsigma.ulamapro;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;


import android.icu.util.Calendar;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


public class Jadwal_kegiatanActivity extends AppCompatActivity {

    String[] judul={
            "Kajian Dhuha",
            "Kajian Dzuhur",
            "Kajian Maghrib",
            "Kajian Jumat",
    };
    String[] waktu={
            "Pukul : 08.00 - 10.00",
            "Pukul : 13.00 - 14.30",
            "Pukul : 18.00 - 18.30",
            "Pukul : 11.00 - 11.45",
    };
    String[] deskripsi={
            "Judul : Tiga Pilar Utama",
            "Judul : Fiqih",
            "Judul : Fiqih Ibadah",
            "Judul : Kunci Pengetuk Pintu Surga",


    };

    MaterialCalendarView materialCalendarView;
    CalendarView calenderview;
    ListView listmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_kegiatan);


        calenderview = (CalendarView) findViewById(R.id.simpleCalendarView);
        listmenu = (ListView) findViewById(R.id.list_jadwal);
        calenderview.setFirstDayOfWeek(Calendar.MONDAY);
        calenderview.setSelectedWeekBackgroundColor(Color.RED);
        calenderview.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        calenderview.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        calenderview.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
        calenderview.setWeekSeparatorLineColor(Color.GREEN);

        calenderview.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(CalendarView view,
                                            int year, int month, int dayOfMonth) {

                Adapter_jadwal adapter=new Adapter_jadwal(Jadwal_kegiatanActivity.this,judul,waktu,deskripsi);
                listmenu.setAdapter(adapter);

            }});




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
