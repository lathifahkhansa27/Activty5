package com.example.activty3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //deklarasi variabel dengan jenis data listview
    private ListView list;

    //memanggil class ListViewAdaptor dan diinisiasi menjadi variabel adapter
    private  ListViewAdapter adapter;

    //deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek Buddle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //menyimpan nama didalam array listnama
        listNama = new String[] {"Jennie","Jisoo","Rose","Lisa",
        "Taehyung","Jimin","Wendy","Seulgi","Jungkook","Yoshi"};

        list = findViewById(R.id.listKontak);

        //mebuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada array listnama
        for (int i = 0; i <listNama.length; i++)
        {
            //membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);
            //binds string ke array
            classNamaArrayList.add(classNama);
        }

        //membuat objek dari listviewadapter
        adapter = new ListViewAdapter(this);

        //binds adapter ke list view
        list.setAdapter(adapter);

        //membuat event dari listonclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //deklarasi variabel nama yang berisi item yang di klik
                String nama = classNamaArrayList.get(position).getNama();

                //memasukan value dari variabel nama dengan kunci "a" dan dimasukan kedalam bunddle
                bundle.putString("a",nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //menampilkan popup menu
                pm.show();
            }
        });
    }

    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),Activtylihatdata.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edeit kontak", Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
