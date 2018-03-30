package com.example.lenovo.xiangmu.Login.V;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lenovo.xiangmu.Home.HomeActivity;
import com.example.lenovo.xiangmu.Login.Bean.LoginBean;
import com.example.lenovo.xiangmu.Login.P.getPresenter;
import com.example.lenovo.xiangmu.R;
import com.example.lenovo.xiangmu.Register.V.RegisterActivity;
import com.example.lenovo.xiangmu.Utils.API;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class LoginActivity extends AppCompatActivity implements getView {
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pass)
    EditText editPass;
    @BindView(R.id.edit_verify)
    EditText editVerify;
    @BindView(R.id.sdv_verify)
    SimpleDraweeView sdvVerify;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.but_register)
    TextView butRegister;
    private getPresenter p;
    private Map<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        map = new HashMap<>();
        p = new getPresenter(this);
    }
    @Override
    public void getShow(final LoginBean loginBean) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
                       if (loginBean.getMessage().equals("用户登录成功")){
                           startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                       }else {
                           Toast.makeText(LoginActivity.this,loginBean.toString(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });

           }
    @OnClick({R.id.sdv_verify, R.id.but_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sdv_verify:
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearCaches();
                sdvVerify.setImageURI(API.CAPTCHA);
                break;
            case R.id.but_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    public void login(View view) {
        map.put("phone", editName.getText().toString());
        map.put("password", editPass.getText().toString());
        map.put("vaildate", editVerify.getText().toString());
        p.presen(map);
        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show();
    }
}
