package com.example.lenovo.xiangmu.Register.M;

import com.example.lenovo.xiangmu.Register.Bean.RegisterBean;
import com.example.lenovo.xiangmu.Utils.RetrofitHelp;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/3/29.
 */

public class getModel {
    public void zhuce(Map<String,String> map, final getZCData data) {
        RetrofitHelp.getAPI().post(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean bean) throws Exception {
                        data.Data(bean);
                    }
                });
    }
    public interface getZCData{
        void Data(RegisterBean bean);
    }
}