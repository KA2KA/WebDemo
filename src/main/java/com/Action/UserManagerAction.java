package com.Action;


import com.Model.UserEntity;
import com.google.gson.Gson;
import com.util.IdWorker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import static org.apache.struts2.interceptor.DateTextFieldInterceptor.DateWord.s;

/**
 * 用户的管理层
 * Created by wuwan on 2016/8/22.
 */
@Controller
@Scope("prototype")
public class UserManagerAction extends BaseAction<UserEntity> {

    /**
     * 用户登录
     */
    public String login() {
        System.out.println("--------into login ------------------");
        System.out.println(model);
        UserEntity user = userService.getUserLogin(model);
        if (user != null) {
            session.put("userEntity", user);
            System.out.println("登陆成功：" + user);
            return SUCCESS;
        }
        System.out.println("登陆失败");
        return ERROR;
    }

    /**
     * 检查用户名是否相同
     *
     * @return
     */
    public String checkName() {
        System.out.println("-----into checkName---------");
        boolean isEXist = userService.getUserByName(model.getUsername());

        return SUCCESS;
    }

    /**
     * 用户注册
     *
     * @return
     */
    public String regist() {
        System.out.println("----into regist-----");
        boolean isExist = userService.getUserByName(model.getUsername());
        if (isExist) {
            System.out.println("存在该用户");
            return ERROR;
        } else {
            String id = new IdWorker().getId();
            model.setId(id);
            userService.saveRegist(model);
            session.put("userEntity", model);
        }
        return SUCCESS;
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    public String modifyUserInfo() {
        System.out.println("--------into modifyUserInfo--------------");
        userService.updateUserInfo(model);
        session.put("userEntity", model);
        return SUCCESS;
    }


}
