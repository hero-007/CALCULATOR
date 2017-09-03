package com.example.calculator.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity1 extends AppCompatActivity {
    int num1 = 0, num2 = 0, ctr = 0,sr=0;
    String n="";
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void displayNum(String nr) {
        TextView tv1 = (TextView) findViewById(R.id.number_display);
        tv1.setText(nr);
    }
    public void displayAns(String nt){
        TextView tv = (TextView) findViewById(R.id.answer_display);
        tv.setText(nt);
    }


    public void inputExp(View view){
        if(view.getId()==R.id.key_0)
            n=n+"0";
        else if(view.getId()==R.id.key_1)
            n=n+"1";
        else if(view.getId()==R.id.key_2)
            n=n+"2";
        else if(view.getId()==R.id.key_3)
            n=n+"3";
        else if(view.getId()==R.id.key_4)
            n=n+"4";
        else if(view.getId()==R.id.key_5)
            n=n+"5";
        else if(view.getId()==R.id.key_6)
            n=n+"6";
        else if(view.getId()==R.id.key_7)
            n=n+"7";
        else if(view.getId()==R.id.key_8)
            n=n+"8";
        else if(view.getId()==R.id.key_9)
            n=n+"9";
        else if(view.getId()==R.id.add_operator)
            n=n+"+";
        else if(view.getId()==R.id.subtract_operator)
            n=n+"-";
        else if(view.getId()==R.id.multiply_operator)
            n=n+"*";
        else if(view.getId()==R.id.divide_operator)
            n=n+"/";
        else
        { }
        displayNum(n);
    }


    public void calculateResult(){
        int len=n.length();
        int k;
        for(int i=0;i<(len);i++){
            char ch=n.charAt(i);
            k=ch;
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
            {
                ctr=1;
                sr=ch;
                continue;
            }
            if(ctr==0)
                num1=(num1*10)+(k-48);
            else
                num2=(num2*10)+(k-48);
        }
    }
    public void printResult(View view){
        calculateResult();
        if(sr==43)
            result=num1+num2;
        else if(sr==45)
            result=num1-num2;
        else if (sr==47)
            result=num1/num2;
        else
            result=num1*num2;
        String se=""+result;
        displayAns(se);
        se="";
        n=""+result;
    }

    public void reset(View view)
    {
        num1=0;
        num2=0;
        sr=0;
        ctr=0;
        result=0;
        n="";
        displayAns("");
        displayNum("0");
    }
}
