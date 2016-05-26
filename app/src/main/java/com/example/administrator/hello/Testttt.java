package com.example.administrator.hello;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Testttt extends Activity {
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public SqliteHelper dbHelpter;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sqlite);

        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        dbHelpter=new SqliteHelper(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelpter.insert("111",11,"1",R.mipmap.ic_launcher);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelpter.delete(3);
            }
        });
            }
        });
    }
}
