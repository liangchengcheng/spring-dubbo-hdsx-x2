package com.hdsx.dubbo.user.api;

import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.user.api.bean.user.ChangePassWordBean;
import com.hdsx.dubbo.user.api.bean.user.UserBean;
import com.hdsx.dubbo.user.api.bean.user.UserQueryBean;

import java.util.List;

public interface UserService {

    /**
     * 登录接口
     */
    Result userLogin(UserBean userBean);

    /**
     * 修改密码接口
     */
    Result changePassWord(ChangePassWordBean changePassWordBean);

    /**
     * 添加用户
     */
    Result addUser(UserBean userBean);

    /**
     * 修改用户
     */
    Result editUser(UserBean userBean);

    /**
     * 通过ID删除用户
     */
    Result deleteUserByUserId(String id);

    /**
     * 通过username查询用户
     */
    Result getUserByName(String username);

    /**
     * 通过userid查询用户
     */
    Result getUserById(String id);

    /**
     * 查询用户的列表
     */
    Result getUserList(UserQueryBean userQueryBean);
}
