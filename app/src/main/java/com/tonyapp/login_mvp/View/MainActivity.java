package com.tonyapp.login_mvp.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tonyapp.login_mvp.Bean.User;
import com.tonyapp.login_mvp.Model.UserModelImpl;
import com.tonyapp.login_mvp.Presenter.UserPresenter;
import com.tonyapp.login_mvp.Presenter.UserPresenterImpl;
import com.tonyapp.login_mvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements UserView {
    @BindView(R.id.id_et_name)
    EditText nameEditText;
    @BindView(R.id.id_et_pwd)
    EditText pwdEditText;
    @BindView(R.id.id_btn_login)
    Button loginBtn;

    private UserPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPresenter = new UserPresenterImpl(this, new UserModelImpl());

    }

    @OnClick(R.id.id_btn_login)
    void click() {
        String username = nameEditText.getText().toString();
        String password = pwdEditText.getText().toString();

        Log.d("MainActivity----->", "username = " + username + ", pwd = " + password);
        // View将用户的点击事件直接路由给Presenter区处理
        mPresenter.login(username, password);
    }

    @Override
    public void showLoginSuccessMsg(User loginedUser) {
        // Presenter在处理完毕后， 会通知View更新UI来通知用户数据操作的结果
        Toast.makeText(getApplicationContext(), loginedUser.getFirstName() + loginedUser.getLastName() + "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailMsg(String errorMsg) {
        // Presenter在处理完毕后， 会通知View更新UI来通知用户数据操作的结果
        Toast.makeText(getApplicationContext(), "Login Fail. " + errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //mPresenter.unSubscribe();
    }
}
