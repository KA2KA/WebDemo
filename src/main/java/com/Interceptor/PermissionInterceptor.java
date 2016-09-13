package com.Interceptor;

import com.Model.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;


/**
 * 自定义拦截器
 * Created by wuwan on 2016/8/29.
 */
public class PermissionInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        此为访问的网址
        HttpServletRequest request = ServletActionContext.getRequest();
        String referer = request.getHeader("referer");//http://localhost:8080/Login.html
        String uri = request.getScheme() + "://" + request.getServerName();//http://localhost:8080
        ActionContext ac = actionInvocation.getInvocationContext();
        UserEntity userEntity = (UserEntity) ac.getSession().get("UserEntity");
        if (userEntity != null && referer.startsWith(uri)) {
//            在此判断其他权限
            return actionInvocation.invoke();
        }
        return "stop";

    }
}
