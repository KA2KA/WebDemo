package com.Dao;

import com.Model.UserEntity;

/**
 * Created by wuwan on 2016/9/30.
 */
public interface UserDao extends GeneralDao<UserEntity, String> {
    /**
     * 根据用户名和密码登陆后台系统
     *
     * @param username
     * @param password
     * @return UserEntity
     */
    UserEntity getUserLogin(String username, String password);
}
