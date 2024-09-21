package com.example.prog_cal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c;
    Button cong, tru, nhan, chia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.editA);
        b = findViewById(R.id.editB);
        c = findViewById(R.id.editKQ);

        cong = findViewById(R.id.button1);
        tru = findViewById(R.id.button2);
        nhan = findViewById(R.id.button3);
        chia = findViewById(R.id.button4);

        cong.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt("0"+a.getText());
                int y = Integer.parseInt("0"+b.getText());

                c.setText("a + b = " + (x + y));
            }
        });

        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt("0"+a.getText());
                int y = Integer.parseInt("0"+b.getText());

                c.setText("a - b = "+(x-y));
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt("0"+a.getText());
                int y = Integer.parseInt("0"+b.getText());

                c.setText("a x b = "+(x*y));
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt("0"+a.getText());
                int y = Integer.parseInt("0"+b.getText());

                c.setText("a / b = "+(x/y));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}