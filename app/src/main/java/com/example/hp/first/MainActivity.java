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

    }

    @Override
    public void onClick(View v) {
       String str=out.getText().toString();
       Double total=Double.parseDouble(str);
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
                total= Double.valueOf(0);
                break;
            default:
              break;
        }
        String  result = String.valueOf(total);
        out.setText(result);
    }
}
