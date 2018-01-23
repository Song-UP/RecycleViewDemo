package llapps.com.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        String adName = SecondeAcitivity.adptetaNames[0];
        switch (view.getId()){
            case R.id.btn_adapter_base:
                adName = SecondeAcitivity.adptetaNames[0];
                SecondeAcitivity.start(this, adName);
                break;
            case R.id.btn_multi_adpter:
                adName = SecondeAcitivity.adptetaNames[1];
                SecondeAcitivity.start(this, adName);
                break;
            case R.id.btn_adpter_head:
                adName = SecondeAcitivity.adptetaNames[2];
                SecondeAcitivity.start(this, adName);
                break;
            case R.id.btn_adpter_span:
                adName = SecondeAcitivity.adptetaNames[3];
                SecondeAcitivity.start(this, adName);
                break;
            case R.id.btn_adpter_banner:
                adName = BannerAcitivty.adptetaNames[0];
                BannerAcitivty.start(this, adName);
                break;
            case R.id.btn_adpter_span_decor:
                adName = BannerAcitivty.adptetaNames[1];
                BannerAcitivty.start(this, adName);
                break;
        }

    }
}
