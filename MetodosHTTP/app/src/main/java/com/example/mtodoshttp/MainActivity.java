package com.example.mtodoshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

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

        EditText txtName = findViewById(R.id.inputName);
        EditText txtSurname = findViewById(R.id.inputSurname);
        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetter(txtName, txtSurname, txtMessage).execute(url);
    }

    public void executaPost(View view) {
        String url = "https://reqres.in/api/users/";
        String parameter = "{\n" +
                "   \"name\": \"testando\",\n" +
                "   \"job\": \"1234\"\n" +
                "}";

        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetterPost(txtMessage).execute(url, parameter);
    }

    public void executaPut(View view) {
        try {
            String url = "https://reqres.in/api/users/";

            EditText txtID = findViewById(R.id.inputID);
            url += txtID.getText().toString();

            EditText txtName = findViewById(R.id.inputName);
            EditText txtSurname = findViewById(R.id.inputSurname);
            TextView txtMessage = findViewById(R.id.textMessage);

            JSONObject messagePut = new JSONObject();
            messagePut.put("name", txtName.getText().toString());
            messagePut.put("job", txtSurname.getText().toString());

            new DataGetterPut(txtMessage).execute(url, messagePut.toString());

        } catch (JSONException e) {
            EditText txtName = findViewById(R.id.inputName);
            txtName.setText("Erro ao realizar o PUT");
        }
    }

    public void executaDelete(View view) {
        String response;

        String url = "https://reqres.in/api/users/";

        EditText txtID = findViewById(R.id.inputID);
        url += txtID.getText().toString();

        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetterDelete(txtMessage).execute(url);
    }
}