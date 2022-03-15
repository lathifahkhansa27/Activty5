package com.example.activty3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel untuk button
    Button btnLogin;

    //deklarasi variabel untuk editext
    EditText edemail, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //menghubungkan variabel edemail dengan componen button pada layout
        edemail = findViewById(R.id.edEmail);

        //menghbungkan variabel edpassword dengan componen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btlogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //membuat email yang benar
                String email = "admin@mail.com";

                //membuat password yang benara
                String pass = "123";

                //cek apakah editetxt email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "text tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email dan password tidak boleh kosong!!",
                            Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                } else {
                    //cek apakah isi dari email dan password sama dengan email dan password
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "login berhasil"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil",
                                Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();

                        //membuat objek buddle
                        Bundle b = new Bundle();

                        //memasukan value dari variabel nama dengan kunci "a" dan dimasukan ke buddle
                        b.putString("a", nama.trim());

                        //memasukan value dari variabel nama dengan kunci "b" dan dimasukan ke buddle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activtu dari mainactivty ke activtyHasil
                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);

                        //memasukan buddle kedalam intent untuk dikrim ke activityHasil
                        i.putExtras(b);

                        //menampilkan ke activitykedua
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toast menampilkan pesan "login gagal"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);

                        //menampilkan Toast
                        t.show();
                    }
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar) {
            //method untuk memanggil activity "daftaractivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}