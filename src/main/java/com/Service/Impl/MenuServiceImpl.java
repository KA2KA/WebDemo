package com.Service.Impl;

import com.Dao.GeneralDao;
import com.Dao.Impl.MenuDaoImpl;
import com.Dao.MenuDao;
import com.Model.MenuEntity;
import com.Service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wuwan on 2016/9/30.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource

    private MenuDao menuDao;

    @Override
    public MenuEntity queryMenuById(String id) {
        return menuDao.get(id);
    }

    @Override
    public void saveMenu(MenuEntity menu) {
        menuDao.save(menu);
    }
}
