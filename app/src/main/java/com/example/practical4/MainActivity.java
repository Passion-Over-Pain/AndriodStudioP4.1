package com.example.practical4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double amountPaid;
    final double totalFees = 25000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rgbAble), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final EditText txtamountPaid = (EditText) findViewById(R.id.txtPaid);
        final RadioButton rgbAble = (RadioButton) findViewById(R.id.rgbAble);
        final Button register = (Button) findViewById(R.id.btnRegister);
        final Button pay = (Button) findViewById(R.id.btnPay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtamountPaid.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amountPaid = Double.parseDouble(input); // Convert only if input is valid
                double registrationFee = totalFees * 0.3;

                if (amountPaid >= registrationFee) {
                    Toast.makeText(MainActivity.this, "You are now able to register", Toast.LENGTH_LONG).show();
                    rgbAble.setChecked(true);
                } else {
                    Toast.makeText(MainActivity.this, "You are unable to register", Toast.LENGTH_LONG).show();
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(rgbAble.isChecked())
               {
                   Toast.makeText(MainActivity.this,"Registration Successful.",Toast.LENGTH_LONG).show();
               }
               else
               {
                   Toast.makeText(MainActivity.this,"Registration unsuccessful. Please pay the registration fee first.",Toast.LENGTH_LONG).show();
               }


           }
       });


    }
}