package com.example.informationapp;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import android.app.ProgressDialog;

public class JavaMailAPI extends AsyncTask<Void, Void, Void> {

    // İlgili değişkenlerimizi tanımlıyoruz

    private Context context;

    private Session session;
    private String email, subject, message;
    private ProgressDialog mProgressDialog;

    //JavaMailAPI Construction'ımızı oluşturup tanımlamaları yapıyoruz.

    public JavaMailAPI(Context context, String email, String subject, String message) {
        this.context = context;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    // Bu fonksiyon ile mail gönderimi esnasındaki işlemin durumunu görüyoruz

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        mProgressDialog = ProgressDialog.show(context,"Mesaj Gönderiliyor", "Lütfen Bekleyiniz...",false,false);
    }

    // Bu fonksiyon ile mail'in gönderilip gönderilmediğini kontrol edip ekrana yazdırıyoruz
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        mProgressDialog.dismiss();


        Toast.makeText(context,"Mesaj Başarıyla Gönderildi",Toast.LENGTH_SHORT).show();

    }

    // Bu fonksiyon ile gmail protokolünü kullanarak SMTP ile mail gönderimi için ayarlamalarımızı yapıyoruz

    @Override
    protected Void doInBackground(Void... voids) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
            }
        });

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(Utils.EMAIL));
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(email)));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;

    }
}