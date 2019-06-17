package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_ponpes extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] judul;
    private final String[] tanggal;
    private final String[] deskripsi;
    Typeface font,fontbold;


    public Adapter_ponpes(Activity context, String[] judul, String[] tanggal, String[] deskripsi) {
        super(context, R.layout.item_list_ponpes, judul);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.judul=judul;
        this.tanggal=tanggal;
        this.deskripsi=deskripsi;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_ponpes, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_judul);
        txtTitle.setText(judul[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_tanggal);
        txtTitle_tiga.setText(tanggal[position]);
        txtTitle_tiga.setTypeface(font);

        TextView txtTitle_tiga1 = (TextView) rowView.findViewById(R.id.text_deskripsi);
        txtTitle_tiga1.setText(deskripsi[position]);
        txtTitle_tiga1.setTypeface(font);


        return rowView;

    };
}
