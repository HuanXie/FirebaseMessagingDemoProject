package com.example.huaxie.firebasemessagingdemoproject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        findViewById(R.id.tester).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAnalytics.setUserProperty("tester", "tester" );
                Toast.makeText(getBaseContext(), "You click the button and mark yourself as a tester",Toast.LENGTH_LONG).show();
            }
        });

        boolean color = firebaseRemoteConfig.getBoolean("color");
        if (color) {
            ((TextView)findViewById(R.id.color)).setText("tester true");
        } else {
            ((TextView)findViewById(R.id.color)).setText("user false");
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
