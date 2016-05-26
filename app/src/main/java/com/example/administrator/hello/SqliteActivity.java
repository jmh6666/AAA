package com.example.administrator.hello;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/23.
 */
public class SqliteActivity extends Activity implements View.OnClickListener{
    private Button mAdd;
    private Button mJian;
    private Button mInsert;
    private Button mSearch;
    private ListView mList;
    private SqliteHelper dbHelper;
    private UserListAdapter mAdapter;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sqlite);

        initView();
    }

    private void initView() {
        mAdd=(Button)findViewById(R.id.button1);
        mJian=(Button)findViewById(R.id.button2);
        mInsert=(Button)findViewById(R.id.button3);
        mSearch=(Button)findViewById(R.id.button4);
        mList=(ListView)findViewById(R.id.list);
        dbHelper=new SqliteHelper(this);
        mAdapter=new UserListAdapter(this);

        mList.setAdapter(mAdapter);

        mAdd.setOnClickListener(this);
        mJian.setOnClickListener(this);
        mInsert.setOnClickListener(this);
        mSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mAdd)
            addDatas();
        if (v==mJian)
            jianDatas();
        if (v==mInsert)
            insertDatas();
        if (v==mSearch)
            searchDatas();
    }

    private void searchDatas() {

    }

    private void insertDatas() {
    dbHelper.update(1,"111");
    }

    private void jianDatas() {
    dbHelper.delete(1);
    }

    private void addDatas() {
        dbHelper.insert("王二麻子",11,"",1);
    }

     class UserListAdapter extends BaseAdapter{
        private ArrayList<User> mListt;
         private Context mContext;

        public UserListAdapter(Context ctx) {
            this.mContext = ctx;
        }

         public void setmListt(ArrayList<User> mListt) {
             this.mListt = mListt;
         }

         @Override
        public int getCount() {
            return mListt.size();
        }

        @Override
        public Object getItem(int position) {
            return mListt.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                convertView= LayoutInflater.from(SqliteActivity.this).inflate(R.layout.layout_person1,null);
                viewHolder=new ViewHolder();
                viewHolder.name=(TextView)convertView.findViewById(R.id.user_name);
                viewHolder.age=(TextView)convertView.findViewById(R.id.user_Age);
                viewHolder.sex=(TextView)convertView.findViewById(R.id.user_sex);
                viewHolder.header= (ImageView) convertView.findViewById(R.id.user_header);
                convertView.setTag(viewHolder);

            }else {
                viewHolder=(ViewHolder)convertView.getTag();
            }

            return convertView;
        }
    }
    public class ViewHolder{
        TextView name;
        TextView age;
        TextView sex;
        ImageView header;
    }
}
