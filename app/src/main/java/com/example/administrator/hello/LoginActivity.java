package com.example.administrator.hello;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/19.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText editNum;
    private EditText vftCode;
    private Button sendMessage;
    private Button submit;
    private CheckBox checkAgree;
    //private TextView agreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_login);
        initView();
    }

    private void initView() {
        editNum = (EditText) findViewById(R.id.edit_phoneNum);
        vftCode = (EditText) findViewById(R.id.edit_yanzhengma);
        sendMessage = (Button) findViewById(R.id.send_Msg);
        submit = (Button) findViewById(R.id.login_submit);
        checkAgree = (CheckBox) findViewById(R.id.check_agree);

        submit.setOnClickListener(this);
        sendMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == submit) {
            login();
           // return;
        }

        if (v == sendMessage) {
            sendMsg();
          //  return;
        }
    }

    private void sendMsg() {
        if (!"15653819832".equals(editNum.getText().toString())) {
//                if (!editNum.getText().toString().equals("15653819832")) {
            Toast.makeText(getApplicationContext(), getString(R.string.inputPhone),
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.sendSuccess),
                    Toast.LENGTH_LONG).show();
            //MyAsyncTask asyncTask=new MyAsyncTask(sendMessage);
            AAsyncTask asyncTask=new AAsyncTask(new IXXXLirstener() {
                @Override
                public void onProgress(int processSize) {
                    Log.e("xxx","processSize"+processSize);
                    sendMessage.setText("短信已发送"+processSize);
                    if(processSize==0){
                        sendMessage.setText("点击重新发送");
                    }
                }
            });
            asyncTask.execute();

        }
    }

    private void login() {
        if (editNum.getText().toString().equals("15653819832")
                && vftCode.getText().toString().equals("1234")
                && checkAgree.isChecked() == true) {
            Toast.makeText(getApplicationContext(), getString(R.string.enterSuccess),
                    Toast.LENGTH_LONG).show();
        } else if (!editNum.getText().toString().equals("15653819832")) {
            Toast.makeText(getApplicationContext(), getString(R.string.inputPhone),
                    Toast.LENGTH_LONG).show();
        } else if (!vftCode.getText().toString().equals("1234")) {
            Toast.makeText(getApplicationContext(), getString(R.string.inputVftCode),
                    Toast.LENGTH_LONG).show();
        } else if (!checkAgree.isChecked()) {
            Toast.makeText(getApplicationContext(), getString(R.string.readAgreement),
                    Toast.LENGTH_LONG).show();
        }
    }
}
 class MyAsyncTask extends AsyncTask<Void,Integer,Integer>{

     private  Button sendMsg;

     public MyAsyncTask(Button sendMsg) {
         this.sendMsg = sendMsg;
     }

     @Override
     protected void onProgressUpdate(Integer... values) {
         super.onProgressUpdate(values);
        sendMsg.setText("短信已发送"+values[0]);
         if (0==values[0]){
             sendMsg.setText("点击重新发送");
         }
     }

     @Override
     protected Integer doInBackground(Void... params) {
         for (int i=10;i>=0;i--){
        publishProgress(i,1);
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         return null;
     }
 }

     interface IXXXLirstener{
         void onProgress(int processSize);
     }

     class AAsyncTask extends android.os.AsyncTask<Void,Integer,Integer>{

         private IXXXLirstener mListener;
         public AAsyncTask(IXXXLirstener lirstener) {
             mListener = lirstener;
         }

         @Override
         protected void onProgressUpdate(Integer... values) {
             super.onProgressUpdate(values);
             mListener.onProgress(values[0]);
         }

         @Override
         protected Integer doInBackground(Void... params) {
             for (int i=10;i>=0;i--){
                 publishProgress(i,1);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             return null;
         }

 }
