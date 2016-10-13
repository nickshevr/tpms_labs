package com.example.nickshevr.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);


        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                //calculate();
                break;
        }
    }

    Integer textBoxToInteger() {
        EditText textBox = (EditText) findViewById(R.id.editText2);
        try {
            return new Integer(textBox.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_SHORT).show();

            return 0;
        }
    }

    public void calculateMinutes() {

    }
}
