package com.example.administrator.peisongyuan.Home_Page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.peisongyuan.PeiSongA.PeiSongYuanA;
import com.example.administrator.peisongyuan.PeiSongB.PeiSongB;
import com.example.administrator.peisongyuan.R;
public class login extends AppCompatActivity {

    public String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button Login=(Button) findViewById(R.id.id_login);
        a="0";
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a=="0") {
                    Intent intent = new Intent(login.this, PeiSongYuanA.class);
                    startActivity(intent);
                }
                else if(a=="1"){
                    Intent intent = new Intent(login.this, PeiSongB.class);
                    startActivity(intent);
                }
            }
        });
    }
}