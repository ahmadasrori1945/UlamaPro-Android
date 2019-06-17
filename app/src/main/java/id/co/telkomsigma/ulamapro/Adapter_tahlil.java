package id.co.telkomsigma.ulamapro;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Adapter_tahlil extends ArrayAdapter {

    private final Activity context;
    private final String[] no;
    private final String[] isi;
    Typeface font, fontbold;

    public Adapter_tahlil(Activity context, String[] no, String[] isi) {
        super(context, R.layout.item_list_tahlil, no);

        this.context = context;
        this.no = no;
        this.isi = isi;


        font = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(context.getAssets(), "fonts/Nexa Bold.otf");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_list_tahlil, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text_angka);
        txtTitle.setText(no[position]);
        txtTitle.setTypeface(fontbold);

        TextView txtTitle_tiga = (TextView) rowView.findViewById(R.id.text_sholawat);
        txtTitle_tiga.setText(isi[position]);
        txtTitle_tiga.setTypeface(font);


        return rowView;

    };
}

//    @Override
//    public int getGroupCount() {
//        return this._listDataHeader.size();
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this._listDataHeader.get(groupPosition);
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.tahlil_listgroup, null);
//        }
//
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.lblListHeader);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle);
//
//        return convertView;
//    }
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//
//
//            final String childText = (String) getChild(groupPosition, childPosition);
//
//            if (convertView == null) {
//                LayoutInflater infalInflater = (LayoutInflater) this._context
//                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = infalInflater.inflate(R.layout.tahlil_listitem, null);
//            }
//
//            TextView txtListChild = (TextView) convertView
//                    .findViewById(R.id.lblListItem);
//
//            txtListChild.setText(childText);
//            return convertView;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//}
