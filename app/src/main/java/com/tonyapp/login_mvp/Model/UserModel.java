package com.tonyapp.login_mvp.Model;


import com.tonyapp.login_mvp.Bean.User;

/**
 * Created by 涛 on 2016/8/8 0008.
 */
public interface UserModel {
    void login(String username, String password, Tony callback);
    interface Tony {
        void onSuccess(User user);
        void onFail(String mssage);
    }
}
