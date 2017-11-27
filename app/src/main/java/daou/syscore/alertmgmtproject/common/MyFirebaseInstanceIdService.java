package daou.syscore.alertmgmtproject.common;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hgdgf on 2017-11-26.
 */

public class MyFirebaseInstanceIdService  extends FirebaseInstanceIdService{
    private final static String TAG = "FCM_ID";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "FirebaseInstanceId Refreshed token: "+refreshedToken);
    }
}
