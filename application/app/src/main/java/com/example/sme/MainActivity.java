package com.example.sme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

//import Button widget
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



//packages for mail
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;


public class MainActivity extends AppCompatActivity {
    Button _btnSend;
    String customerEmail = "jeromeaujiajun@rocketmail.com";
    TextView _txtTest;
    Button _btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtTest = findViewById(R.id.txtTest);
        _btnTest = findViewById(R.id.btnTest);
        _btnSend = findViewById(R.id.btnSend);
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

        _btnTest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String searchItem = "paper";
                try {
                    Document doc1 = Jsoup.connect("https://shopee.sg/search?keyword=" + searchItem).get();
                   // Elements els1 = doc1.getElementsByClass("VTjd7p whIxGK");
                    _txtTest.setText(doc1.title());//els1.toString());
                } catch (IOException e) {
                    _txtTest.setText(e.toString());
                    e.printStackTrace();
                }

            }
        });
    }
}