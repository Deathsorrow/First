package com.example.hp.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {
    EditText rmb;
    TextView show;
    private final String TAG="Rate";
    private  float dollarRate =0.15f;
    private  float euroRate =0.13f;
    private  float wonRate =170.31f;

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
               float val = r*dollarRate;
               show.setText(String.format("%.2f",val));
           }
           else if(btn.getId()==R.id.btn_euro){
               float val = r*euroRate;
               show.setText(String.format("%.2f",val));
           }
           else{
               float val = r*wonRate;
               show.setText(String.format("%.2f",val));
           }
    }
    public void openOne(View btn){
        openConfig();
    }

    private void openConfig() {
        Log.i("open","openOne:");
        Intent hello =new Intent(this,MainActivity.class);
        Intent web = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.jd.com"));
        Intent number = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:17361048415"));


        Intent config = new Intent(this,ConfigActivity.class);
        config.putExtra("dollar_rate_key",dollarRate);
        config.putExtra("euro_rate_key",euroRate);
        config.putExtra("won_rate_key",wonRate);

        Log.i(TAG,"openOne: dollarRate="+ dollarRate);
        Log.i(TAG,"openOne: euroRate="+ euroRate);
        Log.i(TAG,"openOne: wonRate="+ wonRate);

        startActivityForResult(config,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      if(requestCode==1 && resultCode==2){
          Bundle bundle = data.getExtras();
          dollarRate = bundle.getFloat("key_dollar",0.1f);
          euroRate = bundle.getFloat("key_euro",0.1f);
          wonRate = bundle.getFloat("key_won",0.1f);
          Log.i(TAG,"onActivityResult: dollarRate=" + dollarRate);
          Log.i(TAG,"onActivityResult: euroRate=" + euroRate);
          Log.i(TAG,"onActivityResult: wonRate=" + wonRate);

      }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_set){
            openConfig();
        }
        return super.onOptionsItemSelected(item);
    }
}
