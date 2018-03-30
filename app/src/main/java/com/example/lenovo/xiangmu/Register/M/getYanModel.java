package com.example.lenovo.xiangmu.Register.M;

import com.example.lenovo.xiangmu.Login.Bean.LoginBean;
import com.example.lenovo.xiangmu.Register.Bean.YZBean;
import com.example.lenovo.xiangmu.Utils.RetrofitHelp;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/3/30.
 */

public class getYanModel {
    public void YanZheng(final getYanData data, final Map<String,String> map ){
        RetrofitHelp.getAPI().getyz(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YZBean>() {
                    @Override
                    public void accept(YZBean bean) throws Exception {
                        data.Data(bean);
                    }
                });
    }
    public  interface getYanData{
        void Data(YZBean bean);
    }
}
