package com.example.pasgenap10rpl222;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Bundle bundle;
    String name;
    String nim;
    String nohp;
    String email;
    TextView tvnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvnama = (TextView)findViewById(R.id.tvnama);
        bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("nama");
            nim = bundle.getString("nim");
            nohp = bundle.getString("hp");
            email = bundle.getString("email");
        }
        tvnama.setText("PROFIL :");
        //misa ada gambar, bisa pakai gambar asset, atau bisa dari internet
        // www.image.jpg -> Glide
    }
}