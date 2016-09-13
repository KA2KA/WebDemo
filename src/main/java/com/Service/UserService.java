package com.Service;

import com.Model.UserEntity;

/**
 * Service层方法的命名规则：操作+业务
 * Created by wuwan on 2016/8/21.
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    void saveRegist(UserEntity user);

    /**
     * 用户登陆
     *
     * @param user
     * @return
     */
    UserEntity getUserLogin(UserEntity user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUserInfo(UserEntity user);

    /**
     * 通过ID查找对象
     *
     * @param userid
     * @return
     */
    UserEntity getUserByID(String userid);

    /**
     * 检查用户名是否存在
     *
     * @param username
     * @return
     */
    boolean getUserByName(String username);


}
