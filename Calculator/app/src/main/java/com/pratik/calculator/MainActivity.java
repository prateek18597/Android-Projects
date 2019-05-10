package com.pratik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bdel,bc,bmul,bdiv,bsub,beq,bdot;
    EditText et;

    double d;
    long l;
    int isdouble=0;
    int opertion=0;
    int pre_op=0;
    int just_click=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b0=(Button)findViewById(R.id.b0);
        bdel=(Button)findViewById(R.id.bdel);
        bmul=(Button)findViewById(R.id.bmul);
        bsub=(Button)findViewById(R.id.bsub);
        badd=(Button)findViewById(R.id.badd);
        bc=(Button)findViewById(R.id.bc);
        bdot=(Button)findViewById(R.id.bdot);
        beq=(Button)findViewById(R.id.beq);
        bdiv=(Button)findViewById(R.id.bdiv);

        et=(EditText)findViewById(R.id.etext);
        //et.setText(0);
    }

    public void button1(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(1);
        et.setText(s);

    }
    public void button2(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(2);
        et.setText(s);
    }
    public void button3(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(3);
        et.setText(s);

    }
    public void button4(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(4);
        et.setText(s);

    }
    public void button5(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(5);
        et.setText(s);

    }
    public void button6(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(6);
        et.setText(s);

    }
    public void button7(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(7);
        et.setText(s);

    }

    public void button8(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(8);
        et.setText(s);

    }
    public void button9(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(9);
        et.setText(s);

    }
    public void button0(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString().trim());
        s.append(0);
        et.setText(s);

    }

    public void buttondot(View v)
    {
        StringBuffer s=new StringBuffer(et.getText().toString());
        s.append(".");
        et.setText(s);

    }

    public void buttonadd(View v)
    {
        if(pre_op==0) {
            String s = et.getText().toString().trim();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    if (i == 0) {
                        s = "0" + s;
                    }
                    if (i == s.length() - 1) {
                        s += "0";
                    }
                    d = Double.parseDouble(s);
                    isdouble = 1;
                }
            }
            if (isdouble == 0)
                l = Long.parseLong(s);

            opertion = 1;
            et.setText(null);
            pre_op=1;
        }
        else
        {
            if(isdouble==0) {
                if (pre_op== 1) {
                    long ans=(l+Long.parseLong(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        long ans=(l-Long.parseLong(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            long ans=(l*Long.parseLong(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(l/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }
            else
            {
                if (pre_op== 1) {
                    double ans=(d+Double.parseDouble(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        double ans=(d-Double.parseDouble(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            double ans=(d*Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(d/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }

        }

    }

    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void buttonsub(View v)
    {
        if(pre_op==0) {
            String s = et.getText().toString().trim();
            //int isdouble=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    if (i == 0) {
                        s = "0" + s;
                    }
                    if (i == s.length() - 1) {
                        s += "0";
                    }
                    d = Double.parseDouble(s);
                    isdouble = 1;
                }
            }
            if (isdouble == 0)
                l = Long.parseLong(s);

            opertion = 2;
            et.setText(null);
            pre_op=2;
        }
        else
        {
            if(isdouble==0) {
                if (pre_op== 1) {
                    long ans=(l+Long.parseLong(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        long ans=(l-Long.parseLong(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            long ans=(l*Long.parseLong(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(l/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }
            else
            {
                if (pre_op== 1) {
                    double ans=(d+Double.parseDouble(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        double ans=(d-Double.parseDouble(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            double ans=(d*Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(d/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }
        }
    }

    public void buttonmul(View v)
    {
        if(pre_op==0) {
            String s = et.getText().toString().trim();
            //int isdouble=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    if (i == 0) {
                        s = "0" + s;
                    }
                    if (i == s.length() - 1) {
                        s += "0";
                    }
                    d = Double.parseDouble(s);
                    isdouble = 1;
                }
            }
            if (isdouble == 0)
                l = Long.parseLong(s);

            opertion = 3;
            et.setText(null);
            pre_op=3;
        }
        else
        {
            if(isdouble==0) {
                if (pre_op== 1) {
                    long ans=(l+Long.parseLong(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        long ans=(l-Long.parseLong(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            long ans=(l*Long.parseLong(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(l/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }
            else
            {
                if (pre_op== 1) {
                    double ans=(d+Double.parseDouble(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        double ans=(d-Double.parseDouble(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            double ans=(d*Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(d/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }
            }pre_op=0;
        }
    }

    public void buttondiv(View v)
    {
        if(pre_op==0) {
            String s = et.getText().toString().trim();
            //int isdouble=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    if (i == 0) {
                        s = "0" + s;
                    }
                    if (i == s.length() - 1) {
                        s += "0";
                    }
                    d = Double.parseDouble(s);
                    isdouble = 1;
                }
            }
            if (isdouble == 0)
                l = Long.parseLong(s);

            opertion = 4;
            et.setText(null);
            pre_op=4;
        }
        else
        {
            if(isdouble==0) {
                if (pre_op== 1) {
                    long ans=(l+Long.parseLong(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        long ans=(l-Long.parseLong(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            long ans=(l*Long.parseLong(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(l/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }pre_op=0;
            }
            else
            {
                if (pre_op== 1) {
                    double ans=(d+Double.parseDouble(et.getText().toString().trim()));
                    et.setText(ans+"");
                }
                else
                {
                    if(pre_op==2)
                    {
                        double ans=(d-Double.parseDouble(et.getText().toString().trim()));
                        et.setText(ans+"");
                    }
                    else
                    {
                        if(pre_op==3)
                        {
                            double ans=(d*Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                        else
                        {
                            double ans=(d/Double.parseDouble(et.getText().toString().trim()));
                            et.setText(ans+"");
                        }
                    }
                }
                pre_op=0;
            }
        }
    }
    public void buttondel(View v)
    {
        String s=et.getText().toString().trim();
        String t="";
        for(int i=0;i<s.length()-1;i++)
        {
            t+=s.charAt(i);
        }
        et.setText(t);


    }

    public void buttonc(View v)
    {

        isdouble=0;
        opertion=0;
        pre_op=0;
        et.setText(null);
    }

    public void buttoneq(View v)
    {
        pre_op=0;;
     if(isdouble==0) {
         if (opertion== 1) {
             long ans=(l+Long.parseLong(et.getText().toString().trim()));
            et.setText(ans+"");
         }
         else
         {
             if(opertion==2)
             {
                 long ans=(l-Long.parseLong(et.getText().toString().trim()));
                 et.setText(ans+"");
             }
             else
             {
                 if(opertion==3)
                 {
                     long ans=(l*Long.parseLong(et.getText().toString().trim()));
                     et.setText(ans+"");
                 }
                 else
                 {
                     double ans=(l/Double.parseDouble(et.getText().toString().trim()));
                     et.setText(ans+"");
                 }
             }
         }
     }
     else
     {
         if (opertion== 1) {
             double ans=(d+Double.parseDouble(et.getText().toString().trim()));
             et.setText(ans+"");
         }
         else
         {
             if(opertion==2)
             {
                 double ans=(d-Double.parseDouble(et.getText().toString().trim()));
                 et.setText(ans+"");
             }
             else
             {
                 if(opertion==3)
                 {
                     double ans=(d*Double.parseDouble(et.getText().toString().trim()));
                     et.setText(ans+"");
                 }
                 else
                 {
                     double ans=(d/Double.parseDouble(et.getText().toString().trim()));
                     et.setText(ans+"");
                 }
             }
         }
     }

    }



}
