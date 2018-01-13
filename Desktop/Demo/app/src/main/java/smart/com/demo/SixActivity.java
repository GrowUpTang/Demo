package smart.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import smart.com.demo.adapter.HomeAdapter;
import smart.com.demo.adapter.QuickAdapter;
import smart.com.demo.child.FirstActivity;
import smart.com.demo.child.SecondActivity;
import smart.com.demo.entity.HomeItem;

public class SixActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Class<?>[] ACTIVITY = {FirstActivity.class, SecondActivity.class};
    private static final String[] TITLE = {"二维码扫描", "OQC质检"};
    private static final int[] IMG = {R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;
    TextView textView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        textView = findViewById(R.id.text_title);
        textView.setText("前任");
        initView();
        initData();
        initAdapter();
    }
    private void initView() {
        mButton = findViewById(R.id.button_backward);
        mButton.setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvSix);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
    private void initAdapter() {
        QuickAdapter homeAdapter = new HomeAdapter(R.layout.night_item, mDataList);
        homeAdapter.openLoadAnimation();
        homeAdapter.setOnItemClickListener(new QuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(SixActivity.this, ACTIVITY[position]);
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
    @Override
    public void onClick(View view) {
        finish();
    }
}
