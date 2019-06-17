package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_jadwal extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] judul;
    private final String[] waktu;
    private final String[] deskripsi;
    Typeface font,fontbold;


    public Adapter_jadwal(Activity context, String[] judul, String[] waktu, String[] deskripsi) {
        super(context, R.layout.item_list_jadwal, judul);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.judul=judul;
        this.waktu=waktu;
        this.deskripsi=deskripsi;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_jadwal, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_judul);
        txtTitle.setText(judul[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.text_waktu);
        txtTitle1.setText(waktu[position]);
        txtTitle1.setTypeface(font);


        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_detail);
        txtTitle_tiga.setText(deskripsi[position]);
        txtTitle_tiga.setTypeface(font);




        return rowView;

    };
}
