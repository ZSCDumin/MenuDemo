package com.edu.zscdm.menudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ZSCDM on 2017/2/15.
 * 作者邮箱：2712220318@qq.com
 */

public class PopMenuActivity extends Activity implements View.OnClickListener {
    private PopupWindow popupWindow;
    private TextView tvExit, tvSet, tvCancel;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void showPopup() {
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_layout, null);//PopupWindow对象
        popupWindow = new PopupWindow(this);//初始化PopupWindow对象
        popupWindow.setContentView(view);//设置PopupWindow布局文件
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);//设置PopupWindow宽
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);//设置PopupWindow高

        rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null);//父布局

        popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
        popupWindow.setOutsideTouchable(true);

        tvSet = (TextView) view.findViewById(R.id.tv_set);
        tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        tvExit = (TextView) view.findViewById(R.id.tv_exit);//在view对象中通过findViewById找到TextView控件

        tvSet.setOnClickListener(this);//注册点击监听
        tvCancel.setOnClickListener(this);//注册点击监听
        tvExit.setOnClickListener(this);//注册点击监听

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Toast.makeText(PopMenuActivity.this, "PupWindow消失了！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                popupWindow.dismiss();//关闭PopupWindow
                break;
            case R.id.tv_exit:
                finish();//调用Activity的finish方法退出应用程序
                break;
            case R.id.tv_set:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
        }
    }

    public void test(View view) {
        if (popupWindow == null) {
            showPopup();
        } else {
            popupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);//设置PopupWindow的弹出位置。
        }
    }
}