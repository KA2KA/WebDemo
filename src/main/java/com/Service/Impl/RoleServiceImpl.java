package com.Service.Impl;

import com.Dao.GeneralDao;
import com.Dao.RoleDao;
import com.Model.RoleEntity;
import com.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wuwan on 2016/9/21.
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleEntity findRoleById(String roleid) {
        return roleDao.get(roleid);
    }

    @Override
    public RoleEntity findByName(String rolename) {
        return roleDao.getByHQL("from RoleEntity where rolename=?", rolename);
    }

    @Override
    public void addRole(RoleEntity role, String menuId) {
         roleDao.save(role);
    }

    @Override
    public void updateRole(RoleEntity role, String menuId) {

    }

    @Override
    public Integer deleteRole(Integer roleId) {
        return null;
    }
}
