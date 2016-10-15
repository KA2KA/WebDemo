package com.Dao.Impl;

import com.Dao.GeneralDao;
import com.Dao.MenuDao;
import com.Model.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuwan on 2016/9/30.
 */
@Repository("menuDao")
public class MenuDaoImpl extends GeneralDaoImpl<MenuEntity, String> implements MenuDao {


    @Override
    public List<MenuEntity> getAllMenus(int state) {
        StringBuilder hql2 = new StringBuilder("from MenuEntity where state=? order by id desc");
        return this.getListByHQL(hql2.toString(), state);
    }
}
