package com.example.gascalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText alcohol;
    private EditText gasoline;
    private Button calculate;
    private TextView textResult;
    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alcohol = findViewById(R.id.alcoholPrice);
        gasoline = findViewById(R.id.gasPrice);
        calculate = findViewById(R.id.calculateButton);
        textResult = findViewById(R.id.result);
        clear = findViewById(R.id.clearInputs);

        calculate.setOnClickListener(v -> calculate());
        clear.setOnClickListener(v -> clearInputs());
    }

    private void calculate() {
        String alcoholInput = alcohol.getText().toString();
        String gasolineInput = gasoline.getText().toString();

        if (validate(alcoholInput, gasolineInput)) {
            double alcoholPrice = Double.parseDouble(alcoholInput);
            double gasolinePrice = Double.parseDouble(gasolineInput);

            if ((alcoholPrice / gasolinePrice) >= 0.7) {
                textResult.setText("Usar gasolina!");
            } else {
                textResult.setText("Usar álcool!");
            }
        } else {
            textResult.setText("Por favor, insira valores válidos!");
        }
    }

    private boolean validate(String alcoholInput, String gasolineInput) {
        if (alcoholInput.isEmpty() || gasolineInput.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(alcoholInput);
            Double.parseDouble(gasolineInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void clearInputs() {
        alcohol.setText("");
        gasoline.setText("");
        textResult.setText("");
    }
}
