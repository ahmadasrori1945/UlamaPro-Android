package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_asmaulhusna extends BaseAdapter {
    Context context;
    private final String[] asmaul;
    private final String[] isi;
    LayoutInflater layoutInflater;
    View view;
    Typeface font,fontbold;


    public Adapter_asmaulhusna (Activity context,String[] asmaul,String[] isi) {

        // TODO Auto-generated constructor stub

        this.context=context;
        this.asmaul=asmaul;
        this.isi=isi;
        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(),"fonts/Nexa Bold.otf");
    }

    public int getCount() {

        return asmaul.length;
    }

    public String getItem(int position) {


        return null;
    }

    public long getItemId(int position) {

        return 0;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            view = new View(context);
            view = layoutInflater.inflate(R.layout.item_grid_asmaul,null);
            TextView textView = (TextView) view.findViewById(R.id.txtasma);
            textView.setTypeface(fontbold);
            TextView textView2 = (TextView) view.findViewById(R.id.text);
            textView2.setTypeface(fontbold);
            textView.setText(asmaul[position]);
            textView2.setText(isi[position]);


        }

        return view;

    }

}
