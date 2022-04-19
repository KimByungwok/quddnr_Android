package com.example.testready;

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

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);
        txt=(TextView) findViewById(R.id.txt1);
        button=(Button) findViewById(R.id.button1);
        registerForContextMenu(button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "배경색(빨간)");
        menu.add(0, 2, 0, "배경색(초록)");
        menu.add(0, 3, 0, "배경색(파랑)");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                txt.setBackgroundColor(Color.RED);
                break;
            case 2:
                txt.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                txt.setBackgroundColor(Color.BLUE);
                txt.append("\n때지민");
                break;
                
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"배경색 빨강");
        menu.add(0,2,0,"배경색 그린");
        menu.add(0,3,0,"배경색 파랑");


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                button.setBackgroundColor(Color.RED);
                break;
            case 2:
                button.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                button.setBackgroundColor(Color.BLUE);
                button.append("\n돼지민");
                break;
        }
        return super.onContextItemSelected(item);
    }
}