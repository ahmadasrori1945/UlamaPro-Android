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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONObject;

import java.util.List;

import id.co.telkomsigma.ulamapro.R;
import id.co.telkomsigma.ulamapro.model.ModelQuran;

public class Adapter_quran extends BaseAdapter {
    private Context mContext;
    private ModelQuran model;
    private List<ModelQuran> listModel;
    private TextView tvnama, tvno, tvarti, tvarab;
    Typeface font, fontbold;


    public Adapter_quran(Context mContext, List<ModelQuran> listModel) {
        this.mContext = mContext;
        this.listModel = listModel;
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

        model = listModel.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_list_notif, null);
        tvnama = view.findViewById(R.id.text_judul);
        tvarti = view.findViewById(R.id.arti);
        tvarab = view.findViewById(R.id.arab);
        tvno   = view.findViewById(R.id.number);


        tvarti.setText("Jumlah Ayat : "+model.getArti());
        tvnama.setText(model.getNama());
        tvarab.setText(model.getAsma());
        tvno.setText(model.getNomor());

        return view;
    }
}