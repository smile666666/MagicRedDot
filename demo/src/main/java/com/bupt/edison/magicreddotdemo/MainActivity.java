package com.bupt.edison.magicreddotdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bupt.edison.magicreddot.MagicRedDotView;
import com.bupt.edison.magicreddot.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.qqdot_0)
    MagicRedDotView qqdot0;
    @Bind(R.id.qqdot_1)
    MagicRedDotView qqdot1;
    @Bind(R.id.qqdot_2)
    MagicRedDotView qqdot2;
    @Bind(R.id.qqdot_3)
    MagicRedDotView qqdot3;
    @Bind(R.id.qqdot_4)
    MagicRedDotView qqdot4;
    @Bind(R.id.btn_updateMsg)
    Button btnUpdateMsg;
    @Bind(R.id.qqdot_5)
    MagicRedDotView qqdot5;
    @Bind(R.id.qqdot_6)
    MagicRedDotView qqdot6;
    @Bind(R.id.textMsgCount)
    TextView textMsgCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setQQRedDotViewWithText();
        setQQRedDotView();
    }

    private void setQQRedDotViewWithText() {
        qqdot0.setUnreadCount(9);
        qqdot1.setUnreadCount(279);
        qqdot2.setUnreadCount(100);
        qqdot3.setUnreadCount(89);
        qqdot4.setUnreadCount(301);

        btnUpdateMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = (int) (Math.random() * 10);
                int msgCount = 1;
                switch (f % 4) {
                    case 0:
                        msgCount = (int) (Math.random() * 10); //个位数
                        break;
                    case 1:
                        msgCount = (int) (Math.random() * 100);
                        break;
                    case 2:
                        msgCount = (int) (Math.random() * 1000);
                        break;
                    case 3:
                        msgCount = (int) (Math.random() * 1000);
                        break;
                }
                Log.d("edison", "count " + msgCount);
                qqdot5.setUnreadCount(msgCount);
                textMsgCount.setText(String.valueOf(msgCount));
            }
        });
    }

    private void setQQRedDotView() {
        qqdot6.setUnreadCount(666);
        qqdot6.setOnDragStartListener(new MagicRedDotView.OnDragStartListener() {
            @Override
            public void OnDragStart() {
                Toast.makeText(MainActivity.this, "开始拖拽", Toast.LENGTH_SHORT).show();
            }
        });
        qqdot6.setOnDotResetListener(new MagicRedDotView.OnDotResetListener() {
            @Override
            public void OnDotReset() {
                Toast.makeText(MainActivity.this, "红点复位", Toast.LENGTH_SHORT).show();
            }
        });
        qqdot6.setOnDotDismissListener(new MagicRedDotView.OnDotDismissListener() {
            @Override
            public void OnDotDismiss() {
                Toast.makeText(MainActivity.this, "红点消失", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //这里还有个坑,状态栏和标题栏的高度计算结果都是0
        Log.d("edison titlebar", Utils.getTitleBarHeight(getWindow()) + "");
        Log.d("edison statusbar", Utils.getStatusBarHeight(getWindow()) + "");
        Log.d("edison statusbar", Utils.getStatusBarHeight(qqdot6) + "");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
