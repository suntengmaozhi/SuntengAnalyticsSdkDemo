package com.sunteng.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sunteng.aynalyticsdemo.R;
import com.sunteng.statservice.StatConfig;
import com.sunteng.statservice.StatService;


public class MainActivity extends Activity implements OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        StatConfig.setDebugEnable(true); //在正式发布时应该设为false
        StatService.startStatService(this, "dc-10","30000","google");
        setContentView(R.layout.activity_main);
        
        Button btnRegist = (Button)findViewById(R.id.regist);
        Button btnLogin = (Button)findViewById(R.id.login);
        Button btnJump = (Button)findViewById(R.id.jump);
        Button btnCrash = (Button)findViewById(R.id.crash);
        
        btnCrash.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnJump.setOnClickListener(this);
    }

    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist:
                StatService.trackCustomEvent(this, "catelog","action","tag", 5);
                break;
            case R.id.login:
                StatService.trackCustomEvent(this, "catelog2","action2","tag2", 6);
                break;
            case R.id.jump:
                Intent intent = new Intent();
                intent.setClass(this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        
        }
    }
}
