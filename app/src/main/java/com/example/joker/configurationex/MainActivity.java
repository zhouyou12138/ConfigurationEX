package com.example.joker.configurationex;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ori)
    EditText ori;
    @BindView(R.id.navigation)
    EditText navigation;
    @BindView(R.id.touch)
    EditText touch;
    @BindView(R.id.mnc)
    EditText mnc;
    @BindView(R.id.bn)
    Button bn;
    @BindView(R.id.bn2)
    Button bn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bn)
    public void onClick() {
        Configuration cfg = getResources().getConfiguration();//获取系统的Configuration对象
        String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
        String mncCode = cfg.mnc + "";
        String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV ? "没有方向控制" : cfg.orientation == Configuration.NAVIGATION_WHEEL ? "滚轮控制方向" : cfg.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制方向" : "轨迹球控制方向";
        navigation.setText(naviName);
        String touchName = cfg.orientation == Configuration.TOUCHSCREEN_NOTOUCH ? "无触摸屏" : "支持触摸屏";
        ori.setText(screen);
        mnc.setText(mncCode);
        touch.setText(touchName);
    }

    @OnClick(R.id.bn2)
    public void onClick2() {
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {      //如果当前是横屏
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设为竖屏
            // Toast.makeText(this, "系统的屏幕方向发生改变"+"\n 修改后的屏幕方向为：竖屏", Toast.LENGTH_SHORT).show();
        } else // (config.orientation ==Configuration.ORIENTATION_PORTRAIT);//如果当前是竖屏
        {
            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //Toast.makeText(this, "系统的屏幕方向发生改变"+"\n 修改后的屏幕方向为：横屏", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
        Toast.makeText(this, "系统的屏幕方向发生改变" + "\n 修改后的屏幕方向为: " + screen, Toast.LENGTH_SHORT).show();
    }
}
