package com.example.a220329android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    View dialogView;
    EditText digEdName;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);

    button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            dialogView = (View) View.inflate(MainActivity.this,R.layout.main01,null);
            AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
            dig.setTitle("사정자 정보 입력");
            dig.setIcon(R.drawable.star);
            dig.setView(dialogView);

            dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    digEdName = (EditText) dialogView.findViewById(R.id.dldEdt1);

                    tvName = (TextView) tvName.findViewById(R.id.dldEdt2);
                }
            });


        }
    });
    }

}