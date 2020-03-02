package com.hdsx.dubbo.user.service;

import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.common.framework.vo.ResultCode;
import com.hdsx.dubbo.common.framework.vo.ResultUtil;
import com.hdsx.dubbo.user.api.UserService;
import com.hdsx.dubbo.user.api.bean.user.ChangePassWordBean;
import com.hdsx.dubbo.user.api.bean.user.UserBean;
import com.hdsx.dubbo.user.api.bean.user.UserQueryBean;
import com.hdsx.dubbo.user.dao.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserService ，实现和用户信息相关的逻辑
 */
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result userLogin(UserBean userBean) {
        try {
            if (userBean == null || StringUtils.isEmpty(userBean.getUsername()) || StringUtils.isEmpty(userBean.getPassword())) {
                return ResultUtil.error(ResultCode.PARAMETER_NOT_EXIST);
            }

            /**
             * 只做简单校验、密码也没md5、正式项目不可如此，
             * 这里返回的是用户基本信息，正式项目返回基本信息 + token
             */
            String username = userBean.getUsername();
            String pwd0 = userBean.getPassword();
            UserBean userByName = userMapper.getUserByName(username);

            // 校验用户是否存在
            if (userByName == null) {
                return ResultUtil.error(ResultCode.PARAMETER_NOT_EXIST);
            }

            // 校验用户是否被禁用
            if (userByName.getState() == 1) {
                return ResultUtil.error(ResultCode.USER_FORBIDDEN);
            }

            // 校验密码是否正确
            String pwd1 = userByName.getPassword();
            if (!pwd0.equals(pwd1)) {
                return ResultUtil.error(ResultCode.PASSWORD_ERROR);
            }

            // 返回用户基本信息
            return ResultUtil.success(ResultCode.LOGIN_SUCCESS, userByName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.LOGIN_FAIL);
    }

    @Transactional
    @Override
    public Result changePassWord(ChangePassWordBean userBean) {
        try {
            if (userBean == null || StringUtils.isEmpty(userBean.getUsername()) || StringUtils.isEmpty(userBean.getPassword())
                    || StringUtils.isEmpty(userBean.getKey())) {
                return ResultUtil.error(ResultCode.PARAMETER_NOT_EXIST);
            }

            /**
             * 只做简单校验、密码也没md5、正式项目不可如此，
             * 这里返回的是用户基本信息，正式项目返回基本信息 + token
             */
            String username = userBean.getUsername();
            String pwd0 = userBean.getPassword();
            UserBean userByName = userMapper.getUserByName(username);

            // 校验用户是否存在
            if (userByName == null) {
                return ResultUtil.error(ResultCode.AUTH_PARAMETER_ERROR);
            }

            // 校验用户是否被禁用
            if (userByName.getState() == 1) {
                return ResultUtil.error(ResultCode.USER_FORBIDDEN);
            }

            // 校验密码是否正确
            String pwd1 = userByName.getPassword();
            if (!pwd0.equals(pwd1)) {
                return ResultUtil.error(ResultCode.PASSWORD_ERROR);
            }

            // 校验KEY
            String key = userBean.getKey();
            int flag = userMapper.changePassWord(userBean);
            if (flag == 1) {
                // 返回用户基本信息
                return ResultUtil.success(ResultCode.ADD_SUCCESS, userByName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.MODIFY_FAIL);
    }

    @Transactional
    @Override
    public Result addUser(UserBean userBean) {
        try {
            if (userBean == null) {
                return ResultUtil.success(ResultCode.ADD_FAIL);
            }

            int flag = userMapper.addUser(userBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.ADD_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.success(ResultCode.ADD_FAIL);
    }

    @Transactional
    @Override
    public Result editUser(UserBean userBean) {
        try {
            if (userBean == null) {
                return ResultUtil.error(ResultCode.ADD_FAIL);
            }

            int flag = userMapper.editUser(userBean);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.ADD_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.error(ResultCode.ADD_FAIL);

    }

    @Override
    public Result deleteUserByUserId(String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            int flag = userMapper.deleteUserByUserId(id);
            if (flag == 1) {
                return ResultUtil.success(ResultCode.DELETE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.DELETE_FAIL);
    }

    @Override
    public Result getUserByName(String username) {
        try {
            if (StringUtils.isEmpty(username)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            UserBean userById = userMapper.getUserByName(username);
            return ResultUtil.success(ResultCode.QUERY_SUCCESS, userById);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserById(String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            UserBean userById = userMapper.getUserById(id);
            return ResultUtil.success(ResultCode.QUERY_SUCCESS, userById);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }

    @Override
    public Result getUserList(UserQueryBean userQueryBean) {
        try {
            if (userQueryBean == null) {
                return ResultUtil.error(ResultCode.PARAMETER_ERROR);
            }

            Map<Object, Object> map = new HashMap<>();
            List<UserBean> userList = userMapper.getUserList(userQueryBean);
            map.put("data",userList);
            map.put("total", 0);

            if (userList != null && userList.size() > 0) {
                int total = userMapper.getUserListCount(userQueryBean);
                map.put("total", total);
            }

            return ResultUtil.success(ResultCode.QUERY_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResultUtil.error(ResultCode.SYSTEM_UNKNOW_EXCEPTION);
    }
}
