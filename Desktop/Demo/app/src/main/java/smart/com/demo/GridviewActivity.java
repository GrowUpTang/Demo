package smart.com.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import smart.com.demo.adapter.HomeAdapter;
import smart.com.demo.adapter.QuickAdapter;
import smart.com.demo.entity.HomeItem;

import java.util.ArrayList;

public class GridviewActivity extends AppCompatActivity {
    private static final Class<?>[] ACTIVITY = {OneActivity.class, TwoActivity.class, ThreeActivity.class, SixActivity.class};
    private static final String[] TITLE = {"昨天",  "明天", "前任", "你看过源码吗"};
    private static final int[] IMG = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        initView();
        initData();
        initAdapter();
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void initAdapter() {
        QuickAdapter homeAdapter = new HomeAdapter(R.layout.night_item, mDataList);
        homeAdapter.openLoadAnimation();
        homeAdapter.setOnItemClickListener(new QuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(GridviewActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }
    }
}
