package com.edu.zscdm.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//构建菜单
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//菜单选择事件监听
        switch (item.getItemId()){
            case R.id.new_file:
                Toast.makeText(this,"您选择了新建按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.open_file:
                Toast.makeText(this,"您选择了打开按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit_file:
                Toast.makeText(this,"您选择了编辑按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_set:
                Toast.makeText(this,"您选择了删除按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_set:
                Toast.makeText(this,"您选择了退出按钮",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
