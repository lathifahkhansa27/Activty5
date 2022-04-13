package com.example.activty3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activtylihatdata extends AppCompatActivity {
    //deklarasi variabeel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatdata);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomerTelpon);


        //membuat variabel dengan jenis data bundle dan assign value
        //dari variabel tersebut dengan getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        //membuat fungsi untuk mengatur textview dan nomor telpon

        switch (nama) {
            case "Jennie":
                tvnama.setText("jennie Kim");
                tvnomor.setText("0812635478");
                break;
            case "Jisoo":
                tvnama.setText("jisoo Kim");
                tvnomor.setText("0812635479");
                break;
            case "Rose":
                tvnama.setText("Roseana Park");
                tvnomor.setText("0812635475");
                break;
            case "Lisa":
                tvnama.setText("Lalisa M");
                tvnomor.setText("0812635473");
                break;
            case "Taehyung":
                tvnama.setText("Kim Taehyung");
                tvnomor.setText("0812635472");
                break;
            case "Jimin":
                tvnama.setText("Park Jimin");
                tvnomor.setText("0812635471");
                break;
            case "Wendy":
                tvnama.setText("Wendy A");
                tvnomor.setText("0812635474");
                break;
            case "Seulgi":
                tvnama.setText("Seulgi N");
                tvnomor.setText("0812635476");
                break;
            case "jungkook":
                tvnama.setText("jeon Jungkook");
                tvnomor.setText("0812635438");
                break;
            case "Yoshi":
                tvnama.setText("Yoshinori");
                tvnomor.setText("0812635428");
                break;
        }
    }
}

