package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        if (daftar_nama.isEmpty()) {
            daftar_nama.add("data masih kosong");
        }

        // Menggabungkan urutan angka ke sebelah kiri dari nama
        for (int i = 0; i < daftar_nama.size(); i++) {
            String[] parts = daftar_nama.get(i).split(" ");
            if (parts.length > 2) { // Memastikan ada nama dan angka
                daftar_nama.set(i, parts[parts.length - 1] + " " + String.join(" ", parts));
            }
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);
    }
}