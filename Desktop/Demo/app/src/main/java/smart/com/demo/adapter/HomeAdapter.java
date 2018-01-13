package smart.com.demo.adapter;



import java.util.List;

import smart.com.demo.R;
import smart.com.demo.entity.HomeItem;

public class HomeAdapter extends QuickAdapter<HomeItem, ViewHolder> {
    public HomeAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
