package com.Service.Impl;

import com.Dao.MenuDao;
import com.Dao.UserDao;
import com.Model.MenuEntity;
import com.Model.UserEntity;
import com.Model.UserRoleEntity;
import com.Service.UserService;
import com.Vo.MenuTree;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by wuwan on 2016/8/21.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final String slat = "8^^&U&^%$U(FRVUGY%$#@%&*)NK*)()??";
    @Resource
    private UserDao userDao;
    @Resource
    private MenuDao menuDao;

    @Override
    public void saveRegist(UserEntity user) {
        try {

            userDao.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UserEntity getUserLogin(UserEntity user, Map<String, Object> session) {
        user = userDao.getUserLogin(user.getUsername(), user.getPassword());
        if (user == null || user.getState() != UserEntity.NORMAL) {
            return user;
        }
        session.put("userEntity", user);
//       获取用户角色并获取菜单权限列表
        List<MenuTree> return_ms = new ArrayList<>();
        if ("admin".equals(user.getUsername())) {
            List<MenuEntity> menus = menuDao.getAllMenus(MenuEntity.NORMAL);
            for (MenuEntity menu : menus) {
                MenuTree menuTree = new MenuTree();
                menuTree.setId(menu.getId());
                menuTree.setChecked(false);
                menuTree.setText(menu.getName());
                menuTree.setIconCls(menu.getIconcls());
                if (menu.getIsleaf() == 1) {
                    menuTree.setState("open");
                } else {
                    menuTree.setState("closed");
                }
                Map<String, Object> map = new HashMap<>();
                map.put("url", menu.getUrl());
                map.put("action", menu.getAction());
                map.put("grade", menu.getGrade());
                map.put("parentId", menu.getParentid());
                menuTree.setAttributes(map);
                return_ms.add(menuTree);
            }
        }
        session.put("menu", return_ms);
        return user;


    }

    @Override
    public void updateUserInfo(UserEntity user) {
        try {
            userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity getUserByID(String userid) {
        return userDao.get(userid);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean getUserByName(String username) {
        StringBuilder hqlString = new StringBuilder("select count(*) from UserEntity as u where u.username = ?");
        long count = userDao.countByHQL(hqlString.toString(), username);
        if (count > 0) {
            return true;
        }
        return false;
    }


}
