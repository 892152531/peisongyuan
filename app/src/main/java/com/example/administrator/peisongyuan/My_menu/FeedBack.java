package com.example.administrator.peisongyuan.My_menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.administrator.peisongyuan.R;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        Button feedback=(Button) findViewById(R.id.feedback_button);
        feedback.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                //提交意见
            }
        });
    }
}
