package techkids.vn.gameoffoodsender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private String TAG = "MainActivity";

    private String username = "qk123";
    private String foodId = "abcd1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Button btSub = (Button) findViewById(R.id.bt_subcribe);

        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseMessaging.getInstance().subscribeToTopic("newss");

                Log.d(TAG, "onClick: subcribe okay");
                Toast.makeText(MainActivity.this, "sub ok", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.bt_logtoken).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "onClick: {" + token + "}");
            }
        });

    }

    private void writeNewRecord(String recordID, String name, String idFCM) {
        RecordModel recordModel = new RecordModel(name, idFCM);

        databaseReference.child("records").child(recordID).setValue(recordModel);
    }


}
