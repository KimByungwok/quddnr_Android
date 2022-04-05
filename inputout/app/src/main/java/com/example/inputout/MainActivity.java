package com.example.inputout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main01);

        Button btnRead,btnWrite;
        btnRead = (Button) findViewById(R.id.btnRead);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "쿡북 안드로이드";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),"file.txt가 생성됨",Toast.LENGTH_SHORT).show();

                }catch (IOException e){

                }
            }

        });

        btnRead.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[]txt = new byte[30];
                    inFs.read(txt);
                    inFs.close();
                    Toast.makeText(getApplicationContext(),"file.txt가 생성됨",Toast.LENGTH_SHORT).show();

                }catch (IOException e){
                    Toast.makeText(getApplicationContext(),"파일없음",Toast.LENGTH_SHORT).show();
                }
            }

        });



    }
}