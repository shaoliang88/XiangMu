package com.example.lenovo.xiangmu.Register.V;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.lenovo.xiangmu.R;
import com.example.lenovo.xiangmu.Register.Bean.PhoneBean;
import com.example.lenovo.xiangmu.Register.Bean.RegisterBean;
import com.example.lenovo.xiangmu.Register.Bean.YZBean;
import com.example.lenovo.xiangmu.Register.P.getPresenter;
import com.example.lenovo.xiangmu.Register.P.getYZPresenter;
import com.example.lenovo.xiangmu.Utils.RetrofitHelp;

import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity implements getView,getYanView {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_passWord_again)
    EditText edPassWordAgain;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_passWord)
    EditText edPassWord;
    @BindView(R.id.ed_yzm)
    EditText edYzm;
    @BindView(R.id.getYZM)
    Button getYZM;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.ed_email_again)
    EditText edEmailAgain;
    private Map<String, String> map=new HashMap<>();
    private getPresenter p;
    private getYZPresenter YZP;
    private Map<String, String> map2=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
         p = new getPresenter(this);
         YZP=new getYZPresenter(this);
    }
    @Override
    public void getShow(final RegisterBean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(bean.getStatus().equals("0000")){
                    Toast.makeText(RegisterActivity.this, "注册成功,请登录", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(RegisterActivity.this, bean.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @OnClick({R.id.getYZM, R.id.registerButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.getYZM:
                map2 = new HashMap<>();
                 map2.put("phone",edPhone.getText().toString());
                 map2.put("type","1");


                 new Thread(){
                     @Override
                     public void run() {
                         super.run();
                         RetrofitHelp.getAPI().getphone(map2).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<PhoneBean>() {
                             @Override
                             public void accept(PhoneBean phoneBean) throws Exception {

                             }
                         });
                     }
                 }.start();

                break;
            case R.id.registerButton:
                map.put("nickName", edName.getText().toString());
                map.put("email", edEmailAgain.getText().toString());
                map.put("phone",edPhone.getText().toString());
                map.put("password", edPassWord .getText().toString());
                map.put("passwordTwo",edPassWordAgain.getText().toString());
                map.put("check", edYzm.getText().toString());
                p.presenter(map);
                break;
        }
    }

    @Override
    public void getYan(final YZBean bean) {
            String status = bean.getStatus();
            if (status.equals("1002")) {
                Toast.makeText(RegisterActivity.this, "手机号已被注册", Toast.LENGTH_SHORT).show();
            } else {
                YZP.YanPresenter(map);
            }
        }
    }

