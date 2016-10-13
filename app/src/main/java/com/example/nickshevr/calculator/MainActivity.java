package com.example.nickshevr.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView divisionImageButton = (ImageView) findViewById(R.id.division);
        ImageView multiplicationImageButton = (ImageView) findViewById(R.id.multiplication);
        ImageView substractionImageButton = (ImageView) findViewById(R.id.subtract);
        ImageView additionImageButton = (ImageView) findViewById(R.id.addition);

        multiplicationImageButton.setOnClickListener(this);
        substractionImageButton.setOnClickListener(this);
        additionImageButton.setOnClickListener(this);
        divisionImageButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.multiplication:
                multipliaction();
                break;
            case R.id.subtract:
                substraction();
                break;
            case R.id.division:
                division();
                break;
            case R.id.addition:
                addition();
                break;
        }
    }

    public void outPutResult(Double output) {
        EditText outputText = (EditText) findViewById(R.id.output);
        outputText.setText(Double.toString(output));
    }

    public Double stringToInt(String str) {
        try {
            return new Double(str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_LONG).show();

            return 0.0;
        }
    }

    public String getFirstValue() {
        EditText firstText = (EditText) findViewById(R.id.editText2);
        return firstText.getText().toString();
    }

    public String getSecondValue() {
        EditText secondText = (EditText) findViewById(R.id.editText3);
        return secondText.getText().toString();
    }

    private void multipliaction() {
        Double firstArgument = this.stringToInt(this.getFirstValue());
        Double secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument * secondArgument);
    }

    private void substraction() {
        Double firstArgument = this.stringToInt(this.getFirstValue());
        Double secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument - secondArgument);
    }

    private void addition() {
        Double firstArgument = this.stringToInt(this.getFirstValue());
        Double secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument + secondArgument);
    }

    private void division() {
        Double firstArgument = this.stringToInt(this.getFirstValue());
        Double secondArgument = this.stringToInt(this.getSecondValue());

        if (secondArgument == 0) {
            Toast.makeText(this, "Деление на 0 невозможно", Toast.LENGTH_LONG).show();
        } else {
            outPutResult(firstArgument / secondArgument);
        }
    }
}
