package com.example.calculadoradeidade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaIdade(View view) {
        EditText txtMes = findViewById(R.id.inputBirthMonth);
        EditText txtAno = findViewById(R.id.inputBirthYear);

        String stMes = txtMes.getText().toString();
        String stAno = txtAno.getText().toString();

        int mesNascimento = Integer.parseInt(stMes);
        int anoNascimento = Integer.parseInt(stAno);

        int mesAtual = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

        int idade = anoAtual - anoNascimento;

        TextView idadeText = findViewById(R.id.idadeText);

        if (mesAtual > mesNascimento) {
            idadeText.setText("Você fez " + idade + " anos.");
        } else if (mesAtual < mesNascimento) {
            idadeText.setText("Você fará " + idade + " anos.");
        } else if (mesAtual == mesNascimento) {
            idadeText.setText("Parabéns! Você completou ou completará " + idade + " anos neste mês.");
        }
    }
}