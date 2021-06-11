package com.example.pasgenap10rpl222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.AnalyticsListener;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;

import java.util.ArrayList;

public class MahasiswaDataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaDataAdapter adapter;
    private ArrayList<MahasiswaData> mahasiswaArrayList;
    // we user ArrayList to populate data in RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_data);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);

        addData();

        adapter = new MahasiswaDataAdapter(mahasiswaArrayList, new MahasiswaDataAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MahasiswaDataActivity.this, "click item "+position, Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(),DetailActivity.class);
                MahasiswaData mymahasiswa = mahasiswaArrayList.get(position);
                move.putExtra("nama", mymahasiswa.getNama());
                move.putExtra("nim", mymahasiswa.getNim());
                startActivity(move);
            }
        });
        //selesai ngatur data dari adapter, kemudian di tempel ke Recyclerview nya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaDataActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new MahasiswaData("SOAP", "Tekan untuk info lebih lanjut !"));
        mahasiswaArrayList.add(new MahasiswaData("PRICE", "Tekan untuk info lebih lanjut !"));
        mahasiswaArrayList.add(new MahasiswaData("GHOST", "Tekan untuk info lebih lanjut !"));
    }
}