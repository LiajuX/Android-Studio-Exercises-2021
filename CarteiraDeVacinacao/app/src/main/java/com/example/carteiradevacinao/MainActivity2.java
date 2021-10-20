package com.example.carteiradevacinao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public String getPreference(String chave) {
        SharedPreferences sh = getSharedPreferences(getIntent().getStringExtra("PreferenceKey"), Context.MODE_PRIVATE);
        return sh.getString(chave, "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String nomeDaVacina = getPreference("nomeDaVacina");
        String stDiaPrimeiraDose = getPreference("diaPrimeiraDose");
        String stMesPrimeiraDose = getPreference("mesPrimeiraDose");

        TextView txtDiaSegundaDose = findViewById(R.id.textSegundaDose);

        if (nomeDaVacina.equalsIgnoreCase("astrazeneca") || nomeDaVacina.equalsIgnoreCase("pfizer")) {
            txtDiaSegundaDose.setText("Você tomou a 1ª dose dia " + stDiaPrimeiraDose + " do mês " + stMesPrimeiraDose + " e tomará a 2ª dose dia daqui 3 meses");

        } else if (nomeDaVacina.equalsIgnoreCase("coronavac") || nomeDaVacina.equalsIgnoreCase("butanvac")) {
            txtDiaSegundaDose.setText("Você tomou a 1ª dose dia " + stDiaPrimeiraDose + " do mês " + stMesPrimeiraDose + " e tomará a 2ª dose daqui 20 dias");

        } else if(nomeDaVacina.equalsIgnoreCase("janssen")) {
            txtDiaSegundaDose.setText("Você tomou uma vacina de dose única");
        }
    }

    public  void recuperaNomeDaVacina(View view) {
        String nomeDaVacina = getPreference("nomeDaVacina");

        TextView txtNomeDaVacina = findViewById(R.id.textVacina);
        txtNomeDaVacina.setText(nomeDaVacina);
    }
}