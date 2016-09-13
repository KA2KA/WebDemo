package com.Service.Impl;

import com.Dao.GeneralDao;
import com.Model.UserEntity;
import com.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wuwan on 2016/8/21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private GeneralDao<UserEntity, String> baseDao;

    @Override
    public void saveRegist(UserEntity user) {
        try {
            baseDao.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UserEntity getUserLogin(UserEntity user) {

        StringBuilder hqlString = new StringBuilder("from UserEntity where  username=? and  password = ?");
        return baseDao.getByHQL(hqlString.toString(), user.getUsername(), user.getPassword());
    }

    @Override
    public void updateUserInfo(UserEntity user) {
        try {
            baseDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity getUserByID(String userid) {
        return baseDao.get(userid);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public boolean getUserByName(String username) {
        StringBuilder hqlString = new StringBuilder("select username from UserEntity where  username=?");
        long count = baseDao.countByHQL(hqlString.toString(), username);
        if (count > 0) {
            return true;
        }
        return false;
    }


}
