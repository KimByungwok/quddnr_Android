package com.example.dialog_c;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] versionArray = new String[] {"파이","q(10)","R(11)"};
                final boolean[] checkArray = new boolean[] {true, false, false};
                
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("골라봐");
                //dlg.setMessage("내용임");
                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        button1.setText(versionArray[i]);
                    }
                });     // 라디오버튼 목록 대화상자

//                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        button1.setText(versionArray[i]);
//                    }
//                });     // 체크박스 목록 대화상자
                
//                dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        button1.setText(versionArray[i]);
//                    }
//                });   // 기본적인 목록 대화상자

                dlg.setPositiveButton("확인",null);
                dlg.show();
            }
        });
    }
}