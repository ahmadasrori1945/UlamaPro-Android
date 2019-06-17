package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter_community extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] isi;
    private final String[] desc;
    private final String[] tgl_msk;
    Typeface font,fontbold;


    public Adapter_community(Activity context,String[] isi, String[] desc, String[] tgl_msk) {
        super(context, R.layout.item_listcommunity, isi);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.isi=isi;
        this.desc=desc;

        this.tgl_msk=tgl_msk;

        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_listcommunity, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.tvCommunityName);
        txtTitle.setText(isi[position]);
        txtTitle.setTypeface(fontbold);



        TextView txtTitle_tigaa = (TextView) rowView.findViewById(R.id.tvCommunityDate);
        txtTitle_tigaa.setText(tgl_msk[position]);
        txtTitle_tigaa.setTypeface(font);

        TextView txtTitle_tigaaa = (TextView) rowView.findViewById(R.id.tvCommunityDesc);
        txtTitle_tigaaa.setText(desc[position]);
        txtTitle_tigaaa.setTypeface(font);

        return rowView;

    };
}
