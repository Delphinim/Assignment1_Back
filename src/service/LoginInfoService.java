package service;

import entity.LoginInfo;

/**
 * 登录接口
 * @author TZQ
 *
 */

public interface LoginInfoService {

    LoginInfo login(String account, String password);

    void register(LoginInfo user);

}
