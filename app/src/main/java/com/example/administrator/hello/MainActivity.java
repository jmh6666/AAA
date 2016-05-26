package com.example.administrator.hello;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<Info> mDatas;
    private MainAdapter mAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();
        initDatas();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initDatas() {
        mDatas = new ArrayList<Info>();
        String header = String.valueOf(R.mipmap.ic_launcher);
        mDatas.add(new Info(header, "11"));
        mDatas.add(new Info(header, "22"));
        mDatas.add(new Info(header, "33"));
        mDatas.add(new Info(header, "44"));
        mAdapter.setmList(mDatas);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(getApplication(),

                        ""+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void intiView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rview_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MainAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.hello/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.hello/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);

    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
        private List<Info> mList;
        private OnItemClickListener mClick;

        public void setOnItemClickListener(OnItemClickListener mOnClickListener) {
            this.mClick = mOnClickListener;
        }

        public MainAdapter(OnItemClickListener mClick) {
            this.mClick = mClick;
        }

        public MainAdapter() {
            this.mList = new ArrayList<>();
        }

        public void setmList(List<Info> mList) {
            this.mList = mList;
            notifyDataSetChanged();
        }

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater mLayoutInflater = LayoutInflater.from(MainActivity.this);
            MainViewHolder holder = new MainViewHolder(mLayoutInflater
                    .inflate(R.layout.layout_main_button, parent, false));
            return holder;
        }


        @Override
        public void onBindViewHolder(final MainViewHolder holder, final int position) {
            Info info = mList.get(position);
            int i = Integer.valueOf(info.getImgHeader());
            holder.ivHeader.setImageResource(i);
            holder.tvHeader.setText(info.getTxt());

            if (mClick!= null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=holder.getLayoutPosition();
                        mClick.OnItemClick(holder.itemView,pos);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeader;
        private TextView tvHeader;

        public MainViewHolder(View itemView) {
            super(itemView);
            ivHeader = (ImageView) itemView.findViewById(R.id.iv_header);
            tvHeader = (TextView) itemView.findViewById(R.id.tv_header);
        }
    }
}

