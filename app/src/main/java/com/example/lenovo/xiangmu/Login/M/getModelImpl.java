package com.example.lenovo.xiangmu.Login.M;

import com.example.lenovo.xiangmu.Login.Bean.LoginBean;
import com.example.lenovo.xiangmu.Utils.RetrofitHelp;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/3/29.
 */
public class getModelImpl {
    public void getLogin(final getData data, Map<String,String> map){
        RetrofitHelp.getAPI().get(map).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        data.Data(loginBean);
                    }
                });
    }
public interface getData{
    void Data(LoginBean loginBean);
    }
}
