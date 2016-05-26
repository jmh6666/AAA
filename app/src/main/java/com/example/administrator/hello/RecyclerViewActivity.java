package com.example.administrator.hello;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/20.
 */
public class RecyclerViewActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private RecyclerAdapter mAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recyclerview);
        initDatas();
        initView();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mAdapter.addDatas(1);
            }
        });

    }

    private void initDatas() {
        mDatas=new ArrayList<String>();
        for (int i='A';i<'Z';i++){
            mDatas.add(""+(char)i);
        }
    }

    private void initView() {
        mRecyclerView=(RecyclerView) findViewById(R.id.rv_list);
//        listView样式
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        GridView样式
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,6));
//        瀑布流
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        button=(Button)findViewById(R.id.button);
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder mHolder=new MyViewHolder(LayoutInflater.from(RecyclerViewActivity.this)
                    .inflate(R.layout.layout_item,parent,false));
            return mHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public void addDatas(int position){
        mDatas.add(position,"insert one");
            notifyItemInserted(position);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.id_num);
        }
    }


}
