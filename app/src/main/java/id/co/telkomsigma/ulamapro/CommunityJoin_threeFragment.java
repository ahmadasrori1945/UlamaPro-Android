package id.co.telkomsigma.ulamapro;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class CommunityJoin_threeFragment extends Fragment {

    ListView listCommunity;

    String[] isi={
            "Konsultasi Seputar Zakat",
            "Konsultasi Seputar Puasa",
            "Konsultasi Seputar Haji",
    };
    String[] tanggal={
            "20 September 2019",
            "30 Oktober 2019",
            "10 November 2019",
    };
    String[] deskripsi={
            "Pembahasan mengenai zakat",
            "Pembahasan mengenai puasa",
            "Pembahasan mengenai haji",
    };

    TextView option;

    Typeface font,fontbold;
    public CommunityJoin_threeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_community_join, container, false);


        font = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Nexa Light.otf");
        fontbold = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Nexa Bold.otf");

        listCommunity = view.findViewById(R.id.list_community);

        Adapter_community adapter=new Adapter_community(getActivity(),isi,deskripsi,tanggal);
        listCommunity.setAdapter(adapter);

        listCommunity.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                // String Slecteditem= judul[+position];
                //Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), CommunityMessageActivity.class);
                startActivity(i);
            }
        });

        return view;

    }



}
