package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView ecran;
    private String opperation;
    private boolean calcul;
    private String operetor="";
    private boolean estOperetor=false;
    private  int val1=0;
    private int val2=0;
    private float result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecran = findViewById(R.id.textViewEcran);
        ecran.setText(String.valueOf(result));
    }
    public void addChiffre(View v){
        int val = Integer.parseInt(((Button)v).getText().toString());
        val1 = val1*10 + val;
        opperation = opperation + String.valueOf(val1);
        ecran.setText(opperation);
        estOperetor=false;
    }
    public void addOperator(View v){
        if (estOperetor){
            return;
        }else{
            if (operetor.length()==0){
                result = val1 ;
            }else {
                operetor = ((Button)v).getText().toString();
                switch (operetor){
                    case "+":{
                        result = result+val1;
                        break;
                    }
                    case "-":{
                        result = result-val1;
                        break;
                    }
                    case "*":{
                        result = result+val2*val1;
                        break;
                    }
                    case "/":{
                        result = result+val2/val1;
                        break;
                    }
                }
            }
            opperation = opperation + operetor;
            ecran.setText(opperation);
            operetor=((Button)v).getText().toString();
            estOperetor = true;
            val2 = val1;
            val1 = 0;
        }
    }
    public void clacul(View v){
        addOperator(v);
        ecran.setText(String.valueOf(result));
    }
    public void reset(){
        operetor="";
        estOperetor=false;
        val1=0;
        val2=0;
        result=0;
        ecran.setText(String.valueOf(result));
    }

}