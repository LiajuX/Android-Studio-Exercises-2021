package com.example.requesthttp_get;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view) {
        String url = "https://reqres.in/api/users/";

        EditText txtID = findViewById(R.id.inputID);
        url += txtID.getText().toString();

        TextView txtName = findViewById(R.id.textName);
        TextView txtSurname = findViewById(R.id.textSurname);
        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetter(txtName, txtSurname, txtMessage).execute(url);
    }
}