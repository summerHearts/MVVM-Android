package com.example.kenvin.mvvm_android;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.kenvin.mvvm_android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User user;
    private UserField userField;
    private Handler handler = new Handler();

    //MVVM编译时解决问题。dataBinding是MVVM的实现工具
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * MVVM模式
         * 1、对于过大的项目，数据绑定需要过大的内存。
         * 2、XML中进行数据绑定，一旦出问题，很难确定问题在哪里
         */

        //编译时生成的  java源文件  import 引入的是class文件，如何存在class,就可以导入。  javac通过注解处理器，再打包为class文件。
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        user = new User("BLANKAKyS",
                "23929243493",
                "http://c.hiphotos.baidu.com/image/pic/item/a9d3fd1f4134970a8a54d43c9fcad1c8a7865dfa.jpg");

        userField = new UserField();
        binding.setUser(user);
        binding.setField(userField);

        //为了随时修改数据改变视图，使用 继承 BaseObservable，实现数据的变化监听

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setName("KSKGSGK");
                user.setPassword("SKTSIGNAL");
                user.setHeaderImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510889206&di=b7f8346d2e6f6d5255bc7fe807d99eae&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.replays.net%2Flol.replays.net%2Fuploads%2Fpicname%2F2017%2F10%2F1508396314UAz.png");

                userField.name.set("China");
                userField.password.set("8424242424aaa");
            }
        },2000);
    }
}
