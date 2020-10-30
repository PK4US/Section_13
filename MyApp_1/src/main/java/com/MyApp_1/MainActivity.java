package com.MyApp_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayNumberPhone;
    private ArrayAdapter<String> adapter;
    public String call = "tel:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayNumberPhone = new ArrayList();
        arrayNumberPhone.add("+380986774420");
        arrayNumberPhone.add("+380637868341");
        arrayNumberPhone.add("+380984341464");

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayNumberPhone);

        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                call += adapter.getItem(position);
                callPhone();
            }
        });
    }

    private void callPhone() {
        //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(call)));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(call)));
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) callPhone();
            else System.out.println("Пользователь не разрешил совершать звонки из приложения!");
        }
    }
}