package daou.syscore.alertmgmtproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import daou.syscore.alertmgmtproject.R;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goAlertMgmtList = (Button) findViewById(R.id.goAlertMgmtList);
        goAlertMgmtList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.goAlertMgmtList:
                intent = new Intent(this, AlertMgmtMainActivity.class);
                startActivity(intent);
                break;
        }
    }
}


