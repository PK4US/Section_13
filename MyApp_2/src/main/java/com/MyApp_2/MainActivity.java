package com.MyApp_2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    final  String numPhoneAdmin = "0986774420";
    final  String messageError = "Админ! Спасай у нас проблема!";
    final  String messageInfo = "Админ! Все идет по плану!";
    String to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendError(View view) { sendSMSError(); }
    public void sendSMSError() {
        to = "smsto:" + numPhoneAdmin;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(to));
        intent.putExtra("sms_body", messageError);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
            return;
        }
        SmsManager.getDefault().sendTextMessage(numPhoneAdmin, null, messageError, null, null);
    }

    public void sendInfo(View view) { sendSMSInfo(); }
    public void sendSMSInfo() {
        to = "smsto:" + numPhoneAdmin;
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(to));
        intent.putExtra("sms_body", messageInfo);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 2);
            return;
        }
        SmsManager.getDefault().sendTextMessage(numPhoneAdmin, null, messageInfo, null, null);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) sendSMSError();
            else System.out.println("Пользователь не разрешил отправлять SMS из приложения!");
        }
        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) sendSMSInfo();
            else System.out.println("Пользователь не разрешил отправлять SMS из приложения!");
        }
    }
}