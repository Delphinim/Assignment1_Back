package service.impl;

import dao.LoginInfoDao;
import entity.LoginInfo;
import service.LoginInfoService;

/**
 * 登录接口实现类
 * @author TZQ
 *
 */

public class LoginInfoServiceImpl implements LoginInfoService {

    @Override
    public LoginInfo login(String account, String password) {
        return LoginInfoDao.login(account,password);
    }

    @Override
    public void register(LoginInfo user) {
        LoginInfoDao.register(user);

    }

}
