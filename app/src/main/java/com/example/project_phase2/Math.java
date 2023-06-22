package com.example.project_phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Math extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secoundNumber;
    private  EditText answer;

    private Spinner spiner;
    private TextView hiddenText;
    private Animation top;
    private ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        firstNumber=findViewById(R.id.FirstNumber);
        secoundNumber=findViewById(R.id.SecoundNumber);
        spiner=findViewById(R.id.spinner);
        hiddenText=findViewById(R.id.visibleText);
        answer=findViewById(R.id.Answer);
        img=findViewById(R.id.MathId);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        img.setAnimation(top);





    }

    public void btnClick(View view) {
        int number1=Integer.parseInt(firstNumber.getText().toString());
        int number2=Integer.parseInt(secoundNumber.getText().toString());
        int result=Integer.parseInt(answer.getText().toString());
        hiddenText.setVisibility(View.VISIBLE);
        String op=spiner.getSelectedItem().toString();
        if(op.equals("*")){
            int fin=number2*number1;
            if(result==fin){
                hiddenText.setText("Correct... you are hero");

            }
            else{
                hiddenText.setText("Wrong ...the correct answer is :" + fin);
            }

        }




    }

    public void bkclk(View view) {
        hiddenText.setText("");

        Intent intent=new Intent(this,RecycleView.class);
        startActivity(intent);
    }
}
