package com.edu.zscdm.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * 选项对话框
 * Created by ZSCDM on 2017/2/15.
 * 作者邮箱：2712220318@qq.com
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setIconEnable(menu, true);//显示菜单图标

        //动态方法创建
//        MenuItem item = menu.add(menu.NONE, 1, 1, "菜单1");
//        item.setIcon(R.drawable.ic_back);
//        menu.add(menu.NONE, 2, 2, "菜单2");
//        menu.add(menu.NONE, 3, 3, "菜单3");
//        menu.add(menu.NONE, 4, 4, "菜单4");
//        return super.onCreateOptionsMenu(menu);

        //静态方法创建
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.meun1:
                Toast.makeText(MainActivity.this, "菜单一被选择了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(MainActivity.this, "菜单二被选择了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(MainActivity.this, "菜单三被选择了", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Toast.makeText(MainActivity.this, "选项菜单开启", Toast.LENGTH_SHORT).show();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        Toast.makeText(MainActivity.this, "选项菜单关闭", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        return super.onPrepareOptionsMenu(menu);
    }

    //enable为true时，菜单添加图标有效，enable为false时无效。4.0系统默认无效
    private void setIconEnable(Menu menu, boolean enable) {
        try {
            Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            m.setAccessible(true);
            //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
            m.invoke(menu, enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
