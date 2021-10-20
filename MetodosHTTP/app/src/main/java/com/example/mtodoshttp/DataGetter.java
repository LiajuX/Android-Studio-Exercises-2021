package com.example.mtodoshttp;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String, Void, String> {
    private EditText txtName;
    private EditText txtSurname;
    private TextView txtMessage;

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        txtMessage.setText("Usuário encontrado!");

        try {
            JSONObject jsonResponse = new JSONObject(s);

            JSONObject dataResponse = jsonResponse.getJSONObject("data");

            String firstName = dataResponse.getString("first_name");
            String lastName = dataResponse.getString("last_name");

            txtName.setText(firstName);
            txtSurname.setText(lastName);

        } catch (JSONException e) {
            this.txtMessage.setText("Usuário não encontrado!");
        }
    }

    public DataGetter(EditText txtName, EditText txtSurname, TextView txtMessage) {
        this.txtName = txtName;
        this.txtSurname = txtSurname;
        this.txtMessage = txtMessage;

        txtMessage.setText("Pesquisando...");
    }
}
