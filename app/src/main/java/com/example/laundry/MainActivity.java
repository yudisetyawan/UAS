package com.example.laundry;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText editnamapel, editnamabar,
            editjumlahbar, editharga, edituangbay;
    private Button btnproses;
    private Button btnhapus;
    private Button btnexit;
    private Button btnhasil;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbar;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("GoLaundry");
        editnamapel = (EditText) findViewById(R.id.nama_pelanggan);
        editnamabar = (EditText) findViewById(R.id.nama_barang);
        editjumlahbar = (EditText) findViewById(R.id.jml_barang);
        editharga = (EditText) findViewById(R.id.harga_barang);
        edituangbay = (EditText) findViewById(R.id.jml_uang);

        btnhasil = (Button) findViewById(R.id.button2);
        btnproses = (Button) findViewById(R.id.proses);
        btnhapus = (Button) findViewById(R.id.reset);
        btnexit = (Button) findViewById(R.id.exit);

        txtnamapel = (TextView) findViewById(R.id.nama_pelanggan);
        txtnamabar = (TextView) findViewById(R.id.nama_barang);
        txtjumlahbar = (TextView) findViewById(R.id.jml_barang);
        txtharga = (TextView) findViewById(R.id.harga_barang);
        txtuangbay = (TextView) findViewById(R.id.jml_uang);
        txttotalbelanja = (TextView) findViewById(R.id.total);
        txtkembali = (TextView) findViewById(R.id.kembalian);
        txtketerangan = (TextView) findViewById(R.id.keterangan);
        txtbonus = (TextView) findViewById(R.id.bonus);


        btnhasil.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String jumlahbarang = editjumlahbar.getText().toString().trim();
                String hargabarang = editharga.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbarang);
                double h = Double.parseDouble(hargabarang);

                double total = (jb * h);

                txttotalbelanja.setText("Total Semua : " + total);
            }
        });

        btnproses.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongViewCast")
            @Override
            public void onClick(View v) {

                String namapelanggan = editnamapel.getText().toString().trim();
                String namabarang = editnamabar.getText().toString().trim();
                String jumlahbarang = editjumlahbar.getText().toString().trim();
                String hargabarang = editharga.getText().toString().trim();
                String uangbayar = edituangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbarang);
                double h = Double.parseDouble(hargabarang);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Semua : " + total);


                if (total >= 50000) {
                    txtbonus.setText("Bonus : Gratis Ongkir");
                }  else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }

                double uangkembalian = (ub - total);
                if (ub < total) {
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp." + (-uangkembalian));
                    txtkembali.setText("Uang Kembalian : Rp. 0");
                } else {
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtkembali.setText("Uang Kembalian : " + uangkembalian);
                }
            }
        });

        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txtjumlahbar.setText(" ");
                txtuangbay.setText(" ");
                txtkembali.setText("Uang Kembali : Rp. 0");
                txtketerangan.setText("-");
                txtbonus.setText("-");
                txttotalbelanja.setText("Total Semua : Rp 0");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_LONG).show();
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}