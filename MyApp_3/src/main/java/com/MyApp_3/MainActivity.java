package com.MyApp_3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readSMS();
    }

    private void readSMS() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, 1);
            return;
        }
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                ArrayList<Message> messages = new ArrayList<>();
                ListView lv = findViewById(R.id.lv);
                MessageAdapter adapter = new MessageAdapter(this, R.layout.item, messages);
                lv.setAdapter(adapter);

                messages.add(new Message(cursor.getString(cursor.getColumnIndex("address")), cursor.getString(cursor.getColumnIndex("body")),cursor.getString(cursor.getColumnIndex("date"))));
                messages.add(new Message(cursor.getString(cursor.getColumnIndex("address")), cursor.getString(cursor.getColumnIndex("body")),cursor.getString(cursor.getColumnIndex("date"))));
                messages.add(new Message(cursor.getString(cursor.getColumnIndex("address")), cursor.getString(cursor.getColumnIndex("body")),cursor.getString(cursor.getColumnIndex("date"))));

//                for (int i = 0; i < cursor.getColumnCount(); i++) {
//                    System.out.println(cursor.getColumnName(i) + ": " + cursor.getString(i));
//                    messages.add(new Message(cursor.getString(cursor.getColumnIndex("address")), cursor.getString(cursor.getColumnIndex("body")),cursor.getString(cursor.getColumnIndex("date"))));
//                }
            } while (cursor.moveToNext());
        }
        else {
            System.out.println("Нет SMS");
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) readSMS();
            else System.out.println("Пользователь не разрешил читать SMS из приложения!");
        }
    }
}