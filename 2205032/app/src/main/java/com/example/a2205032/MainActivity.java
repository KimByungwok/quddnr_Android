package com.example.a2205032;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt1);
        btn = (Button) findViewById(R.id.btn1);

        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "배경색(노랑)");
        menu.add(0, 2, 0, "텍스트 추가");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                btn.setBackgroundColor(Color.YELLOW);

                break;
            case 2:
                btn.append("겨울 눈");

                break;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 1, 0, "토스트");
        menu.add(0, 2, 0, "텍스트 추가");
        menu.add(0, 3, 0, "배경색(마젠타)");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(getApplicationContext(), "토스트 생성", Toast.LENGTH_SHORT).show();

                break;
            case 2:
                txt.append("\n마스크 벗기");

                break;
            case 3:
                txt.setBackgroundColor(Color.MAGENTA);

                break;
        }

        return false;
    }
}