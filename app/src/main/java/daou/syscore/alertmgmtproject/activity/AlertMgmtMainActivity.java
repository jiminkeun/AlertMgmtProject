package daou.syscore.alertmgmtproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import daou.syscore.alertmgmtproject.R;

public class AlertMgmtMainActivity extends AppCompatActivity implements Button.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_mgmt_main);

        Button btnProjectSearch = (Button)findViewById(R.id.btnProjectSearch);
        btnProjectSearch.setOnClickListener(this);

        Button btnFcmPushList = (Button)findViewById(R.id.btnFcmPushList);
        btnFcmPushList.setOnClickListener(this);

        Button btnMessageList = (Button)findViewById(R.id.btnMessageList);
        btnMessageList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnProjectSearch:
                //intent = new Intent(this, ProjectSearchActivity.class);
                //startActivity(intent);
                break;
            case R.id.btnFcmPushList:
                intent = new Intent(this, FcmPushListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMessageList:
                /*intent = new Intent(this, MessageListActivity.class);
                startActivity(intent);*/
                break;
        }
    }
}
