package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_isisholawat extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] judul;
    private final String[] isi;
    private final String[] no;
    Typeface font,fontbold;


    public Adapter_isisholawat(Activity context, String[] judul, String[] isi, String[] no) {
        super(context, R.layout.item_list_isi_alquran, judul);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.judul=judul;
        this.isi=isi;
        this.no=no;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_isi_alquran, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_ayat);
        txtTitle.setText(judul[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.text_terjemahan);
        txtTitle1.setText(isi[position]);
        txtTitle1.setTypeface(font);


        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_angka);
        txtTitle_tiga.setText(no[position]);
        txtTitle_tiga.setTypeface(font);




        return rowView;

    };
}
