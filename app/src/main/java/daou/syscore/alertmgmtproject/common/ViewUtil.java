package daou.syscore.alertmgmtproject.common;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by hgdgf on 2017-11-25.
 */

public class ViewUtil {

    public ViewUtil() {}

    public static String returnResult = "0";

    public static void showAlert(Context context, String btnMsg, String alertMsg) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        //제목설정
        alert.setTitle("처리안내");
        // alertDialog 설정
        alert
                .setMessage(alertMsg)
                .setCancelable(false)
                .setPositiveButton(btnMsg,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 확인처리
                                ViewUtil.returnResult = "1";
                            }
                        });
                /*.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //취소처리
                                ViewUtil.returnResult = "2";
                            }
                        });*/

        // 다이얼로그 생성
        AlertDialog alertDialog = alert.create();
        alert.show();
    }
}
