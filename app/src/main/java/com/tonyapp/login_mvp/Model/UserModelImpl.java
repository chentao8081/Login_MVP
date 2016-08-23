package com.tonyapp.login_mvp.Model;

import android.text.TextUtils;
import android.util.Log;

import com.tonyapp.login_mvp.Bean.User;

/**
 * Created by 涛 on 2016/8/8 0008.
 */
public class UserModelImpl implements UserModel {

    @Override
    public void login(String username, String password, Tony callback) {
        if (TextUtils.equals(username, "tony") && TextUtils.equals(password, "123")) {
            Log.d("UserModelImpl----->", "login successfully");
            User user = new User("tony", "123");
            callback.onSuccess(user);
        } else {
            Log.d("UserModelImpl----->", "login fail");
            callback.onFail("Login Fail.");
        }
    }
}
