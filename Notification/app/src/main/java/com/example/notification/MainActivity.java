package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notify(View view) {
        NotificationManager notification =  (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        EditText title = findViewById(R.id.inputTitle);
        EditText text = findViewById(R.id.inputText);

        Notification notify = new Notification.Builder(getApplicationContext())
                .setContentTitle(title.getText().toString())
                .setContentText(text.getText().toString())
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(Notification.PRIORITY_HIGH)
                .setWhen(System.currentTimeMillis())
                .setShowWhen(true)
                .setSmallIcon(R.drawable.ic_notification).build();

        notification.notify(1, notify);
    }
}