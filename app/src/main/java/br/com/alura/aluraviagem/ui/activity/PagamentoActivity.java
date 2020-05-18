package br.com.alura.aluraviagem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagem.R;
import br.com.alura.aluraviagem.model.Pacote;
import br.com.alura.aluraviagem.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo =
                new Pacote("São Paulo", "@drawable/sao_paulo_sp",
                        2, new BigDecimal("243.99"));


        mostraPreco(pacoteSaoPaulo);

        Intent intent = new Intent(this, ResumoCompraActivity.class);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira
                = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
