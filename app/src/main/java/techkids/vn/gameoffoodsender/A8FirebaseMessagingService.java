package techkids.vn.gameoffoodsender;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by huynq on 7/14/17.
 */

public class A8FirebaseMessagingService extends FirebaseMessagingService {
    private String TAG = "A8FirebaseMessaging";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "onMessageReceived: data: " + remoteMessage.getData());

        } else {
            Log.d(TAG, "onMessageReceived: data null");
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "onMessageReceived: noti: " + remoteMessage.getNotification().getBody());
            sendNoti(remoteMessage.getNotification().getBody());
        }
    }

    public void sendNoti(String noti) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notiBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("FCMMMM")
                .setContentText(noti)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notiBuilder.build());

    }
}
