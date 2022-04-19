package com.example.testready_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    View dialogView;
    TextView txt1;
    EditText dlgEdtId, dlgEdtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("커스텀 대화상자");

        txt1=(TextView)findViewById(R.id.txt1);
        btn = (Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView=(View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        dlgEdtId = (EditText) dialogView.findViewById(R.id.dlgId);
                        dlgEdtPass = (EditText) dialogView.findViewById(R.id.dlgPW);

                        txt1.setText(dlgEdtId.getText().toString() + "님의 비밀번호는 " + dlgEdtPass.getText().toString() + "입니다\n");
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txt1.setText("취소하셧슴다");
                        txt1.setTextColor(Color.MAGENTA);
                        Toast.makeText(MainActivity.this, "토스트 굽굽", Toast.LENGTH_SHORT).show();

                    }
                });

                dlg.show();
            }
        });
    }


}