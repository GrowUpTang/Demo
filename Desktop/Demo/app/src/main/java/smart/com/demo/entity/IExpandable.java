package smart.com.demo.entity;

import java.util.List;

/**
 * Created by Lenovo on 2018-01-10.
 */
public interface IExpandable<T> {
    boolean isExpanded();

    void setExpanded(boolean expanded);

    List<T> getSubItems();


    int getLevel();
}
