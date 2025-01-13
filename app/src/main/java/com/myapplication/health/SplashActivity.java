package com.myapplication.health;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    ImageView ivlogo;
    TextView tvtitle,tvsubtitle;
    Animation fadeInAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivlogo =findViewById(R.id.iv_Main_Logo);
        tvtitle =findViewById(R.id.tvTitle);
        tvsubtitle =findViewById(R.id.tvsubtitle);

        fadeInAnim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        ivlogo.setAnimation(fadeInAnim);
        tvtitle.setAnimation(fadeInAnim);
        tvsubtitle.setAnimation(fadeInAnim);
        Handler handler =new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent i =new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);

            }
        },3000);

    }
}