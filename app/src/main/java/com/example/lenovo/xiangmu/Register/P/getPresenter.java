package com.example.lenovo.xiangmu.Register.P;

import com.example.lenovo.xiangmu.Register.Bean.RegisterBean;
import com.example.lenovo.xiangmu.Register.M.getModel;
import com.example.lenovo.xiangmu.Register.V.getView;

import java.util.Map;

/**
 * Created by lenovo on 2018/3/29.
 */

public class getPresenter {
    private final getModel model;
    private getView view;
    public getPresenter(getView view) {
        this.view = view;
        model=new getModel();
    }
public void presenter(Map<String,String> map){
        model.zhuce(map, new getModel.getZCData() {
            @Override
            public void Data(RegisterBean bean) {
                view.getShow(bean);
            }
        });
}


}
