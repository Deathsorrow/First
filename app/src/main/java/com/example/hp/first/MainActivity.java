package com.example.hp.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.hp.first.R.id.btn0;
import static com.example.hp.first.R.id.btn1;
import static com.example.hp.first.R.id.btn2;
import static com.example.hp.first.R.id.btn3;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView out;
    TextView outb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out= findViewById(R.id.tetout);
        out.setText(R.string.fenshu);
        Button btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        Button btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        Button btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Button btn0=findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        outb= findViewById(R.id.tetoutb);
        outb.setText(R.string.fenshu);
        Button btn3b=findViewById(R.id.btn3b);
        btn3b.setOnClickListener(this);
        Button btn2b=findViewById(R.id.btn2b);
        btn2b.setOnClickListener(this);
        Button btn1b=findViewById(R.id.btn1b);
        btn1b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       String str=out.getText().toString();
       int total=Integer.parseInt(str);
       String strb=outb.getText().toString();
       int totalb=Integer.parseInt(strb);
        switch (v.getId()) {
            case R.id.btn1:
                total=total+1;
                break;
            case R.id.btn2:
                total=total+2;
                break;
            case R.id.btn3:
                total=total+3;
                break;
            case R.id.btn0:
                total= Integer.valueOf(0);
                totalb= Integer.valueOf(0);
                break;

            case R.id.btn1b:
                totalb=totalb+1;
                break;
            case R.id.btn2b:
                totalb=totalb+2;
                break;
            case R.id.btn3b:
                totalb=totalb+3;
                break;
            default:
              break;
        }
        String  result = String.valueOf(total);
        out.setText(result);

        String  resultb = String.valueOf(totalb);
        outb.setText(resultb);
    }
}
