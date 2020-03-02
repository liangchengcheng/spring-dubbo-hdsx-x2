package com.hdsx.dubbo.user.dao;

import com.hdsx.dubbo.user.api.bean.user.ChangePassWordBean;
import com.hdsx.dubbo.user.api.bean.user.UserBean;
import com.hdsx.dubbo.user.api.bean.user.UserQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    /**
     * 新增用户
     */
    int addUser(UserBean userBean);

    /**
     * 编辑用户
     */
    int editUser(UserBean userBean);

    /**
     * 根据用户ID删除用户
     */
    int deleteUserByUserId(String id);

    /**
     * 根据用户名查询用户
     */
    UserBean getUserByName(String username);

    /**
     * 根据ID查询用户
     */
    UserBean getUserById(String id);

    /**
     * 查询用户
     */
    List<UserBean> getUserList(UserQueryBean userQueryBean);

    /**
     * 查询多少个数据 - 分页用
     */
    int getUserListCount(UserQueryBean userQueryBean);

    /**
     * 修改用户的密码
     */
    int changePassWord(ChangePassWordBean changePassWordBean);

}