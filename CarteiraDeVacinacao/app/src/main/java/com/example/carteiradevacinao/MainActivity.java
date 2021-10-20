package com.example.carteiradevacinao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final String PreferenceKey = "PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPreference(String chave, String valor) {
        SharedPreferences sh = getSharedPreferences(PreferenceKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(chave, valor).apply();
    }

    public void gravaDadosEMostraProximaTela(View view) {
        Intent proximaTela = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtDia = findViewById(R.id.inputDia);
        addPreference("diaPrimeiraDose", txtDia.getText().toString());

        EditText txtMes = findViewById(R.id.inputMes);
        addPreference("mesPrimeiraDose", txtMes.getText().toString());

        EditText txtVacina = findViewById(R.id.inputVacina);
        addPreference("nomeDaVacina", txtVacina.getText().toString());

        proximaTela.putExtra("PreferenceKey", PreferenceKey);

        startActivity(proximaTela);
    }
}