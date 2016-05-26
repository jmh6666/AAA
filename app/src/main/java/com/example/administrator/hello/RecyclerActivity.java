package com.example.administrator.hello;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 */
public class RecyclerActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<User> mDatas;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycler);

        initView();
        initDatas();

    }

    private void initDatas() {
        mDatas = new ArrayList<User>();
        mDatas.add(new User("张三", 11, "男", R.mipmap.ic_launcher,1));
        mDatas.add(new User("李四", 12, R.mipmap.ic_launcher,2));
        mDatas.add(new User("王二麻子", 19, "男", R.mipmap.ic_launcher,1));
        mAdapter.setmList(mDatas);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"您点击了第"+position,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(),"您按住了第"+position+"个，啦啦啦",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rvList);
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter=new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }


    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
        void OnItemLongClick(View view,int position);
    }
     class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int TYPE_ONE = 1;
        private static final int TYPE_TWO = 2;
        private List<User> mList;


         private OnItemClickListener mOnItemClickListener;

         public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
             this.mOnItemClickListener = mOnItemClickListener;
         }

         public RecyclerViewAdapter() {
            this.mList=new ArrayList<>();
        }

        public void setmList(List<User> mList) {
            this.mList = mList;
            notifyDataSetChanged();
        }

        @Override
        public int getItemViewType(int position) {
            User user = mList.get(position);
            if (user.getType() == 1)
                return TYPE_ONE;
            if (user.getType() == 2)
                return TYPE_TWO;
            return super.getItemViewType(position);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(RecyclerActivity.this);
            if (viewType == TYPE_ONE)
                return new MyViewHolder(inflater
                    .inflate(R.layout.layout_person1, parent, false));

            return new MyViewHolder2(inflater
                    .inflate(R.layout.layout_person2,parent,false));
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            User user=mList.get(position);
            if (holder instanceof MyViewHolder2) {
                MyViewHolder2 holder2 = (MyViewHolder2) holder;
                holder2.mHeader.setImageResource(user.getUserHeader());
                String age=String.valueOf(user.getUserAge());
                holder2.mAge.setText(age);
                holder2.mName.setText(user.getUserName());
            }if (holder instanceof MyViewHolder){
                MyViewHolder holder1 = (MyViewHolder) holder;
                holder1.mHeader.setImageResource(user.getUserHeader());
                String age = String.valueOf(user.getUserAge());
                holder1.mAge.setText(age);
                holder1.mName.setText(user.getUserName());
                holder1.mSex.setText(user.getUserSex());
            }
            if (mOnItemClickListener!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=holder.getLayoutPosition();
                        mOnItemClickListener.OnItemClick(holder.itemView,pos);
                    }
                });
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickListener.OnItemLongClick(holder.itemView,pos);
                        return false;
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView mHeader;
    TextView mName;
    TextView mAge;
    TextView mSex;

    public MyViewHolder(View itemView) {
        super(itemView);

        mHeader = (ImageView) itemView.findViewById(R.id.user_header);
        mName = (TextView) itemView.findViewById(R.id.user_name);
        mAge = (TextView) itemView.findViewById(R.id.user_Age);
        mSex = (TextView) itemView.findViewById(R.id.user_sex);
    }

}

    class MyViewHolder2 extends RecyclerView.ViewHolder {
    ImageView mHeader;
    TextView mName;
    TextView mAge;

    /**
     * Constructs a new instance of {@code Object}.
     */
    public MyViewHolder2(View itemView) {

        super(itemView);
        mHeader = (ImageView) itemView.findViewById(R.id.user_header2);
        mName = (TextView) itemView.findViewById(R.id.user_name2);
        mAge = (TextView) itemView.findViewById(R.id.user_age2);
    }
}
