package com.example.temp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText doc, dof;
    Button btcf, btfc, btclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        doc = findViewById(R.id.edtC);
        dof = findViewById(R.id.edtF);
        btfc = findViewById(R.id.FtoC);
        btcf = findViewById(R.id.CtoF);
        btclear = findViewById(R.id.btncl);

        btcf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                int c = Integer.parseInt("" + doc.getText());
                dof.setText("" + dcf.format(c*1.8+32));
            }
        });
        btfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                int f = Integer.parseInt("" + dof.getText());
                doc.setText("" + dcf.format((f-32)/1.8));
            }
        });
        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doc.setText("");
                dof.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}