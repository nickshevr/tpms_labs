package com.example.nickshevr.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

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
        }
    }

    public Integer stringToInt(String str) {
        try {
            return new Integer(str);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");

            return 0;
        }
    }

    public String getFirstValue() {
        EditText firstText = (EditText) findViewById(R.id.editText2);
        return firstText.getText().toString();
    }

    public String getSecondValue() {
        EditText firstText = (EditText) findViewById(R.id.editText2);
        return firstText.getText().toString();
    }

    private void multipliaction() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

    }

    private void substraction() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());

    }

    private void addition() {
        Integer firstArgument = this.stringToInt(this.getFirstValue());
        Integer secondArgument = this.stringToInt(this.getSecondValue());


    }

}
