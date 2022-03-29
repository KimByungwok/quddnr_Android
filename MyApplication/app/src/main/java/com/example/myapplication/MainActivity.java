package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout baseLayout;
    Button button01, button02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);
        button01 = (Button) findViewById(R.id.btn1);
        button02=(Button) findViewById(R.id.btn2);
        registerForContextMenu(button01);
        registerForContextMenu(button02);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater mInflater=getMenuInflater();
        if(v==button01){
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu, menu;
        }
        if(v==button02){
            menu.setHeaderTitle("버튼 변경");
            mInflater.inflate(R.menu.menu01, menu);
        }
    }

    public boolean onContextItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.itemRotate:
                button02.setRotation(-45);
                return true;
            case R.id.itemSubSize:
                button02.setScaleX(4);
                return true;
        }
    }

}