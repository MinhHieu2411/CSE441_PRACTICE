package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText id = findViewById(R.id.edtid);
        EditText name = findViewById(R.id.edtname);
        EditText birth = findViewById(R.id.edtbirth);
        EditText sal = findViewById(R.id.edtsal);
        Button btn = findViewById(R.id.button);
        TextView output = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String outputtext = output.getText().toString();

                String newstaff = id.getText().toString() +" - " +  name.getText().toString() + " - " + birth.getText().toString() + " - " + sal.getText().toString() + "\n";


                outputtext = outputtext + newstaff;

                output.setText(outputtext);


                id.setText("");
                name.setText("");
                birth.setText("");
                sal.setText("");
                
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}