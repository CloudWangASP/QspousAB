package com.xc.qspousab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

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
                NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(LoginActivity.this);
                dialogBuilder
                        .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                        .withTitleColor("#FFFFFF")                                  //def
                        .withDividerColor("#11000000")                              //def
                        .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                        .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                        .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
                        .withIcon(getResources().getDrawable(R.drawable.logo))
                        .withDuration(700)                                          //def
                        .withEffect(Effectstype.Slidetop)                                         //def Effectstype.Slidetop
                        .withButton1Text("OK")                                      //def gone
                        .withButton2Text("Cancel")                                  //def gone
                        .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                        .setCustomView(R.layout.dialog_layout,v.getContext())         //.setCustomView(View or ResId,context)
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(v.getContext(),"i'm btn2",Toast.LENGTH_SHORT).show();
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
