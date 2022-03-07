package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Bu kısımda XML üzerinden oluşturduğumuz butonları tanımlıyoruz
    private Button button10;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button15;
    private Button button90;
    private Button button91;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bu kısımda tanımladığımız butonlara bastığımızda hangi fonksiyona ait işlemi yapacağını atıyoruz
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity6();
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity7();
            }
        });

        button15 = (Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity8();
            }
        });

        button90 = (Button) findViewById(R.id.button90);
        button90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity100();
            }
        });

        button91 = (Button) findViewById(R.id.button91);
        button91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity101();
            }
        });
    }

    // Bu kısımda fonksiyonlarımızı tanımlıyoruz ve fonksiyonların hangi işlemi yapacağını atıyoruz

    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openActivity4() {
        Intent intent = new Intent(this, Main10Activity.class);
        startActivity(intent);
    }

    public void openActivity5() {
        Intent intent = new Intent(this, Main11Activity.class);
        startActivity(intent);
    }

    public void openActivity6() {
        Intent intent = new Intent(this, Main12Activity.class);
        startActivity(intent);
    }

    public void openActivity7() {
        Intent intent = new Intent(this, Main13Activity.class);
        startActivity(intent);
    }

    public void openActivity8() {
        Intent intent = new Intent(this, Main14Activity.class);
        startActivity(intent);
    }

    public void openActivity100() {
        Intent intent = new Intent(this, Main15Activity.class);
        startActivity(intent);
    }

    public void openActivity101() {
        Intent intent = new Intent(this, Main16Activity.class);
        startActivity(intent);
    }


    //Bu kısımda ise yazdığımız kodların tamamı uygulamamızın bu aktivitede tam ekran olarak çalışmasını sağlıyor

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {



        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE

                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }


    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}