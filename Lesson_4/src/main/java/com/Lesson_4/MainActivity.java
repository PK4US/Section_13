package com.Lesson_4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readContacts();
    }

    private void readContacts() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            return;
        }

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                for (int i = 0; i < c.getColumnCount(); i++) {
                    //System.out.println(c.getColumnName(i) + ": " + c.getString(i));
                }

                /*Cursor cNew = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                        new String[]{c.getString(c.getColumnIndex("_id"))}, null);
                if (cNew.moveToFirst()) {
                    do {
                        for (int i = 0; i < cNew.getColumnCount(); i++) {
                            System.out.println(cNew.getColumnName(i) + ": " + cNew.getString(i));
                        }
                    } while (cNew.moveToNext());
                }
                */
                Cursor cNew = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        new String[]{c.getString(c.getColumnIndex("_id"))}, null);
                if (cNew.moveToFirst()) {
                    do {
                        for (int i = 0; i < cNew.getColumnCount(); i++) {
                            System.out.println(cNew.getColumnName(i) + ": " + cNew.getString(i));
                        }
                    } while (cNew.moveToNext());
                }
            } while (c.moveToNext());
        }
        else {
            System.out.println("Нет контактов");
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) readContacts();
            else System.out.println("Пользователь не разрешил читать свои контакты!");
        }
    }
}