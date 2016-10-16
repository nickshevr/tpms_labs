package com.example.nickshevr.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener{
    public int parseHour(int hour) {
        if (hour > 24) {
            return 24;
        }

        if (hour < 0) {
            return 0;
        }

        return hour;
    }

    public int parseMinute(int minute) {
        if (minute > 60 || minute < 0) {
            return 0;
        }

        return minute;
    }

    public class TimeClass {

        private int startHour;
        private int endHour;
        private int startMinute;
        private int endMinute;

        public int MinuteDifference;

        public void setMinuteDifference() {
            int endTotal = (this.endHour * 60) + this.endMinute;
            int startTotal = (this.startHour * 60) + this.startMinute;

            this.MinuteDifference = Math.abs(endTotal - startTotal);
        }

        public int getMinuteDifference() {
            setMinuteDifference();

            return this.MinuteDifference;
        }

        public int getStartHour() {
            return this.startHour;
        }

        public void setStartHour(int value) {
            this.startHour = parseHour(value);
        }

        public int getEndHour() {
            return this.endHour;
        }

        public void setEndHour(int value) {
            this.endHour = parseHour(value);
        }

        public int getStartMinute() {
            return this.startMinute;
        }

        public void setStartMinute(int value) {
            this.startMinute = parseMinute(value);
        }

        public int getEndMinute() {
            return this.endMinute;
        }

        public void setEndMinute(int value) {
            this.endMinute = parseMinute(value);
        }
    }

    final TimeClass baseObject = new TimeClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final EditText output = (EditText) findViewById(R.id.output);
        output.setFocusable(false);

        final EditText startHour = (EditText) findViewById(R.id.startTimeHour);

        startHour.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int hour = Integer.parseInt(s.toString());
                baseObject.setStartHour(hour);
                int valueToAdd = parseHour(hour);
                startHour.setText(Integer.toString(valueToAdd));
                output.setText(Integer.toString(baseObject.getMinuteDifference()));
            }

        });

        final EditText endHour = (EditText) findViewById(R.id.endTimeHour);

        endHour.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int hour = Integer.parseInt(s.toString());
                baseObject.setEndHour(Integer.parseInt(s.toString()));
                int valueToAdd = parseHour(hour);
                endHour.setText(Integer.toString(valueToAdd));
            }

        });

        final EditText startMinute = (EditText) findViewById(R.id.startTimeMinute);

        startMinute.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int minute = Integer.parseInt(s.toString());
                baseObject.setStartMinute(Integer.parseInt(s.toString()));
                int valueToAdd = parseMinute(minute);
                startMinute.setText(Integer.toString(valueToAdd));
            }

        });

        final EditText endMinute = (EditText) findViewById(R.id.endTimeMinute);

        endMinute.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int minute = Integer.parseInt(s.toString());
                baseObject.setEndMinute(Integer.parseInt(s.toString()));
                int valueToAdd = parseMinute(minute);
                endMinute.setText(Integer.toString(valueToAdd));
            }

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                calculate();
                break;
        }
    }

    Integer textBoxToInteger(EditText textBox) {
        try {
            return new Integer(textBox.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_SHORT).show();

            return 0;
        }
    }

    public void calculate() {
       /* EditText startHoutText = (EditText) findViewById(R.id.startTimeHour);
        Integer startHour = textBoxToInteger(startHoutText);

        EditText endHoutText = (EditText) findViewById(R.id.endTimeHour);
        Integer endHour = textBoxToInteger(endHoutText);

        EditText startMinuteText = (EditText) findViewById(R.id.startTimeMinute);
        Integer startMinute = textBoxToInteger(startMinuteText);

        EditText endMinuteText = (EditText) findViewById(R.id.startTimeHour);
        Integer endMinute = textBoxToInteger(endMinuteText);

        Integer result = (startHour - endHour *60) + (startMinute - endMinute);*/
        //int minuteDiff = baseObject.getMinuteDifference();

        //Toast.makeText(this, Integer.toString(minuteDiff), Toast.LENGTH_LONG).show();
    }
}
