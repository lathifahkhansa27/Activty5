package com.example.activty3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {
    //deklarasi variabel dengan tipe data editText
    EditText edtNama,edtAlamat,edtEmail,edtPassword,edtrepass;

    //deklarasi variabel dengan tipe data floating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keempat);

        //menghubungkan variabel edtnama,edtemail,edtpassword dengan layout button
        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword =findViewById(R.id.edPassword);
        edtrepass = findViewById(R.id.edrepass);
        FloatingActionButton fab = findViewById(R.id.fabSimpan);

        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //membuat kondisi untuk mengecek apakah edit text ksong atau tidak
                View view = null;
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //menampilkan pesan notif jika seluruh edittext wajib diisi

                    Snackbar.make(view,"wajib isi seluruh data!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //menampilkan kondisi untuk cek apakah isi dari edittext password dan edittext repassword
                    // sama tau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //menampiplkan pesan notif jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(),"pendaftaran berhasil...",
                                Toast.LENGTH_LONG).show();

                        //method untuk kembali ke activty
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //menampilkan pesan bahwa isi dari edittext password dan edottext repassword
                        //tidak sama
                        Snackbar.make(view,"Password dan Repassword harus sama!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
