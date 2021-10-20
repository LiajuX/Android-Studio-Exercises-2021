package com.example.persistenciasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public DatabaseManager db;
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public Integer idAtual = 0;
    public Integer totalClientes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = new DatabaseManager(this, "base", null, 1);
        startDatabase();
        populaTela();
    }

    public void startDatabase() {
        this.db.inserirCliente(1, "Júlia", "12312312311", "01012000");
        this.db.inserirCliente(2, "Amanda", "12312312312", "01012001");
        this.db.inserirCliente(3, "Daniel", "12312312313", "01012002");
    }

    public void populaTela() {
        Cursor c = db.listaTodosClientes();

        if (c.getCount()>0) {
            c.moveToFirst();
            totalClientes = c.getCount();
            idAtual = 0;

            clientes.clear();

            do {
                Cliente cli = new Cliente();
                cli.setId_cliente(c.getInt(c.getColumnIndex("ID_CLIENTE")));
                cli.setNome(c.getString(c.getColumnIndex("NOME")));
                cli.setCpf(c.getString(c.getColumnIndex("CPF")));
                cli.setData_nasc(c.getString(c.getColumnIndex("DATA_NASC")));

                clientes.add(cli);
            } while(c.moveToNext());
        }
    }

    public void showProximo(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText nome = findViewById(R.id.inputNome);
        EditText cpf = findViewById(R.id.inputCPF);
        EditText data_nasc = findViewById(R.id.inputDataDeNascimento);

        Cliente c = clientes.get(idAtual);

        id.setText(c.getId_cliente().toString());
        nome.setText(c.getNome());
        cpf.setText(c.getCpf());
        data_nasc.setText(c.getData_nasc());

        idAtual++;

        if(idAtual == totalClientes) idAtual = 0;
    }
    public void atualizar(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText nome = findViewById(R.id.inputNome);
        EditText cpf = findViewById(R.id.inputCPF);
        EditText data_nasc = findViewById(R.id.inputDataDeNascimento);

        this.db.atualizaCliente(new Integer(id.getText().toString()), nome.getText().toString(),cpf.getText().toString(),data_nasc.getText().toString());
        populaTela();

    }

    public void apagar(View view) {
        EditText cpf = findViewById(R.id.inputCPF);

        this.db.removeCliente(cpf.getText().toString());
        populaTela();
    }

    public void novo(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText nome = findViewById(R.id.inputNome);
        EditText cpf = findViewById(R.id.inputCPF);
        EditText data_nasc = findViewById(R.id.inputDataDeNascimento);

        id.setText((new Integer(totalClientes+1)).toString());
        nome.setText("");
        cpf.setText("");
        data_nasc.setText("");
    }

    public void inserir(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText nome = findViewById(R.id.inputNome);
        EditText cpf = findViewById(R.id.inputCPF);
        EditText data_nasc = findViewById(R.id.inputDataDeNascimento);

        this.db.inserirCliente(new Integer(id.getText().toString()),nome.getText().toString(),cpf.getText().toString(),data_nasc.getText().toString());

        populaTela();
    }
}