package com.example.hp.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {
    EditText rmb;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        rmb=findViewById(R.id.rmb);
        show=findViewById(R.id.showout);

    }
    public void OnClick(View btn){
           String str=rmb.getText().toString();
           float r =0;
           if(str.length()>0) {
               r = Float.parseFloat(str);
           }
           else{
               Toast.makeText(this, "请输入人民币金额", Toast.LENGTH_SHORT).show();
           }
           if(btn.getId()==R.id.btn_dollar){
               float val = r*0.15f;
               show.setText(String.valueOf(val));
           }
           else if(btn.getId()==R.id.btn_euro){
               float val = r*0.13f;
               show.setText(String.valueOf(val));
           }
           else{
               float val = r*170.31f;
               show.setText(String.valueOf(val));
           }
    }
    public void openOne(View btn){
        Log.i("open","openOne:");
        Intent hello =new Intent(this,MainActivity.class);
        Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.jd.com"));
        Intent number = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:17361048415"));
        startActivity(number);
    }
}
