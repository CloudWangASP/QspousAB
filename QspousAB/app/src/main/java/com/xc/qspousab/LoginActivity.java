package com.xc.qspousab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.canyinghao.candialog.CanDialog;
import com.canyinghao.candialog.CanDialogInterface;

public class LoginActivity extends AppCompatActivity {

    Button yuangong;
    Button boss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        yuangong = (Button) findViewById(R.id.yuangong);
        boss = (Button) findViewById(R.id.boss);
        //创建逻辑控件与页面空间的关联
        yuangong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CanDialog.Builder(LoginActivity.this)
                        .setIconType(CanDialog.ICON_INFO)
//                        .setTitle("Dialog Title")
                        .setEditDialog("请在此输入密码", true, 8, 0)
                        .setNegativeButton("取消", true, null)
                        .setPositiveButton("确定", true, new CanDialogInterface.OnClickListener() {
                            @Override
                            public void onClick(CanDialog dialog, int position, CharSequence text, boolean[] checkitems) {


//                                dialog.setAnimationMessage(CanDialog.ANIM_INFO_SUCCESS, "Password is " + text.toString());
//                                dialog.setPositiveButton("sure", true, null);


                            }
                        })
                        .setCircularRevealAnimator(CanDialog.CircularRevealStatus.BOTTOM_RIGHT)
                        .setCancelable(true)
                        .show();
            }
        });
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, Login2Activity.class);
                startActivity(intent);
            }
        });
    }


}
