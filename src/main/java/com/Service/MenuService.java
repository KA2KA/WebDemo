package com.Service;

import com.Model.MenuEntity;

/**
 * Created by wuwan on 2016/9/30.
 */

public interface MenuService {
    /**
     * 根据id查询
     * @param s
     */
    MenuEntity queryMenuById(String s);

    /**
     * 保存menu
     * @param menu
     */
    void saveMenu(MenuEntity menu);
}
