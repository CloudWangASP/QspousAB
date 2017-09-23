package com.xc.qspousab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.xc.qspousab.R;
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
                login(v, "员工账本", "123456", RecordActivity.class);
            }
        });
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v, "老板账本", "123456", ChartAnalysisActivity.class);
            }
        });
    }

    private void login(View v, String title, final String psd, final Class clz) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(LoginActivity.this);
        dialogBuilder
                .withTitle(title)
                .withTitleColor(getResources().getColor(R.color.colorWhite))
                .withDividerColor(getResources().getColor(R.color.colorLogoYellow))
                .withMessage("请在此输入密码")
                .withMessageColor(getResources().getColor(R.color.colorWhite))
                .withDialogColor(getResources().getColor(R.color.colorLogoYellow))
                .withIcon(getResources().getDrawable(R.drawable.dialog_icon))
                .withDuration(500)
                .withEffect(Effectstype.Newspager)
                .withButton1Text("确定")
                .withButton2Text("取消")
                .isCancelableOnTouchOutside(true)
                .setCustomView(R.layout.activity_dialog_key, v.getContext())
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText keyword = (EditText) dialogBuilder.getCustomView().findViewById(R.id.keyword);
                        if (keyword.getText().toString().equals(psd)) {
                            Intent intent = new Intent();
                            intent.setClass(LoginActivity.this, clz);
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

}
