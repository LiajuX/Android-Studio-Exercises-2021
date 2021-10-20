package com.example.etanolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostraTela2(View view) {
        Intent proximaTela = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtPrecoGasolina = findViewById(R.id.inputGasolina);
        EditText txtPrecoEtanol = findViewById(R.id.inputEtanol);

        String stPrecoGasolina = txtPrecoGasolina.getText().toString();
        String stPrecoEtanol = txtPrecoEtanol.getText().toString();

        float precoGasolina = Float.parseFloat(stPrecoGasolina);
        float precoEtanol = Float.parseFloat(stPrecoEtanol);

        proximaTela.putExtra("precoGasolina", precoGasolina);
        proximaTela.putExtra("precoEtanol", precoEtanol);

        startActivity(proximaTela);
    }
}