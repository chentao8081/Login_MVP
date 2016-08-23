package com.tonyapp.login_mvp.Presenter;

import android.util.Log;

import com.tonyapp.login_mvp.Bean.User;
import com.tonyapp.login_mvp.Model.UserModel;
import com.tonyapp.login_mvp.Model.UserModelImpl;
import com.tonyapp.login_mvp.View.UserView;

/**
 * Created by 涛 on 2016/8/8 0008.
 */
public class UserPresenterImpl implements UserPresenter {
    private UserView mUserView;
    private UserModelImpl mUserModelImpl;
    public UserPresenterImpl(UserView view, UserModelImpl mUserModelImpl1) {
        mUserView = view;
        mUserModelImpl = mUserModelImpl1;
    }

    @Override
    public void login(String username, String password) {
        // Presenter处理View路由过来的用户操作，
        // 将其转换成相对的命令，传递给Model来做数据操作
        mUserModelImpl.login(username, password, new UserModel.Tony(){
            public void onSuccess(User user) {
                Log.d("UserPresenterImpl----->", user.getFirstName() + user.getLastName());
                // Model层对数据操作后，将结果返回给Presenter，
                // 再由Presenter来通知View去更新UI来通知用户数据操作的结果
                mUserView.showLoginSuccessMsg(user);
            }
            public void onFail(String errorMsg) {
                mUserView.showLoginFailMsg(errorMsg);
            }
        });
    }
}
