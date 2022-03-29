package com.example.contextmenu03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    LinearLayout baseLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);
        setTitle("배경색 바꾸기 (컨텍스트 메뉴)");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tMsg = Toast.makeText(MainActivity.this,"토스트 연습",Toast.LENGTH_SHORT);
                //tMsg.setGravity(Gravity.TOP | Gravity.LEFT,300, 1000);
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int x0ffset = (int) (Math.random()*display.getWidth());
                int y0ffset = (int) (Math.random()*display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT,x0ffset,y0ffset);
                tMsg.show();

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,view,menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        if(view == button1){
            menu.setHeaderTitle("배경색 변경");
            menu.add(0,1,0,"배경색 빨간색");
            menu.add(0,2,0,"배경색 초록색");
            menu.add(0,3,0,"배경색 파란색");
        }
        if (view == button2){
            menu.add(0,4,0,"버튼각 변경");
            menu.add(0,5,0,"버튼각 변경");
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                break;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                break;
            case 4:
                button2.setRotation(45);
                break;
            case 5:
                baseLayout.setScaleX(2);
                break;
        }
        return super.onContextItemSelected(item);
    }
}