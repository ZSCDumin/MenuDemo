package com.edu.zscdm.menudemo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ZSCDM on 2017/2/15.
 * 作者邮箱：2712220318@qq.com
 */

public class Main3Activity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        editText.setHint("上下文菜单测试");

        textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setHint("上下文菜单测试");
        registerForContextMenu(editText);//为EditText控件添加上下文菜单
        registerForContextMenu(textView);
        linearLayout.addView(editText);
        linearLayout.addView(textView);
        setContentView(linearLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {//创建上下文菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("上下文菜单"); //上下文菜单的标题
        menu.setHeaderIcon(android.R.drawable.ic_btn_speak_now); //上下文菜单图标
        menu.add(Menu.NONE, 1, 1, "粘贴"); //
        menu.add(Menu.NONE, 2, 2, "清空");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {//子菜单选择事件监听
        switch (item.getItemId()) {//根据子菜单ID进行菜单选择判断
            case 1:
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setPrimaryClip(ClipData.newPlainText(null, "内容"));
                if (clipboardManager.hasPrimaryClip()) {
                    editText.setText(clipboardManager.getPrimaryClip().getItemAt(0).getText());
                }
                break;
            case 2:
                editText.setText("");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
