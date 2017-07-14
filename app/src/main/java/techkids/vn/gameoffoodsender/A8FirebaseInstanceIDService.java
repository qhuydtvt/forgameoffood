package techkids.vn.gameoffoodsender;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by huynq on 7/14/17.
 */

public class A8FirebaseInstanceIDService extends FirebaseInstanceIdService {
    private String TAG = "A8FirebaseInstance";
    @Override
    public void onTokenRefresh() {
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + refreshToken);

        saveToFirebaseDB(refreshToken);
    }

    private void saveToFirebaseDB(String refreshToken) {
        //TODO: save to db
    }
}
