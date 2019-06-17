package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_sholawat extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] no;
    private final String[] isi;
    Typeface font,fontbold;


    public Adapter_sholawat(Activity context, String[] no, String[] isi) {
        super(context, R.layout.item_list_sholawat, no);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.no=no;
        this.isi=isi;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_sholawat, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_angka);
        txtTitle.setText(no[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_sholawat);
        txtTitle_tiga.setText(isi[position]);
        txtTitle_tiga.setTypeface(font);


        return rowView;

    };
}
