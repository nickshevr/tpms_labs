package com.example.nickshevr.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Stack;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOG_TAG = "FirstActivity";

    private static Stack<Double> memory = new Stack<Double>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@ToDo Remove this hack

        EditText output = (EditText) findViewById(R.id.output);
        output.setFocusable(false);

        ImageView divisionImageButton = (ImageView) findViewById(R.id.division);
        ImageView multiplicationImageButton = (ImageView) findViewById(R.id.multiplication);
        ImageView substractionImageButton = (ImageView) findViewById(R.id.subtract);
        ImageView additionImageButton = (ImageView) findViewById(R.id.addition);
        ImageView mraddImageButton = (ImageView) findViewById(R.id.mradd);
        ImageView mrremoveImageButton = (ImageView) findViewById(R.id.mrremove);
        TextView nextActivityButton = (TextView) findViewById(R.id.next);

        multiplicationImageButton.setOnClickListener(this);
        substractionImageButton.setOnClickListener(this);
        additionImageButton.setOnClickListener(this);
        divisionImageButton.setOnClickListener(this);
        mrremoveImageButton.setOnClickListener(this);
        mraddImageButton.setOnClickListener(this);
        nextActivityButton.setOnClickListener(this);
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
            case R.id.mrremove:
                popMemory();
                break;
            case R.id.mradd:
                addMemory();
                break;
            case R.id.next:
                nextActivity();
                break;
        }
    }

   public void nextActivity() {
       Intent intent = new Intent(MainActivity.this, TimerActivity.class);
       startActivity(intent);
   }

    public void outPutResult(Double output) {
        EditText outputText = (EditText) findViewById(R.id.output);
        outputText.setText(Double.toString(output));
    }

    public Double stringToDouble(String str) {
        try {
            return new Double(str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_SHORT).show();

            return 0.0;
        }
    }

    public void addMemory() {
        EditText output = (EditText) findViewById(R.id.output);
        Double result;
        try {
            result = new Double(output.getText().toString());
            memory.push(result);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Нечего запоминать", Toast.LENGTH_SHORT).show();
        }
    }

    public void popMemory() {
        EditText firstText = (EditText) findViewById(R.id.editText2);
        if (memory.empty()) {
            Toast.makeText(this, "Память калькулятора пуста", Toast.LENGTH_SHORT).show();
        } else {
            firstText.setText(Double.toString(memory.pop()));
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
        Double firstArgument = this.stringToDouble(this.getFirstValue());
        Double secondArgument = this.stringToDouble(this.getSecondValue());

        outPutResult(firstArgument * secondArgument);
    }

    private void substraction() {
        Double firstArgument = this.stringToDouble(this.getFirstValue());
        Double secondArgument = this.stringToDouble(this.getSecondValue());

        outPutResult(firstArgument - secondArgument);
    }

    private void addition() {
        Double firstArgument = this.stringToDouble(this.getFirstValue());
        Double secondArgument = this.stringToDouble(this.getSecondValue());

        outPutResult(firstArgument + secondArgument);
    }

    private void division() {
        Double firstArgument = this.stringToDouble(this.getFirstValue());
        Double secondArgument = this.stringToDouble(this.getSecondValue());

        if (secondArgument == 0) {
            Toast.makeText(this, "Деление на 0 невозможно", Toast.LENGTH_SHORT).show();
        } else {
            outPutResult(firstArgument / secondArgument);
        }
    }
}
