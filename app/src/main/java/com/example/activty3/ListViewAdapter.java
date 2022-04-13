package com.example.activty3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    //deklarasi variabel dengan jenis data context
    Context mContext;

    //deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor Listviewadapter
    public ListViewAdapter(Context context) {
        //memberi nilai mcontext dengan context
        mContext = context;

        //mengatur layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke array list
        this.arrayList.addAll(HomeActivity.classNamaArrayList);

    }
    //membuat class untuk mendeklarasikan temmpat untuk meletakan isi kedalam listview
    public class ViewHolder{
        //mendeklarasikan variabel dengan jenis textview
        TextView name;
    }

    //fungsi getCount() mengembalikan jumlah item yang akan ditampiplkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return HomeActivity.classNamaArrayList.size();
    }

    //fungsi ini digunakan untuk mendaptakan dadta item yang terkaiit dengan posisi
    // tertentu dalam kumpulan data untuk medaptkan data yang sesuai dari lokasi
    // tertentu dalam pengumpulan data item
    @Override
    public Object getItem(int i) {
        //mengambil nilai berupa objek dari array data
        return HomeActivity.classNamaArrayList.get(i);
    }

    //fungsi mengembalikan "nilai" dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsi ini secara otomatis dipanggil ketika menampilkan item list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data viewholder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null) {

            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }else {
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getNama());

        //mengembalikan nilai ke variabel view
        return view;
    }
}
