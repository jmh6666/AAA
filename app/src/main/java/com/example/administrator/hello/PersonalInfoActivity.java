package com.example.administrator.hello;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/20.
 */
public class PersonalInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mName;
    private EditText mIdCrad;
    private TextView selectHome;
    private EditText idDoor;
    private Button submitCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_input_info);
        initView();
        selectHome.setOnClickListener(this);
        submitCheck.setOnClickListener(this);

    }

    private void initView() {
        mName = (EditText) findViewById(R.id.edit_name);
        mIdCrad = (EditText) findViewById(R.id.edit_IdCard);
        selectHome = (TextView) findViewById(R.id.select_home);
        idDoor= (EditText) findViewById(R.id.edit_IdDoor);
    }

    @Override
    public void onClick(View v) {
        if(v==selectHome){
            selectAdress();
            return;
        }
        if (v==submitCheck){
            submitCk();
            return;
        }
    }

    private void submitCk() {
    }

    private void selectAdress() {
    }
}