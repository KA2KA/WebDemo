package com.Dao.Impl;

import com.Dao.UserDao;
import com.Model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wuwan on 2016/9/30.
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl extends GeneralDaoImpl<UserEntity, String> implements UserDao {

    @Override
    public UserEntity getUserLogin(String username, String password) {
        StringBuilder hql = new StringBuilder(" from UserEntity where username=? and password=?");
        return this.getByHQL(hql.toString(), username, password);
    }
}
