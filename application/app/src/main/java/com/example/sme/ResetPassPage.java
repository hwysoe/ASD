package com.example.sme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import Button widget
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;


//packages for mail

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


public class ResetPassPage extends AppCompatActivity {
    Button _btnSend;
    String customerEmail = "jeromeaujiajun@rocketmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        _btnSend = findViewById(R.id.btnReset);
        _btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String SME_email = "shopmadez22@gmail.com";
                final String SME_email_pass = "ktvcougoreeskeax";
                String message = "Hi this is a test email";
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                Session session= Session.getInstance(props,
                        new javax.mail.Authenticator(){
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication(){
                                return new PasswordAuthentication(SME_email, SME_email_pass);
                            }
                        });
                try{
                    Message msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(SME_email));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail));
                    msg.setSubject("Test");
                    msg.setText(message);
                    Transport.send(msg);
                    //Toast.makeText(getApplicationContext(), text:)
                }catch (MessagingException e){
                    throw new RuntimeException(e);
                }
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}