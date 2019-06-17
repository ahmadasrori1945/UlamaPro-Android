package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_setting extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] judul;
    Typeface font,fontbold;


    public Adapter_setting(Activity context, String[] judul) {
        super(context, R.layout.item_list_settings, judul);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.judul=judul;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_settings, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_judul);
        txtTitle.setText(judul[position]);
        txtTitle.setTypeface(fontbold);




        return rowView;

    };
}
