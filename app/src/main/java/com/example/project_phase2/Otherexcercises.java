package com.example.project_phase2;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;


public class Otherexcercises extends AppCompatActivity {
    private boolean q1=false,q2=false,q3=false,q4=false,q5=false;
    private RadioButton applerd;
    private Button btn;
    private RadioButton tomatrd;

    private Spinner animalspn;

    private EditText skyedt;
    private RadioButton basket;
    private RadioButton racket;
    private RadioButton mitt;
    private RadioButton stick;
    private RadioButton clr1;
    private RadioButton clr2;
    private RadioButton clr3;
    private Button showbtn;
    private Button showwrng;
    private TextView lasttxt;
    private TextView wrngrxr;
    private static int res=5;
    private String wrn="";

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherexercises);
       applerd=findViewById(R.id.radio_Apple);
        tomatrd=findViewById(R.id.Tomato);
        animalspn=findViewById(R.id.animalid);
        basket=findViewById(R.id.basket);
        racket=findViewById(R.id.racket);
        mitt=findViewById(R.id.mitt);
        stick=findViewById(R.id.stick);
        showbtn=findViewById(R.id.showbtn);
        clr1=findViewById(R.id.clr1);
        clr2=findViewById(R.id.clr2);
        clr3=findViewById(R.id.clr3);
        lasttxt=findViewById(R.id.restxt);
        showwrng=findViewById(R.id.wrngbtn);
        wrngrxr=findViewById(R.id.wrntxt);
        skyedt=findViewById(R.id.skyclredt);

    }

    public void appleclk(View view) {
        //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

    }
    public void tomatclk(View view) {
    }
    public void basketclk(View view) {
    }

    public void racketclk(View view) {
    }

    public void mittclk(View view) {
    }

    public void stickclk(View view) {
    }

    public void clr1clk(View view) {
    }

    public void clr2clk(View view) {
    }

    public void clr3clk(View view) {
    }

    public void showclk(View view) {
        if(!applerd.isChecked()){
            res-=1;
            wrn+="Exercise One Is Wrong\n";

        }
        else{
            q1=true;
        }

        if(!animalspn.getSelectedItem().toString().equals("Cow")){
            res-=1;
            wrn+="Exercise Two Is Wrong\n";
        }
        else{
            q2=true;
        }
        String x=skyedt.getText().toString().toLowerCase();
        if(!x.equals("blue")){
            wrn+="Exercise Three Is Wrong\n";
            res-=1;
        }
        else{
            q3=true;
        }
        if(!stick.isChecked()){
            wrn+="Exercise Four Is Wrong\n";
            res-=1;
        }
        else{
            q4=true;
        }
        if(!clr3.isChecked()){
            wrn+="Exercise Five Is Wrong\n";
            res-=1;
        }
        else{
            q5=true;
        }
        Questions []q=new Questions[5];
        q[0]=new Questions(q1);

        q[1]=new Questions(q2);

        q[2]=new Questions(q3);

        q[3]=new Questions(q4);

        q[4]=new Questions(q5);

        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=pref.edit();
        Gson gson=new Gson();
        String grd=gson.toJson(q);

        editor.putString("grades",grd);
        editor.commit();

        lasttxt.setText("your Score Is "+res+"\nSaved to shared prefs!"+"\n");
        lasttxt.setVisibility(view.VISIBLE);
            Toast.makeText(this, grd, Toast.LENGTH_SHORT).show();
        if(res!=5){
            showwrng.setVisibility(view.VISIBLE);
        }

    }

    public void wrongbtn(View view) {

        wrngrxr.setText(wrn);
        wrngrxr.setVisibility(view.VISIBLE);

            SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);
            Gson gson=new Gson();
            String str=prefs.getString("grades","");
            Questions [] q=gson.fromJson(str,Questions[].class);

            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void bkclk(View view) {
        wrngrxr.setText("");
        lasttxt.setText("");
        lasttxt.setVisibility(view.INVISIBLE);
        Intent intent=new Intent(this,RecycleView.class);
        startActivity(intent);
    }
}
