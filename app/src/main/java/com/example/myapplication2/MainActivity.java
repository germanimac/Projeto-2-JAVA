package com.coffye.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.coffye.myapplication.R;
import com.example.myapplication2.urlDOWN;
import com.example.myapplication2.urlLEFT;
import com.example.myapplication2.urlRIGHT;
import com.example.myapplication2.urlUP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        if (android.os.Build.VERSION.SDK_INT > 9) // corretor par funfar na rede local e interwebs
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        urlUP urlU = new urlUP();
        urlDOWN urlD = new urlDOWN();
        urlRIGHT urlR = new urlRIGHT();
        urlLEFT urlL = new urlLEFT();

        try {
            urlU.cima();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            urlD.baixo();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void onClickUp(View v) {

        try {
            System.out.println("up");
            urlUP.cima();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onClickDown(View v) {

        try {
            System.out.println("down");
            urlDOWN.baixo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onClickRight(View v) {

        try {
            System.out.println("up");
            urlRIGHT.direita();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void onClickLeft(View v) {

        try {
            System.out.println("up");
            urlLEFT.esquerda();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}