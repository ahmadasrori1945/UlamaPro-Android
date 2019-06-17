package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_notification extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] judul;
    private final String[] isi;
    private final String[] waktu;
    Typeface font,fontbold;


    public Adapter_notification(Activity context, String[] judul, String[] isi,String[] waktu) {
        super(context, R.layout.item_list_notif, judul);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.judul=judul;
        this.isi=isi;
        this.waktu=waktu;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_notif, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_judul);
        txtTitle.setText(judul[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_waktu);
        txtTitle_tiga.setText(waktu[position]);
        txtTitle_tiga.setTypeface(font);

        TextView txtTitle_tiga1 = (TextView) rowView.findViewById(R.id.text_deskripsi);
        txtTitle_tiga1.setText(isi[position]);
        txtTitle_tiga1.setTypeface(font);


        return rowView;

    };
}
