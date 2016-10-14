package com.example.nickshevr.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;



public class TimerActivity extends AppCompatActivity implements View.OnClickListener{
    public interface Observer {
        void objectCreated(Object obj);
        void objectModified(Object obj);
    }

    static class Observers<T extends Observer> extends ArrayList<T> {
        public void notifyObjectCreated(Object obj) {
            for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
                iter.next().objectCreated(obj);
        }
        public void notifyObjectModified(Object obj) {
            for (Iterator<T> iter = (Iterator<T>) iterator(); iter.hasNext();)
                iter.next().objectModified(obj);
        }
    }

    interface TimeCalculator {
        public class TimeClass {

            Observers observers = new Observers();

            private int startHour;
            private int endHour;
            private int startMinute;
            private int endMinute;

            public int MinuteDifference;

            public int getMinuteDifference() {
                int endTotal = (this.endHour * 60) + this.endMinute;
                int startTotal = (this.startHour * 60) + this.startMinute;

                return endTotal - startTotal;
            }

            public int getStartHour() {
                return this.startHour;
            }

            public void setStartHour(int value) {
                this.startHour = value;
                observers.notifyObjectModified(this);
            }

            public int getEndHour() {
                return this.endHour;
            }

            public void setEndHour(int value) {
                this.endHour = value;
                observers.notifyObjectModified(this);
            }

            public int getStartMinute() {
                return this.startMinute;
            }

            public void setStartMinute(int value) {
                this.startMinute = value;
                observers.notifyObjectModified(this);
            }

            public int getEndMinute() {
                return this.endMinute;
            }

            public void setEndMinute(int value) {
                this.endMinute = value;
                observers.notifyObjectModified(this);
            }
        }
    }

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

    Integer textBoxToInteger(EditText textBox) {
        try {
            return new Integer(textBox.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Неккоректные данные", Toast.LENGTH_SHORT).show();

            return 0;
        }
    }

    public void calculate() {
        EditText startHoutText = (EditText) findViewById(R.id.startTimeHour);
        Integer startHour = textBoxToInteger(startHoutText);

        EditText endHoutText = (EditText) findViewById(R.id.endTimeHour);
        Integer endHour = textBoxToInteger(endHoutText);

        EditText startMinuteText = (EditText) findViewById(R.id.startTimeMinute);
        Integer startMinute = textBoxToInteger(startMinuteText);

        EditText endMinuteText = (EditText) findViewById(R.id.startTimeHour);
        Integer endMinute = textBoxToInteger(endMinuteText);

        Integer result = (startHour - endHour *60) + (startMinute - endMinute);
    }
}
