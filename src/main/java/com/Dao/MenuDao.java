package com.Dao;

import com.Model.MenuEntity;

import java.util.List;

/**
 * Created by wuwan on 2016/9/30.
 */

public interface MenuDao extends GeneralDao<MenuEntity, String> {
    /**
     * 获取所有状态正常的菜单列表
     *
     * @param state
     * @return
     */
    List<MenuEntity> getAllMenus(int state);

}
