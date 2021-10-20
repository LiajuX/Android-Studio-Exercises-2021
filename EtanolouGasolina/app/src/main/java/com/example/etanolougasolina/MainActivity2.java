package com.example.etanolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        float precoGasolina = getIntent().getFloatExtra("precoGasolina", precoGasolina = 0);
        float precoEtanol = getIntent().getFloatExtra("precoEtanol", precoEtanol = 0);

        TextView textCombustivel = findViewById(R.id.textCombustivel);
        TextView textDetalhes = findViewById(R.id.textDetalhes);

        float diferencaDePreco = precoGasolina - precoEtanol;

        if (diferencaDePreco > 0) {
            textCombustivel.setText("Etanol");
            textDetalhes.setText("É mais vantajoso abastecer com etanol do que com gasolina neste posto");
        } else if (diferencaDePreco < 0) {
            textCombustivel.setText("Gasolina");
            textDetalhes.setText("É mais vantajoso abastecer com gasolina do que com etanol neste posto");
        } else {
            textCombustivel.setText("Tanto faz");
            textDetalhes.setText("O combustível escolhido não faz diferença");
        }
    }
}