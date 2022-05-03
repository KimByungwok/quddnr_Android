package com.example.a220503;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    View dialogView;
    TextView txt1;
    EditText dlgEtId, dlgEtPw;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);
        setTitle("커스텀 대화상자");

        txt1 = (TextView) findViewById(R.id.txt1);
        btn = (Button) findViewById(R.id.btn1);

        // 버튼 1 ,txt1 생성

        //버튼 눌렀을때 dialog xml 실행 할려고 하는것
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.main02, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("상품 주문 정보");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(dialogView);

                //포지티브 = 긍정적인것
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dlgEtId = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEtPw = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                        cb = (CheckBox) dialogView.findViewById(R.id.ch1);
                        txt1.setText("주문정보 : "+dlgEtId.getText().toString() + "  주문 수량 :" +
                                dlgEtPw.getText().toString() + "입니다\n"
                                +(cb.isChecked() ? "착불결제" : "선불결제"));
                        txt1.setTextColor(Color.BLUE);
                    }

                });
                //부정적인거 = 네거티브 (취소버튼)
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txt1.setText("취소하셧습니다... ㅂㅂ");
                        txt1.setTextColor(Color.MAGENTA);
                        //아래는 토스트 만드는것
                        Toast tMsg = Toast.makeText(MainActivity.this,
                                "잘가라 ㅋㅋ", Toast.LENGTH_SHORT);//여기다 .show 붙일수도 있음
                        tMsg.show();
                    }
                });
                dlg.show();//dlg.show 에서 dlg 지우고 .show가능 ㅇㅇ
            }
        });
    }
}