package smart.com.demo.adapter;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class ViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;

    private final HashSet<Integer> nestViews;

    private final LinkedHashSet<Integer> childClickViewIds;

    private final LinkedHashSet<Integer> itemChildLongClickViewIds;
    private QuickAdapter adapter;

    @Deprecated
    public View convertView;


    public ViewHolder(final View view) {
        super(view);
        this.views = new SparseArray<>();
        this.childClickViewIds = new LinkedHashSet<>();
        this.itemChildLongClickViewIds = new LinkedHashSet<>();
        this.nestViews = new HashSet<>();
        convertView = view;
    }

    @Deprecated
    public View getConvertView() {

        return convertView;
    }

    public ViewHolder setText(@IdRes int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public ViewHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    public ViewHolder setVisible(@IdRes int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }

    @Deprecated
    public ViewHolder setOnClickListener(@IdRes int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    @Deprecated
    public ViewHolder setOnTouchListener(@IdRes int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    @Deprecated
    public ViewHolder setOnLongClickListener(@IdRes int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    @Deprecated
    public ViewHolder setOnItemClickListener(@IdRes int viewId, AdapterView.OnItemClickListener listener) {
        AdapterView view = getView(viewId);
        view.setOnItemClickListener(listener);
        return this;
    }

    /**
     * Sets the listview or gridview's item long click listener of the view
     *
     * @param viewId   The view id.
     * @param listener The item long click listener;
     * @return The BaseViewHolder for chaining.
     */
    public ViewHolder setOnItemLongClickListener(@IdRes int viewId, AdapterView.OnItemLongClickListener listener) {
        AdapterView view = getView(viewId);
        view.setOnItemLongClickListener(listener);
        return this;
    }

    public ViewHolder setTag(@IdRes int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }
    /**
     * Sets the adapter of a adapter view.
     *
     * @param adapter The adapter;
     * @return The BaseViewHolder for chaining.
     */
    protected ViewHolder setAdapter(QuickAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
