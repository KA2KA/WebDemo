package com.InitServlet;

import com.Model.MenuEntity;
import com.Model.RoleEntity;
import com.Model.UserEntity;
import com.Service.MenuService;
import com.Service.RoleService;
import com.Service.UserService;
import com.Vo.StateEnum;
import com.util.IdWorker;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * 此Servlet用于初始化数据库相关信息
 * Created by wuwan on 2016/9/30.
 */

public class InitDB extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext sc = config.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        String classpath = sc.getRealPath("/") + "/WEB-INF/classes";
        MenuService menuService = (MenuService) context.getBean("menuService");
        RoleService roleService = (RoleService) context.getBean("roleService");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("menuService:"+menuService);
        initAdminUser(userService);
        initBasicRole(roleService);
        initMenuData(classpath, menuService);
    }

    /**
     * 初始化系统管理员
     *
     * @param userService
     */
    private void initAdminUser(UserService userService) {
        boolean isExist = userService.getUserByName("admin");
        if (isExist == false) {
            UserEntity user = new UserEntity();
            user.setId(100);
            user.setUsername("admin");
            user.setPassword("admin");
            user.setNickname("系统管理员");
            user.setAlias("admin");
            user.setState(1);
            user.setVision(0);
            userService.saveRegist(user);
        }
    }

    /**
     * 初始化基本角色
     *
     * @param roleService
     */
    private void initBasicRole(RoleService roleService) {
        RoleEntity basicRole = roleService.findByName("BasicRole");
        if (basicRole == null) {
            basicRole = new RoleEntity();
            basicRole.setId(100);
            basicRole.setRolename("BasicRole");
            basicRole.setDescription("基本角色权限");
            basicRole.setState(1);
            basicRole.setVision(0);
            roleService.addRole(basicRole, null);
        }
    }

    /**
     * 初始化菜单表
     *
     * @param classpath
     * @param menuService
     */
    private void initMenuData(String classpath, MenuService menuService) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(classpath, "Menu.csv")), "utf-8"));
            String len;
            br.readLine();
            while ((len = br.readLine()) != null) {
                String[] split = len.trim().split("#");
                MenuEntity menu = menuService.queryMenuById(split[0]);
                if (menu == null) {
                    menu = new MenuEntity();
                    menu.setId(split[0]);
                    if (!"".equals(split[1]))
                        menu.setParentid(Integer.parseInt(split[1]));
                    menu.setName(split[2]);
                    menu.setGrade(Integer.parseInt(split[3]));
                    menu.setUrl(split[4]);
                    menu.setAction(split[5]);
                    menu.setState(Integer.parseInt(split[6]));
                    menu.setIsleaf(Integer.parseInt(split[7]));
                    menu.setIconcls(split[8]);
                    menu.setVision(0);
                    menuService.saveMenu(menu);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
