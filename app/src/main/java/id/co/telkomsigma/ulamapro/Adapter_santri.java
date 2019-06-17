package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_santri extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] nik;
    private final String[] isi;
    private final String[] waktu_absen;
    Typeface font,fontbold;


    public Adapter_santri(Activity context, String[] nik, String[] isi, String[] waktu_absen) {
        super(context, R.layout.item_list_santri, nik);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.nik=nik;
        this.isi=isi;
        this.waktu_absen=waktu_absen;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_santri, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_angka2);
        txtTitle.setText(nik[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_surah);
        txtTitle_tiga.setText(isi[position]);
        txtTitle_tiga.setTypeface(font);

        TextView txtTitle_tiga1 = (TextView) rowView.findViewById(R.id.text_surah2);
        txtTitle_tiga1.setText(waktu_absen[position]);
        txtTitle_tiga1.setTypeface(font);


        return rowView;

    };
}
