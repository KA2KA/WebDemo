package com.Action;


import com.Model.UserEntity;
import com.Vo.MenuTree;
import com.google.gson.Gson;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 用户的管理层
 * Created by wuwan on 2016/8/22.
 */
@Controller
@Scope("prototype")
public class UserManagerAction extends BaseAction<UserEntity> {
//    private static final Logger logger = LoggerFactory.getLogger(UserManagerAction.class);

    /**
     * 用户登录:获取用户信息，获取用户角色和菜单权限
     */
    public String login() {
        try {
            userService.getUserLogin(model, session);
            List<MenuTree> mTlist = (List<MenuTree>) session.get("menu");
            for (MenuTree mt : mTlist) {
                System.out.println("mt.getId():" + mt.getId());
            }
        } catch (Exception e) {
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * 检查用户名是否相同
     *
     * @return
     */
    public String checkName() {
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
//            String id = new IdWorker().getId();
//            model.setId();
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
