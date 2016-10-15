package com.Service;

import com.Model.RoleEntity;

/**
 * Created by wuwan on 2016/9/21.
 */
public interface RoleService {
    /**
     * 根据id查询角色表
     *
     * @param roleid
     * @return
     */
    RoleEntity findRoleById(String roleid);

    /**
     * 根据角色名查询角色
     *
     * @param rolename
     * @return
     */
    RoleEntity findByName(String rolename);

    /**
     * 添加角色
     *
     * @param role
     * @param menuId
     */
    void addRole(RoleEntity role, String menuId);

    /**
     * 修改角色
     *
     * @param role
     * @param menuId
     */
    void updateRole(RoleEntity role, String menuId);

    /**
     * 提供批量删除角色
     * 同步删除用户角色表和权限表中对应的数据
     *
     * @param roleId
     * @return
     */
    Integer deleteRole(Integer roleId);
}
