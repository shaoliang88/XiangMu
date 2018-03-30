package com.example.lenovo.xiangmu.Utils;


import com.example.lenovo.xiangmu.Login.Bean.LoginBean;
import com.example.lenovo.xiangmu.Register.Bean.PhoneBean;
import com.example.lenovo.xiangmu.Register.Bean.RegisterBean;
import com.example.lenovo.xiangmu.Register.Bean.YZBean;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by lenovo on 2018/3/29.
 */

public interface APIService {
    //登录
@GET(API.LOGIN)
Observable<LoginBean> get(@QueryMap Map<String,String> map);
//注册
@FormUrlEncoded
@POST(API.REGISTER)
Observable <RegisterBean> post(@FieldMap Map<String,String> map);
    //验证
    @GET(API.IF)
    Observable<YZBean> getyz(@QueryMap Map<String,String> map);
    //短信
    @GET(API.Phone)
    Observable<PhoneBean> getphone(@QueryMap Map<String,String> map);
}
