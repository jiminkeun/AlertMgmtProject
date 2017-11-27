package daou.syscore.alertmgmtproject.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import daou.syscore.alertmgmtproject.R;
import daou.syscore.alertmgmtproject.adapter.FcmPuchAdapter;
import daou.syscore.alertmgmtproject.dao.FcmPushDao;
import daou.syscore.alertmgmtproject.item.FcmPushInfo;
import daou.syscore.alertmgmtproject.sqlmap.FcmPushDBSqlData;

public class FcmPushListActivity extends AppCompatActivity implements Button.OnClickListener{
    SQLiteDatabase db = null;
    private ListView pushListView = null;
    private FcmPuchAdapter pushAdapter = null;
    ArrayList<FcmPushInfo> pushList = new ArrayList<FcmPushInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcm_push_list);

        // Db data 리스트 list 객체에 저장
        getFcmPushDbData(pushList);

        // custom adapter 적용하여 view 에 적용
        pushAdapter = new FcmPuchAdapter(this, R.layout.listview_fcm_push, pushList);
        pushListView = (ListView) this.findViewById(R.id.listview_fcmpush);
        pushListView.setAdapter(pushAdapter);

        // Fcm 푸시 삭제
        Button btnPushDelByPushList = (Button) findViewById(R.id.btnPushDelByPushList);
        btnPushDelByPushList.setOnClickListener(this);
    }

    private void getFcmPushDbData(ArrayList<FcmPushInfo> pushList) {
        FcmPushDao pushDao = new FcmPushDao(this);
        pushDao.selectAllDao(FcmPushDBSqlData.SQL_DB_SELECT_ALL, pushList);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        // 삭제버튼
        switch (v.getId()) {
            case R.id.btnPushDelByPushList:
                int countPush = pushAdapter.getCount();
                int checked;

                Log.i("전체 푸시 수", Integer.toString(countPush) + " 명");
                if(countPush > 0) {
                    checked = pushListView.getCheckedItemPosition();
                    Log.i("삭제 position", Integer.toString(checked));
                    if(checked > -1 && checked < countPush) {

                        // FcmPushInfo 해당 position Data 삭제
                        FcmPushDao pushDao = new FcmPushDao(this);
                        pushDao.deleteDao(FcmPushDBSqlData.SQL_DB_DELETE_DATA, pushAdapter.getItem(checked).getNo());

                        // 목록 삭제
                        pushList.remove(checked);

                        // listView 선택 초기화
                        pushListView.clearChoices();

                        // 데이터 갱신
                        pushAdapter.notifyDataSetChanged();
                    }
                }
                break;
        }
    }
}
