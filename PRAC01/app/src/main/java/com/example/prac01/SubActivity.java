package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);

        EditText edtname = findViewById(R.id.edtname);
        EditText edtgpa = findViewById(R.id.edtgpa);
        Button returnbtn = findViewById(R.id.returnbtn);

        returnbtn.setOnClickListener(view -> {
            Intent returnintent = new Intent();
            String name = edtname.getText().toString();
            String gpa =edtgpa.getText().toString();

            returnintent.putExtra("ten",name);
            returnintent.putExtra("gpa",gpa);
            setResult(RESULT_OK, returnintent);
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}