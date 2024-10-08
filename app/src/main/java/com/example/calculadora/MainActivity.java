package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public double n1, n2, result;
    public char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button AC = findViewById(R.id.button);
        Button DEL = findViewById(R.id.button2);
        Button PERCENT = findViewById(R.id.button3);
        Button DIVIDE = findViewById(R.id.button4);
        Button SEVEN = findViewById(R.id.button5);
        Button EIGHT = findViewById(R.id.button6);
        Button NINE = findViewById(R.id.button7);
        Button MULTIPLY = findViewById(R.id.button8);
        Button FOUR = findViewById(R.id.button9);
        Button FIVE = findViewById(R.id.button10);
        Button SIX = findViewById(R.id.button11);
        Button SUBTRACT = findViewById(R.id.button12);
        Button ONE = findViewById(R.id.button13);
        Button TWO = findViewById(R.id.button14);
        Button THREE = findViewById(R.id.button15);
        Button ADD = findViewById(R.id.button16);
        Button ZERO = findViewById(R.id.button18);
        Button DOT = findViewById(R.id.button19);
        Button EQUAL = findViewById(R.id.button20);
        TextView DISPLAY = findViewById(R.id.textView);

        ZERO.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "0"));
        ONE.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "1"));
        TWO.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "2"));
        THREE.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "3"));
        FOUR.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "4"));
        FIVE.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "5"));
        SIX.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "6"));
        SEVEN.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "7"));
        EIGHT.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "8"));
        NINE.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "9"));
        DOT.setOnClickListener(v -> DISPLAY.setText(DISPLAY.getText() + "."));

        AC.setOnClickListener(v -> DISPLAY.setText(""));
        DEL.setOnClickListener(v -> {
            String currentText = DISPLAY.getText().toString();
            if (!currentText.isEmpty()) {
                DISPLAY.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        ADD.setOnClickListener(v -> {
            n1 = Double.parseDouble(DISPLAY.getText().toString());
            operation = '+';
            DISPLAY.setText("");
        });

        SUBTRACT.setOnClickListener(v -> {
            n1 = Double.parseDouble(DISPLAY.getText().toString());
            operation = '-';
            DISPLAY.setText("");
        });

        MULTIPLY.setOnClickListener(v -> {
            n1 = Double.parseDouble(DISPLAY.getText().toString());
            operation = 'x';
            DISPLAY.setText("");
        });

        DIVIDE.setOnClickListener(v -> {
            n1 = Double.parseDouble(DISPLAY.getText().toString());
            operation = '/';
            DISPLAY.setText("");
        });

        PERCENT.setOnClickListener(v -> {
            n1 = Double.parseDouble(DISPLAY.getText().toString());
            operation = '%';
            DISPLAY.setText("");
        });

        EQUAL.setOnClickListener(v -> {
            String secondNumber = DISPLAY.getText().toString();
            if (!secondNumber.isEmpty()) {
                n2 = Double.parseDouble(secondNumber);

                switch (operation) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case 'x':
                        result = n1 * n2;
                        break;
                    case '/':
                        result = n1 / n2;
                        break;
                    case '%':
                        result = n1 % n2;
                        break;
                }
                DISPLAY.setText(String.valueOf(result));
            }
        });
    }
}
