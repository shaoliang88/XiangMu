package com.example.lenovo.xiangmu.Register.P;
import com.example.lenovo.xiangmu.Register.Bean.YZBean;
import com.example.lenovo.xiangmu.Register.M.getYanModel;
import com.example.lenovo.xiangmu.Register.V.getYanView;
import java.util.Map;
/**
 * Created by lenovo on 2018/3/30.
 */
public class getYZPresenter {
    private final getYanModel model;
    public getYanView view;
    public getYZPresenter(getYanView view) {
        this.view = view;
         model=new getYanModel();
    }
    public void YanPresenter(Map<String,String> map){
        model.YanZheng(new getYanModel.getYanData() {
            @Override
            public void Data(YZBean bean) {
                view.getYan(bean);
            }
        },map);
    }
}
