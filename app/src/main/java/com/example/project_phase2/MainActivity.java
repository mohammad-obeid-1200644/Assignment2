package com.example.project_phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText password;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserName=findViewById(R.id.userId);
        password=findViewById(R.id.password);
        setupSharedPrefs();
        save();

    }

    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void ptnLOgIn(View view) {
        editor.putString("user",UserName.getText().toString());
        editor.putString("pass",password.getText().toString());
        editor.putBoolean("flag",true);
        editor.commit();
        Toast.makeText(this, UserName.getText()+" " + password.getText(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,WelcomeAndAnimation.class);
        startActivity(intent);



    }

    public void save(){
        if(prefs.getBoolean("flag",false)){
            UserName.setText(prefs.getString("user",""));
            password.setText(prefs.getString("pass",""));

        }
    }
}