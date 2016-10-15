package com.Action;

import com.Model.MenuEntity;
import com.Service.MenuService;
import com.Vo.MenuTree;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuwan on 2016/9/30.
 */
@Controller
@Scope("prototype")
public class MenuManagerAction extends BaseAction<MenuEntity> {
    @Autowired
    private MenuService menuService;
    private String result;


    /**
     * 从Session中获取用户的菜单
     */
    public String listMenuTreeByUser() {
        List<MenuTree> mTlist = (List<MenuTree>) session.get("menu");
        List<MenuTree> return_ms = new ArrayList<>();
//        取出一级菜单
        if (model.getId() == null) {
            for (MenuTree mt : mTlist) {
                Object parentId = mt.getAttributes().get("parentId");
                if (parentId == null || "0".equals(parentId)) {
                    return_ms.add(mt);
                }
            }
        } else {
//        取出二级菜单
            for (MenuTree mt : mTlist) {
                Integer parentId = (Integer) mt.getAttributes().get("parentId");
                if (parentId != null && 0 != parentId && parentId == Integer.parseInt(model.getId())) {
                    return_ms.add(mt);
                }
            }
        }
        Gson gson = new Gson();
        result = gson.toJson(return_ms);
        System.out.println("result:" + result);
        return SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
