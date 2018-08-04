package com.azo.marcfreir.signs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.AdapterView;

public class Main extends AppCompatActivity {
    private Spinner spinnerDay = null;
    private Spinner spinnerMonth = null;

    //METHOD FOR THE DATES VALIDATION
    private void validateDate() {
        int day = spinnerDay.getSelectedItemPosition();
        int month = spinnerMonth.getSelectedItemPosition();

        day++;
        month++;

        //LOGIC
        if (day > 29 && month == 2) {
            spinnerDay.setSelection(28);
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)) {
            spinnerDay.setSelection(29);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ADDING THE SPINNERS - CALLING BY ID WITH THE "R" CLASS
        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);

        //ADDING THE ADAPTER
        ArrayAdapter<CharSequence> adapter_day = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_month = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);

        //SETTING THE DROP DOWN
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //SETTING THE ADAPTER
        spinnerDay.setAdapter(adapter_day);
        spinnerMonth.setAdapter(adapter_month);

        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validateDate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validateDate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //
        Button send = (Button) findViewById(R.id.buttonSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positionDay = spinnerDay.getSelectedItemPosition();
                int positionMonth = spinnerMonth.getSelectedItemPosition();

                positionDay++;
                positionMonth++;

                InterpreterSign Interpreter = new InterpreterSign();

                Sign signResult = Interpreter.interpret(positionDay, positionMonth);

                Bundle args = new Bundle();
                args.putSerializable("result", signResult);

                Intent intent = new Intent(Main.this, Result.class);
                intent.putExtra("sign", args);

                startActivity(intent);
            }
        });

    }
}
