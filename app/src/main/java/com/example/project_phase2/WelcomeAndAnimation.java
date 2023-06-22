package com.example.project_phase2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeAndAnimation extends AppCompatActivity {

    private Animation top, bottom;
    private TextView txt;
    private ImageView img;
    private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_and_animation);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        txt = findViewById(R.id.textId);
        img = findViewById(R.id.imageId);

        txt.setAnimation(bottom);
        img.setAnimation(top);
        go=findViewById(R.id.gooo);
        go.setAnimation(bottom);


    }

    public void btnGO(View view) {
        Intent intent=new Intent(this, RecycleView.class);
        startActivity(intent);


    }

    public void btnBack(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}