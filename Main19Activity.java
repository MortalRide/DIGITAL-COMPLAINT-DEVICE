package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main19Activity extends AppCompatActivity {
    // XML üzerinde oluşturduğumuz butonların tanımlamalarını yapıyoruz
    private EditText message;
    private Button button;
    private Button _button32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        // Butonlara basıldığında çalışacak ilgili fonksiyonları atıyoruz

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity33();
            }
        });

        message = findViewById(R.id.message);
        _button32 = findViewById(R.id.button32);

        _button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }
        });
    }

    // JavaMailAPI içinde oluşturduğumuz fonksiyonları kullanarak ilgili mail adresinin konusunu
    // giriyoruz ve sayfada yazılacak yazının butona basıldığında gönderimini sağlamak için
    // ilgili fonksiyonu değişkenleri atayarak çağırıyoruz
    private void senEmail() {
        String mEmail = "sikayetrapor@gmail.com";
        String mSubject = "Çevre Hakkında Öneri";
        String mMessage = message.getText().toString();


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

        javaMailAPI.execute();
    }

    // Bu kısımda fonksiyonlarımızı tanımlıyoruz ve fonksiyonların hangi işlemi yapacağını atıyoruz
    public void openActivity33(){
        Intent intent = new Intent(this, MainActivity.class);
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
