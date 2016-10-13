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

        ImageView multiplicationImageButton = (ImageView) findViewById(R.id.imageView);
        ImageView substractionImageButton = (ImageView) findViewById(R.id.imageView2);
        ImageView additionImageButton = (ImageView) findViewById(R.id.imageView3);

        multiplicationImageButton.setOnClickListener(this);
        substractionImageButton.setOnClickListener(this);
        additionImageButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                multipliaction();
                break;
            case R.id.imageView2:
                substraction();
                break;
            case R.id.imageView3:
                addition();
                break;
            case R.id.imageView4:
                division();
                break;
        }
    }

    public void outPutResult(Integer output) {
        EditText outputText = (EditText) findViewById(R.id.output);
        outputText.setText(Integer.toString(output));
    }

    public Integer stringToInt(String str) {
        try {
            return new Integer(str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_LONG).show();

            return 0;
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
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument * secondArgument);
    }

    private void substraction() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument - secondArgument);
    }

    private void addition() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

        outPutResult(firstArgument + secondArgument);
    }

    private void division() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

        if (secondArgument == 0) {
            Toast.makeText(this, "Деление на 0 невозможно", Toast.LENGTH_LONG).show();
        } else {
            outPutResult(firstArgument % secondArgument);
        }
    }

}
