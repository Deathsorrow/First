package com.example.hp.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.hp.first.R.id.btn;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView out;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out= findViewById(R.id.tetout);
        out.setText(R.string.shuchu);
        edit=findViewById(R.id.inp);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String str=edit.getText().toString();
        Double num=Double.parseDouble(str);
        Double hsd=num*33.8;
        new java.text.DecimalFormat("#.00").format(hsd);
        String  result = String.valueOf(hsd);
        out.setText(result+"华氏度");
    }
}
