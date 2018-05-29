package com.medipro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivMobileSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
    }

    private void getView() {
        ivMobileSignUp=(ImageView)findViewById(R.id.iv_mobile_sing_up);
        ivMobileSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_mobile_sing_up:
                startActivity(new Intent(this,MobileSignUpActivity.class));
                finish();
                break;
        }
    }
}
