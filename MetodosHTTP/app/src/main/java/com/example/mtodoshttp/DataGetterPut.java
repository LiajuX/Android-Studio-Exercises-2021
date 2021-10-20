package com.example.mtodoshttp;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPut extends AsyncTask<String, Void, String> {
    private TextView txtMessage;

    @Override
    protected String doInBackground(String... strings) {
        return NetworkToolkit.doPut(strings[0], strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonResponse = new JSONObject(s);
            String createdAt = jsonResponse.getString("updatedAt");

            txtMessage.setText(createdAt);

        } catch (JSONException e) {
            this.txtMessage.setText("Erro ao realizar PUT");
        }
    }

    public DataGetterPut(TextView txtMessage) {
        this.txtMessage = txtMessage;
    }
}
