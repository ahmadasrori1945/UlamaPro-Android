package id.co.telkomsigma.ulamapro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CommunityMessageActivity extends AppCompatActivity {


    String[] no={
            "Assalamualaikum",
            "Saya ingin bertanya ",

    };

    String[] isi={
            "6.32",
            "6.33",
            "6.34"

    };

    ListView listmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_message);

        listmenu=(ListView)findViewById(R.id.list_message);

        Adapter_communitymessage adapter=new Adapter_communitymessage(CommunityMessageActivity.this,no,isi);
        listmenu.setAdapter(adapter);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
