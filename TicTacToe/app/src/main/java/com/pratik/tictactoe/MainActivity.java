package com.pratik.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,toss;
    RadioButton p1,p2;
    private int turn=1;

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
        toss=(Button)findViewById(R.id.tossbtn);
        p1=(RadioButton)findViewById(R.id.radioButton6);
        p2=(RadioButton)findViewById(R.id.radioButton5);
    }

    public void toss(View view)
    {
        try{
        int x=1;
        tv.setText("Running");//(int)(Math.random()*10)%2;
        if(x==1)
        {
            p1.setText("O");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
        else
        {
            p2.setText("X");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }}catch (Exception e)
        {
            tv.setText("Error Occured");
        }
    }

    View.OnClickListener

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            }
        }

    public void button1(View view) {
        if (turn == 1)
        {
            b1.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b1.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }

    public void button2(View view)
    {
        if (turn == 1)
        {
            b2.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b2.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }

    }

    public void button3(View view)
    {
        if (turn == 1)
        {
            b3.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b3.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }

    }

    public void button4(View view)
    {
        if (turn == 1)
        {
            b4.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b4.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }

    public void button5(View view)
    {
        if (turn == 1)
        {
            b5.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b5.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }

    }

    public void button6(View view)
    {
        if (turn == 1)
        {
            b6.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b6.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }

    public void button7(View view)
    {
        if (turn == 1)
        {
            b7.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b7.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }

    public void button8(View view)
    {
        if (turn == 1)
        {
            b8.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b8.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }

    public void button9(View view)
    {
        if (turn == 1)
        {
            b9.setText("O");
            p2.setSelected(true);
            p1.setSelected(false);
            tv.setText("Turn: Player 2");
            turn=2;
        }
        else
        {
            b9.setText("X");
            p1.setSelected(true);
            p2.setSelected(false);
            tv.setText("Turn: Player 1");
            turn=1;
        }
    }
}
