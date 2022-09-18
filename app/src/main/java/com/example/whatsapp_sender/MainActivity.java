package com.example.whatsapp_sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutPhone;
    private TextInputLayout inputLayoutMessage;

    private TextInputEditText inputPhoneText;
    private TextInputEditText inputMessageText;
    private Button sendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutPhone = findViewById(R.id.number_layout);
        inputLayoutMessage = findViewById(R.id.Message_layout);

        inputPhoneText = findViewById(R.id.Number_text);
        inputMessageText = findViewById(R.id.Message_input);

        sendMessage = findViewById(R.id.send_message);




        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri whatsapp_url = Uri.parse("https://wa.me/55" + inputPhoneText.getText().toString()
                        + "?text=" + inputMessageText.getText().toString().replace(" ", "%20"));
                Intent callIntent = new Intent(Intent.ACTION_VIEW, whatsapp_url);
                startActivity(callIntent);
            }
        });

    }
}