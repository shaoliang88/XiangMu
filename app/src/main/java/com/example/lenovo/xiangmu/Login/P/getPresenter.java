package com.example.lenovo.xiangmu.Login.P;

import com.example.lenovo.xiangmu.Login.Bean.LoginBean;
import com.example.lenovo.xiangmu.Login.M.getModelImpl;
import com.example.lenovo.xiangmu.Login.V.getView;

import java.util.Map;

/**
 * Created by lenovo on 2018/3/29.
 */

public class getPresenter {
    private getView view;
    private getModelImpl model;
    public getPresenter(getView view ) {
        this.view = view;
        this.model = new getModelImpl();
    }
    public void presen(Map<String,String> map){
        model.getLogin(new getModelImpl.getData() {
            @Override
            public void Data(LoginBean loginBean) {
             view.getShow(loginBean);
            }
        },map);
    }
}
