package com.example.activty3;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data textview
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //menghubungkan variabel txEmail dengan componen Textview pada layout
        txEmail = findViewById(R.id.tvEmail);

        //mengubungkan variabel txEmail dengan componen textview pada layout
        txPassword = findViewById(R.id.tvPassword);

        //mendeklrasikan variabel buddle yang akan digunakan untuk mengambil
        //pesan yang dikirimkan melalui method intent
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        //menampilkan value dari varaibel email kedalam txemail
        txEmail.setText(email);

        //menampilkan value dari variabel pass kedalam txpassword
        txPassword.setText(pass
        );


    }
}


