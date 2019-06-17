package id.co.telkomsigma.ulamapro.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import id.co.telkomsigma.ulamapro.R;
import id.co.telkomsigma.ulamapro.model.ModelIsiQuran;
import id.co.telkomsigma.ulamapro.model.ModelQuran;

public class Adapter_isiquran extends BaseAdapter {
    private Context mContext;
    private ModelIsiQuran model;
    private ModelIsiQuran model2;
    private List<ModelIsiQuran> listModel;
    private List<ModelIsiQuran> listModel2;
    private TextView tvnama, tvno, tvarti, tvarab,tvisisurat;


    Typeface font,fontbold;

    public Adapter_isiquran(Context mContext, List<ModelIsiQuran> listModel, List<ModelIsiQuran> listModel2) {
        this.listModel = listModel;
        this.listModel2 = listModel2;
        this.mContext = mContext;

        font = Typeface.createFromAsset(mContext.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(mContext.getAssets(), "fonts/Nexa Bold.otf");

    }

    @Override
    public int getCount() {
        return listModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

//        model = listModel.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_list_isi_alquran, null);
        tvno = view.findViewById(R.id.text_angka);
        tvarti = view.findViewById(R.id.text_terjemahan);
        tvisisurat = view.findViewById(R.id.text_ayat);

        tvno.setText(this.listModel.get(position).getNumber_ayat());
        tvisisurat.setText(this.listModel.get(position).getText_ayat());
        tvarti.setText(this.listModel2.get(position).getText_indo());

        return view;
    }
//        LayoutInflater inflater= LayoutInflater.from(mContext);
//        View rowView=inflater.inflate(R.layout.item_list_isi_alquran, null,true);
//
//        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_ayat);
//        txtTitle.setText(this.listModel.get(position).get("text"));
//        txtTitle.setTypeface(fontbold);
//
//        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.text_terjemahan);
//        txtTitle1.setText(this.listModel2.get(position).get("text"));
//        txtTitle1.setTypeface(font);
//
//
//        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_angka);
//        txtTitle_tiga.setText(this.listModel.get(position).get("numberInSurah"));
//        txtTitle_tiga.setTypeface(font);
//
//        return rowView;
//

//    };
}
