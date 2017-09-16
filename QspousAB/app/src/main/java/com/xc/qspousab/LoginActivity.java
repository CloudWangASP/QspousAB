package com.xc.qspousab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.xc.qspousab.view.NiftyDialogBuilder;

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
                final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(LoginActivity.this);
                dialogBuilder
                        .withTitle("员工账本")                                  //.withTitle(null)  no title
                        .withTitleColor(getResources().getColor(R.color.colorWhite))                                  //def
                        .withDividerColor(getResources().getColor(R.color.colorLogoYellow))                              //def
                        .withMessage("请在此输入密码")                     //.withMessage(null)  no Msg
                        .withMessageColor(getResources().getColor(R.color.colorWhite))                              //def  | withMessageColor(int resid)
                        .withDialogColor(getResources().getColor(R.color.colorLogoYellow))                               //def  | withDialogColor(int resid)
                        .withIcon(getResources().getDrawable(R.drawable.dialog_icon))
                        .withDuration(500)                                          //def
                        .withEffect(Effectstype.Newspager)                                         //def Effectstype.Slidetop
                        .withButton1Text("确定")//def gone
                        .withButton2Text("取消")                                  //def gone
                        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                        .setCustomView(R.layout.activity_dialog_key, v.getContext())         //.setCustomView(View or ResId,context)
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                EditText keyword = (EditText) dialogBuilder.getCustomView().findViewById(R.id.keyword);
                                if (keyword.getText().toString().equals("123456")) {
                                    Intent intent = new Intent();
                                    intent.setClass(LoginActivity.this, Login2Activity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "请输入正确密码", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogBuilder.dismiss();
                            }
                        })
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
