package com.tonyapp.login_mvp.View;

import com.tonyapp.login_mvp.Bean.User;

/**
 * Created by 涛 on 2016/8/8 0008.
 */
public interface UserView {
    void showLoginSuccessMsg(User loginedUser);
    void showLoginFailMsg(String errorMsg);
}
