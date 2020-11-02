package com.MyApp_3;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));
        messages.add(new Message("+380986774420", "Hello,how are you?","22:45"));

        ListView lv = findViewById(R.id.lv);
        MessageAdapter adapter = new MessageAdapter(this, R.layout.item, messages);

        lv.setAdapter(adapter);

    }

//    private void readSMS() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_SMS}, 1);
//            return;
//        }
//        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/"), null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
////                System.out.println(cursor.getString(cursor.getColumnIndex("body")));
////                System.out.println(cursor.getString(cursor.getColumnIndex("address")));
////                System.out.println(cursor.getString(cursor.getColumnIndex("date")));
////                Telephony.TextBasedSmsColumns.MESSAGE_TYPE_SENT
//                for (int i = 0; i < cursor.getColumnCount(); i++) {
//                    System.out.println(cursor.getColumnName(i) + ": " + cursor.getString(i));
//                }
//            } while (cursor.moveToNext());
//        }
//        else {
//            System.out.println("Нет SMS");
//        }
//    }
//
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == 1) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) readSMS();
//            else System.out.println("Пользователь не разрешил читать SMS из приложения!");
//        }
//    }
}